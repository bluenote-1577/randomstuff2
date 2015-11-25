package ca.ece.ubc.cpen221.mp5;

import org.json.simple.JSONObject;

// TODO: Use this class to represent a restaurant.
// State the rep invariant and abs

/**
 * 
 * @author Jim
 * Rep Invariant : toStringFormat and restaurantInfo may never change
 * Abstraction Function : this restaurant objects represents a real restaurants information.
 */
public class Restaurant {
	
	private final String toStringFormat;
	private JSONObject restaurantInfo;
	
	/**
	 * Constructor. Takes a string that we make equal to the JSON format for
	 * the toString() method, and the restaurant info JSON object we can
	 * extract information from.
	 * @param toString the restaurant in JSOn format
	 * @param restaurantInfo the restaurants information
	 */
	public Restaurant (String toString, JSONObject restaurantInfo){
		toStringFormat = toString;
		this.restaurantInfo = restaurantInfo;
	}
	/**
	 * 
	 * @return the name of the restaurant.
	 */
	public String getName(){
		return new String((String)restaurantInfo.get("name"));
	}
	
	/**
	 * 
	 * @return the rating of the restaurant(Number of stars) as a double.
	 */
	public double getRating(){
		return (double)restaurantInfo.get("stars");
	}
	
	@Override
	public String toString(){
		return toStringFormat;
	}

}
