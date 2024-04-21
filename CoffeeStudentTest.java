import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeStudentTest {
	Coffee coffee_small_shot,coffee_medium_syrup;
	String coffee_1_string, coffee_2_string;

	@BeforeEach
	void setUp() throws Exception {
		coffee_small_shot=new Coffee("Black",Size.SMALL,true,false);
		coffee_1_string=coffee_small_shot.toString();
		coffee_medium_syrup=new Coffee("Latte",Size.MEDIUM,false,true);
		coffee_2_string=coffee_medium_syrup.toString();
	}

	@AfterEach
	void tearDown() throws Exception {
		coffee_small_shot=coffee_medium_syrup=null;
		coffee_1_string=coffee_2_string=null;
	}

	@Test
	void test() {
		//price test
				assertEquals(2.5,coffee_small_shot.calcPrice());
				assertEquals(3.0,coffee_medium_syrup.calcPrice());
				// equals test
				assertFalse(coffee_small_shot.equals(coffee_medium_syrup));
				assertTrue(coffee_small_shot.equals(coffee_small_shot));
				assertTrue(coffee_medium_syrup.equals(coffee_medium_syrup));
				
				//test getters
				assertTrue(coffee_medium_syrup.getExtraSyrup());
				assertTrue(coffee_small_shot.getExtraShot());
				//test toString
				assertTrue(coffee_1_string.equals(coffee_small_shot.toString()));
				assertTrue(coffee_2_string.equals(coffee_medium_syrup.toString()));
	}

}
