package nims;

public class Player {
    private int score = 0;
    private final String name;

    public Player(String name){
        this.name = name;
        System.out.println("-----------------------------");
    }

    public int getScore(){
        return this.score;
    }

    public String getName(){
        return this.name;
    }

    public void adjustScore(int x){
        score += x;
    }
}
