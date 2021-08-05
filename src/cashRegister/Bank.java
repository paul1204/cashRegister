package cashRegister;

import java.util.*;
//import java.io.*;

public class Bank {

	String name = "Java Banking Solutions";
	
    
	private Hashtable<Integer, String> customers;
	private Hashtable<Integer, Integer> cardNumber;
	private Hashtable<Integer, Double> cardBalance;
	private Hashtable<Integer, Integer> cardPin;
	private Hashtable<Integer, Integer> zipCode;
	
	public Bank(){setCustomers();}
	
	//The bank is receiving a request with cardInformation. 
	//Check to see if the Pin matches, then Check Balance
	
	public boolean bankAuth(creditCardMock card, int userKey, double price, int binaryKey) {
		boolean a = false,b = false;
		
		if(binaryKey != 1) {
			//Sequence 1a - Check if Pin is Valid
			a = validatePin(card , userKey);
		}
		
		if(binaryKey != 0) {
			//Sequence 1b - Check if Zip is Valid
			a = validateZip(card, userKey);
		}
		
		//Sequence 2- Check if there is enough Balance
		b = checkBalance(card, price);
		//AND Truth Table
		return (a && b);
	}

	private boolean validateZip(creditCardMock card, int zip) {
		int num = card.getCardNum();
		if(zip == zipCode.get(num)) {
			return true;
		}
		return false;
	}
	 
	
	private boolean validatePin(creditCardMock card, int pin) {
		int num = card.getCardNum();
		if(pin == cardPin.get(num)) {
			return true;
		}
		return false;
	}
	
	private boolean checkBalance(creditCardMock card, double price) {
		int num = card.getCardNum();
		double bal = cardBalance.get(num);
		if(price <= bal) {
			//Updates Customer's Balance
			cardBalance.replace(num, bal, Math.abs((bal - price)));
			return true;
		}
		return false;
	}
	 
	private void allocateTables() {
		customers = new Hashtable<>();
		cardNumber = new Hashtable<>();
		cardBalance = new Hashtable<>();
		cardPin = new Hashtable<>();
		zipCode = new Hashtable<>();
	}
	
	
	private void setCustomers() {
				allocateTables();
		
							//Account Number -> Name
				customers.put(654321, "Bob Bobby");
				customers.put(987654, "Bill Billy");
				customers.put(213141, "Waldo");
				customers.put(817161, "Bugs Bunny");
				
							//Account Number -> Card Number
				cardNumber.put(654321, 12345);
				cardNumber.put(987654, 56789);
				cardNumber.put(213141, 101112);
				cardNumber.put(817161, 13141516);	
				
							//Card Number -> Available Balance
				cardBalance.put(12345, 100.00);
				cardBalance.put(56789, 100.00);
				cardBalance.put(101112, 1000.00);
				cardBalance.put(13141516, 5.00);
				
							//Card Number -> cardPin
				cardPin.put(12345, 7412);
				cardPin.put(56789, 7896);
				cardPin.put(101112, 7532);
				cardPin.put(13141516, 7536);	
				
							//Card Number -> Zip 
				zipCode.put(12345, 23866);
				zipCode.put(56789, 23867);
				zipCode.put(101112, 23868);
				zipCode.put(13141516, 23869);
				
	}
}