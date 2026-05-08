import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {

    static Scanner input = GamblingApp.input;
    private ArrayList<Player> players = new ArrayList<>();

    public void getPlayers() {

        boolean keepPrompting = true;
        while (keepPrompting) {

            System.out.println("Enter all player names separated by \",\"");
            String playerNames = input.nextLine().trim();
            addPlayers(playerNames);

            System.out.println("Do you want to add more players? (Y/N):");
            String userInput = input.nextLine().trim().toUpperCase();

            switch (userInput) {
                case "Y":
                    break;

                case "N":
                    keepPrompting = false;
                    break;

                default:
                    System.out.println("Please enter a valid choice");
            }
        }
    }
    public void addPlayers(String playerList) {
        String[] parsedPlayerNames = playerList.split(",");
        for (String player : parsedPlayerNames) {
            players.add(new Player(player.trim()));
        }
    }
    public void dealHands(Deck deck) {

        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                player.receiveCard(deck.deal());
            }
        }
    }
    public void runBlackjack(){

        Deck deck = new Deck(6);
        getPlayers();
        dealHands(deck);

        for (Player player : players){
            player.displayHand();
        }
    }
}
