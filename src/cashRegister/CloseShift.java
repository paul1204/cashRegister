package cashRegister;

//import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException; 

public class CloseShift {

	double sales = 0;
	double tax = 0;
	int qty = 0;
	//Cost of Goods Sold
	double cogs = 0;
	
	
	File shiftReport; // = new File("Shift_Report.txt");
	FileWriter w; // = new FileWriter(shiftReport);
	
	public CloseShift() {
		try {
			shiftReport = new File("C:\\Users\\pauls\\eclipse-workspace\\cashRegisterTutorial\\src\\Shift_Report.txt");
			w = new FileWriter(shiftReport);
		} catch (IOException e) {
			e.printStackTrace();}
	}
	
	//Gross Sales
	public void addSales(double sales) {
		this.sales += sales;
	}
	//Donations
	public void addTax(double tax) {
		this.tax += tax;
	}
	
	//Needed for Inventory 
	public void addQty(int qty) {
		this.qty += qty;
	}
	
	//Cost of Goods Sold 
	public void addCogs(double cogs) {
		this.cogs += cogs;
	}
	
	
	
	
	public void close() {
		String salesStr = Double.toString(sales);
		String taxStr = Double.toString(tax);
		String qtyStr = Integer.toString(qty);
	//	String cogsStr = Double.toString(cogs);
		
			try {
				w.write(salesStr);
				w.write(" ");
				w.write(taxStr);
				w.write(" ");
				w.write(qtyStr);
				w.write(" ");
				//write.write(cogsStr);
				w.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		
	}

}