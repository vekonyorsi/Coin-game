package coingame.javafx.controller;

import coingame.results.GameResult;
import coingame.results.GameResultDeserializer;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.tinylog.Logger;

import java.util.List;


public class LeaderboardController {
    @FXML
    private TableView<GameResult> leaderboardTable;

    @FXML
    private TableColumn<GameResult, String> player1Name;

    @FXML
    private TableColumn<GameResult, String> player2Name;

    @FXML
    private TableColumn<GameResult, String> winner;

    @FXML
    private TableColumn<GameResult, Integer> player1Score;

    @FXML
    private TableColumn<GameResult, Integer> player2Score;

    @FXML
    private TableColumn<GameResult, String> dateColumn;

    public void initialize(){
        List<GameResult> leaderboardList = GameResultDeserializer.deserialize();
        player1Name.setCellValueFactory(new PropertyValueFactory<>("player1Name"));
        player2Name.setCellValueFactory(new PropertyValueFactory<>("player2Name"));
        winner.setCellValueFactory(new PropertyValueFactory<>("winner"));
        player1Score.setCellValueFactory(new PropertyValueFactory<>("player1Score"));
        player2Score.setCellValueFactory(new PropertyValueFactory<>("player2Score"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        ObservableList<GameResult> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(leaderboardList);
        leaderboardTable.setItems(observableResult);
        Logger.info("Loading leaderboard..");
    }

    public void exitGame(ActionEvent actionEvent) {
        Logger.info("Exiting..");
        Platform.exit();
    }
}