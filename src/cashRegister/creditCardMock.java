package cashRegister;

class creditCardMock {

	private int cardNum;
	//private String fullName;
	String fullName;
	private int pin;
	
	//private int month;
	//private int yearExp;
	
	//private int secCode;
	
	public creditCardMock(int cardNumber, String name, int pin) {
		this.cardNum = cardNumber;
		this.fullName = name; 
		this.pin = pin;
	}
	
	//From User
	public int getPin() {
		return this.pin;
	}

	public int getCardNum() {
		return this.cardNum;
	}
	
}
