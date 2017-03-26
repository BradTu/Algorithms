//Made by Brad Tully
//4 March 2017
//This class is used for the priority queue in the Dijkstra class it compares the two vertices
//distance from source to decide which one to extract

package thePackage;

import java.util.Comparator;

public class TheComparator implements Comparator<Vertex>{
	//Compare two Vertices
	@Override
    public int compare(Vertex x, Vertex y) {
        if (x.getDistFromSource() < y.getDistFromSource())
        {
            return -1;
        }
        if (x.getDistFromSource() > y.getDistFromSource())
        {
            return 1;
        }
        return 0;
    }
}
