package cashRegister;

public class Till {


	final double absAmount = 100.00;
	
	double amount = absAmount;
	
	public Till(){
		
	}
	 
	public Till(double n) {
		this.amount = n;
	}
	
	public void dispenseChange(double nn) {
		this.amount += nn;
	}
	
}
