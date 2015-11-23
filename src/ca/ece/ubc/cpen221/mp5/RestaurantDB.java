package ca.ece.ubc.cpen221.mp5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// TODO: This class represents the Restaurant Database.
// Define the internal representation and 
// state the rep invariant and the abstraction function.

public class RestaurantDB {

	private HashMap<String, Restaurant> restaurantDB = new HashMap<String, Restaurant>();
	private String restaurants;
	private String reviews;
	private String users;

	/**
	 * Create a database from the Yelp dataset given the names of three files:
	 * <ul>
	 * <li>One that contains data about the restaurants;</li>
	 * <li>One that contains reviews of the restaurants;</li>
	 * <li>One that contains information about the users that submitted reviews.
	 * </li>
	 * </ul>
	 * The files contain data in JSON format.
	 * 
	 * @param restaurantJSONfilename
	 *            the filename for the restaurant data
	 * @param reviewsJSONfilename
	 *            the filename for the reviews
	 * @param usersJSONfilename
	 *            the filename for the users
	 */
	public RestaurantDB(String restaurantJSONfilename, String reviewsJSONfilename, String usersJSONfilename) {

		restaurants = restaurantJSONfilename;
		reviews = reviewsJSONfilename;
		users = usersJSONfilename;
		scanRestaurants();
	}

	public Set<Restaurant> query(String queryString) {
		// TODO: Implement this method
		// Write specs, etc.
		return null;
	}
	
	/**
	 * This method obtains the restaurant information in JSON format given a valid business ID.
	 * @param businessID the id of the business
	 * @return the string representing the restaurant in JSON format or an error message
	 */
	public String getRestaurant(String businessID){
		if(restaurantDB.get(businessID) == null) return "Not a valid business ID.";
		
		return restaurantDB.get(businessID).toString();
	}

	
	private void scanRestaurants() {
		JSONParser parser = new JSONParser();

		try {
			BufferedReader restaurantReader = new BufferedReader(new FileReader(restaurants));
			String line = restaurantReader.readLine();
			while (line != null) {
				JSONObject restaurantInfo = (JSONObject) parser.parse(line);
				restaurantDB.put((String) restaurantInfo.get
						("business_id"), new Restaurant(line,restaurantInfo));
				line = restaurantReader.readLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
