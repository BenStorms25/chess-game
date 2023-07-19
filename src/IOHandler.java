import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IOHandler {

    // the game manager is going to be the listener here
    private GameManager listener;

    public IOHandler(){}

    public void displayOpeningMessage(){
        // will start input output process for handling game
        System.out.print("\n=======================\n");
        System.out.println("Welcome to Chess!");
        System.out.print("=======================\n");
        System.out.println("\nMake moves by typing in PGN codes.\n");
        System.out.print("For example, moving a " +
                "pawn to the e4 space would be written as 'e4',\n");
        System.out.print("and moving a Knight to the f6 space would be written as Nf6.\n");
        System.out.print("=======================\n\n");
    }

    private boolean isValidMove(String move){
        // will eventually need to code for disambiguity between
        // two of the same piece that can move to the same spot.




        // verify pgn validity
        List<Character> pieces = new ArrayList<>(Arrays.asList('N', 'Q', 'K', 'R', 'B'));
        List<Character> files =
                new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f','g','h'));

        char[] arr = move.toCharArray();

        // required length
        if(arr.length < 2 || arr.length > 3){
            return false;
        }
        // if non pawn piece moving
        if(arr.length > 2){
            // first index should be letter
            if(!pieces.contains(arr[0])){
                return false;
            }
        }
        // must specify file
        if(!files.contains(arr[arr.length - 2])){
            return false;
        }
        // must move to a number between 1 and 8
        if(isConvertibleToInt(arr[arr.length -1])){
            if(Character.getNumericValue(arr[arr.length -1]) < 1 ||
                    Character.getNumericValue(arr[arr.length -1]) > 8){
                return false;
            }
        } else {
            return false;
        }

        // all checks pass
        return true;
    }



    public void beginIOStream(){
        // will need to add randomly generated color for user
        String input;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter move: ");
            input = scanner.nextLine();
            if(isValidMove(input)){
                // send input to game manager
                handleInput(input);
            }
            else {
                System.out.println("input was not valid: " + input);
            }

        } while(!input.equalsIgnoreCase("q"));

    }

    public static boolean isConvertibleToInt(char input) {
        try {
            Character.getNumericValue(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void handleInput(String input) {
        if (listener != null) {
            listener.onInputReceived(input);
        }
    }

    public void setInputListener(GameManager manager) {
        this.listener = manager;
    }

}
