package cashRegister;
import javax.swing.JTable;
//Need to Complete A Cash Drawer Object, and Object to Perform Sequence of Paying with Cash.

//Add a void Functionality
public class CalcTotal {
	Double[] a = new Double[1];
	
	public JTable table;
	
	int i = 0; 
	double subTotal = 0;
	final double taxRate = 0.06;
	double tax = 0;
	int qty = 0;
	double absTotal = -1.11;
	
	///P & L Report Variables
	//Cost of Goods Sold
	//Pulls from cashDrawer and card auth 
	double cogs = 0;
	double taxChecker = 0;
	
	public CalcTotal() {
		//this.table = t;
	}
	
	
	
	public double generateTotal(double price,double cos, JTable t) {
		this.table = t;
		setSubTotal(price);
		setCogs(cos);
		return this.getTotal();	
	}
	
	public void setSubTotal(double price) {
		this.subTotal += price;
		this.tax = (subTotal * taxRate);
		this.absTotal = (subTotal + tax);
		this.qty++;
	}
	
	private void setCogs(double c) {
		this.cogs = c;
	}
	
	public double getCogs() {
		return this.cogs;
	}
	
	public double[] generateRecord() {
		this.subTotal += Double.parseDouble(table.getValueAt(i, 2).toString());
		this.tax += (taxRate * this.subTotal);
		//this.qty += Double.parseDouble(t.getValueAt(i, 1).toString());
		i++;
		a[0] = getTotal();
		this.qty = i;
		return new double[] {this.subTotal, this.tax, this.qty, this.cogs};
  }
	
//	
//	private void seqence() {
//	
//		//setTax();
//		//getTax();
//	setTotal();
//	//getTotal();
//	
//	}
////	public void generateTotal(JTable table) {
////		for(int i = 0; i < table.getRowCount(); i++) {
////			subTotal += Double.parseDouble(table.getValueAt(i, 2).toString());
////			qty += Double.parseDouble(table.getValueAt(i, 1).toString());
////		}
////	  }
	
	public void setTax() {
		tax = (taxRate * subTotal);
	}

	public double getTax() {
		return (tax);
	}
	
	public void setTotal() {
		absTotal = (tax + subTotal);
	}
	
	public double getTotal() {
		return (absTotal);
	}
	
	public int getQty() {
		return (qty);
	}
	
	public double getSubTotal() {
		return this.subTotal;
	}
	
	public void resetTotal() {
		this.subTotal = 0;
		this.tax = 0;
		this.absTotal = 0;
		this.qty = 0;
	}
	
}
