import java.util.Scanner;

public class TicTacToe {
    public enum Pieces {X, O, I};

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
        }
        return selection;
    }
    public static void initializeBoard(Pieces[][] board) {
        int i, j;

        for(i = 0; i < board.length; ++i) {
            for(j = 0; j < board[i].length; ++j) {
                board[i][j] = Pieces.I;
            }
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

    //Get values for the players move
    public static int[] playerMove(Scanner input) {
        int[] moveCoords = new int[2];

        //Prompt for input
        System.out.println("Please enter your move in the form: x y");
        moveCoords[0] = input.nextInt();
        moveCoords[1] = input.nextInt();

        return moveCoords;
    }

    //Updates the board state with player move
    public static void updateBoard(int[] move, Pieces[][] board, Pieces token) {
        for(int i = 0; i < board.length; ++i) {
            for(int j = 1; j <= board[i].length; ++j) {
                if((i == move[0] - 1) && (j == move[1])) {
                    board[i][j - 1] = token;
                    break;
                }
            }
        }
    }

    //Checks if the last turn won the game
    public static boolean checkIfWinner(Pieces[][] board, int[] lastMove, Pieces token) {
        int i;
        int j = 0;
        int row = lastMove[0] - 1;
        int col = lastMove[1] - 1;
        int consecutive = 0;

        //Check row
        for(i = 0; i < board[row].length; ++i) {
            if(board[row][i] == token) {
                ++consecutive;
            }
        }

        if(consecutive == 3) {
            return true;
        }

        //REset consecutive
        consecutive = 0;

        //Check Column
        for(i = 0; i < board.length; ++i) {
            if(board[i][col] == token) {
                ++consecutive;
            }
        }

        if(consecutive == 3) {
            return true;
        }

        //Reset consecutive
        consecutive = 0;

        //Check diagonal from 0,0
        for(i = 0; i < board.length; ++i) {
            if(board[i][j] == token) {
                ++consecutive;
            }
            ++j;
        }

        if(consecutive == 3) {
            return true;
        }

        //Reset consecutive
        consecutive = 0;

        //Check diagonal from 3,1
        j = 2;
        for(i = 0; i < board.length; ++i) {
            if(board[i][j] == token) {
                ++consecutive;
            }
            --j;
        }

        if(consecutive == 3) {
            return true;
        }
        else {
            return false;
        }
    }

    //Checks if the game is a draw
    public static boolean checkIfDraw(Pieces[][] board, boolean winCond) {
        int i, j;
        Pieces empty = Pieces.I;
        boolean draw = false;

        for(i = 0; i < board.length; ++i) {
            for(j = 0; j < board[i].length; ++j) {
                if(board[i][j] == empty) {
                    draw = false;
                    break;
                }
                if((board[i][j] != empty) && !winCond) {
                    draw = true;
                }
            }
        }
        return draw;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Initialize board
        Pieces[][] board = new Pieces[3][3];
        int[][] coordinates = new int[3][3];

        //stats variables
        int numOfGamesPlayed = 0;
        int gamesWon         = 0;
        int draws            = 0;
        double avgWin        = 0.0;

        boolean winCondition = false;
        boolean draw         = false;
        boolean exit         = false;
        int menuChoice;
        int[] playerMove;

        do {
            //Get player input
            displayMenu();
            menuChoice = getPlayerChoice(input);
            switch (menuChoice) {
                case 1: {
                    //Set up the board
                    initializeBoard(board);
                    displayBoard(board);

                    //Update stat
                    ++numOfGamesPlayed;

                    //Update win conditions
                    winCondition = false;
                    draw         = false;

                    while (!winCondition && !draw) {

                        //Player 1 turn
                        playerMove = playerMove(input);
                        updateBoard(playerMove, board, Pieces.X);
                        displayBoard(board);

                        //Checks for a win or draw
                        winCondition = checkIfWinner(board, playerMove, Pieces.X);
                        draw = checkIfDraw(board, winCondition);

                        //Update stats variables
                        if(winCondition) {
                            System.out.println("Player 1 wins!\n");
                            ++gamesWon;
                            break;
                        }
                        else if(draw) {
                            System.out.println("It's a draw.\n");
                            ++draws;
                            break;
                        }
                        else {
                            //Player 2 turn
                            playerMove = playerMove(input);
                            updateBoard(playerMove, board, Pieces.O);
                            displayBoard(board);

                            //Checks for a win or draw
                            winCondition = checkIfWinner(board, playerMove, Pieces.O);
                            draw = checkIfDraw(board, winCondition);

                            if(winCondition) {
                                System.out.println("Player 2 wins!");
                                break;
                            }

                            if(draw) {
                                System.out.println("It's a draw.");
                                ++draws;
                                break;
                            }
                        }

                    }
                    break;
                }
                case 2:
                    avgWin = gamesWon / numOfGamesPlayed;

                    //Display stats
                    System.out.println("-----Game Statistics-----");
                    System.out.println("Number of games played: " + numOfGamesPlayed);
                    System.out.println("Number of draws:        " + draws);
                    System.out.println("Games won:              " + gamesWon);
                    System.out.printf("Average games won:      %.2f\n\n", avgWin);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a valid menu choice.");
                    break;
            }
        } while(!exit);
    }
}
