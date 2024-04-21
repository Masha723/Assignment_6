import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SizeStudentTest {

	
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void test_values_Of() {
		assertEquals(Size.valueOf("MEDIUM"),Size.MEDIUM);
	}
	@Test
	void test_values() {
		assertEquals(Size.values()[2],Size.SMALL);
		assertEquals(Size.values()[1],Size.MEDIUM);
		assertEquals(Size.values()[0],Size.LARGE);
	}

}
