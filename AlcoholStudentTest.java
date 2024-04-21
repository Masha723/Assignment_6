import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlcoholStudentTest {
	Alcohol alcohol_weekend,alcohol_workday;
	String alcohol_1_stirng;
	String alcohol_2_string;

	@BeforeEach
	void setUp() throws Exception {
		alcohol_weekend=new Alcohol("Vodka",Size.LARGE,true);
		alcohol_workday=new Alcohol("Beer",Size.SMALL,false);
		alcohol_1_stirng=alcohol_weekend.toString();
		
		alcohol_2_string=alcohol_workday.toString();
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		alcohol_weekend=alcohol_workday=null;
		alcohol_1_stirng=alcohol_2_string=null;

	}

	@Test
	void test() {
		//test equals
				assertFalse(alcohol_weekend.equals(alcohol_workday));
				assertTrue(alcohol_weekend.equals(alcohol_weekend));
				assertTrue(alcohol_workday.equals(alcohol_workday));
				// isWeekend
				assertEquals(alcohol_weekend.isWeekend(),true);
				assertEquals(alcohol_workday.isWeekend(),false);
				//price
				assertEquals(alcohol_weekend.calcPrice(),3.6);
				assertEquals(alcohol_workday.calcPrice(),2.0);
				//toString
				assertEquals(alcohol_weekend.toString(),alcohol_1_stirng);
				assertEquals(alcohol_workday.toString(),alcohol_2_string);
				
	}

}
