package cashRegister;

public class gasPumps extends cardAuth{
	creditCardMock card = new creditCardMock(13141516 ,"Bugs Bunny", 7536);
	
	int pumpNum;
	int selectOctane = -1;
	final int regular = 0;
	final int midGrade = 1;
	final int premium = 2;
	

	public boolean auth(creditCardMock card, int zip, double price) {
		return cardProcess.bankAuth(card, zip, price);
	}
	
}








