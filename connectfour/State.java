package connectfour;

/**
 * Tic-Tac-Toe state variables.
 */
public class State
{
    private int gameState = Constants.STANDBY;
    private int whoseMove = Constants.R;
    private String xName = "";
    private String oName = "";
    private int[][] board = new int[Constants.BOARD_ROWS][Constants.BOARD_COLS];

    public boolean isWinner() {
        for (int col = 0; col < Constants.BOARD_COLS; col++){
            for (int row = 0; col < Constants.BOARD_ROWS; col++){
            if (checkVertical(row, col)) return true;
            if (checkHorizontal(row, col)) return true;
            if (checkDiagonalUp(row, col)) return true;
            if (checkDiagonalDown(row, col)) return true;
            }
        }
        return false;
    }
        
    private boolean checkVertical(int row, int col) {
        int total = 0;
        if(row + 3 >= Constants.BOARD_ROWS) return false;
        for(int i = 0; i < 4; i++) {
            total += getBoardCell(row + i, col);
        }
        if (total == -4 || total == 4) return true;
        return false;
    }
    
    private boolean checkHorizontal(int row, int col) {
        int total = 0;
        if(col + 3 >= Constants.BOARD_COLS) return false;
        for(int i = 0; i < 4; i++) {
            total += getBoardCell(row, col + i);
        }
        if (total == -4 || total == 4) return true;
        return false;
    }
    
    private boolean checkDiagonalUp(int row, int col) {
        int total = 0;
        if(row + 3 >= Constants.BOARD_ROWS || col + 3 >= Constants.BOARD_COLS) return false;
        for(int i = 0; i < 4; i++) {
            total += getBoardCell(row + i, col + i);
        }
        if (total == -4 || total == 4) return true;
        return false;
    }
    
    private boolean checkDiagonalDown(int row, int col) {
        int total = 0;
        if(row + 3 >= Constants.BOARD_ROWS || col + 3 >= Constants.BOARD_COLS) return false;
        for(int i = 0; i < 4; i++) {
            total += getBoardCell(row + (3 - i), col + i);
        }
        if (total == -4 || total == 4) return true;
        return false;
    }

    public boolean isTie() {
        for (int row=0; row<Constants.BOARD_ROWS; row++) {
            for (int col=0; col<Constants.BOARD_COLS; col++) {
                if (getBoardCell(row,col) == Constants.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public int getWhoseMove() {
        return whoseMove;
    }

    public void setWhoseMove(int whoseMove) {
        this.whoseMove = whoseMove;
    }

    public String getXName() {
        return xName;
    }

    public void setXName(String xName) {
        this.xName = xName;
    }

    public String getOName() {
        return oName;
    }

    public void setOName(String oName) {
        this.oName = oName;
    }

    public int getBoardCell(int row, int col) {
        return this.board[row][col];
    }
    
    public void clearBoard() {
        for (int row=0; row<Constants.BOARD_ROWS; row++) {
            for (int col=0; col<Constants.BOARD_COLS; col++) {
                this.board[row][col] = 0;
            }
        }
    }

    public void placePiece(int col, int value) {
        int row = Constants.BOARD_ROWS;
        while(this.board[(row - 1) - 1][col - 1] == Constants.BLANK){
            row--;
            if(row == 1) break;
        }   
        this.board[row - 1][col - 1] = value;
        }
        
    }

