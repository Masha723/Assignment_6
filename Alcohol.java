
public class Alcohol extends Beverage{
	String bevName;
	Size size;
	boolean isWeekend;
	public static final Type type=Type.ALCOHOL;
	

	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend=isWeekend;
		this.size=size;
		this.bevName=bevName;
	}
	public boolean isWeekend() {
		return this.isWeekend;
		
	}
	@Override
	public boolean equals(Object anotherBev) {
		if (anotherBev instanceof Alcohol ) 
		{
			Alcohol a=(Alcohol) anotherBev;
			if (a.bevName.equals(this.bevName) && a.size==this.size && a.isWeekend==this.isWeekend)
				{return true;}
			else 
				{return false;}
		}
		else 
		{
			return false;
		}
	}
		
	
	

	@Override
	public double calcPrice() {
		double price=this.addSizePrice();
		if (this.isWeekend)
			{price+=0.6;}
		return price;
	}
	
	
	@Override
	public String toString() {
		String str;
		if (this.isWeekend) {str="yes";}
		else {str="no";}
		return "Type: "+type
				+",  Beverage name: "+this.bevName
				+", Size: "+this.size
				+", Today is weekend: "+str
				+", Price: "+this.calcPrice();
		
		
	}

}
