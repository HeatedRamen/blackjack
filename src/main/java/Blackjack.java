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
            dealer.displayHand();
            promptHits();

            checkWinner();
            isRunning = promptKeepPlaying();
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
                player.receiveCard(deck.dealCard());
            }
                dealer.receiveCard(deck.dealCard());
        }
    }

    public void promptHits(){
        boolean isStand;

        for(Player player : players){

            isStand = false;

            while(!isStand) {
                player.displayHand();
                System.out.println("Do you want to hit or stand? (H/S)");
                String playerAction = getPlayingChoice();

                switch (playerAction) {

                    case "H":
                        player.receiveCard(deck.dealCard());
                        break;

                    case "S":
                        isStand = true;
                        break;

                    default:
                        System.out.println("Invalid Option! You're forced to stand >:)");
                        isStand = true;
                }
            }

        }
    }
    public void checkWinner(){

        boolean isWinner = false;

        for (Player player : players){
            if (player.getHand().getHandValue() > dealer.getHand().getHandValue() &&
                player.getHand().getHandValue() <= 22){
                System.out.println("Congrats " + player.getName() + "! You won!");
                isWinner = true;
            }
        }

        if (!isWinner){
            System.out.println("Womp Womp no one beat the dealer...");
        }
    }

    public boolean promptKeepPlaying(){

        // Prompt the using to keep playing
        System.out.println("Do you want to keep playing? (Y/N)");
        String userChoice = getPlayingChoice();


        switch (userChoice) {

            case "Y":
                checkDeck();
                clearHands();
                return true;

            case "N":
                return false;

            default:
                System.out.println("Invalid option! You're forced to play again >:)");
                return true;
        }
    }

    public String getPlayingChoice() { return input.nextLine().trim().toUpperCase(); }

    public void checkDeck(){

        // Seems like a random number, but it's at the 3 deck mark so its probably time for a new shoe
        if(deck.getSize() < 156) {

            // Adds all the cards back then shuffles
            deck.refillDeck(6);
            deck.shuffle();
        }
    }

    public void clearHands(){

        for (Player player : players){
            player.clearHand();
        }
        dealer.clearHand();
    }

}
