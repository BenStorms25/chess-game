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

    public void handleMove(String move){
        // trigger move will accept a move string and process it, moving the correct piece to the correct space.

        char[] arr = move.toCharArray();
        String space = move.substring(move.length() - 2);

        if(arr.length == 2){
            movePawn(space);
        } else {
            switch(arr[0]){
                case 'N':
                    moveKnight(space);
                    break;
                case 'B':
                    moveBishop(space);
                    break;
                case 'Q':
                    moveQueen(space);
                    break;
                case 'K':
                    moveKing(space);
                    break;
                case 'R':
                    moveRook(space);
                    break;
            }
        }
    }



    private void movePawn(String space){
        // determine legality, then move
        System.out.println("moving pawn");
    }
    private void moveRook(String space){
        System.out.println("moving rook");
    }
    private void moveQueen(String space){
        System.out.println("moving queen");
    }
    private void moveKnight(String space){
        System.out.println("moving knight");
    }
    private void moveBishop(String space){
        System.out.println("moving bishop");
    }
    private void moveKing(String space){
        System.out.println("moving king");
    }


    private static int[] algebraicToIndices(String algebraicNotation) {
        int[] indices = new int[2];

        // Ensure the algebraic notation is in the correct format (e.g., 'a1')
        if (algebraicNotation.length() != 2) {
            throw new IllegalArgumentException("Invalid algebraic notation format.");
        }

        char fileChar = algebraicNotation.charAt(0);
        char rankChar = algebraicNotation.charAt(1);

        // Convert the file character to array index
        int fileIndex = fileChar - 'a'; // 'a' corresponds to 0, 'b' corresponds to 1, and so on

        // Convert the rank character to array index
        int rankIndex = Character.getNumericValue(rankChar) - 1; // '1' corresponds to 0, '2' corresponds to 1, and so on

        // Check if the indices are within the valid range (0 to 7)
        if (fileIndex < 0 || fileIndex > 7 || rankIndex < 0 || rankIndex > 7) {
            throw new IllegalArgumentException("Invalid algebraic notation: Out of board range.");
        }

        indices[0] = rankIndex;
        indices[1] = fileIndex;

        return indices;
    }


    public void displayBoard(){
        System.out.println(this.board);
    }

}
