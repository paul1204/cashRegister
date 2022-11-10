package receipt;
import java.util.ArrayList;

import cashRegister.CalcTotal;
import items.Item;

public class MasterReceipt {

	String storeName = "xyz store";
	String address = "101 E Main Street";
//public String addressNumber;
//public String addressOne;
//public String addressTwo;
	String city = "Richmond";
    String zip = "23888";
	String phone = "7577202082";
	
	double subTotal;
	int qty;
	double absTotal;
	
	int transactionNum;
	ArrayList<Item> receiptItems = new ArrayList<Item>(); 
	
	public MasterReceipt() {
	}
	
	public void pushTotalToReceipt(CalcTotal total,  int transactionNumber) {
		this.subTotal = total.getSubTotal();
		this.qty = total.getQty();
		this.absTotal = total.getTotal();
		this.transactionNum = transactionNumber;
		//this.receiptItems = list;	
	}

	
	public void addItem(Item i) {
		this.receiptItems.add(i);
	}
	
	public void clearReceipt() {
		receiptItems.clear();
		this.subTotal = 0;
		this.qty = 0;
		this.absTotal = 0;
		transactionNum = 0;
	}
	
	public String toJson() {
		return "";
	}
	
	public CustomerReceipt generateChildReceipt(CustomerReceipt receipt) {
			receipt.storeName = this.storeName;
			receipt.phone = this.phone;
			receipt.absTotal = this.absTotal;
			receipt.transactionNum = this.transactionNum;
			receipt.receiptItems = this.receiptItems;
			
			return receipt;
	}
	
	
}
