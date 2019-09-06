package warcard;


public class Card {
    
	
    final public static String []  SUITOFCARDS = {
    		"C","S","H","D"
    };
    
    final public static String[] RANKOFCARDS ={
    		"2","3","4","5","6","7","8","9","10","J","Q","K","A"
    };
    
    public int suits;
    public int ranks;
    
    //card constructor
    public Card(int cardRank, int cardSuit){
        this.suits = cardSuit;
        this.ranks = cardRank;
    }
    	
    	public int getSuits(){
    		return suits;
    	}
    	
    	 public int getRanks(){
    		return ranks;
    	 }
    	 
    	 public int cardValue(){
    		 return(suits+1) + (4*ranks);
    	 }
    	
    	public String toString(){
    		return "[" + SUITOFCARDS[suits] + "-" + RANKOFCARDS[ranks] + "]";
    		}
     
    	}

		
	


