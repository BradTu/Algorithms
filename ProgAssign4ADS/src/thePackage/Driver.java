//Made by Brad Tully
//8 March 2017
//Programming Assignment 4
//This program reads in a directed graph and turns it into an undirected graph then performs Prim's Algorithm
//on it

package thePackage;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		//Change the amount of vertices and edges and it automatically changes the files
		int numVertices = 11765;
		int numEdges = 90758;
		String filename = "WarAndPeace.txt_" + numVertices + "_" + numEdges + "_graph.txt";
		//use for other files not in the above format, note: change numVertices and numEdges
		//filename = " ";
		
		//Create an array of edges, vertices, adjacent vertices list, and a graph
		Edge[] edge = new Edge[numEdges * 2];
		Vertex[] vertex = new Vertex[numVertices];
		AdjacentVertices[] adjVerts = new AdjacentVertices[numVertices];
		Graph graph = new Graph();
		
		//---------------------------------------File Reading Start-----------------------------------------------------------
		//String copier and some increments to change the array allocation number
		String[] stringTwo = new String[numEdges * 2];
		int inc = 0;
		int incTwo = 0;
		int incThree = 0;
		
		//Two reading scanners one for vertices the other for edges
		Scanner theScanner = new Scanner(new FileInputStream(filename));
		Scanner theScannerTwo = new Scanner(new FileInputStream(filename));
		
		//Read in the vertices i.e. the first string on each line also initialize the adjacent vertices
		//and add them to the graph
		while(theScanner.hasNextLine() && theScanner.hasNext()){
			vertex[inc] = new Vertex(theScanner.next());
			adjVerts[inc] = new AdjacentVertices();
			graph.getGraph().put(vertex[inc], adjVerts[inc].getAdjecentVertices());
			theScanner.nextLine();
			inc++;
		}
		
		//Initialize string that'll be used to store each line temporarily, increment int for adding to the graph
		//temporary edge weight so the reverse edge can be added to the graph, string used for vertex name temporarily
		String line = " ";
		int incFour = 0;
		String temporaryVertex = " ";
		double temporaryWeight = 0;
		
		//Stores one line from file to "line" string then reads through that string to get edges
		//gets the reverse edge to convert it from a directed to undirected graph
		while(theScannerTwo.hasNextLine() && theScannerTwo.hasNext()){
			line = theScannerTwo.nextLine();
			Scanner theScannerThree = new Scanner(line);
			while (theScannerThree.hasNext()){
				//Get the name of the starting vertex
				if (incTwo == 0){
					temporaryVertex = theScannerThree.next();
					incTwo++;
				}
				incTwo++;
				//Make sure the scanner has more than one value on the line
				if (theScannerThree.hasNext()) {
					stringTwo[incThree] = theScannerThree.next();
					temporaryWeight = theScannerThree.nextDouble();
					//Create the edge E(u, v) add to graph
					for (int i = 0; i < numVertices; i++) {
						if (vertex[i].getName().equalsIgnoreCase(stringTwo[incThree])) {
							for (int j = 0; j < numVertices; j++){
								if (vertex[j].getName().equalsIgnoreCase(temporaryVertex)){
									edge[incThree] = new Edge(vertex[j], temporaryWeight, vertex[i]);
									graph.getGraph().get(vertex[j]).add(edge[incThree]);
								}
							}
						}
					}
					//Add opposite edge i.e. E(v, u) add to graph to make an undirected graph
					for (int i = 0; i < numVertices; i++) {
						if (vertex[i].getName().equalsIgnoreCase(stringTwo[incThree])) {
							for (int j = 0; j < numVertices; j++){
								if (vertex[j].getName().equalsIgnoreCase(temporaryVertex)){
									incThree++;
									edge[incThree] = new Edge(vertex[i], temporaryWeight, vertex[j]);
									graph.getGraph().get(vertex[i]).add(edge[incThree]);
								}
							}
						}
					}
					//increment
					incThree++;
				}
			}
			//reset incTwo to read through each line
			incTwo = 0;
			incFour++;
		}
		
		//-------------------------------------------------File Reading End---------------------------------------------------
		
		//Create an object of type Prim, an arraylist that stores the resulting vertices of Prim's Algorithm
		//and a vertex used to print out the results if you so choose
		Prim prim = new Prim(vertex[0], graph, numVertices);
		ArrayList<Vertex> result = new ArrayList<Vertex>();
		Vertex reader = new Vertex();
		
		//Run Prim's Algorithm 
		result = prim.primsAlgorithm(vertex);
		
		
		// Prints out the array list from Prim's algorithm 
	    // Shows that Prim's correctly works
		Iterator iterate = result.iterator();
		while (iterate.hasNext()) {
			reader = (Vertex) iterate.next();
			System.out.println(reader.getPi() + " " + reader.getKey() + " " + reader.getName());
		}
		
	}

}










