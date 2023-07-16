 public class Piece {

    enum Type {
        PAWN,
        ROOKE,
        KNIGHT,
        BISHOP,
        QUEEN,
        KING
    }

     private Color color;
     private Type type;

     public Piece(Color color, Type type) {
         this.color = color;
         this.type = type;
     }

     // getters
     public Color getColor() {
         return color;
     }

     public Type getType() {
         return type;
     }


 }
