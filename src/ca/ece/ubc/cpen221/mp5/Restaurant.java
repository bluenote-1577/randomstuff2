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
	
	public Restaurant (String toString, JSONObject restaurantInfo){
		toStringFormat = toString;
		this.restaurantInfo = restaurantInfo;
	}
	
	@Override
	public String toString(){
		return toStringFormat;
	}

}
