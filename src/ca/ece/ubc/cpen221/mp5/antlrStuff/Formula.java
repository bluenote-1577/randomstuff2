package ca.ece.ubc.cpen221.mp5.antlrStuff;
import java.util.Set;

import ca.ece.ubc.cpen221.mp5.*;
//todo : will be similar to formula in lab9
public interface Formula {

	/**
	 * This method evaluates any formula by retrieving the correct set of restaurants from
	 * the database.
	 * @param database the database this query will get information from
	 * @return a set of restaurants that corresponds to what the query is asking for
	 */
	public Set<Restaurant> evaluate(RestaurantDB database);
}
