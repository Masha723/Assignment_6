
public class Coffee extends Beverage{
	String bevName;
	Size size;
	boolean extraShot;
	boolean extraSyrup;
	public static final Type type=Type.COFFEE;

	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName, Type.COFFEE, size);
		this.bevName=bevName;
		this.size=size;
		this.extraShot=extraShot;
		this.extraSyrup=extraSyrup;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcPrice() {
		double price=super.addSizePrice();
		if (this.extraShot==true)
			{price+=0.5;}
		if (this.extraSyrup==true )
			{price+=0.5;}
		
		return price;
	}

	@Override
	public boolean equals(Object anotherBev) {
		
		if (anotherBev instanceof Coffee) 
		{
			Coffee a=(Coffee) anotherBev;
			if (a.bevName.equals(this.bevName) && a.size==this.size && a.extraShot==this.extraShot && a.extraSyrup==this.extraSyrup)
				{return true;}
			else 
				{return false;}
		}
		else {return false;}
	}
	
	
	
	public boolean getExtraShot() {
		return this.extraShot;
	}
	
	public boolean getExtraSyrup() {
		return this.extraSyrup;
	}
	
	public String toString() {
		String shot;
		String syrup;
		if (this.extraShot) {shot="yes";}
		else {shot="no";}
		if (this.extraSyrup) {syrup="yes";}
		else {syrup="no";}
		return "Type: "+type
				+",   Beverage name: "
				+this.bevName+", Size: "
				+this.size+", Extra shot: "
				+shot+", Extra Syrup: "+syrup
				+", Price: "+this.calcPrice();}
	
	
	
}
