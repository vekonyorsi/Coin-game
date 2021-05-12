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
        });

    }

    public void openAction(ActionEvent actionEvent) throws Exception {
        player1 = new Player(p1name, 1, 0);
        player2 = new Player(p2name, 2, 0);
        state = new GameState();
        String button = ((Button) actionEvent.getSource()).getId();
        String val = ((Button) actionEvent.getSource()).getText();
        String [] array = button.split("_");
        int index = Integer.parseInt(array[1]);
        player1.setScore(Integer.parseInt(val));
        state.firstChoice(index);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/game2.fxml"));
        Parent root = fxmlLoader.load();

        fxmlLoader.<GameController2>getController().p1.setText(player1.getName());
        fxmlLoader.<GameController2>getController().p2.setText(player2.getName());
        fxmlLoader.<GameController2>getController().p2.setTextFill(javafx.scene.paint.Color.GREEN);
        fxmlLoader.<GameController2>getController().p1_score.setText(Integer.toString(player1.getScore()));
        fxmlLoader.<GameController2>getController().p2_score.setText(Integer.toString(player2.getScore()));
        fxmlLoader.<GameController2>getController().new_1.setText(String.valueOf(state.getCoinRow().get(0)));
        fxmlLoader.<GameController2>getController().new_2.setText(String.valueOf(state.getCoinRow().get(1)));
        fxmlLoader.<GameController2>getController().new_3.setText(String.valueOf(state.getCoinRow().get(2)));
        fxmlLoader.<GameController2>getController().new_4.setText(String.valueOf(state.getCoinRow().get(3)));
        fxmlLoader.<GameController2>getController().new_5.setText(String.valueOf(state.getCoinRow().get(4)));
        fxmlLoader.<GameController2>getController().new_6.setText(String.valueOf(state.getCoinRow().get(5)));
        fxmlLoader.<GameController2>getController().new_7.setText(String.valueOf(state.getCoinRow().get(6)));
        fxmlLoader.<GameController2>getController().new_8.setText(String.valueOf(state.getCoinRow().get(7)));
        fxmlLoader.<GameController2>getController().new_9.setText(String.valueOf(state.getCoinRow().get(8)));
        fxmlLoader.<GameController2>getController().new_10.setText(String.valueOf(state.getCoinRow().get(9)));
        fxmlLoader.<GameController2>getController().new_11.setText(String.valueOf(state.getCoinRow().get(10)));
        fxmlLoader.<GameController2>getController().SetPlayers(player1, player2);
        fxmlLoader.<GameController2>getController().SetState(state);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }

    public void setPlayersName(String p1name, String p2name) {
        this.p1name = p1name;
        this.p2name = p2name;
    }



}
