import java.util.Scanner;

public class GamblingMenu {

    public void displayHomeMenu(){
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

    public String getHomeMenuChoice(Scanner input){
        System.out.println("Enter your choice: ");
        return input.nextLine();
    }

    public void runGame(){

        Scanner input = new Scanner(System.in);
        String menuChoice;

        displayHomeMenu();
        menuChoice = getHomeMenuChoice(input);

        switch(menuChoice){
            case "1" -> runBlackjack();
            default -> System.out.println("!!   Not available yet   !!");
        }
    }
    public void runBlackjack(){}
}
