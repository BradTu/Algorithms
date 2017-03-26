//Made by Brad Tully
//8 March 2017
//Programming Assignment 4
//This class takes the graph and runs Prim's algorithm on it

package thePackage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Prim {
		//Vertex for the source node, number of vertices, hash map graph, comparator for the priority queue
		Vertex source = new Vertex();
		int numVertices;
		HashMap<Vertex, ArrayList<Edge>> graph = new HashMap<Vertex, ArrayList<Edge>>();
		Comparator<Vertex> comparator = new TheComparator();
		
		//Constructor for Prim object takes a Vertex, Graph and the number of vertices
		public Prim(Vertex s, Graph g, int vert){ 
			source = s;
			graph = g.getGraph();
			numVertices = vert;
		}
		
		//This method takes an array of vertices and run's Prim's Algorithm on the graph taken from the
		//constructor values
		public ArrayList<Vertex> primsAlgorithm(Vertex[] verts){
			//queue for Prim's, temporary arraylist for initializing the source
			//Vertex and edge objects, arraylist to store the closed vertices
			PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>(numVertices, comparator);
			ArrayList<Edge> temporary = new ArrayList<Edge>();
			Vertex u = new Vertex();
			Vertex tempVertex = new Vertex();
			Edge v = new Edge();
			ArrayList<Vertex> closed = new ArrayList<Vertex>();
			
			//Initial for each loop in pseudocode not needed because vertex objects are initialized with
			//key = infinity and pi value = nil (empty)
			
			//set the initial key value to 0
			temporary = graph.get(source);
			graph.remove(source);
			source.changeKey(0);
			graph.put(source, temporary);
			
			//Put all of the vertices into the priority queue
			for (int i = 0; i < numVertices; i++){
				Q.add(verts[i]);
			}
			
			//Loop that continues while the queue has vertices in it
			while (Q.isEmpty() == false){
				//Extract the min value save it in u
				u = Q.poll();
				//Make sure the key exists then iterate through the adjecent vertices/ edges
				if (graph.containsKey(u) == true) {
					Iterator it = graph.get(u).iterator();
					while (it.hasNext()) {
						//Extract the edge save it in v
						v = (Edge) it.next();
						//If the end vertex is in the queue and the weight of the edge is less than the end vertex key
						if (Q.contains(v.getEndVertex()) && v.getWeight() < v.getEndVertex().getKey()) {
							v.getEndVertex().changePi(u.getName());
							v.getEndVertex().changeKey(v.getWeight());
							tempVertex = v.getEndVertex();
							Q.remove(v.getEndVertex());
							Q.add(tempVertex);
						}
						//Check pertinent information and add the end vertex to the closed vertices array list
						if(!closed.contains(v.getEndVertex()) && !Q.contains(v.getStartVertex()) &&
						   !v.getEndVertexName().equalsIgnoreCase(source.getName())) 
						{
							closed.add(v.getEndVertex());
						}
					}
				}
			}
			return closed;
		}

}
