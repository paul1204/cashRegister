package cashRegister;

public class creditCardReader {
	//This Card Reader is Located within the Store
	
	//We instantiate a Credit Card here because we will be using it on the Card Reader.
	creditCardMock card = new creditCardMock(13141516 ,"Bugs Bunny", 7536);
	private int samplePin = 7536;
	
	public creditCardReader() {
		initialize();
	}
	
	public creditCardMock acceptCard(){
		return card;
	}
	
	//Customer Typing in their Pin
	public int acceptPin() {
		//Implement a Pin Pad UI
		return samplePin;
	}
	
	private void initialize() {
		//Turn on 
	}
}