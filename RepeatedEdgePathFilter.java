package trenci;
import trenci.Path;
/**
 * This filter will return true if and only if the given path contains no
 * repeated edges.

 */

public class RepeatedEdgePathFilter<V> implements PathFilter<V> {
	
	     public boolean passFilter(final Path<V> path) {
	         return !path.hasRepeatedEdges();
	    }
}
