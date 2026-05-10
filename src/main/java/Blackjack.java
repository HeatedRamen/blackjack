import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {

    static Scanner input;
    private ArrayList<Player> players;
    private Player dealer;
    private Deck deck;


    Blackjack(){
        input = GamblingApp.input;
        players = new ArrayList<>();
        dealer = new Player("Dealer");
        deck = new Deck();
    }

    public void runBlackjack() {

        boolean isRunning = true;

        deck.fillDeck(6);
        deck.shuffle();
        getPlayers();

        while (isRunning) {
            dealHands();
            dealer.displayCard();
            promptHits();

            dealer.displayHand();
            playDealer();

            checkWinner();
            isRunning = promptKeepPlaying();
        }
    }

    public void getPlayers() {

        boolean keepPrompting = true, validInput;

        while (keepPrompting) {

            System.out.println("Enter all player names separated by \",\"");
            String playerNames = getPlayerChoice();
            addPlayers(playerNames);

            validInput = false;
            while (!validInput) {
                System.out.println("Do you want to add more players? (Y/N):");
                String userInput = getPlayerChoice();

                switch (userInput) {
                    case "Y":
                        validInput = true;
                        break;

                    case "N":
                        keepPrompting = false;
                        validInput = true;
                        break;

                    default:
                        System.out.println("Please enter a valid choice");
                }
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

    public void promptHits() {
        boolean isStand;

        for (Player player : players) {

            isStand = false;
            player.displayHand();

            while (!isStand) {
                System.out.println("Do you want to hit or stand? (H/S)");
                String playerAction = getPlayerChoice();

                switch (playerAction) {

                    case "H":
                        player.receiveCard(deck.dealCard());
                        player.displayHand();

                        if (player.getHandValue() > 21) {
                            System.out.println(player.getName() + " busted!");
                            isStand = true;
                        }
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

    public void checkWinner() {

        boolean isWinner = false;

        for (Player player : players) {
            if (isPlayerBust(player)) {
            } else if (isDealerBust()) {
                System.out.println("Congrats " + player.getName() + "! You won!");
                isWinner = true;
            } else if (isPush(player)) {
                System.out.println("Unlucky " + player.getName() + "... You matched the dealer.");
                isWinner = true;
            } else if (player.getHandValue() > dealer.getHandValue()) {
                System.out.println("Congrats " + player.getName() + "! You won!");
                isWinner = true;
            }
        }

        if (!isWinner) {
            System.out.println("Womp Womp... No one beat the dealer...");
        }
    }

    public boolean promptKeepPlaying() {

        // Prompt the using to keep playing
        System.out.println("Do you want to keep playing? (Y/N)");
        String userChoice = getPlayerChoice();

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

    public void checkDeck() {

        // Seems like a random number, but it's at the 3 deck mark so its probably time for a new shoe
        if (deck.getSize() < 156) {
            // Adds all the cards back then shuffles
            System.out.println("Preparing New Shoe...");
            deck.fillDeck(6);
            deck.shuffle();
        }
    }

    public void clearHands() {
        for (Player player : players) {
            player.clearHand();
        }
        dealer.clearHand();
    }

    public void playDealer() {

        while (dealer.getHandValue() < 17) {
            dealer.receiveCard(deck.dealCard());
            dealer.displayHand();
        }

        if (dealer.getHandValue() > 21) {
            System.out.println("Dealer busted!");
        }
    }

    public boolean isDealerBust() {
        return (dealer.getHandValue() > 21) ? true : false;
    } // Player gets over 21

    public boolean isPlayerBust(Player player) {
        return (player.getHandValue() > 21) ? true : false;
    } // Dealer gets over 21

    public boolean isPush(Player player) {
        return (player.getHandValue() == dealer.getHandValue()) ? true : false;
    }

    public String getPlayerChoice() {
        return input.nextLine().trim().toUpperCase();
    }
}
