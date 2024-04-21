import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerStudentTest {
	Customer under_age,mature;
	String under_age_string, mature_string;
	

	@BeforeEach
	void setUp() throws Exception {
		under_age=new Customer("John",12);
		mature=new Customer("Kathy",33);
		under_age_string="Customer name: John, age: 12";
		mature_string="Customer name: Kathy, age: 33";
				
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		under_age=mature=null;
		under_age_string=mature_string=null;
	}

	@Test
	void test_toString() {
		//toString
		assertEquals(under_age.toString(),under_age_string);
		assertEquals(mature.toString(),mature_string);
	}
	@Test
	void test_getters() {
		//getters
		assertEquals(under_age.getAge(),12);
		assertEquals(mature.getAge(),33);
		assertEquals(under_age.getName(),"John");
		assertEquals(mature.getName(),"Kathy");
	}
	@Test
	void test_setters() {
		//setters
				mature.setAge(15);
				under_age.setAge(22);
				mature.setName("Deborah");
				under_age.setName("Mike");
				assertEquals(under_age.getAge(),22);
				assertEquals(mature.getAge(),15);
				assertEquals(under_age.getName(),"Mike");
				assertEquals(mature.getName(),"Deborah");
	}
	
	
	

}
