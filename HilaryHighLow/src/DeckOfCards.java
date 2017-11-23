
public class DeckOfCards { // begin DeckOfCards data type 

   // playing cards of deck of cards 
   private PlayingCard[] deck; 

   // count of the number of playing 
   // card remaining in the deck. 
   private int count;  
   // invariant: 0 <= count <= PlayingCard.SUITS.length * PlayingCard.RANK.length

   // construct a deck of 56 different playing cards in rank order 
   // arranged by suit, ie, not shuffled.   
   public DeckOfCards() { 
      int suits = PlayingCard.SUITS.length; 
      int ranks = PlayingCard.RANKS.length; 
      count = suits * ranks;  

      deck = new PlayingCard[count]; 

      for (int suitIndex = 0; suitIndex < suits; suitIndex++) 
         for (int rankIndex = 0; rankIndex < ranks; rankIndex++) 
            deck[suitIndex * ranks + rankIndex] =  
               new PlayingCard(rankIndex, suitIndex); 
   } 

   // have all playing cards in the deck been dealt? 
   public boolean isEmpty() {  
	   if(count==0){
		   return true;
	   }
	   else {
		   return false;
	   }
    
   }  
   // return the top playing card from the 
   // deck of cards assuming the deck is non-empty, 
   // otherwise the cards that have been dealt are
   // re-shuffled and the new top playing card is dealt. 
   public PlayingCard deal() { 
	   if (isEmpty()==true){
		  count= PlayingCard.SUITS.length*PlayingCard.RANKS.length;
		  shuffle();
		  
	   }
		   PlayingCard cardDrawn = deck[count-1];
		   count--;
		   return cardDrawn;
	   
      // ... you must fill in the body of this method! 
   } 
   // randomaly shuffle the remaining playing cards in the deck. 
   public void shuffle() { 
	   int tempNum=0;
	   for(int i=0;i<=deck.length-1;i++){
		   PlayingCard temp= deck[i];
		   tempNum =(int)(Math.random()*deck.length);
		   deck[tempNum]= temp;
		   deck[i]=deck[tempNum];
	   } 
   } 
   
   // convert the deck of cards to pictographs in a String value.  
   public String toPictographs() { 
       String deckAsString = ""; 
       for(int index = 0; index < count; index++) {  
          deckAsString = deckAsString + deck[index].toPictograph() + " "; 
          if ((index + 1) % PlayingCard.RANKS.length == 0) 
             deckAsString = deckAsString + "\n";             
       } 
       return deckAsString; 
   } 

   // test the DeckOfCards data type by creating a deck of cards 
   // then suffling the deck and dealing two cards from the deak. 
   public static void main(String[] args) { 
      System.out.println("Deck of cards:"); 
      DeckOfCards deck = new DeckOfCards(); 
      System.out.println(deck.toPictographs()); 
      deck.shuffle();
      System.out.println("Shuffle the deck:"); 
      System.out.println(deck.toPictographs());
      for (int index=1;index<=56;index++){
    	  deck.deal();
    	 boolean done= deck.isEmpty();
    	  System.out.println(done);
    	  System.out.println(deck.toPictographs()); 
      }
      for(int index=1;index<55;index++){
    	 PlayingCard card = deck.deal();
    	 String input = card.toString();
    	 System.out.println(input);
    	
      }
      PlayingCard card = deck.deal();
      System.out.println("Deal a card:"); 
      System.out.println(card.toPictograph()); 
      System.out.println("Remaining cards in deck:"); 
      System.out.println(deck.toPictographs()); 
      PlayingCard nextCard = deck.deal(); 
      System.out.println("Deal another card:"); 
      System.out.println(nextCard.toPictograph()); 
      System.out.println("Remaining cards in deck:"); 
      System.out.println(deck.toPictographs()); 
   } 

} // end DeckOfCards data type