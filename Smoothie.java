
public class Smoothie extends Beverage {
	String bevName;
	Size size;
	int numOfFruits;
	boolean addProtein;
	public static final Type type=Type.SMOOTHIE;


	public Smoothie(String bevName, Size size,int numOfFruits, boolean addProtein)
	{
		super(bevName, Type.SMOOTHIE, size);
		this.bevName=bevName;
		this.size=size;
		this.numOfFruits=numOfFruits;
		this.addProtein=addProtein;
	}
	
	@Override
	public double calcPrice() {
		double price=0.0;
		if (this.addProtein)
			{price=super.addSizePrice()+this.numOfFruits*0.5+1.5;}
		else
			{price=super.addSizePrice()+this.numOfFruits*0.5;}
		return price;
	}
	public int getNumOfFruits() {
		return this.numOfFruits;
	}
	public boolean getAddProtein() {
		return this.addProtein;
	}
	@Override
	public String toString() {
		String str;
		if (this.addProtein==true) {
			str="yes";
		}
		else {
			str="no";
		}
		return "Type: "+type+", Beverage name: "
				+this.bevName+", Size: "
				+this.size+", Number of fruits: "
				+this.numOfFruits+", add protein: "+str
				+", Price: "+this.calcPrice();
	}
	@Override
	public boolean equals(Object anotherBev) {
		
	
		if (anotherBev instanceof Smoothie) 
		{
			Smoothie a=(Smoothie) anotherBev;
			if (a.bevName.equals(this.bevName) && a.size==this.size && a.addProtein==this.addProtein && a.numOfFruits==this.numOfFruits)
				{return true;}
			else 
				{return false;}
		}
		else 
		{
			return false;
		}
		
	}
	
	
	
	
	
	
	
}
