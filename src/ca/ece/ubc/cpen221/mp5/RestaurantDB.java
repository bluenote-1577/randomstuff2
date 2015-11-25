package ca.ece.ubc.cpen221.mp5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import ca.ece.ubc.cpen221.mp5.antlrStuff.AtomTypes;

// TODO: This class represents the Restaurant Database.
// Define the internal representation and 
// state the rep invariant and the abstraction function.
//-add containers for reviews and users

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

	public Set<Restaurant> query(String queryString, AtomTypes type) {
		Set<Restaurant> toReturn = new HashSet<Restaurant>();

		if (type == AtomTypes.IN) {
			return null;
		}

		else if (type == AtomTypes.CATEGORY) {
			return null;
		}

		else if (type == AtomTypes.PRICE) {
			return null;
		}

		else if (type == AtomTypes.RATING) {
			if (queryString.matches("[\"1-5\"][\\\\.][\\\\.][\"1-5\"]")) {
				//the 0th and 3rd index represents the digits, and we 
				//use Character.digit instead of casting because for some reason
				//casting gives us the wrong answer.
				double number1 =  Character.digit(queryString.charAt(0),10);
				double number2 = Character.digit(queryString.charAt(3),10);
			//	System.out.println(number1); testing
			//	System.out.println(number2);
				for (Restaurant restaurant : restaurantDB.values()) {
					if(restaurant.getRating() <= number2 
							&& restaurant.getRating() >=number1){
						toReturn.add(restaurant);
					}
				}
				
				return toReturn;
			}
			//returns null if it doesn't match the regex
			else return null;
		}

		else if (type == AtomTypes.NAME) {
			for (Restaurant restaurant : restaurantDB.values()) {
				if (restaurant.getName().equals(queryString)) {
					toReturn.add(restaurant);
				}
			}
			;

			return toReturn;
		}

		throw new RuntimeException("shouldn't be here");

	}

	/**
	 * This method obtains the restaurant information in JSON format given a
	 * valid business ID.
	 * 
	 * @param businessID
	 *            the id of the business
	 * @return the string representing the restaurant in JSON format or an error
	 *         message
	 */
	public String getRestaurant(String businessID) {
		if (restaurantDB.get(businessID) == null)
			return "Not a valid business ID.";

		return restaurantDB.get(businessID).toString();
	}

	/**
	 * called on initialization to scan the restaurants into our database
	 */
	private void scanRestaurants() {
		JSONParser parser = new JSONParser();

		try {
			BufferedReader restaurantReader = new BufferedReader(new FileReader(restaurants));
			String line = restaurantReader.readLine();
			while (line != null) {
				JSONObject restaurantInfo = (JSONObject) parser.parse(line);
				restaurantDB.put((String) restaurantInfo.get("business_id"), new Restaurant(line, restaurantInfo));
				line = restaurantReader.readLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
