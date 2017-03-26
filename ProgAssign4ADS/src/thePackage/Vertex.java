//Made by Brad Tully
//8 March 2017
//Programming Assignment 4
//This class stores one vertex that has a name, key value, and stores the name of the previous vertex

package thePackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class Vertex {
	//Variables to store the name, key and previous vertex name (starts out empty)
	private String name = " ";
	private Double key;
	private String pi = " ";
	
	//Constructor that sets the name, initializes the key to infinity
	public Vertex(String n){
		name = n;
		key = Double.POSITIVE_INFINITY;
	}
	
	//No argument constructor
	public Vertex(){
		
	}
	
	//Change the name of the vertex
	public void addName(String n){
		name = n;
	}
	
	//Set previous vertex name
	public void changePi(String p){
		pi = p;
	}
	
	//Change the key value
	public void changeKey(double d){
		key = d;
	}
	
	//Get the name of the previous vertex name
	public String getPi(){
		return pi;
	}
	
	//Returns the name of the vertex
	public String getName(){
		return name;
	}
	
	//Returns the key value
	public double getKey(){
		return key;
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







