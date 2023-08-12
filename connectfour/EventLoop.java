package connectfour;

public class EventLoop {

  // Instance variables for the UI and State classes
  State state = new State();
  UI ui = new UI();
  int col;

  public static void main(String[] args) {
      EventLoop eventLoop = new EventLoop();
      eventLoop.run();
  }
  
  public void run() {
    while (state.getGameState() != Constants.QUIT_PROGRAM) {
      int gameState = state.getGameState();
      if (gameState == Constants.STANDBY) {
        state.setGameState(Constants.GET_R_NAME);
        ui.printWelcome();
      } else if (gameState == Constants.GET_R_NAME) {
        state.setXName(ui.promptForName(Constants.R));
        state.setGameState(Constants.GET_B_NAME);
    
      } else if (gameState == Constants.GET_B_NAME) {
        state.setOName(ui.promptForName(Constants.B));
        state.setGameState(Constants.GET_R_MOVE);
    
      } else if (gameState == Constants.GET_R_MOVE) {
        col = ui.getMoveCol(state, state.getWhoseMove());
        if (ui.isLegalMove(state, col)) {
          state.setGameState(Constants.MAKE_MOVE);
        } else {
        ui.printInvalidMove(col);
        }
      } else if (gameState == Constants.GET_B_MOVE) {
        col = ui.getMoveCol(state, state.getWhoseMove());
        if (ui.isLegalMove(state, col)) {
          state.setGameState(Constants.MAKE_MOVE);
        } else {
        ui.printInvalidMove(col);
        }
      } else if (gameState == Constants.MAKE_MOVE) {
        ui.printMove(state, col);
        state.placePiece(col, state.getWhoseMove());
        state.setGameState(Constants.CHECK_IF_WINNER);
        ui.printBoard(state);
      } else if (gameState == Constants.CHECK_IF_WINNER) {
        if (state.isWinner()) {
          if (state.getWhoseMove() == Constants.R) {
            state.setGameState(Constants.R_WINS);
          } else {
            state.setGameState(Constants.B_WINS);
          }
        } else {
          state.setGameState(Constants.CHECK_IF_TIE);
        }

      } else if (gameState == Constants.CHECK_IF_TIE) {
        if (state.isTie()) {
          ui.printTieGame();
          state.setGameState(Constants.GAME_OVER);
        } else {
          state.setWhoseMove(state.getWhoseMove() * -1);
          if (state.getWhoseMove() == Constants.R) {
            state.setGameState(Constants.GET_R_MOVE);
          } else {
            state.setGameState(Constants.GET_B_MOVE);
          }
        }

      } else if (gameState == Constants.R_WINS) {
        ui.printWinner(state);
        state.setGameState(Constants.GAME_OVER);
    
      } else if (gameState == Constants.B_WINS) {
        ui.printWinner(state);
        state.setGameState(Constants.GAME_OVER);

      } else if (gameState == Constants.GAME_OVER) {
        if (ui.startNewGame()) {
            state.clearBoard();
            state.setGameState(Constants.STANDBY);
        } else {
         state.setGameState(Constants.QUIT_PROGRAM);
        }
      }
    }
  }
}
