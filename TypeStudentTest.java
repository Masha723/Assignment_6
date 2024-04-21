import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TypeStudentTest {

	
	
	
	@BeforeEach
	void setUp() throws Exception {}
		

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void test_valuesof() {
		assertEquals(Type.valueOf("COFFEE"),Type.COFFEE);
	}
	@Test
	void test_values() {
		assertEquals(Type.values()[0],Type.ALCOHOL);
		assertEquals(Type.values()[1],Type.COFFEE);
		assertEquals(Type.values()[2],Type.SMOOTHIE);
	}

}
