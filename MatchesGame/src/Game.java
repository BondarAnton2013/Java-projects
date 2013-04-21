import java.util.Random;

public class Game {

    static int MATHESCOUNT = 21;
    static int MAXMATHES = 5;
    static int MINMATHES = 1;

    public static void main(String[] args) {
        System.out.println("The main idea of this game is that on game place is determined quantity of matches. "
                + "\nPlayer and Computer one by one take from one to five matches. "
                + "The winner is the one, who takes the last match.");
        Player player = new Player();
        Computer computer = new Computer();
        startGame(player, computer);
    }

    static void startGame(Player p, Computer c) {
        boolean whoFirst = chooseFirstPlayer();
        showWhoisFirst(whoFirst);
        while (MATHESCOUNT > 0) {
            if (whoFirst == false) {
                int takeMatches = p.doNextMove();
                calculateRemainMatches(takeMatches);
                showGameInfo();
                whoFirst = true;
            } else {
                int takeMatches = c.doNextMove();
                calculateRemainMatches(takeMatches);
                showGameInfo();
                whoFirst = false;
            }
        }
        showWhoWin(whoFirst);
    }

    static boolean chooseFirstPlayer() {
        Random randomPlayer = new Random();
        return randomPlayer.nextBoolean();
    }

    static int calculateRemainMatches(int MatchesCount) {
        return MATHESCOUNT -= MatchesCount;
    }

    static void showWhoisFirst(boolean randomPlayer) {
        if (randomPlayer) {
            System.out.println("Computer is first");
        } else {
            System.out.println("Player is first");
        }
    }

    static void showGameInfo() {
        System.out.println("Left matches " + MATHESCOUNT);
    }

    static void showWhoWin(boolean whoFirst) {
        if (whoFirst) {
            System.out.println("Player win!");
        } else {
            System.out.println("Computer win!");
        }
    }
}



