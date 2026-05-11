import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<>();
    }

    public void addCard(Card card){ hand.add(card); }
    public void clear(){ hand.clear(); }
    public int getSize(){ return hand.size();}
    public int getCardValue(){

        int handValue = 0;
        int numAces = 0;

        for (Card card : hand){
            if(card.getValue().equalsIgnoreCase("A")){
                numAces++;
            }
            handValue += card.getPointValue();
        }

        while (handValue > 21 && numAces > 0){
            handValue -= 10;
            numAces--;
        }
        return handValue;
    }

    public String showOneCard(){ return hand.get(0).toString(); }

    @Override
    public String toString() {

        String handValue = "";

        for (Card card : hand){
            handValue += card + " ";
            }

        return handValue;
        }
    }

