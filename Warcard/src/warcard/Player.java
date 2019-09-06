package warcard;

import java.util.ArrayList;



public class Player {
	int id = 0;
	public static int playernumber = 0;

	public Player(){
		id = ++playernumber;
	}
		
	public int getPlayerNumber(){
		  return id;
	}
	
	public ArrayList <Card> cardsofplayer = new ArrayList <>();
	
	public ArrayList<Card> getHand() {
		return cardsofplayer;
	}
	
	public int handSize() {
		return cardsofplayer.size();
	}
	
	public boolean hasCards( ) {
		return cardsofplayer.size() > 0;
	}

	public Card getTopCard(){
		return cardsofplayer.get(0);
	}
	
	public Card removeCard(){
		return cardsofplayer.remove(0);
	}


}



