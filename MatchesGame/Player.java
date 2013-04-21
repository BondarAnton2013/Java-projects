
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    int maxMove = Game.MAXMATHES;
    int minMove = Game.MINMATHES;

    int doNextMove() {
        boolean correctlyInput = false;
        int inputResult = 0;
        boolean checkState = true;
        while (correctlyInput == false || checkState == true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Press matches count: ");
            try {
                inputResult = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }
            try {
                checkState = checkRange(inputResult, this);
            } catch (InputRangeException e) {
                System.out.println(e.getMessage().toString());
            }
            correctlyInput = true;
        }
        return inputResult;

    }

    static boolean checkRange(int inputResult, Player p) throws InputRangeException {
        boolean conditionForInput = inputResult > p.maxMove
                || inputResult < p.minMove
                || inputResult > Game.MATHESCOUNT;
        if (conditionForInput) {
            throw new InputRangeException("Range Error! Add number from "
                    + Game.MINMATHES + " to " + Game.MAXMATHES);
        } else {
            conditionForInput = false;
            return conditionForInput;
        }
    }
}


