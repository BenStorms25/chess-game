public class Space {

    private Color color;
    private boolean isOccupied;
    private Piece piece;
    private String label;
    private String file;
    private String rank;

    public Space(Color color, boolean isOccupied, Piece occupiedBy, String label){
        this.color = color;
        this.isOccupied = isOccupied;
        this.piece = occupiedBy;
        this.label = label;
    }

    public Space(Color color, String label){
        this.color = color;
        this.isOccupied = false;
        this.piece = null;
        this.label = label;
    }

    public Space(){
        this.color = Color.WHITE;
        this.isOccupied = false;
        this.piece = null;
        this.file = "";
        this.rank = "";
        this.label = "";
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void setFile(String file){
        this.file = file;
        setLabel();
    }
    public void setRank(String rank){
        this.rank = rank;
        setLabel();
    }

    public void setPiece(Piece piece){
        this.piece = piece;
        this.isOccupied = true;
    }

    private void setLabel(){
        this.label = this.file.concat(this.rank);
    }

    public Piece getPiece(){
        return piece;
    }
    public boolean isOccupied(){
        return isOccupied;
    }


    @Override
    public String toString() {
        return (this.label);
    }


}
