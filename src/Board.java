public class Board {

    private Space[][] board;

    public Board(){
        this.board = new Space[8][8];
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Space();
            }
        }
        colorAndLabelBoard();
    }

    public void initializeBoard(){
        // this will assign all pieces to starting spaces

        // assign pawns to ranks 2 and 7
        for(int i = 0; i < 8; i++){
            board[1][i].setPiece(new Piece(Color.WHITE, Piece.Type.PAWN));
            board[6][i].setPiece(new Piece(Color.BLACK, Piece.Type.PAWN));

            switch(i) {
                case 0, 7:
                    board[0][i].setPiece(new Piece(Color.WHITE, Piece.Type.ROOKE));
                    board[7][i].setPiece(new Piece(Color.BLACK, Piece.Type.ROOKE));
                    break;
                case 1, 6:
                    board[0][i].setPiece(new Piece(Color.WHITE, Piece.Type.KNIGHT));
                    board[7][i].setPiece(new Piece(Color.BLACK, Piece.Type.KNIGHT));
                    break;
                case 2, 5:
                    board[0][i].setPiece(new Piece(Color.WHITE, Piece.Type.BISHOP));
                    board[7][i].setPiece(new Piece(Color.BLACK, Piece.Type.BISHOP));
                    break;
                case 3:
                    board[0][i].setPiece(new Piece(Color.WHITE, Piece.Type.QUEEN));
                    board[7][i].setPiece(new Piece(Color.BLACK, Piece.Type.QUEEN));
                    break;
                case 4:
                    board[0][i].setPiece(new Piece(Color.WHITE, Piece.Type.KING));
                    board[7][i].setPiece(new Piece(Color.BLACK, Piece.Type.KING));
                    break;
            }

        }

    }



    private void colorAndLabelBoard(){
        // this method will assign color and label to each space on the board

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                // iterating through all spaces

                // setting files
                board[0][j].setFile("a");
                board[1][j].setFile("b");
                board[2][j].setFile("c");
                board[3][j].setFile("d");
                board[4][j].setFile("e");
                board[5][j].setFile("f");
                board[6][j].setFile("g");
                board[7][j].setFile("h");

                // setting ranks
                board[i][j].setRank(Integer.toString(j + 1));

                if((i + 1) % 2 != 0){
                    if((j + 1) % 2 != 0){
                        board[i][j].setColor(Color.BLACK);
                    }
                }
                else {
                    if((j+1) % 2 == 0){
                        board[i][j].setColor(Color.BLACK);
                    }
                }
            }
        }

    }

    public void displayBoard(){
        System.out.println(this.board);
    }

}
