import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {

    static Scanner input = GamblingApp.input;
    private ArrayList<Player> players = new ArrayList<>();
    private Player dealer = new Player("Dealer");
    private Deck deck = new Deck(6);


    public void runBlackjack(){

        boolean isRunning = true;

        deck.shuffle();

        getPlayers();

        while (isRunning) {
            dealHands();

            for (Player player : players) {
                player.displayHand();
            }
            dealer.displayHand();
            checkWinner();
            promptKeepPlaying();
        }
    }

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
    public void dealHands() {

        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                player.receiveCard(deck.deal());
            }
                dealer.receiveCard(deck.deal());
        }
    }

    public void checkWinner(){
        for (Player player : players){
            if (player.getHand().getCardValue() > dealer.getHand().getCardValue()){
                System.out.println("Congrats " + player.getName() + "! You won!");
            }
        }
    }

    public void promptKeepPlaying(){
        System.out.println("Do you want to keep playing? (Y/N)");
        String userChoice = getPlayingChoice();

        switch (userChoice) {
            case "Y":
                checkDeck();
                clearHands();
            case "N":
                return;
            default:
                System.out.println("Invalid option! You're forced to play again >:)");

        }

    }

    public String getPlayingChoice() { return input.nextLine().trim().toUpperCase(); }

    public void checkDeck(){
        if(deck.getSize() < (players.size() + 1) * 2) {
            deck.refillDeck(6);
            deck.shuffle();

        }
    }

    public void clearHands(){
        for (Player player : players){
            player.getHand().clearHand();
        }
        dealer.getHand().clearHand();
    }
}
