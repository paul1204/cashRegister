package cashRegister;

public class gasPumps extends pump{
	creditCardMock card = new creditCardMock(13141516 ,"Bugs Bunny", 7536);
	
	int pumpNum;
	int selectOctane = -1;
	int regular = 0;
	int midGrade = 1;
	int premium = 2;
	

	@Override
	void pumpFuel() {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	creditCardMock readCard() {
		return card;
		
	}

	@Override
	void selectOctance() {
		// TODO Auto-generated method stub
		
	}
	
}

enum Octane{Regular,Midgrade,Premium}

abstract class pump{	
	abstract void selectOctance();
	void selectOctane(Octane gas) {}
	abstract void pumpFuel(); 
	abstract creditCardMock readCard();
}




