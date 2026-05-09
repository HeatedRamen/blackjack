import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<>();
    }

    public void deal(Card card){
        hand.add(card);
    }

    public String getValue(){

        String handValue = "";

        for (Card card : hand){
            switch (card.getSuit()){
                case "Hearts" -> handValue += card.getValue() + "♥ ";
                case "Diamond" -> handValue += card.getValue() + "♦ ";
                case "Spades" -> handValue += card.getValue() + "♠ ";
                case "Clubs" -> handValue += card.getValue() + "♣ ";
                default -> handValue += card.getValue() + " ";
            }
        }

        return handValue;
    }

    public int getHandValue(){

        int handValue = 0;

        for (Card card : hand){
            handValue += card.getPointValue();
        }
        return handValue;
    }
    public void clear(){
        hand.clear();
    }



}
