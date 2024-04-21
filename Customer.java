
public class Customer extends Object{
	String name;
	int age;
	public Customer(String name, int age) {
		this.name=name;
		this.age=age;
	}
	public Customer(Customer c) {
		this(c.name,c.age);
	}
	
	public int getAge() {
		return this.age;
	}
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	
	
	public String toString() {
		return "Customer name: "+this.name+", age: "+this.age;
	}
	
}
