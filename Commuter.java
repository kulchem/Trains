package trenci;

import java.util.List;

import trenci.NoSuchRouteException;
import trenci.Graph;

public interface Commuter {
	/*
	     * Computes the distance (in terms of distance to travel) to go from a
	     * starting node to an ending node while visiting a list of intermediate
	     * nodes. Note that the link between each city has to be direct. This means
	     * that for an input "A-->B-->C", the method should start at A and try to go
	     * directly to B, without stopping at any other city first
	     
	     */
	    int routeDistance(String startingCity, String destinationCity, List<String> intermediateCities);
	
	    /*
	     * Computes the number of different paths existing between two cities with a
	     * maximum number of stops between them. Note that this might include
	     * cycles. For instance, given the following cities and connections between
	     * them "A-->B-->C-->A", there is 2 different paths between A and B with a
	     * maximum of 4 stops: "A-->B" and "A-->B-->C-->A-->B".
	     * 
	     
	     */
	    int numberOfPathsWithMaxStops(String startingCity, String destinationCity, int stops);
	
	    /*
	     * Computes the number of different paths existing between two cities with a
	     * maximum travel distance between them. Note that this might include
         * cycles. For instance, given the following cities and connections between
	     * them "A-5->B-2->C-4->A", there is 2 different paths between A and B with
         * a maximum travel distance of 20: "A-->B" (5) and "A-->B-->C-->A-->B"
	     * (16). However, if the maximum travel distance allowed is 15 then only the
	     * first path is valid.
	    
	     */
	    int numberOfPathsWithMaxWeight(String startingCity, String destinationCity, int weight);
	
	    /*
	     * Computes the number of different paths existing between two cities having
	     * an exact number of stops between them.
	     
	     
	     */
	    int numberOfPathsWithExactStops(String startingCity, String destinationCity, int stops);
	
	    /*
	     * Returns the shortest route between two cities in terms of distance to
	     * travel. Note that, by definition, the shortest path between two cities
	     * can not contain cycles.
	     
	     */
	    int shortestDistance(String startingCity, String destinationCity);
	
	    /**
	     * Returns a {@link Graph} representation of all the cities and connections
	     * between them
	     
	     */
	    Graph<String> getAllRoutes();
	
	    int routeDuration(String startingCity, String endCity, List<String> intermediateCities);
	
	}
	

	


