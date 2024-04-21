import java.util.*;

public class Order extends Object implements OrderInterface, Comparable<Order> {
	int orderTime;
	int OrderNo;
	Day orderDay; 
	Customer cust;
	ArrayList<Beverage> beverages = new ArrayList<Beverage>();
	 
	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderDay=orderDay;
		this.orderTime=orderTime;
		this.cust=new Customer(cust.name,cust.age);
		this.OrderNo=generateOrder();
	}
	


	@Override
	public int compareTo(Order o) {
		if (this.calcOrderTotal()<o.calcOrderTotal())
		{return -1;}
		else if(this.calcOrderTotal()>o.calcOrderTotal())
		{return 1;}
		else {return 0;}
	}

	@Override
	public boolean isWeekend() {
		if (this.orderDay==Day.SUNDAY || this.orderDay==Day.SATURDAY)
		{return true;}
		else {return false;}
	}
	
	@Override
	public Beverage getBeverage(int itemNo) 
	{
		return this.beverages.get(itemNo);
	}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Beverage b=new Coffee(bevName,size,extraShot,extraSyrup);
		beverages.add(b);
		
	}

	@Override
	public void addNewBeverage(String bevName, Size size) {
		Beverage b=new Alcohol(bevName,size,this.isWeekend());
		beverages.add(b);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Beverage b=new Smoothie(bevName,size,numOfFruits,addProtein);
		beverages.add(b);
		
	}

	@Override
	public double calcOrderTotal() {
		double total=0.0;
		for (int i=0;i<this.beverages.size();i++)
		{
			Beverage b=this.beverages.get(i);
			total+=b.calcPrice();
			
		}
		// TODO Auto-generated method stub
		return total;
	}

	@Override
	public int findNumOfBeveType(Type type) {
		int total=0;
		for (int i=0;i<this.beverages.size();i++)
		{
			if (this.beverages.get(i).type==type) {
				total+=1;
			}
		}

		return total;
	}

	public int generateOrder() {
		Random rn = new Random();
		int range = 90000 - 10000 + 1;
		int randomNum =  rn.nextInt(range) + 10000;
		return randomNum;
	}
	public int getOrderNo()
	{return this.OrderNo;}
	public int getOrderTime() {
		return this.orderTime;
	}
	public Day getOrderDay() {
		return this.orderDay;
	}

	public Customer getCustomer() {
		return new Customer(this.cust.name,this.cust.age);
	}
	
	public Day getDay() {
		return this.orderDay;
	}
	public int getTotalItems() {
		return this.beverages.size();
	}

	public String toString() {
		String str="";

		for (int i=0;i<beverages.size();i++) {
			if (beverages.get(i)!=null)
			{str+=beverages.get(i).toString()+"\n ";}	
		}
		
		return "\nOrder No: "+this.OrderNo
				+"\n Time: "+this.orderTime
				+"\n Day: "+this.getDay()+", "+this.cust.toString()
				+"\n Beverages:\n"
				+" "+str
				+"Your total is : "
				+this.calcOrderTotal();
		
	}

}
	
	
	

