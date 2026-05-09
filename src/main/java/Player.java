public class Player {
    private final String name;
    private Hand hand;
    private int chips;

    public Player(String name){
        this.name = name;
        hand = new Hand();
        this.hand = new Hand();
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

    public void displayHand(){
        System.out.println(name + " hand: " + hand.getValue());
    }

    public void receiveCard(Card card){
        hand.deal(card);
    }
    public void clearHand(){
        hand.clear();
    }
}
