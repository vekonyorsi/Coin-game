package coingame.state;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Player {


    private String name;

    private IntegerProperty score = new SimpleIntegerProperty();

    public String getName() {
        return name;
    }

    public int getScore() {
        return score.get();
    }

    public IntegerProperty scoreProperty() {
        return score;
    }

    public void setScore(int score) {
        this.score.set(this.score.getValue()+score);
    }

    public Player(){

    }

    public Player(String name) {
        this.name = name;

    }
}
