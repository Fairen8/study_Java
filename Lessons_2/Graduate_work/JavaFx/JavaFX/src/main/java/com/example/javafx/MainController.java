package com.example.javafx;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField abbreviated_link;

    @FXML
    private Button add_btn;

    @FXML
    private TextField full_link;

    @FXML
    private Label message_label;

    @FXML
    private VBox panelVBox;

    DB db = new DB();

    @FXML
    void initialize() {
        try {
            setLinks();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

        add_btn.setOnAction(event -> {
            try {
                addLink();
            } catch (SQLException | ClassNotFoundException | IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void addLink() throws SQLException, ClassNotFoundException, IOException {
        String full = full_link.getText();
        String abbreviated = abbreviated_link.getText();

        message_label.setText("");

        if (db.isExistsLink(abbreviated))
            message_label.setText("Укажите другое сокращение");
        else if (full.length() < 5)
            message_label.setText("Укажите корректную ссылку");
        else if (abbreviated.equals(""))
            message_label.setText("Укажите корректное сокращение");
        else {
            db.addlink(full, abbreviated);
            message_label.setText("Добавлено!");
            setLinks();
        }
    }

    private void setLinks() throws SQLException, IOException {
        panelVBox.getChildren().clear();
        ResultSet resultSet = db.getLinks();
        while (resultSet.next()){
            Node node = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("link.fxml")));


            Hyperlink hyperlink = (Hyperlink) node.lookup("#abbreviated");
            hyperlink.setText(resultSet.getString("abbreviated"));

            panelVBox.getChildren().add(node);
            panelVBox.setSpacing(10);
        }
    }
}
