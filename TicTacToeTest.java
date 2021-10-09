/*
-	File containg unit tests for TicTacToe.java
-
-	All tests are dependent on junit version: 4.12
*/

import static org.junit.Assert.*;
import org.junit.Assert.*;
import org.junit.Test;
import java.util.Scanner;

public class TicTacToeTest {
    @Test
    public void displayMenuTest() {
        TicTacToe.displayMenu();
    }

    @Test   //Menu selection test 1
    public void getPlayerChoiceTest01() {
        Scanner scan = new Scanner(System.in);


        int input = TicTacToe.getPlayerChoice(scan);
        int output = 1;

        assertEquals(output, input);
    }
}


