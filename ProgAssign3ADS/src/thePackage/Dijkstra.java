//Made by Brad Tully
//4 March 2017
//This class runs the Modified Dijkstra's Algorithm on a graph

package thePackage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Dijkstra {
	//Vertex for the source node, number of vertices, hash map graph, comparator for the priority queue
	Vertex source = new Vertex();
	int vertices;
	HashMap<Vertex, ArrayList<Edge>> graph = new HashMap<Vertex, ArrayList<Edge>>();
	Comparator<Vertex> comparator = new TheComparator();
	
	//Constructor for Dijkstra object takes a Vertex, Graph and the number of vertices, initializes the queue
	public Dijkstra(Vertex s, Graph g, int vert){ 
		source = s;
		graph = g.getGraph();
		vertices = vert;
	}
	
	//Runs the modified version of Dijkstra's Algorithm on the graph
	public ArrayList<Vertex> modifiedDijkstra(){
		//queue for dijkstra's, temporary arraylist for INITIALIZE-SINGLE-SOURCE
		PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>(vertices, comparator);
		ArrayList<Edge> temporary = new ArrayList<Edge>();
		//Vertex and edge objects, arraylist to store the closed vertices
		Vertex u = new Vertex();
		Edge v = new Edge();
		ArrayList<Vertex> closed = new ArrayList<Vertex>();
		//INITIALIZE-SINGLE-SOURCE store the arraylist at source to a temporary get rid of the source
		//change the distance value to 0 put the key back in and add back the arraylist
		temporary = graph.get(source);
		graph.remove(source);
		source.changeDistFromSource(0);
		graph.put(source, temporary);
		//Put the source vertex into the priority queue Q = {s}
		Q.add(source);
		//Loop that continues while the queue has vertices in it
		while (Q.isEmpty() == false){
			u = Q.poll();
			if (graph.containsKey(u) == true) {
				Iterator it = graph.get(u).iterator();
				//iterate through the adjacent vertices
				while (it.hasNext()) {
					v = (Edge) it.next();
					// Relax edges
					if (v.getEndVertex().getDistFromSource() > u.getDistFromSource() + v.getWeight()) {
						v.getEndVertex().changeDistFromSource(u.getDistFromSource() + v.getWeight());
						if (Q.contains(v.getEndVertex())) {
							Q.remove(v.getEndVertex());
						}
						Q.add(v.getEndVertex());
					}
					//add values to the closed list
					if (closed.contains(u) == false) {
						closed.add(u);
					}
					if (closed.contains(v.getEndVertex()) == false){
						closed.add(v.getEndVertex());
					}
				}
			}
		}
		return closed;
	}

}
