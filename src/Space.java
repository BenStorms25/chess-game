public class Space {

    private Color color;
    private boolean isOccupied;
    private Piece occupiedBy;

    private String label;

    private String file;
    private String rank;

    public Space(Color color, boolean isOccupied, Piece occupiedBy, String label){
        this.color = color;
        this.isOccupied = isOccupied;
        this.occupiedBy = occupiedBy;
        this.label = label;
    }

    public Space(Color color, String label){
        this.color = color;
        this.isOccupied = false;
        this.occupiedBy = null;
        this.label = label;
    }

    public Space(){
        this.color = Color.WHITE;
        this.isOccupied = false;
        this.occupiedBy = null;
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

    private void setLabel(){
        this.label = this.file.concat(this.rank);
    }

    public Piece getPiece(){
        return occupiedBy;
    }
    public boolean isOccupied(){
        return isOccupied;
    }


    @Override
    public String toString() {
        return (this.label);
    }


}
