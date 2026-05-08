import java.util.Scanner;

public class GamblingMenu {


    static Scanner input = GamblingApp.input;

    static public void displayHomeMenu(){
        System.out.println("""
                =======================================================
                                    !! EARLY ACCESS !!
                =======================================================
                ♤                                                     ♧
                ♡                     Select Game                     ♢
                ♧                                                     ♡
                ♢                     1. Blackjack                    ♤
                ♡                  2. More coming soon!               ♢
                ♤                                                     ♧
                =======================================================""");
    }

    static public String getHomeMenuChoice(Scanner input){
        System.out.println("Enter your choice: ");
        return input.nextLine();
    }

    static public void runGame(){

        displayHomeMenu();
        String menuChoice = getHomeMenuChoice(input);

        switch(menuChoice){
            case "1" -> {
                Blackjack blackjack = new Blackjack();
                blackjack.runBlackjack();
            }
            default -> System.out.println("""
                                      !!              Not available yet           !!
                                      !!   You completely broke the program...    !!
                                      !!                  Exiting                 !!""");

        }
    }




}

