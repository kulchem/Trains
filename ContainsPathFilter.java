package trenci;
import trenci.Path;

public class ContainsPathFilter <V> implements PathFilter<V>{
	 private final Path<V> objectivePath;
	 
	     public ContainsPathFilter(final Path<V> objectivePath) {
	         this.objectivePath = objectivePath;
	     }
	 
	    
	     public boolean passFilter(final Path<V> path) {
	         return objectivePath.startsWith(path);
	     }
}
