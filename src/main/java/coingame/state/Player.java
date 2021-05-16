package coingame.state;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


/**
 * This class stores informations about a player.
 */
public class Player {

    private String name;
    private IntegerProperty score = new SimpleIntegerProperty();

    /**
     * Getter for the name of a player.
     *
     * @return return with the name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the score of a player.
     *
     * @return return an {@link Integer}.
     */
    public int getScore() {
        return score.get();
    }

    /**
     * @return return with an IntegerProperty type value that is the score of a player.
     */
    public IntegerProperty scoreProperty() {
        return score;
    }

    /**
     * Set the score of a player.
     * @param score the score of a player.
     */
    public void setScore(int score) {
        this.score.set(this.score.getValue()+score);
    }


    /**
     * Creates {@code Player} object.
     */
    public Player(){

    }

    /**
     *  Contructor with one argument.
     * @param name the name of a player.
     */
    public Player(String name) {
        this.name = name;

    }
}
