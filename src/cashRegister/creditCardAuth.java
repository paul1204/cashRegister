package cashRegister;

public class creditCardAuth extends cardAuth{
	public boolean auth(creditCardMock card, int pin, double price) {
		return cardProcess.bankAuth(card, pin, price, 0);
	}
}

abstract class cardAuth{
	 Bank cardProcess;
	 cardAuth() {cardProcess = new Bank();}
}

