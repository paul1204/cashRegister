package cashRegister;

//import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat; 

public class CloseShift {

	double sales = 0;
	double tax = 0;
	int qty = 0;
	//Cost of Goods Sold
	double cogs = 0;
	
	
	File shiftReport; // = new File("Shift_Report.txt");
	FileWriter w; // = new FileWriter(shiftReport);
	
	public CloseShift() {
		
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
	
	public void reset() {
		this.sales = 0;
		this.tax = 0;
		this.qty = 0;
		this.cogs = 0;
	}
	
	
	public void close() {
		
		try {
			shiftReport = new File("shiftReport.txt");
			w = new FileWriter(shiftReport);
		} catch (IOException e) {
			e.printStackTrace();}
		
		String salesStr = Double.toString(sales);
		DecimalFormat d = new DecimalFormat("###.##");
		String taxStr = d.format(tax);
		String qtyStr = Integer.toString(qty);
	//	String cogsStr = Double.toString(cogs);
		
			try {
				w.write("Sales ");
				w.write(salesStr);
				w.write(" ");
				w.write("Tax ");
				w.write(taxStr);
				w.write(" ");
				w.write("Qty ");
				w.write(qtyStr);
				w.write(" ");
				//write.write(cogsStr);
				//this.reset();
				w.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

}