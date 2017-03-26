//Made by Brad Tully
//8 March 2017
//Programming Assignment 4
//This class keeps track of the edge (weight) and starting/ destination vertices

package thePackage;

import java.util.HashMap;
import java.util.Map;

public class Edge {
	//Vertices that the edge is touching and the weight of the edge
	private Vertex endVertex = new Vertex();
	private Vertex startVertex = new Vertex();
	private double weight;
	
	//Constructor sets the value of the weight and vertices
	public Edge(Vertex vs, double w, Vertex ve){
		weight = w;
		endVertex = ve;
		startVertex = vs;
	}
	
	//No argument constructor
	public Edge(){
		
	}
	
	//Change the weight of the edge
	public void setWeight(double w){
		weight = w;
	}
	
	//Change the end vertex
	public void setEndVertex(Vertex v){
		endVertex = v;
	}
	
	//Change the start vertex
	public void setStartVertex(Vertex v){
		startVertex = v;
	}
	
	//Returns the weight
	public double getWeight(){
		return weight;
	}
	
	//Returns the end vertex
	public Vertex getEndVertex(){
		return endVertex;
	}
	
	//Returns the start vertex
	public Vertex getStartVertex(){
		return startVertex;
	}
	
	//Returns the name of the end vertex
	public String getEndVertexName(){
		return endVertex.getName();
	}
	
	//Returns the name of the start vertex
	public String getStartVertexName(){
		return startVertex.getName();
	}
}







