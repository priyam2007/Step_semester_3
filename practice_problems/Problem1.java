import java.util.Random;

public class Problem1 {
    /**
     * Determines the winner of a single Rock-Paper-Scissors round.
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] demoPlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] demoComputerMoves = {"Scissors", "Paper", "Rock", "Scissors", "Rock"};

        int wins = 0, losses = 0, draws = 0;
        int n = demoPlayerMoves.length;

        System.out.printf("%-10s | %-12s | %-14s | %-14s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            String pMove = demoPlayerMoves[i];
            String cMove = demoComputerMoves[i];
            String result = playRound(pMove, cMove);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            System.out.printf("%-10s | %-12s | %-14s | %-14s%n", "Round " + (i + 1), pMove, cMove, result);
        }

        double winPct = ((double) wins / n) * 100.0;
        System.out.printf("Final Summary: Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPct);
    }
}
