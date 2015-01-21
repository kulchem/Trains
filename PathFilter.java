package trenci;
import trenci.AndPathFilter;
import trenci.NotPathFilter;
import trenci.OrPathFilter;
import trenci.Path;

/**
 * Base interface to filter paths given different criteria. Each concrete
 * implementation can decide when the given path is valid or not. The filters in
 * this package use the Composite design pattern to easily extend and combine an
 * arbitrary number of filters.

 */

public interface PathFilter<V> {
	 boolean passFilter(final Path<V> path);
}
