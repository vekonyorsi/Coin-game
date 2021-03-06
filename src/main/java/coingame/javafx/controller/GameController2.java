package coingame.javafx.controller;

import coingame.results.GameResult;
import coingame.results.GameResultSerializer;
import coingame.state.GameState;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class is for the second page of the Coin-game.
 */
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
    Label p1_score;
    @FXML
    Label p2_score;

    @FXML
    Label winner;

    @FXML
    private String currentPlayer;

    @FXML
    private String play1;
    @FXML
    private String play2;

    private GameState state;


    @FXML
    private void initialize() {
        Platform.runLater(() -> {
            p1.setText(state.getPlayer1Name());
            p2.setText(state.getPlayer2Name());
            p2.setTextFill(Color.GOLD);
            p1_score.setText(state.getPlayer1ScoreProperty().getValue().toString());
            state.getPlayer2ScoreProperty().addListener(this::player2Score);
            Logger.info("Updating {}'s and {}'s score.", state.getPlayer1Name(), state.getPlayer2Name());
            state.getPlayer1ScoreProperty().addListener(this::player1Score);
            state.currentPlayerProperty().addListener(this::currentPlayer);
            state.winnerNameProperty().addListener(this::won);
            buttonName();
        });

    }

    private void player1Score(ObservableValue<? extends Number> observableValue, Number oldP1Score, Number newP1Score) {
        p1_score.setText(newP1Score.toString());
    }


    private void player2Score(ObservableValue<? extends Number> observableValue, Number oldP2Score, Number newP2Score) {
        p2_score.setText(newP2Score.toString());
    }

    private void currentPlayer(ObservableValue<? extends Boolean> observableValue, Boolean oldCurrent, Boolean newCurrent) {
        if(newCurrent){
            p1.setTextFill(Color.GOLD);
            p2.setTextFill(Color.PALEGOLDENROD);
        }
        else {
            p1.setTextFill(Color.PALEGOLDENROD);
            p2.setTextFill(Color.GOLD);
        }

    }

    private void won(ObservableValue<? extends String> observableValue, String win, String win2) {
        winner.setText(win2 + " won the game!");
        p1.setTextFill(Color.PALEGOLDENROD);
        GameResult result = new GameResult(state.getPlayer1Name(), state.getPlayer2Name(), win2,
                state.getPlayer1ScoreProperty().getValue(), state.getPlayer2ScoreProperty().getValue(),
                ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd. - HH:mm:ss"  )));
        GameResultSerializer.serialize(result);
        state.getPlayer1ScoreProperty().addListener(this::player1Score);
    }

    private void buttonName(){
        new_1.setText(state.getList().get(0).toString());
        new_2.setText(state.getList().get(1).toString());
        new_3.setText(state.getList().get(2).toString());
        new_4.setText(state.getList().get(3).toString());
        new_5.setText(state.getList().get(4).toString());
        new_6.setText(state.getList().get(5).toString());
        new_7.setText(state.getList().get(6).toString());
        new_8.setText(state.getList().get(7).toString());
        new_9.setText(state.getList().get(8).toString());
        new_10.setText(state.getList().get(9).toString());
        new_11.setText(state.getList().get(10).toString());
    }

    /**
     * This method is called when a plyer clicks on a coin from the coinrow.
     *
     * Calls the {@link GameState} model's {@code step} method.
     *
     * @param actionEvent the current action event.
     */
    @FXML
    public void gameAction(ActionEvent actionEvent) {
        String[] buttonid = ((Button) actionEvent.getSource()).getId().split("_");
        Button button = (Button) actionEvent.getSource();
        if(state.step(Integer.parseInt(buttonid[1]))) {
            button.setVisible(false);

        }
        Logger.info("Deleting the {}. coin from the row.", buttonid[1]);

    }

    @FXML
    private void leaderAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/leaderboard.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * A method that sets the state of the game to {@code state}.
     *
     * @param state The new state of the game.
     */
    public void setState(GameState state){
        this.state = state;
    }

    /**
     * This method is called by pressing exit button.
     *
     * @param actionEvent The current action event.
     */
    public void exitGame(ActionEvent actionEvent) {
        Logger.info("Exiting..");
        Platform.exit();
    }



}
