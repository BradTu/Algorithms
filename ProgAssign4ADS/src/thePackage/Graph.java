//Made by Brad Tully
//8 March 2017
//Programming Assignment 4
//This class stores the vertices and edges into the form of a graph using a hash map

package thePackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;



public class Graph {
	//The data structure that holds the graph uses a Vertex as a key and an array list as the value
	//technically stores the AdjacentVertices class but does so indirectly
	HashMap<Vertex, ArrayList<Edge>> graph = new HashMap<Vertex, ArrayList<Edge>>();
	
	//Constructor takes the vertex as the key and array list as the value
	public Graph(Vertex v, ArrayList<Edge> al){
		graph.put(v, al);
	}
	
	//No argument constructor
	public Graph(){
		
	}
	
	//Add new values to the graph
	public void addVerticesEdges(Vertex v, ArrayList<Edge> al){
		graph.put(v, al);
	}
	
	//Doesn't truly print out the graph but prints out the skeleton of it
	public void printGraph(){
		System.out.println(graph.toString());
	}
	
	//Returns the graph
	public HashMap<Vertex, ArrayList<Edge>> getGraph(){
		return graph;
	}
	
}

















