public class GameManager implements InputListener {
    /*
    GameManager should be responsible for handling the Board instance,
    performing operations on the board based on user input,
    and should oversee the input/output of the game.
    */

    // should have a board.
    Board board;
    private IOHandler handler;

    public GameManager(){
        board = new Board();
    }

    public void newGame(){
        handler = new IOHandler();
        // set the input listener to be the manager
        handler.setInputListener(this);
        // display messages and begin game
        handler.displayOpeningMessage();
        handler.beginIOStream();
    }

    public void initializeBoard(){
        // puts all pieces in starting position on board
        board.initializeBoard();
    }

    public void displayBoard() {
        board.displayBoard();
    }

    @Override
    public void onInputReceived(String input) {
        // where moves are received
        System.out.println("move has been recieved: " + input);
    }

}
