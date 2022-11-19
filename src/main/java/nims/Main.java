package nims;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean isPlaying = false;
        do {
            Util.clearScreen(System.out);
            System.out.print("Please enter a name for the first player: ");
            Util.setColor(System.out, Util.Color.CYAN);
            Player p1 = new Player(sc.nextLine());
            Util.clearFormatting(System.out);
            System.out.println("-----------------------------");
            System.out.print("Please enter a name for the second player: ");
            Util.setColor(System.out, Util.Color.CYAN);
            Player p2 = new Player(sc.nextLine());
            Util.clearFormatting(System.out);
            System.out.println("-----------------------------");

            Game game = new Game(p1, p2);
            game.setFirstPlayer((int) (Math.random() * 2) == 0 ? p1 : p2);

            while (!game.isComplete()) {
                System.out.printf("Player 1 (%s)'s score: %d\n", p1.getName(), p1.getScore());
                System.out.printf("Player 2 (%s)'s score: %d\n", p2.getName(), p2.getScore());

                Player p = game.getNextPlayer();
                System.out.println(p.equals(p1) ? String.format("Player 1 (%s)'s turn", p1.getName()) : String.format("Player 2 (%s)'s turn", p2.getName()));
                p.adjustScore(game.takePiece());
            }

            System.out.println("Would you like to keep playing? [yn]");
            String playAgainResponse = "";
            while (!playAgainResponse.equalsIgnoreCase("y") && !playAgainResponse.equalsIgnoreCase("n")) {
                playAgainResponse = sc.nextLine();
            }
            if (playAgainResponse.equalsIgnoreCase("y")) isPlaying = true;
        } while (isPlaying);
    }
}