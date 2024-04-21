import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BevShopStudentTest {
	
	BevShop bevshop;
	String receipt;
	

	@BeforeEach
	void setUp() throws Exception {
		bevshop=new BevShop();
		bevshop.startNewOrder(18, Day.MONDAY, "John", 21);
		receipt=bevshop.toString();
				
		
		//because to string includes generated order number, I use to string method rather than handmade string
		
	}

	@AfterEach
	void tearDown() throws Exception {
		bevshop=null;
		receipt=null;
		
	}

	@Test
	void test_isValidTime() {
		assertTrue(bevshop.isValidTime(18));
	}
	@Test
	void test_getMaxNumOfFruits() {
		assertEquals(bevshop.getMaxNumOfFruits(),5);
	}
	@Test
	void test_getMinAgeForAlcohol() {
		assertEquals(bevshop.getMinAgeForAlcohol(),21);
	}
	@Test
	void test_isMaxFruit() {
		assertTrue(bevshop.isMaxFruit(10));
	}
	@Test
	void test_getMaxOrderForAlcohol() {
		assertEquals(bevshop.getMaxOrderForAlcohol(),3);
	}
	@Test
	void test_isValidAge() {
		assertFalse(bevshop.isValidAge(12));
		assertTrue(bevshop.isValidAge(22));
	}
	@Test
	void test_startNewOrder() {		
		
		Order last_order=bevshop.getOrderAtIndex(bevshop.orders.size()-1);
		Order current_order=bevshop.getCurrentOrder();
		assertTrue(last_order.equals(current_order));
	}
	@Test
	void test_getNumOfAlcoholDrink() {
		bevshop.processAlcoholOrder("Mohito", Size.LARGE);	
		assertEquals(bevshop.getNumOfAlcoholDrink(),1);
	}
	
	@Test
	void test_processCoffeeOrder() {
		bevshop.processCoffeeOrder("Latte", Size.LARGE, false, false);
		int coffee=bevshop.getCurrentOrder().findNumOfBeveType(Type.COFFEE);
		assertEquals(coffee,1);
	}
	@Test
	void test_processAlcoholOrder() {
		bevshop.processAlcoholOrder("Vodka", Size.SMALL);
		int alcohol=bevshop.getCurrentOrder().findNumOfBeveType(Type.ALCOHOL);
		assertEquals(alcohol,1);
	}
	@Test
	void test_processSmoothieOrder() {
		bevshop.processSmoothieOrder("BANANA", Size.LARGE, 0, false);
		int smoothie=bevshop.getCurrentOrder().findNumOfBeveType(Type.SMOOTHIE);
		assertEquals(smoothie,1);
	}
	@Test
	void test_findOrder() {
		int order=bevshop.getCurrentOrder().getOrderNo();
		Order order_one=bevshop.getCurrentOrder();
		int index=bevshop.findOrder(order);
		Order order_two=bevshop.getOrderAtIndex(index);
		assertTrue(order_one.equals(order_two));

	}
	@Test
	void test_totalOrderPrice() {
		int order=bevshop.getCurrentOrder().getOrderNo();
		double total_order=bevshop.totalOrderPrice(order);
		double total_order_two=bevshop.getCurrentOrder().calcOrderTotal();
		assertTrue(total_order==total_order_two);
	}
	@Test
	void test_totalMonthlySale() {
		bevshop.processAlcoholOrder("Mohito", Size.LARGE);
		assertEquals(bevshop.totalMonthlySale(),3.0);
	}
	@Test
	void test_getCurrentOrder() {
		Order order_one=bevshop.getCurrentOrder();
		int index=bevshop.totalNumOfMonthlyOrders()-1;
		Order order_two=bevshop.getOrderAtIndex(index);
		assertTrue(order_one.equals(order_two));
		
	}
	@Test
	void test_totalNumOfMonthlyOrders() {
		assertEquals(bevshop.totalNumOfMonthlyOrders(),1);
	}
	@Test
	void test_sortOrders() {
		bevshop.startNewOrder(18, Day.MONDAY, "John", 21);
		bevshop.processCoffeeOrder("latte", Size.LARGE, false, false);//3.0
		bevshop.startNewOrder(18, Day.MONDAY, "John", 21);
		bevshop.processCoffeeOrder("latte", Size.SMALL, false, false);//2.0
		bevshop.startNewOrder(18, Day.MONDAY, "John", 21);
		bevshop.processCoffeeOrder("latte", Size.MEDIUM, false, false);//2.5
		double [] test= {0.0,2.0,2.5,3.0};
		
		int length=bevshop.totalNumOfMonthlyOrders();
		
		bevshop.sortOrders();
		for (int i=0;i<length;i++) {
			assertEquals(test[i],bevshop.orders.get(i).calcOrderTotal());
		}
	
		
		
	}
	@Test
	void test_toString() {
		System.out.println(bevshop.toString());
		System.out.println(receipt);
		
		assertTrue(bevshop.toString().equals(receipt));
	}
	
	
	
	

}
