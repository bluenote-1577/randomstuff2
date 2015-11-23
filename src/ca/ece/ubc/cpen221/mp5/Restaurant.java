package ca.ece.ubc.cpen221.mp5;

import org.json.simple.JSONObject;

// TODO: Use this class to represent a restaurant.
// State the rep invariant and abs

public class Restaurant {
	
	private String toStringFormat;
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
