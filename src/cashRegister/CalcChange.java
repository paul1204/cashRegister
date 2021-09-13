package cashRegister;

public class CalcChange {
	
	double total = 0;
	double userAmount = 0;
	double absTotal = 0;
	
	//CalcTotal totalAmount;
	
	public CalcChange(CalcTotal total, double cashInput) {
		this.total = total.getTotal();
		this.userAmount = cashInput;
	}
	
	public double calcChange(){
		total -= userAmount;
		return Math.abs(total); 
	}
	
	public double[] report(CalcTotal table) {
		return table.generateRecord();
	}
}
