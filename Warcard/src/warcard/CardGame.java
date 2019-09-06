package warcard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CardGame {

	static Deck deck = new Deck();
	ArrayList <Player> players;
	private static Scanner scan; 
	int roundnumber;

	public static void main(String[] args) {
	   
		CardGame cardgame = new CardGame();
	   
	 //declare the variables
		   scan = new Scanner(System.in);
		   int numberofplayers = 0;
		   int numberofshuffle = 0;
		   boolean  numplayererror = false;
		   boolean  numshuffleerror = false;
		  
		   	   
		   //display the title of the game
		   System.out.println("^^^^^^^^^^WARCARDGAME^^^^^^^^");
		   System.out.println();
		   
		   //ask for the number of players      
		   do {
			   System.out.println();
			   System.out.println("Enter Number of Players (2-52): ");
		           if (scan.hasNextInt()) {
		        	   numberofplayers = scan.nextInt();
		               if (numberofplayers >=2 && numberofplayers <=52) {
		            	   numplayererror = true;
		               } else {
		            	   scan.nextLine();
		            	   System.out.println("Please choose only from numbers 2 to 52.");
		               	 } 
		           } else {
		           		   scan.nextLine();
		           		   System.out.println("Please put a valid number from 2 to 52");
		           	   }
		   
		   } while (!numplayererror);
		   
		   
		   //ask how many times will the deck be shuffled
		   do {
			   System.out.println();
			   System.out.println("Enter Number of Shuffle/s (0-7): ");
		           if (scan.hasNextInt()) {
		        	   numberofshuffle = scan.nextInt();
		               if (numberofshuffle >=0 && numberofshuffle <=7) {
		            	   numshuffleerror = true;
		               } else {
		            	   scan.nextLine();
		            	   System.out.println("Please choose only from numbers 0 to 7.");
		               	 } 
		           } else {
		           		scan.nextLine();
		           		System.out.println("Please put a valid number from 0 to 7.");
		           	 }
		
		   	} while (!numshuffleerror);
		   

		    System.out.println();
		   	System.out.println("Initial Deck of Cards:");
		   	for(int i=0; i<52; i++){
		   		System.out.print(deck.deckofcards.get(i));
		   	}
		   
		   	cardgame.play(numberofplayers, numberofshuffle);
		   	
	}
	

	
	public void play(int numberofplayers, int numberofshuffle) {
	   
		
		    ArrayList <Card> shuffleddeck = new ArrayList <>();
		    
		    Deck cardpile	= new Deck();   
		    
		    	System.out.println();
		       
			    if (numberofshuffle == 0){
			    	System.out.println("The Deck Is Not Shuffled");
			    	shuffleddeck.addAll(deck.deckofcards);
			    }
			    
			    //shuffle the deck of cards using Faro shuffle
			    if (numberofshuffle != 0){
			    	System.out.println();
			    	System.out.println("Shuffled Deck of Cards:");
			    
			    	for (int s=0; s<numberofshuffle; s++) {
			    		shuffleddeck.clear();
			    		for(int i=0; i<13; i++ ) {
			    			int j = i+26;
			    			shuffleddeck.add(cardpile.deckofcards.get(i));
			   
			    			shuffleddeck.add(cardpile.deckofcards.get(j));
			    		}
			   
			  
			    		for(int k=13; k<26; k++ ) {
			    			int l = k+26;
			    			shuffleddeck.add(cardpile.deckofcards.get(k));
			   
			    			shuffleddeck.add(cardpile.deckofcards.get(l));
			   
			    		}
			   
			    		cardpile.deckofcards.clear();
			    		cardpile.deckofcards.addAll(shuffleddeck);
			 
			       }
			   
			    	//prints the shuffled deck
			    	
			    	for (Card cardx : shuffleddeck) {
			    		System.out.print(cardx);
		     
		    	} 
		    }
	    
		    //creates an ArrayList of players
		    
			players = new ArrayList <>(); 
		    
				  for (int x = 0; x < numberofplayers; x++){
					  players.add(new Player());
				  }
				  
				  //distributes the cards to the players
				  
				  while (!shuffleddeck.isEmpty()){
					  for (int x = 0; x < numberofplayers; x++) {
						  players.get(x).cardsofplayer.add(0,shuffleddeck.remove(0));
						  if (shuffleddeck.isEmpty()) {
							  break;
						  }
					  }
				  }
		
				  //shows initial cards of players
				  
				  System.out.println();
				  System.out.println();
				  System.out.println("Initial Cards of Players:");
				  			  
				  for (int x = 0; x < numberofplayers; x++){
					  System.out.print("Player" + String.valueOf(x+1));
					  System.out.println(players.get(x).cardsofplayer);
				  }	  
				  
				  System.out.println();
				  System.out.println("Start of War Card Game");
				  System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^");
				
				//the game will continue while number of players with not empty card/s is greater than 1
				
				while (multipleNonEmptyPlayers(players, numberofplayers)) {
					generateRoundString(numberofplayers);
				   
				} 
					//declaration of winner of the game
					System.out.println();
					System.out.println("Player " + players.get(0).getPlayerNumber() + " WINS THE GAME!");
					System.out.println(players.get(0).cardsofplayer);  //gets player 0 because that player remains in the game
				
				}
			
		
		private void  generateRoundString(int numberofplayers) {
				  
				int roundwinner = 0;
				int cardValue = 0;
				int highestvaluecard = 0;
				int index = 0;
				String roundString = "Round " + ++roundnumber  ;
					
					for (int i=0; i< players.size(); i++) {
					    roundString += ", Player " + players.get(i).getPlayerNumber() 
					    		+ this.players.get(i).getTopCard() ; 
					    cardValue = this.players.get(i).getTopCard().cardValue(); /*+ players.get(i).handcard.get(0).cardValue();*/
					    
					    //comparing card values of the top card of each player
					    if  (highestvaluecard < cardValue) {
					    	roundwinner = i;
					    	highestvaluecard = cardValue;
					    	System.out.println();
					    
					    }
								
					}
					
					//the winner collects all the cards in order
					for (int x = roundwinner; x < players.size(); x++) {
						players.get(roundwinner).cardsofplayer.add(players.get(x).removeCard());
					}	
					
					for (int x = 0; x < roundwinner; x++) {
						players.get(roundwinner).cardsofplayer.add(players.get(x).removeCard());
					}
		
						//shows round number
					System.out.println(roundString);
				
					
					//shows the winner of the round
				  	System.out.println("Player " + (players.get(roundwinner).getPlayerNumber()) 
				  			+ " Wins Round " + roundnumber + "!");
				  	System.out.println("Cards of Players After Round " + roundnumber + ":");
				  	
				  	//prints the cards of players after each round
					for (int x = 0; x < players.size(); x++){
						  System.out.print("Player" + players.get(x).getPlayerNumber());
						  System.out.println(players.get(x).cardsofplayer);
					 }
					
					System.out.println();
				  	
					//eliminates players with 0 cards
				    while (index != players.size()){
				  		if (players.get(index).cardsofplayer.isEmpty()){
				  			players.remove(index);
				  		}
				  	 else
						index++;
				     }	
		}
	
				//condition for the while statement, if the players with not empty cards is still greater than 0, the game will continue
				boolean multipleNonEmptyPlayers(List<Player> players, int numberofplayers) {
					
					int numNonEmpty = 0;
			
					for (int i=0; i<players.size(); i++) {
						if (players.get(i).handSize() > 0) {
							numNonEmpty ++;
						}
					}
					return numNonEmpty > 1;
				}
		
}
