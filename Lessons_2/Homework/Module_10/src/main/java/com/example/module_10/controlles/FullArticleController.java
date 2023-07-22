package com.example.module_10.controlles;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.module_10.DB;
import com.example.module_10.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FullArticleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_btn;

    @FXML
    private Label text;

    @FXML
    private Label title;

    DB db = new DB();

    public static int id;

    @FXML
    void initialize() {
        back_btn.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                HelloApplication.setScene("articles-panel.fxml" , stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        try {
            ResultSet res = db.getArticle(id);
            if (res.next()) {
                title.setText(res.getString("title"));
                text.setText(res.getString("text"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

