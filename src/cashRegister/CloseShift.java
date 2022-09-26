package cashRegister;

//import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.opencsv.CSVWriter; 

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
	
	
	public File close() {
		

		try {
			shiftReport = new File("/home/paul/Desktop/csvFile/shiftReport.csv");
			w = new FileWriter(shiftReport);
			  
		   // create CSVWriter object filewriter object as parameter
		   CSVWriter writer = new CSVWriter(w);
			
		String salesStr = Double.toString(sales);
		DecimalFormat d = new DecimalFormat("###.##");
		String taxStr = d.format(tax);
		String qtyStr = Integer.toString(qty);
		String cogsStr = Double.toString(cogs);
		
			
			//ArrayList<String[]> data = new ArrayList<String[]>();
		   // data.add(new String[] { salesStr, taxStr, qtyStr });
		//	writer.writeAll(data);
		//Don't delete these yet		
//				w.write("Sales ");
				w.write(salesStr);
				w.write(",");
//				w.write("Tax ");
				w.write(taxStr);
				w.write(",");
//				w.write("Qty ");
				w.write(qtyStr);
				w.write(",");
				w.write(cogsStr);
				//this.reset();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();	
}
		return shiftReport;	
	}	
}