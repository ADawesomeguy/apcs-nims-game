package nims;

import java.util.Scanner;

public class Game {
    private int pieces;
    private final Player p1;
    private final Player p2;
    private Player currentPlayer;
    private final Scanner sc = new Scanner(System.in);

    // Sets up the game with a random amount of pieces between 10 and 50
    // Sets up the players so, they can be accessed
    public Game(Player p1, Player p2) {
        pieces = (int) (Math.random() * 41) + 10; // TODO: Grab a random value between 10 and 50
        this.p1 = p1;
        this.p2 = p2;
    }

    // Allows a player to take a specific amount of pieces.
    // Adds the amount of pieces taken to the user's score.
    public int takePiece() {
        System.out.println("There " + (pieces == 1 ? "is " : "are ") + pieces + " remaining!");
        int take = 0;

        while (!isLegal(take)) {
            System.out.print("Please input the amount of pieces you would like to take: ");
            take = sc.nextInt();
        }

        pieces -= take;

        System.out.println("There " + (pieces == 1 ? "is " : "are ") + pieces + " remaining!");
        System.out.println("-----------------------");
        if (pieces == 0) {
            System.out.printf("Winner is: %s!\n", currentPlayer.equals(p1) ? "Player 2 " + "(" + p2.getName() + ")" : "Player 1 " + "(" + p1.getName() + ")");
        }
        return take;
    }


    public Player getNextPlayer() {
        // Changes which players turn it is and returns the current player.
        if (currentPlayer.equals(p1)) currentPlayer = p2;
        else currentPlayer = p1;

        return currentPlayer;
    }

    // Checks whether the user's requested move is allowed or not.
    public boolean isLegal(int x) {
        // can always take 1
        if (x == 1) return true;

        return x <= (pieces / 2) /* cast to int */ && x > 0;
    }


    public boolean isComplete() {
        return pieces == 0;
    }

    public void setFirstPlayer(Player p) {
        currentPlayer = p;
    }
}
