package coingame.javafx.controller;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;



public class LaunchController {
    @FXML
    private TextField p1name;

    @FXML
    private TextField p2name;

    @FXML
    private Button startButton;

    @FXML
    private Label p1error;

    @FXML
    private Label p2error;

    @FXML
    private Label sameNameError;


    public void startAction(ActionEvent actionEvent) throws Exception {

        if (p1name.getText().isEmpty()) {
            sameNameError.setText("");
            p1error.setText("Player1 is empty!");
        }
        else {
            p1error.setText("");
        }
        if (p2name.getText().isEmpty()) {
            sameNameError.setText("");
            p2error.setText("Player2 is empty!");
        }
        else {
            p2error.setText("");
        }

        if (!p1name.getText().isEmpty() && !p2name.getText().isEmpty()){
            if(p1name.getText().equals(p2name.getText())){
                sameNameError.setText("Please add " + "\n" + "different names!");
            }
            else {
                sameNameError.setText("");
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/game.fxml"));
                Parent root = fxmlLoader.load();
                GameController gameController = fxmlLoader.<GameController>getController();
                gameController.setPlayersName(p1name.getText(), p2name.getText());
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            }
        }
    }

    public void exitGame(ActionEvent actionEvent) {
        //log.debug("{} button is pressed", ((Button)actionEvent.getSource()).getText());
        //log.info("Exiting...");
        Platform.exit();
    }

}
