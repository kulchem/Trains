package trenci;
import trenci.PathFilter;
import trenci.Path;
/*
 This filter allows to combine two other filters and will return true only if
both filters return true and false in any other case. By using the
 {@link PathFilter} interface for the type of its parameters we can combine
 simple and other composite filters indistinctively. This use of the Composite
 pattern gives a great flexibility to create arbitrarily complex filters from
 simple ones

 
 @param <V>
           The type of the nodes in the path
 */
public class AndPathFilter<V> implements PathFilter<V> {
	private final PathFilter<V> firstFilter;
	    private final PathFilter<V> secondFilter;
	
	    public AndPathFilter(final PathFilter<V> firstFilter, final PathFilter<V> secondFilter) {
	        this.firstFilter = firstFilter;
	        this.secondFilter = secondFilter;
	    }
	
	   
	    public boolean passFilter(final Path<V> path) {
	        return firstFilter.passFilter(path) && secondFilter.passFilter(path);
	    }
}
