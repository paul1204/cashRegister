package items;

public class Item {

	public String name;
	public double price;
	public String upcNumber;
	//12oz 24oz etc...
	public String size;
	
	
	public Item(String n, double p, String upcNum, String s) {
		this.name = n;
		this.price = p;
		this.upcNumber = upcNum;
		this.size = s;
	}


	public String getName() {
		return name;
	}


	public double getPrice() {
		return price;
	}


	public String getUpcNumber() {
		return upcNumber;
	}


	public String getSize() {
		return size;
	}
	
}
