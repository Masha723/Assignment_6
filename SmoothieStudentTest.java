
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieStudentTest {

	
	Smoothie smoothie_protein,smoothie_fruits;
	String smoothie_1_string,smoothie_2_string;


	@BeforeEach
	void setUp() throws Exception {
		
		
		smoothie_protein=new Smoothie("Protein Shacke",Size.LARGE,0,true);
		smoothie_fruits=new Smoothie("FruitMix",Size.SMALL,3,false);
		smoothie_1_string=smoothie_protein.toString();
		smoothie_2_string=smoothie_fruits.toString();
		
	
	}

	@AfterEach
	void tearDown() throws Exception {
	
		smoothie_protein=smoothie_fruits=null;
		
		
		smoothie_1_string=smoothie_2_string=null;
	}

	
	
	
	@Test
	void test_Smoothie() {
		//toString
		
		assertEquals(smoothie_1_string,smoothie_protein.toString());
		assertEquals(smoothie_2_string,smoothie_fruits.toString());
		//price
		assertEquals(smoothie_protein.calcPrice(),4.5);
		assertEquals(smoothie_fruits.calcPrice(),3.5);
		// getters
		assertEquals(smoothie_protein.getNumOfFruits(),0);
		assertEquals(smoothie_fruits.getNumOfFruits(),3);
		assertEquals(smoothie_protein.getAddProtein(),true);
		assertEquals(smoothie_fruits.getAddProtein(),false);
		//equals
		
		assertTrue(smoothie_fruits.equals(smoothie_fruits));
		
		
		
		
	}
	
}
