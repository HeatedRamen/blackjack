public class Player {
    private String name;
    private Hand hand;
    private int chips;

    public Player(String name){
        this.name = name;
        hand = new Hand();
    }
    public Player(String name, int chips){
        this.name = name;
        this.chips = chips;
    }

    public String getName() { return name; }

    public Hand getHand() { return hand; }
    public void setHand(Hand hand) { this.hand = hand; }

    public int getChips(){ return chips; }
    public void setChips(int chips) { this.chips = chips; }

    public void displayHand(){
        System.out.println(name + " hand: " + hand.getValue() + "\n" + hand.getCardValue());
    }
}
