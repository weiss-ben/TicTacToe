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
        if(selection > 0 && selection < 4) {
            return selection;
        }
        else {
            System.out.println("Selection must be a number 1-3.");
            System.out.println("Please select a menu option: ");

            selection = getPlayerChoice(input);
            return selection;
        }
    }

    //Displays the game board in its current state
    public static void displayBoard(int[][] spaces) {
        int i, j;   //index variables for looping over board

        for(i = 0; i < spaces.length; ++i) {
            for(j = 0; j < spaces[i].length; ++j) {
                System.out.print(spaces[i][j]);

                //Format the grid
                if(j != 2) {
                    System.out.print("|");
                }

                //Printing line in between rows
                if((j == 2) && (i < 2)) {
                    System.out.println("\n-----");
                }
            }
        }
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


        //while(!winCondition) {
            //display board
            //get players move
            //update board
            //display the board
            //check win condition

        //}

        displayBoard(coordinates);


    }
}
