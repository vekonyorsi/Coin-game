package coingame.javafx.controller;

import coingame.state.GameState;
import coingame.state.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class GameController2 {
    @FXML
    Button new_1;
    @FXML
    Button new_2;
    @FXML
    Button new_3;
    @FXML
    Button new_4;
    @FXML
    Button new_5;
    @FXML
    Button new_6;
    @FXML
    Button new_7;
    @FXML
    Button new_8;
    @FXML
    Button new_9;
    @FXML
    Button new_10;
    @FXML
    Button new_11;

    @FXML
    Label p1;
    @FXML
    Label p2;

    @FXML
    Label p1_score = player1.getScore();
    @FXML
    Label p2_score;

    Button gomb;

    @FXML
    private String currentPlayer;

    @FXML
    private String play1;
    @FXML
    private String play2;

    private Player player1;
    private Player player2;
    private GameState state;


    int min = 1;
    int max = 11;




    public void gameAction(ActionEvent actionEvent) {
        String[] gombid = ((Button) actionEvent.getSource()).getId().split("_");
        gomb = (Button) actionEvent.getSource();
        gomb.getText();


        if(Integer.parseInt(gombid[1]) == min || Integer.parseInt(gombid[1]) == max) {
            //min += 1;
            gomb.setVisible(false);
            if(Integer.parseInt(gombid[1]) == min && max != min) {

                switchPlayer(min-1);
                min += 1;
            }
            if(Integer.parseInt(gombid[1]) == max) {
                switchPlayer(max-1);
                max -= 1;
            }

        }

    }


    private void switchPlayer(int x) {
        if (currentPlayer.equals(player1.getName())) {
            currentPlayer = player2.getName();
            p2.setTextFill(javafx.scene.paint.Color.GREEN);
            p1.setTextFill(javafx.scene.paint.Color.BLACK);
            int y = state.getCoinRow().get(x);
            player1.setScore(y);
            p1_score.setText(Integer.toString(player1.getScore()));

        }
        else {
            currentPlayer = player1.getName();
            p1.setTextFill(javafx.scene.paint.Color.GREEN);
            p2.setTextFill(Color.BLACK);
            int y = state.getCoinRow().get(x);
            player2.setScore(y);
            p2_score.setText(Integer.toString(player2.getScore()));
        }
    }



    public void SetPlayers(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player2.getName();

    }
    public void SetState(GameState state){
        this.state = state;
    }


}
