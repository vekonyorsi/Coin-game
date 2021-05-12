package coingame.state;

public class Player {


    private String name;

    public String getName() {
        return name;
    }

    private int playerid;

    private int score;
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = this.score + score;
    }



    public Player(){

    }

    public Player(String name, int playerid, int score) {
        this.name = name;
        this.playerid = playerid;
        this.score = score;
    }
}
