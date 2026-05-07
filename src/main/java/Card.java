public class Card {
    private final String suit;
    private final String value;

    public Card (String suit, String value){
        this.suit = suit;
        this.value = value;
    }

    public String getSuit(){ return suit; }
    public String getValue(){ return value; }

    public int getPointValue() {
        if (    value.equalsIgnoreCase("K") ||
                value.equalsIgnoreCase("Q") ||
                value.equalsIgnoreCase("J")){
            return 10;
        } else if (value.equalsIgnoreCase("A")){
            return 11; // ?
        }else { return Integer.parseInt(value); }
    }

}
