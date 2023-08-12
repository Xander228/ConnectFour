package connectfour;

/**
 * Tic-Tac-Toe game constants
 */

public class Constants
{
    // Valid board size
    public static final int BOARD_COLS = 7;
    public static final int BOARD_ROWS = 6;

    // Valid board values
    public static final int R = -1;    // Indicates a red peice
    public static final int B = 1;     // Indicates a black peice
    public static final int BLANK = 0; // Indicates a blank square

    // Game states
    public static final int STANDBY = 0;
    public static final int GET_R_NAME = 1;
    public static final int GET_B_NAME = 2;
    public static final int GET_R_MOVE = 3;
    public static final int GET_B_MOVE = 4;
    public static final int MAKE_MOVE = 5;
    public static final int CHECK_IF_WINNER = 6;
    public static final int CHECK_IF_TIE = 7;
    public static final int R_WINS = 8;
    public static final int B_WINS = 9;
    public static final int GAME_OVER = 10;
    public static final int QUIT_PROGRAM = 11;
    
    // Strings
    public static final String DIVIDER_STRING = "|---|---|---|---|---|---|---|";
    public static final String BOARD_STRING = "| %s | %s | %s | %s | %s | %s | %s |\n";
    public static final String GET_PLAYER_NAME = "Player %s: What is your name?\n";
    public static final String TITLE = "Welcome to Connect Four!";
    public static final String GET_COL_MOVE = "Player %s (%s): Enter the column for your next move\n";
    public static final String INVALID_COLUMN = "Your column must be between 1 and 7";
    public static final String INVALID_MOVE_ERROR = "Column %d is not a valid move. Please try again\n";
    public static final String PRINT_MOVE = "Player %s (%s) move to %d\n";
    public static final String WINNER = "%s - %s is the winner!\n";
    public static final String TIE_GAME = "It's a tie game!";
    public static final String START_NEW_GAME = "Start a new game (Y or N)?";
}
