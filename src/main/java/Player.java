public class Player {
    private final String name;
    private Hand hand;
    private int chips;

    public Player(String name){
        this.name = name;
        this.hand = new Hand();
        chips = 1000;
    }
    public Player(String name, int chips){
        this.name = name;
        this.chips = chips;
        this.hand = new Hand();
    }

    public String getName() { return name; }

    public Hand getHand() { return hand; }


    public int getChips(){ return chips; }
    public void setChips(int chips) { this.chips = chips; }

    public void displayCard(){
        System.out.println(name + " hand: " + hand.showOneCard());
    }
    public void displayHand(){
        System.out.println(name + " hand: " + hand + "\nValue: " + getHandValue());
    }

    public void receiveCard(Card card){
        hand.addCard(card);
    }
    public void clearHand(){
        hand.clear();
    }
    public int getHandValue(){
        return hand.getCardValue();
    }
    public boolean hasBlackjack(){ return getHandValue() == 21 && hand.getSize() == 2; }
}
