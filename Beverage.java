
public abstract class Beverage extends Object {
	String bevName;
	Type type;
	Size size;
	public final static double BASE_PRICE=2.0;
	public final static double MEDIUM_PRICE=0.5;
	public final static double LARGE_PRICE=1.0;
	
	public Beverage(String bevName,Type type,Size size) {
		this.bevName=bevName;
		this.type=type;
		this.size=size;
	}
	public double getBasePrice() {
		return BASE_PRICE;
	}
	public Type getType() {
		return this.type;
	}
	public String getBevName() {
		return this.bevName;
	}
	public Size getSize() 
	{
		return this.size;
	}
	
	
	
	public double addSizePrice() {
		double result=0;
		if (this.size==Size.SMALL) {
			 result=BASE_PRICE;
		}
		else if (this.size==Size.MEDIUM) {
			 result=BASE_PRICE+MEDIUM_PRICE;
		}
		else if (this.size==Size.LARGE) {
			 result=BASE_PRICE+LARGE_PRICE;
		}
		return result;
	}
	
	
	@Override
	public String toString() 
	{
		return "Beverage: "+this.bevName+", Size: "+this.size+"Price: "+this.calcPrice();
		
	}
	
	
	
	public boolean equals(Object  anotherBev) 
	{
		if (anotherBev instanceof Beverage ) 
		{
			Beverage a=(Beverage) anotherBev;
			if (a.bevName.equals(this.bevName) && a.size==this.size && a.type==this.type)
				{return true;}
			else 
				{return false;}
		}
		else 
		{
			return false;
		}
	}	
	public abstract double calcPrice();
}
