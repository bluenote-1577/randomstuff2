package ca.ece.ubc.cpen221.mp5.antlrStuff;

import java.util.Set;

import ca.ece.ubc.cpen221.mp5.Restaurant;
import ca.ece.ubc.cpen221.mp5.RestaurantDB;

/**
 * 
 * @author Jim
 * This class represents an atom, which is one individual query command.
 * E.g. "In" or "Price" 
 */

public class Atom implements Formula {

	private final AtomTypes type;
	private final String string;
	
	/**
	 * This atom holds 2 qualities, a type and a string.
	 * The type determines what kind of query we do, and the
	 * string determined what that query searches for.
	 * @param type an AtomType, RATING, NAME, etc
	 * @param string the string to be searched, 1..2 or International House Cafe
	 */
	public Atom(AtomTypes type, String string){
		this.type = type;
		this.string = string;
		
	}

	@Override
	public Set<Restaurant> evaluate(RestaurantDB database) {
		return database.query(string,type);
	}
	
}
