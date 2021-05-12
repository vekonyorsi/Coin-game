package coingame.javafx.controller;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import lombok.extern.slf4j.Slf4j;

import java.awt.event.ActionEvent;
import java.io.IOException;


@Slf4j
public class LaunchController {
    @FXML
    private TextField p1name;

    @FXML
    private TextField p2name;

    @FXML
    private Button startButton;

    @FXML
    private void initialize() {
        startButton.disableProperty().bind(
                Bindings.isEmpty(p1name.textProperty())
                        .or(Bindings.isEmpty(p2name.textProperty()))
                        .or(Bindings.equal(p1name.textProperty(), p2name.textProperty()))
        );
    }


}
