package cashRegister;

import java.util.ArrayList;

public class gasPumps extends cardAuth{
	//creditCardMock card = new creditCardMock(13141516 ,"Bugs Bunny", 7536);
	ArrayList<Double> price;
	
	int pumpNum;
	int selectOctane = -1;
	final int regular = 0;
	final int midGrade = 1;
	final int premium = 2;
	
	double price87;
	double price89;
	double price93;
	
	
	
	double totalGal = 0.00;
	double totalPrice = 0.00;
	
	
	//Quick Testing Purposes
	//US Gallons
	double pumpedAmount = 5.34;
	

	public gasPumps(int a) {
		this.pumpNum = a;
		initializeMessages();
		initializePrices();
	}
	
	public String getPrice() {
		return Double.toString(this.totalPrice);
	}
	
	public String getGallons() {
		//Be sure to switch back variables
		return Double.toString(this.pumpedAmount);
	}
	public String getPumpNumber() {
		return Integer.toString(this.pumpNum);
	}
	
	public String getRegular() {
		return Double.toString(this.price87);
	}
	
	public String getMidGrade() {
		return Double.toString(this.price89);
	}
	public String getPremium() {
		return Double.toString(this.price93);
	}
	
	public void changePrices(double reg, double mid, double premium) {
		this.price87 = reg;
		this.price89 = mid;
		this.price93 = premium; 
	}
	
	public void selectGrade(int num) {
		if(num == regular) {pumpFuel(regular);}
		if(num == midGrade) {pumpFuel(midGrade);}
		if(num == premium) {pumpFuel(premium);}

	}
	
	
	public gasPumps() {
		initializeMessages();
		initializePrices();
	}
	private void initializeMessages() {
		//Print Pump Information
		//Slide Card for Payment
	}
	
	private void initializePrices() {
		price = new ArrayList<Double>();
		price87 = 2.99;
		price89 = price87 + 0.25;
		price93 = price89 + 0.50;
//		
//		System.out.println(price87);
//		System.out.println(price89);
//		System.out.println(price93);
		
		price.add(0,price87);
		price.add(1,price89);
		price.add(2,price93);
	}
	
	//Bad Code. This method gets called, and returns a value
	//But the Method that originally called pumpFuel is a void type.
//	public double pumpFuel(int selectOctane) {
//		return totalPrice = (pumpedAmount * price.get(selectOctane));
//	}
	
	private void pumpFuel(int selectOctane) {
	totalPrice = (pumpedAmount * price.get(selectOctane));
     }
	
	protected boolean auth(creditCardMock card, int zip, double price) {
		return cardProcess.bankAuth(card, zip, price, 1);
	}
	
	
//	public static void main(String[] args) {
//		gasPumps a = new gasPumps();
//	}
	
	
	
	
	
}








