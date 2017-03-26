//Made by Brad Tully
//8 March 2017
//This class is used for the priority queue in the Prim class it compares the two vertices
//key value the smaller one gets ejected from the queue

package thePackage;

import java.util.Comparator;

public class TheComparator implements Comparator<Vertex>{
	//Compare two Vertices key values
	@Override
    public int compare(Vertex x, Vertex y) {
        if (x.getKey() < y.getKey())
        {
            return -1;
        }
        if (x.getKey() > y.getKey())
        {
            return 1;
        }
        return 0;
    }
}
