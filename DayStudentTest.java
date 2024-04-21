

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DayStudentTest {
	
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		
	}

	@Test
	void test_valuesOf() {
		assertEquals(Day.valueOf("MONDAY"),Day.MONDAY);
		
	}
	@Test
	void test_values() {
		assertEquals(Day.values()[0],Day.MONDAY);
		assertEquals(Day.values()[1],Day.TUESDAY);
		assertEquals(Day.values()[2],Day.WEDNESDAY);
		assertEquals(Day.values()[3],Day.THURSDAY);
		assertEquals(Day.values()[4],Day.FRIDAY);
		assertEquals(Day.values()[5],Day.SATURDAY);
		assertEquals(Day.values()[6],Day.SUNDAY);
		
	}
	
	

	

}
