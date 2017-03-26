//Made by Brad Tully
//2 March 2017
//Programming Assignment 3
//This class keeps track of the edge and destination vertex

package thePackage;

import java.util.HashMap;
import java.util.Map;

public class Edge {
	//Vertex that the edge is pointing to and the weight of the edge
	private Vertex endVertex = new Vertex();
	private double weight;
	
	//Constructor sets the value of the weight and vertex
	public Edge(double w, Vertex v){
		weight = w;
		endVertex = v;
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
	
	//Returns the weight
	public double getWeight(){
		return weight;
	}
	
	//Returns the end vertex
	public Vertex getEndVertex(){
		return endVertex;
	}
	
	//Returns the name of the end vertex
	public String getEndVertexName(){
		return endVertex.getName();
	}
	
}







