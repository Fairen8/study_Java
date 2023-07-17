package com.example.module_9.controlles;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.module_9.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ArticlesPanelController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exit_btn;

    @FXML
    void initialize() {
        exit_btn.setOnAction(event -> {
            try {
                exitUser(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void exitUser(ActionEvent event) throws IOException {
        File file = new File("user.settings");
        file.delete();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HelloApplication.setScene("main.fxml", stage);
    }

}

