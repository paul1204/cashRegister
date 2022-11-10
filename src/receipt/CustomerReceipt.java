package receipt;

import java.util.ArrayList;

import items.Item;

public class CustomerReceipt extends MasterReceipt{

	String storeName;
	String phone;
	
	double absTotal;
	
	int transactionNum;
	ArrayList<Item> receiptItems;
	
	
	
}