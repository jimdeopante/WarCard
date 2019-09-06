package warcard;
import java.util.ArrayList;


public class Deck {
	
    ArrayList <Card> deckofcards = new ArrayList <Card>();
    
    public Deck(){
    	//stores 52 cards in the ArrayList
    	   
    	for (int suits = 3; suits >= 0; suits--) {
    		for (int ranks = 12; ranks >= 0; ranks--) {
  			  deckofcards.add(new Card(ranks, suits));
  			
    		}
    	}
    }    			
}
    
    	
    	
    	
    

   
   

    
    
    
    
    
