//Made by Brad Tully
//4 March 2017
//This class stores an array list that contains adjacent vertices and their respective edge

package thePackage;

import java.util.ArrayList;

public class AdjacentVertices {
	//Create an array list to store the edges that lead to adjacent vertices
	ArrayList<Edge> list = new ArrayList<Edge>();
	
	//Constructor takes an argument of type edge and adds it to the list
	public AdjacentVertices(Edge e){
		list.add(e);
	}
	
	//No argument constructor
	public AdjacentVertices(){
		
	}
	
	//Add a new edge to the array list
	public void addEdgeToList(Edge e){
		list.add(e);
	}
	
	//Returns the array list
	public ArrayList<Edge> getAdjecentVertices(){
		return list;
	}
	
}
