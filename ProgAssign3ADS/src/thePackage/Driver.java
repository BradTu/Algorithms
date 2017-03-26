//Made by Brad Tully
//2 March 2017
//Programming Assignment 3
//This program creates a weighted directed graph and runs a modified Dijkstra's algorithm on it

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
		//THESE CHANGE WITH THE FILE BEING USED
		int numVertices = 5;
		int numEdges = 10;
		String filename = "graph-lotr.txt";
		
		//Create an array of edges, vertices, adjacent vertices list, and a graph
		Edge[] edge = new Edge[numEdges];
		Vertex[] vertex = new Vertex[numVertices];
		AdjacentVertices[] adjVerts = new AdjacentVertices[numVertices];
		Graph graph = new Graph();
		
		//---------------------------------------File Reading Start-----------------------------------------------------------
		//String copier and some increments to change the array allocation number
		String[] stringTwo = new String[numEdges];
		int inc = 0;
		int incTwo = 0;
		int incThree = 0;
		
		//Two reading scanners one for vertices the other for edges
		Scanner theScanner = new Scanner(new FileInputStream(filename));
		Scanner theScannerTwo = new Scanner(new FileInputStream(filename));
		
		//Read in the vertices i.e. the first string on each line
		while(theScanner.hasNextLine() && theScanner.hasNext()){
			vertex[inc] = new Vertex(theScanner.next());
			theScanner.nextLine();
			inc++;
		}
		
		//Initialize string that'll be used to store each line temporarily increment int for adding to the graph
		String line = " ";
		int incFour = 0;
		
		//Initialize the Adjacent Vertices array
		for (int i = 0; i < numVertices; i++){
			adjVerts[i] = new AdjacentVertices();
		}
		
		//Stores one line from file to line then reads through that string to get edges
		while(theScannerTwo.hasNextLine() && theScannerTwo.hasNext()){
			line = theScannerTwo.nextLine();
			Scanner theScannerThree = new Scanner(line);
			while (theScannerThree.hasNext()){
				//Skip the first string on the line i.e. the vertex
				if (incTwo == 0){
					theScannerThree.next();
					incTwo++;
				}
				incTwo++;
				//Make sure the scanner has more than one value on the line
				if (theScannerThree.hasNext()) {
					stringTwo[incThree] = theScannerThree.next();
					//Create the edges and add them to the adjacent vertices object
					for (int i = 0; i < numVertices; i++) {
						if (vertex[i].getName().equalsIgnoreCase(stringTwo[incThree])) {
							edge[incThree] = new Edge(theScannerThree.nextDouble(), vertex[i]);
							adjVerts[incFour].addEdgeToList(edge[incThree]);
						}
					}
					//Add the vertex and adjacent vertices to the graph
					graph.addVerticesEdges(vertex[incFour], adjVerts[incFour].getAdjecentVertices());
					incThree++;
				}
			}
			incTwo = 0;
			incFour++;
		}
		//-------------------------------------------------File Reading End---------------------------------------------------
		
		//Create an object of type Dijkstra, an arraylist that stores the result of Dijkstra's algorithm
		//and a vertex used to print out the results if you so choose
		Dijkstra dijkstra = new Dijkstra(vertex[0], graph, numVertices);
		ArrayList<Vertex> result = new ArrayList<Vertex>();
		Vertex reader = new Vertex();
		
		//Run Dijkstra's Algorithm 
		
		result = dijkstra.modifiedDijkstra();
		
		
		//Prints out the array list from Dijkstra's algorithm
		 Iterator iterate = result.iterator();
		 while (iterate.hasNext()){
			reader = (Vertex) iterate.next();
			System.out.println(reader.getName() + " " + reader.getDistFromSource());
		}
		
	}

}










