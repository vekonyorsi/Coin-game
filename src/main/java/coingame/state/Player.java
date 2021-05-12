package coingame.state;

public class Player {

    private String name;

    private int playerid;

    private int score;

    public Player(){

    }

    public Player(String name, int playerid, int score) {
        this.name = name;
        this.playerid = playerid;
        this.score = score;
    }
}
