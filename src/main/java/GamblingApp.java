import java.util.ArrayList;
import java.util.Scanner;

public class GamblingApp {

    private static ArrayList<Player> players = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        boolean stillGambling = true;
        String gamblingCommand = "";

        Deck deck = new Deck(6);
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        deck.shuffle();

        while (stillGambling && deck.getSize() > 0) {
            playerHand.deal(deck.deal());
            dealerHand.deal(deck.deal());
            playerHand.deal(deck.deal());
            dealerHand.deal(deck.deal());

            println("Dealer Hand: " + dealerHand.getValue() + "\n" + dealerHand.getCardValue());
            println("Player Hand: " + playerHand.getValue() + "\n" + playerHand.getCardValue());

            // Reset hand
            dealerHand.clearHand();
            playerHand.clearHand();

            println("Do you want to continue? (X to exit)");
            gamblingCommand = input.nextLine();

            if (gamblingCommand.equalsIgnoreCase("X")) {
                stillGambling = false;
            }
        }
    }

    static public void println(String message){
        System.out.println(message);
    }
}
