package coingame.state;


import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javassist.Loader;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;


public class GameState {

    private Player player1;

    private Player player2;

    private StringProperty winnerName = new SimpleStringProperty();

    private ListProperty<Integer> list = new SimpleListProperty<>();


    /**
     * Player1 true
     * Player2 false
     */

    private BooleanProperty currentPlayer = new SimpleBooleanProperty();


    public void firstChoice(int index) {
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

        list.set(FXCollections.observableArrayList(list2));
    }

    private int min = 1;
    private int max = 11;

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

    public GameState(String player1, String player2) {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
        this.list.set(FXCollections.observableArrayList(List.of(1, 5, 6, 4, 8, 6, 4, 3, 1, 2, 2, 8)));
        this.currentPlayer.set(true);
    }

    public IntegerProperty getPlayer1ScoreProperty(){
        return player1.scoreProperty();
    }

    public IntegerProperty getPlayer2ScoreProperty(){
        return player2.scoreProperty();
    }

    public boolean isCurrentPlayer() {
        return currentPlayer.get();
    }

    public BooleanProperty currentPlayerProperty() {
        return currentPlayer;
    }

    public String getWinnerName() {
        return winnerName.get();
    }

    public StringProperty winnerNameProperty() {
        return winnerName;
    }

    public ObservableList<Integer> getList() {
        return list.get();
    }

    public ListProperty<Integer> listProperty() {
        return list;
    }

    public String getPlayer1Name(){
        return player1.getName();
    }

    public String getPlayer2Name(){
        return player2.getName();
    }

}
