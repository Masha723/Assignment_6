import java.util.*;
import java.util.Collections;
public class BevShop extends Object implements BevShopInterface{
	public static final int MAX_FRUIT=5;
	public static final int MAX_ORDER_FOR_ALCOHOL=3;
	public static final int MAX_TIME=23;
	public static final int MIN_AGE_FOR_ALCOHOL=21;
	public static final int MIN_TIME=8;
	ArrayList<Order> orders=new ArrayList<Order>();
	Order order;
	
	
	public BevShop() {
		
	}
  
	

	@Override
	public boolean isValidTime(int time) {
		if (time>8 && time<23)
		{return true;}
		else {return false;}
	}

	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits) {
		if (numOfFruits>MAX_FRUIT)
		{return true;}
		else{return false;}
	}

	@Override
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public boolean isEligibleForMore() {
		if (this.order.findNumOfBeveType(Type.ALCOHOL)>MAX_ORDER_FOR_ALCOHOL) {
			return true;
		}
		else{return false;}
	}

	@Override
	public int getNumOfAlcoholDrink() {
		
		return this.order.findNumOfBeveType(Type.ALCOHOL);
	}

	@Override
	public boolean isValidAge(int age) {
		if(age<MIN_AGE_FOR_ALCOHOL)
		{return false;}
		else{return true;}
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		this.order=new Order(time,day,new Customer(customerName,customerAge));
		orders.add(this.order);
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		
		this.order.addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		int age=this.order.getCustomer().getAge();
		
		if (this.getNumOfAlcoholDrink()>2)
		{
			System.out.println("\t\tYou have reached maximum amount of alcohol drinks per order.");
		}
		else if(!this.isValidAge(age)) 
		{
			
			System.out.println("\t\tInvalid age. Customer should be 21 or older.");
			
		}	
		else {
			this.order.addNewBeverage(bevName, size);
		}

	}
	

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		
		if (numOfFruits<=MAX_FRUIT)
			{this.order.addNewBeverage(bevName, size,numOfFruits,addProtein);}
	    else
			{System.out.println("\t\tFruits amount limited 5 per one drink");}
		
	}

	@Override
	public int findOrder(int orderNo) {
		int number=0;
		for (int i=0;i<this.orders.size();i++) 
		{
			Order or=this.orders.get(i);
			if (or.OrderNo==orderNo) {
				number=i;
				break;
			}
		}
		return number;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		double result=0.0;
		for (int i=0;i<orders.size();i++) {
			if (orders.get(i).getOrderNo()==orderNo) {
				result=orders.get(i).calcOrderTotal();
			}
		}
		
		return result;
	}

	@Override
	public double totalMonthlySale() {
		double total=0.0;
		for(int i=0;i<this.orders.size();i++) 
		{
			total+=this.orders.get(i).calcOrderTotal();
			
		}
		return total;
	}

	@Override
	public int totalNumOfMonthlyOrders() {
		
		return this.orders.size();
	}

	@Override
	public Order getCurrentOrder() {
		
		return this.order;
	}

	@Override
	public Order getOrderAtIndex(int index) {
		
		return this.orders.get(index);
	}

	@Override
	//sort orders in the ascending order of the total check
	public void sortOrders() {
		int n = this.orders.size();
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                {
            		if (this.orders.get(j).compareTo(this.orders.get(min_idx))<0)
                    	{min_idx = j;}
                }
         
            Collections.swap(this.orders,min_idx,i);            
        }
		
	}
	public String toString() {
		String str="";
		if (this.orders.size()>0)
		{
			for (int i=0;i<this.orders.size();i++) 
			{
				str+=this.orders.get(i).toString()+"\n ";
			}
		}
		else if (this.order!=null){
			str+=this.order.toString();
		}
		else {
			str+="\t\tOrder is not started yet";
		}
		return str;
	}
	
	
}