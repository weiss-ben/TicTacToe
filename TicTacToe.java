import java.util.Scanner;

public class TicTacToe {
    public enum Pieces {X, O};

    //Displays the main menu
    public static void displayMenu() {
        System.out.println("Game Menu");
        System.out.println("---------");

        System.out.println("1. Play");
        System.out.println("2. Game Stats");
        System.out.println("3. Quit");

        System.out.println("Please select a menu option: ");
    }

    //Returns an int indicating the player's menu selection
    public static int getPlayerChoice(Scanner input) {
        int selection = input.nextInt();

        //Make sure input is legal. If not reprompt
        switch (selection) {
            case 1:
                return selection;
            case 2:
                return selection;
            case 3:
                return selection;
            default:
                System.out.println("Selection must be a number 1-3.");
                System.out.println("Please select a menu option: ");
                selection = getPlayerChoice(input);
        }
        return selection;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Initialize board
        Pieces[][] board = new Pieces[3][3];
        int[][] coordinates = new int[3][3];

        //stats variables
        int numOfGamesPlayed = 0;
        int gamesWon         = 0;
        double avgWin        = 0.0;

        boolean winCondition = false;
        int menuChoice;

        //Get first player input
        displayMenu();
        menuChoice = getPlayerChoice(input);


        while(!winCondition) {

        }




    }
}
