package trenci;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import trenci.ContainsPathFilter;
import trenci.ExactHopsPathFilter;
import trenci.MaxHopsPathFilter;
import trenci.PathFilter;
import trenci.RepeatedEdgePathFilter;
import trenci.WeightPathFilter;
import trenci.DefaultEdge;
import trenci.Graph;
import trenci.GraphPath;
import trenci.Path;

/**
 Default implementation of {@link Commuter}. It uses the interface provided by
 {@link Graph}, particularly
{@link Graph#getAllPaths(Object, Object, PathFilter)}
 
 */

public final class CommuterImpl {
	private final Graph<String> routes;

	    public CommuterImpl(final Graph<String> routes) {
	        super();
	        this.routes = routes;
	    }
	
	    
	    public int numberOfPathsWithExactStops(final String startingCity, final String destinationCity, final int stops) {
	        // We need to get all the paths up to the maximum number of stops first
	        // Otherwise for stops > 1, the "getAllPaths" method would stop on the
	        // first city
	        final List<Path<String>> paths = routes.getAllPaths(startingCity, destinationCity, new MaxHopsPathFilter<String>(stops));
	        final List<Path<String>> exactPaths = new ArrayList<Path<String>>();
	        // Now we filter again to get only those with the exact number of stops
	        // and not less
	        final PathFilter<String> exactFilter = new ExactHopsPathFilter<String>(stops);
	        for (final Path<String> each : paths) {
	            if (exactFilter.passFilter(each)) {
	                exactPaths.add(each);
	            }
	        }
	        return exactPaths.size();
	    }
	
	    
	    public int numberOfPathsWithMaxStops(final String startingCity, final String destinationCity, final int stops) {
	        return routes.getAllPaths(startingCity, destinationCity, new MaxHopsPathFilter<String>(stops)).size();
	    }
	
	    
	    public int numberOfPathsWithMaxWeight(final String startingCity, final String destinationCity, final int weight) {
	        return routes.getAllPaths(startingCity, destinationCity, new WeightPathFilter<String>(weight)).size();
	    }
	
	    
	    public int shortestDistance(final String startingCity, final String destinationCity) {
	        // By definition the shortest path between two nodes can not have cycles
	        // in it
	        final List<Path<String>> allPaths = routes.getAllPaths(startingCity, destinationCity,
	                new RepeatedEdgePathFilter<String>());
	        return Collections.min(allPaths).getPathTotalWeight();
    	    }

	    
	    public int routeDistance(final String startingCity, final String destinationCity, final List<String> intermediateNodes) {
	        final Path<String> objectivePath = createPath(startingCity, destinationCity, intermediateNodes);
	        final List<Path<String>> allPaths = routes.getAllPaths(startingCity, destinationCity, new ContainsPathFilter<String>(
	                objectivePath));
	
	        // No need to check list size since at this point there should be
	        // only 1 element on it. If there is no path a NoSuchRoute exception
	        // should have been thrown on the previous call to "getAllPaths".
	        return allPaths.get(0).getPathTotalWeight();
	    }
	
	    /**
	     * Creates a {@link Path} object from a starting node, an ending node and a
	     * list of intermediate nodes
         * 
	     * @param from
         *            The starting node
	     * @param to
	     *            The ending node
	     * @param intermediateNodes
	     *            List of intermediate nodes
	     * @return a {@link Path} object representing the route between the nodes
	     */
	    private Path<String> createPath(final String from, final String to, final List<String> intermediateNodes) {
	        final Path<String> resultingPath = GraphPath.emptyPath();
	        String currentNode = from;
	        if (intermediateNodes != null) {
	            for (final String eachIntermediate : intermediateNodes) {
	                resultingPath.addEdge(DefaultEdge.getWeightedEdge(currentNode, eachIntermediate, 0));
	                currentNode = eachIntermediate;
	            }
	        }
	        resultingPath.addEdge(DefaultEdge.getWeightedEdge(currentNode, to, 0));
	        return resultingPath;
	    }
	
	   
	    public Graph<String> getAllRoutes() {
	        return routes;
	    }
	
	    
	    public int routeDuration(String startingCity, String endCity, List<String> intermediateCities) {
	        return  routeDistance(startingCity, endCity, intermediateCities) + 2 * intermediateCities.size();
	    }
	
	}


