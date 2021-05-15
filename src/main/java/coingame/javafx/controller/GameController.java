package coingame.javafx.controller;

import coingame.state.GameState;
import coingame.state.Player;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


@Slf4j
public class GameController {
    @FXML
    Text p1nameText;


    private String p1name;
    private String p2name;

    private GameState state;



    @FXML
    private void initialize() {
        Platform.runLater(() -> {
            p1nameText.setText(p1name);
            state = new GameState(p1name, p2name);

        });

    }

    public void openAction(ActionEvent actionEvent) throws Exception {

        String button = ((Button) actionEvent.getSource()).getId();
        String val = ((Button) actionEvent.getSource()).getText();
        String [] array = button.split("_");
        int index = Integer.parseInt(array[1]);
        state.firstChoice(index-1);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/game2.fxml"));
        Parent root = fxmlLoader.load();
        fxmlLoader.<GameController2>getController().setState(state);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void setPlayersName(String p1name, String p2name) {
        this.p1name = p1name;
        this.p2name = p2name;
    }



}
