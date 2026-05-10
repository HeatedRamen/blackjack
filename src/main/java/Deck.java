import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<>();
    }

    public int getSize(){ return deck.size(); }

    // Shuffle deck
    public void shuffle(){
        Collections.shuffle(deck);
    }

    // Deal card from top of deck and remove it
    public Card dealCard(){
        Card dealtCard = deck.get(0);
        deck.remove(0);
        return dealtCard;
    }

    public void fillDeck(int numDecks) {

        String[] suits = {"Hearts", "Diamond", "Clubs", "Spades"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8",
                "9", "10", "J", "Q", "K", "A"};

        for (int i = 0; i < numDecks; i++) {

            for (String suit : suits) {
                for (String value : values) {
                    Card card = new Card(suit, value);
                    deck.add(card);
                }
            }
        }
    }
}

