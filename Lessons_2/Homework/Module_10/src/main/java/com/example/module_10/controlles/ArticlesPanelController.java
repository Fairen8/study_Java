package com.example.module_10.controlles;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import com.example.module_10.DB;
import com.example.module_10.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ArticlesPanelController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add_article_btn;

    @FXML
    private Button user_profile_btn;

    @FXML
    private VBox panelVBox;

    @FXML
    void initialize() throws SQLException, IOException {

        DB db = new DB();
        ResultSet resultSet = db.getArticles();
        while (resultSet.next()) {
            Node node = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("article.fxml")));

            Label title = (Label) node.lookup("#title");
            title.setText(resultSet.getString("title"));

            Label intro = (Label) node.lookup("#intro");
            intro.setText(resultSet.getString("intro"));

            int id = resultSet.getInt("id");

            node.setOnMousePressed(event -> {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                try {
                    FullArticleController.id = id;
                    HelloApplication.setScene("full_article.fxml", stage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            node.setOnMouseEntered(event -> {
                node.setStyle("-fx-background-color: #707173");
            });

            node.setOnMouseExited(event -> {
                node.setStyle("-fx-background-color: #343434");
            });
            
            panelVBox.getChildren().add(node);
            panelVBox.setSpacing(10);
        }

        user_profile_btn.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                HelloApplication.setScene("user_profile.fxml" , stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        add_article_btn.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                HelloApplication.setScene("add_article.fxml" , stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

