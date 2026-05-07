import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;

    // Standard 1 deck
    public Deck(){

        deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamond", "Clubs", "Spades"};
        String[] values = {"2","3","4","5","6","7","8",
                            "9","10","J","Q","K","A"};

        for (String suit : suits){
            for (String value : values){
                Card card = new Card(suit, value);
                deck.add(card);
            }
        }
    }

    // Multiple decks
    public Deck(int numDecks){

        deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamond", "Clubs", "Spades"};
        String[] values = {"2","3","4","5","6","7","8",
                "9","10","J","Q","K","A"};

        for (int i = 0 ; i < numDecks ; i++){
            for (String suit : suits){
                for (String value : values){
                    Card card = new Card(suit, value);
                    deck.add(card);
                }
            }
        }
    }

    public int getSize(){ return deck.size(); }

    // Shuffle deck
    public void shuffle(){
        Collections.shuffle(deck);
    }

    // Deal card from top of deck and remove it
    public Card deal(){
        Card dealtCard = deck.get(0);
        deck.remove(0);
        return dealtCard;
    }
}

