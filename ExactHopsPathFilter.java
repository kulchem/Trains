package trenci;
import trenci.Path;
/*
 * This filter will check to see if the given path has exactly the amount of
 * hops, i.e., edges, as the value specified on its constructor

 */

public class ExactHopsPathFilter <V> implements PathFilter<V>{
	private final int hopsNumber;
	
	    public ExactHopsPathFilter(final int hopsNumber) {
	        super();
	        this.hopsNumber = hopsNumber;
	    }
	
	   
	    public boolean passFilter(final Path<V> path) {
	        return path.getNumberOfHops() == hopsNumber;
    }
	
}
