
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderStudentTest {

	Order order_one,order_two;
	Customer cust_one,cust_two;
	String order_one_string,order_two_string;
	String cust_one_str,cust_two_str;

	@BeforeEach
	void setUp() throws Exception {
		cust_one=new Customer("John",23);
		
		cust_two=new Customer("Kathy",18);
		cust_one_str=cust_one.toString();
		cust_two_str=cust_two.toString();

		order_one=new Order(9,Day.FRIDAY,cust_one);
		order_two=new Order(13,Day.SUNDAY,cust_two);
		
		
		//total 12
		order_one.addNewBeverage("Mocha", Size.LARGE,true,true);//4
		order_one.addNewBeverage("MilkShake", Size.LARGE,3,true);//6
		order_one.addNewBeverage("Vodka", Size.SMALL);//2
		
		//total 7+3.6+2.5=13.1
		order_two.addNewBeverage("Latte", Size.SMALL,true,false);//2.5
		order_two.addNewBeverage("Pineapple", Size.LARGE,5,true);//4.5+2.5=7
		order_two.addNewBeverage("Mohito", Size.LARGE);//3+0.6
		order_one_string=order_one.toString();
		order_two_string=order_two.toString();
	}

	@AfterEach
	void tearDown() throws Exception {
		cust_one=cust_two=null;
		order_one=order_two=null;
		cust_one_str=cust_two_str=null;
	}

	@Test
	void test_compareTo() {
		assertEquals(order_one.compareTo(order_one),0);
		assertEquals(order_one.compareTo(order_two),-1);
		assertEquals(order_two.compareTo(order_one),1);
	}
	@Test
	void test_isWeekend() {
		assertTrue(order_two.isWeekend());
		assertFalse(order_one.isWeekend());
	}
	@Test
	void test_getBeverage() {
		assertEquals(order_one.getBeverage(0).type,Type.COFFEE);
		assertEquals(order_two.getBeverage(1).type,Type.SMOOTHIE);
	}
	@Test
	void test_addNewBeverage() {
		order_one.addNewBeverage("Coca_Cola", Size.LARGE,0,false);//15
		order_two.addNewBeverage("Coca_Cola", Size.LARGE,0,false);//16.1
		assertEquals(order_two.getBeverage(3).type,Type.SMOOTHIE);
		assertEquals(order_one.getBeverage(3).type,Type.SMOOTHIE);
	}
	@Test
	void test_calcTotalOrder() {
		assertEquals(order_one.calcOrderTotal(),12.0);
		assertEquals(order_two.calcOrderTotal(),13.1);
	
	}
	@Test
	void test_findNumOfBeveTyper() {
		
		assertEquals(order_one.findNumOfBeveType(Type.COFFEE),1);
		assertEquals(order_two.findNumOfBeveType(Type.SMOOTHIE),1);
		
	}

	
	@Test
	void test_getOrderNo() {
		assertEquals(order_one.getOrderNo(),order_one.OrderNo);
	}
	@Test
	void test_getOrderTime() {
		assertEquals(order_one.getOrderTime(),9);
		assertEquals(order_two.getOrderTime(),13);
	}
	@Test
	void test_getOrderDay() {
		assertEquals(order_one.getOrderDay(),Day.FRIDAY);
		assertEquals(order_two.getOrderDay(),Day.SUNDAY);
		assertEquals(order_one.getDay(), Day.FRIDAY);
		assertEquals(order_two.getDay(),Day.SUNDAY);
	}
	@Test
	void test_getCustomer() {
		assertEquals(order_one.getCustomer().toString(),cust_one_str);
		assertEquals(order_two.getCustomer().toString(),cust_two_str);
	}

	@Test
	void test_getTotalItems() {
		assertEquals(order_one.getTotalItems(),3);
		assertEquals(order_two.getTotalItems(),3);
	}
	@Test
	void test_toString() {
		assertEquals(order_one.toString(),order_one_string);
		assertEquals(order_two.toString(),order_two_string);
	}
	
	
	
	
	
	
	

}
