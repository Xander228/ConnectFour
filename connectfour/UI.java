package connectfour;
import java.util.Scanner;

/**
 * CopyOfUI class
 */
public class UI
{

    Scanner scanner;

public UI() {
    scanner = new Scanner(System.in);         
}

// Utility methods
public String getROrB(int whoseMove) {
  return (whoseMove == 0) ? " " : (whoseMove == -1) ? "R" : "B";
}

public String getPlayerName(int whoseMove, String xName, String yName) {
  return (whoseMove == -1) ? xName : yName;
}

public boolean isLegalMove(State state, int col) {
  return 1 <= col && col <= Constants.BOARD_COLS &&
    state.getBoardCell(Constants.BOARD_ROWS - 1, col - 1) == Constants.BLANK;
}

// Prompt for input methods
public String promptForName(int player) {
    System.out.printf(Constants.GET_PLAYER_NAME, getROrB(player));
    return scanner.next();
}



public int getMoveCol(State state, int whoseMove) {
    int col = 0;
    while (col <= 0 || col >= 8) {
        try {
            System.out.printf(Constants.GET_COL_MOVE, getROrB(whoseMove), getPlayerName(whoseMove,state.getXName(),state.getOName()));
            col = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(Constants.INVALID_COLUMN);
        }
    }
    return col;
}

public boolean startNewGame() {
  System.out.println(Constants.START_NEW_GAME);
  String yesOrNo = scanner.next();
  return yesOrNo.equals("Y") || yesOrNo.equals("y");
}

// Printing text methods
public void printWelcome() {
    System.out.println(Constants.TITLE);
}

public void printBoard(State state) {
    System.out.println(Constants.DIVIDER_STRING);
    for (int row = Constants.BOARD_ROWS - 1; row >= 0; row--) {
        System.out.printf(Constants.BOARD_STRING, getROrB(state.getBoardCell(row, 0)), getROrB(state.getBoardCell(row, 1)), getROrB(state.getBoardCell(row, 2)), getROrB(state.getBoardCell(row, 3)), getROrB(state.getBoardCell(row, 4)), getROrB(state.getBoardCell(row, 5)), getROrB(state.getBoardCell(row, 6)));
        System.out.println(Constants.DIVIDER_STRING);
    }
}

public void printInvalidColumn(int col) {
    System.out.printf(Constants.INVALID_COLUMN, col);
}

public void printInvalidMove(int col) {
    System.out.printf(Constants.INVALID_MOVE_ERROR, col);
}

public void printMove(State state, int col) {
    System.out.printf(Constants.PRINT_MOVE, getROrB(state.getWhoseMove()), getPlayerName(state.getWhoseMove(),state.getXName(),state.getOName()), col);
} 

public void printWinner(State state) {
    System.out.printf(Constants.WINNER, getROrB(state.getWhoseMove()), getPlayerName(state.getWhoseMove(),state.getXName(),state.getOName()));
}

public void printTieGame() {
    System.out.println(Constants.TIE_GAME);
}
}
