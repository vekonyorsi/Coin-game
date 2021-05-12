package coingame.javafx.controller;

import coingame.state.GameState;
import coingame.state.Player;
import javafx.application.Platform;
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
import java.util.ArrayList;


@Slf4j
public class GameController {
    @FXML
    Text p1nameText;

    @FXML
    Text p2nameText;

    private Player player1;
    private Player player2;

    private String p1name;
    private String p2name;

    private GameState state;

    @FXML
    private void initialize() {
        Platform.runLater(() -> {
            p1nameText.setText(p1name);
            p2nameText.setText(p2name);
            //player1.setName(p1name);
            //player2.setName(p2name);
        });

    }

    public void openAction(ActionEvent actionEvent) throws Exception {
        player1 = new Player(p1nameText.getText(), 1, 0);
        //player2 = new Player(p2nameText.getText(), 2, 0);
        state = new GameState();
        String gomb = ((Button) actionEvent.getSource()).getId();
        String [] tomb = gomb.split("_");
        int index = Integer.parseInt(tomb[1]);
        state.firstChoice(index);
        System.out.println(gomb);
        System.out.println(state.toString());

    }

    public void setPlayersName(String p1name, String p2name) {
        this.p1name = p1name;
        this.p2name = p2name;
    }


}
