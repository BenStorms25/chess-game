public class GameManager {
    /*
    GameManager should be responsible for handling the Board instance,
    performing operations on the board based on user input,
    and should oversee the input/output of the game.
    */

    // should have a board.
    Board board;

    public GameManager(){
        board = new Board();
    }

    public void newGame(){
        // will start input output process for handling game
    }

    public void initializeBoard(){
        // puts all pieces in starting position on board
        board.initializeBoard();
    }

    public void displayBoard() {
        board.displayBoard();

    }

}
