package cashRegister;

public class creditCardAuth extends cardAuth{
	
	@Override
	public boolean auth(creditCardMock card, int pin, double price) {
		return cardProcess.bankAuth(card, pin, price);
	}
}

abstract class cardAuth{
	 Bank cardProcess;
	 cardAuth() {cardProcess = new Bank();}
	 abstract boolean auth(creditCardMock card, int pin, double price);
}

