package coingame.state;

import javafx.beans.property.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents the state of the game.
 */

public class GameState {

    private Player player1;
    private Player player2;
    private StringProperty winnerName = new SimpleStringProperty();
    private ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 5, 6, 4, 8, 6, 4, 3, 1, 2, 2, 8));

    /**
     * Player1 true.
     * Player2 false.
     */

    private BooleanProperty currentPlayer = new SimpleBooleanProperty();

    /**
     * This method is called when the first player chooses from the coin-circle.
     * Sets the coins in row and adds the selected coin's value to the first player's score.
     *
     * @param index gets the selected button's id.
     */
    public void firstChoice(int index) {
        if(this.list.size() == 12){
            currentPlayer.set(!currentPlayer.getValue());
            player1.setScore(list.get(index));
            list.remove(index);
            ArrayList<Integer> list2 = new ArrayList<>();
            for (int i = index; i < list.size(); i++){
                list2.add(list.get(i));
            }
            for (int i = 0; i < index; i++) {
                list2.add(list.get(i));
            }
            list = list2;
        }
    }

    private int min = 1;
    private int max = 11;

    /**
     * This method adds the player's score the value of the coin in the left
     * if they selected the first coin in the row.
     *
     * Calls the {@code winner} method.
     */
    public void leftCut(){
        if (currentPlayer.getValue()) {
            player1.setScore(list.get(0));
        }
        else {
            player2.setScore(list.get(0));
        }
        list.remove(0);
        min += 1;
        currentPlayer.set(!currentPlayer.getValue());
        winner();
    }

    /**
     * This method adds the player's score the value of the coin in the right
     * if they selected the last coin in the row.
     *
     * Calls the {@code winner} method.
     */
    public void rightCut(){
        if (currentPlayer.getValue()) {
            player1.setScore(list.get(list.size()-1));
        }
        else {
            player2.setScore(list.get(list.size()-1));
        }
        list.remove(list.size()-1);
        max -= 1;
        currentPlayer.set(!currentPlayer.getValue());
        winner();
    }

    /**
     * This method represents the step of a player.
     *
     * If it is the first coin, calls {@code leftCut} method.
     * If it is the last coin, calls {@code rightCut} method.
     *
     * @param coinId the id of the pressed coin.
     * @return returns {@code true}, if the player clicked on the first or last coin. If not, returns {@code false}.
     *
     */
    public boolean step(int coinId){
        if(coinId == min || coinId == max){
            if(coinId == min){
                leftCut();
            }
            else {
                rightCut();
            }
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * This method decides who the winner is.
     * If all the coins are selected by the 2 players, checks the scores.
     */
    public void winner() {
        if (list.isEmpty()) {
            if(player1.getScore() > player2.getScore()) {
                winnerName.set(player1.getName());
            }
            else {
                winnerName.set(player2.getName());
            }
        }
    }

    /**
     * Create an instance of {@code GameState} object.
     * Initializes the two players' name with the corresponding parameters given.
     * Sets the {@code currentPlayer}'s value to true.
     *
     * @param player1 Name of the first player.
     * @param player2 Name of the second player.
     */
    public GameState(String player1, String player2) {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
        this.currentPlayer.set(true);
    }

    /**
     * Gets the {@link  Property} object containing the score of {@code Player1Score}.
     *
     * @return a {@link IntegerProperty} object.
     */
    public IntegerProperty getPlayer1ScoreProperty(){
        return player1.scoreProperty();
    }

    /**
     * Gets the {@link  Property} object containing the score of {@code Player2Score}.
     *
     * @return a {@link IntegerProperty} object.
     */
    public IntegerProperty getPlayer2ScoreProperty(){

        return player2.scoreProperty();
    }

    /**
     * Gets the {@link  Property} object containing the  {@code currentPlayer}.
     *
     * @return a {@link BooleanProperty} object.
     */
    public BooleanProperty currentPlayerProperty() {
        return currentPlayer;
    }


    /**
     * Getter of the {@code WinnerName}
     * @return the name of the winner from the {@code winnerNameProperty}
     */
    public String getWinnerName() {
        return winnerName.get();
    }

    /**
     * Returns a {@link Property} containing the name of the winner.
     * @return the {winnerName}.
     */
    public StringProperty winnerNameProperty() {
        return winnerName;
    }

    /**
     * Gets a {@link List} of integers. Contains the values of the coins.
     *
     * @return a {@link List} of integers.
     */
    public List<Integer> getList() {
        return list;
    }

    /**
     * Getter of the {@code player1Name}.
     *
     * @return the first player's name.
     */
    public String getPlayer1Name(){
        return player1.getName();
    }

    /**
     * Getter of the {@code player2Name}.
     *
     * @return the second player's name.
     */
    public String getPlayer2Name(){
        return player2.getName();
    }

}
