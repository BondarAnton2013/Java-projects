
public class Computer {

    int maxMove = Game.MAXMATHES;
    int minMove = Game.MINMATHES;

    int doNextMove() {
        System.out.println("Computer moves");
        int result = this.minMove;
        for (int matchesCount = this.minMove;
             matchesCount <= this.maxMove; matchesCount++) {
            int moveValue = Game.MATHESCOUNT - matchesCount;
            if ((moveValue % 6) == 0) {
                result = matchesCount;
            }
        }
        return result;
    }
}
