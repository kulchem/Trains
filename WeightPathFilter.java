package trenci;
import trenci.Path;
/**
 * This filter will check to see if the total weight of the given path is less
 * than the value specified on the constructor

 */

public class WeightPathFilter<V> implements PathFilter<V>  {
	private final int maxWeight;
	
	    public WeightPathFilter(final int maxWeight) {
	        super();
	        this.maxWeight = maxWeight;
	    }
	
	    
	    public boolean passFilter(final Path<V> path) {
	        return path.getPathTotalWeight() < maxWeight;
	    }
}
