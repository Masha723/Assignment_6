import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BeverageStudentTest {
    Beverage coffee_small_shot,coffee_medium_syrup;
	String coffee_1_string, coffee_2_string;
	
	Beverage alcohol_weekend,alcohol_workday;
	String alcohol_1_stirng;
	String alcohol_2_string;
	
	Beverage smoothie_protein,smoothie_fruits;
	String smoothie_1_string,smoothie_2_string;
	
	Beverage unkwown;


	@BeforeEach
	void setUp() throws Exception {
		coffee_small_shot=new Coffee("Black",Size.SMALL,true,false);
	
		
		coffee_1_string=coffee_small_shot.toString();
		coffee_medium_syrup=new Coffee("Latte",Size.MEDIUM,false,true);
		coffee_2_string=coffee_medium_syrup.toString();
		
		alcohol_weekend=new Alcohol("Vodka",Size.LARGE,true);
		alcohol_workday=new Alcohol("Beer",Size.SMALL,false);
		alcohol_1_stirng=alcohol_weekend.toString();
		
		alcohol_2_string=alcohol_workday.toString();
		
		smoothie_protein=new Smoothie("Protein Shacke",Size.LARGE,0,true);
		smoothie_fruits=new Smoothie("FruitMix",Size.SMALL,3,false);
		smoothie_1_string=smoothie_protein.toString();
		smoothie_2_string=smoothie_fruits.toString();
		
	
	}

	@AfterEach
	void tearDown() throws Exception {
		coffee_small_shot=coffee_medium_syrup=null;
		alcohol_weekend=alcohol_workday=null;
		smoothie_protein=smoothie_fruits=null;
		
		coffee_1_string=coffee_2_string=null;
		alcohol_1_stirng=alcohol_2_string=null;
		smoothie_1_string=smoothie_2_string=null;
		
	}

	@Test
	void test_equals() {
		//equals method
		assertFalse(coffee_small_shot.equals(alcohol_weekend));
		assertTrue(coffee_small_shot.equals(coffee_small_shot));
		assertFalse(smoothie_fruits.equals(alcohol_weekend));
		assertTrue(smoothie_fruits.equals(smoothie_fruits));
		
		
	}
	
	@Test
	void test_size_price() {
		// size price
				assertEquals(coffee_small_shot.addSizePrice(),2.0);
				assertEquals(smoothie_protein.addSizePrice(),3.0);
				assertEquals(coffee_medium_syrup.addSizePrice(),2.5);
	}
	@Test
	void test_getters() {
		
		assertEquals(alcohol_weekend.getBasePrice(),2.0);
		assertEquals(alcohol_workday.getBasePrice(),2.0);
		assertEquals(alcohol_weekend.getType(),Type.ALCOHOL);
		assertEquals(alcohol_workday.getSize(),Size.SMALL);
		assertEquals(alcohol_workday.getBevName(),"Beer");
		
	}
	@Test
	void test_toString() {
		//toString
		assertEquals(coffee_1_string,coffee_small_shot.toString());
		assertEquals(coffee_medium_syrup.toString(),coffee_2_string);
		assertEquals(alcohol_weekend.toString(),alcohol_1_stirng);
		assertEquals(alcohol_workday.toString(),alcohol_2_string);
	}
	
	
	
	

}
