package ca.ece.ubc.cpen221.mp5.antlrStuff;
import ca.ece.ubc.cpen221.mp5.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class FormulaFactoryTest {

	RestaurantDB database = new RestaurantDB("data/restaurants.json","data/reviews.json"
			,"data/users.json");
	//@Test
	public void test() {
		
		FormulaFactory.parse("in(Telegraph Ave) && "
				+ "(category(Chinese) || category(Italian)) && price(1..2)");
		fail("Not yet implemented");
	}
	
	@Test
	//Tests that the "name" query works.
	public void testNAME(){
		String string = new String("name(International House Cafe)");
		Formula f = FormulaFactory.parse(string);
		System.out.println(f.evaluate(database).toString());
		assertEquals(f.evaluate(database).toString().contains("International House Cafe"),true);
	}

	@Test
	//Tests the rating query.
	public void testRATING(){
		String string = new String("rating(3...4)");
		Formula f = FormulaFactory.parse(string);
		System.out.print(f.evaluate(database).size());
		assertEquals(f.evaluate(database).toString().contains("International House Cafe"),true);
		assertEquals(f.evaluate(database).toString().contains("Coffee Source"),false);
		assertEquals(f.evaluate(database).toString().contains("Pappy's Grill & Sports Bar"),false);
	}
	
	public void testCATEGORY(){
		String string = new String("name(International House Cafe)");
		Formula f = FormulaFactory.parse(string);
		assertEquals(f.evaluate(database).toString().contains("International House Cafe"),true);
	}

}
