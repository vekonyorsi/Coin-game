package coingame.javafx.controller;

import coingame.state.GameState;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.tinylog.Logger;


public class GameController {
    @FXML
    Text p1nameText;

    private String p1name;
    private String p2name;

    private GameState state;

    @FXML
    private void initialize() {
        Platform.runLater(() -> {
            p1nameText.setText(p1name + " starts the game!");
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
        Logger.info("Loading second game scene..");
    }

    public void setPlayersName(String p1name, String p2name) {
        this.p1name = p1name;
        this.p2name = p2name;
    }

}
