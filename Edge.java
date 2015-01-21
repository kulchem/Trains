package trenci;
/**
 * Basic interface for a weighted edge between two vertex

 */

public interface Edge<V> {
	V getStartingVertex();
	
	    V getEndingVertex();
	
	    int getWeight();
}
