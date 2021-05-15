package coingame.javafx.controller;

import coingame.results.GameResult;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class LeaderboardController {
    @FXML
    private TableView<GameResult> leaderboardTable;

    @FXML
    private TableColumn<GameResult, String> player1name;

    @FXML
    private TableColumn<GameResult, String> player2name;

    @FXML
    private TableColumn<GameResult, String> winner;

    @FXML
    private TableColumn<GameResult, Integer> player1Score;

    @FXML
    private TableColumn<GameResult, Integer> player2Score;

    @FXML
    private TableColumn<GameResult, String> dateColumn;


    public void exitGame(ActionEvent actionEvent) {
        Platform.exit();
    }
}