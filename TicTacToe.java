import java.util.Scanner;

public class TicTacToe {
    public enum Pieces {X, O,};

    //Displays the main menu
    public static void displayMenu() {
        System.out.println("Game Menu");
        System.out.println("---------");

        System.out.println("1. Play");
        System.out.println("2. Game Stats");
        System.out.println("3. Quit\n");

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
    public static void displayBoard(Pieces[][] spaces) {
        int i, j;   //index variables for looping over board
        int[] boardIndicesLetters = {1, 2, 3};

        for(i = 0; i < spaces.length; ++i) {
            for(j = 0; j < spaces[i].length; ++j) {

                //Format board position indices
                if(i == 0 && j == 0) {
                    System.out.println("  1 2 3");
                }
                if(j == 0) {
                    System.out.print(boardIndicesLetters[i] + " ");
                }

                //Print X and 0
                System.out.print(spaces[i][j]);

                //Format the grid
                if(j != 2) {
                    System.out.print("|");
                }

                //Printing line in between rows
                if((j == 2) && (i < 2)) {
                    System.out.println("\n  -----");
                }
            }
        }
        System.out.println("\n");
    }

    //Gets values for the players move
    public static int[] playerMove(Scanner input) {
        int[] moveCoords = new int[2];

        //Prompt for input
        System.out.println("Please enter your move in the form: x y");
        moveCoords[0] = input.nextInt();
        moveCoords[1] = input.nextInt();

        return moveCoords;
    }

    //Updates the board state with player move
    public static void updateBoard(int[] move, Pieces[][] board) {
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[i].length; ++j) {
                if((i == move[0]) && (j == move[1])) {
                    board[i - 1][j - 1] = Pieces.X;
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
        int[] playerMove;

        //Get first player input
        displayMenu();
        menuChoice = getPlayerChoice(input);


        //while(!winCondition) {
            displayBoard(board);
            playerMove = playerMove(input);
            updateBoard(playerMove, board);
            displayBoard(board);
            //check win condition

        //}


    }
}
