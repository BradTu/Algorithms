//Made by Brad Tully
//2 March 2017
//Programming Assignment 3
//This class stores one vertex that has a name and a distance from source

package thePackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class Vertex {
	//Variables to store the name and distance from source vertex
	private String name = " ";
	private Double distanceFromSource;
	
	//Constructor that sets the name and initializes the distance from source as infinity
	public Vertex(String n){
		name = n;
		distanceFromSource = Double.POSITIVE_INFINITY;
	}
	
	//No argument constructor
	public Vertex(){
		
	}
	
	//Change the name of the vertex
	public void addName(String n){
		name = n;
	}
	
	//Change the distance from the source vertex
	public void changeDistFromSource(double d){
		distanceFromSource = d;
	}
	
	//Returns the name of the vertex
	public String getName(){
		return name;
	}
	
	//Returns the distance from the source vertex
	public double getDistFromSource(){
		return distanceFromSource;
	}

	//Hash Code so it can be stored in the hash map
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	//Equals method so it can be stored in the hash map
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}







