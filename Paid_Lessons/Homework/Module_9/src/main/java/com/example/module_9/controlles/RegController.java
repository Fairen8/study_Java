package com.example.module_9.controlles;

import com.example.module_9.DB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button auth_btn;

    @FXML
    private TextField auth_login;

    @FXML
    private PasswordField auth_pass;

    @FXML
    private Button reg_btn;

    @FXML
    private TextField reg_email;

    @FXML
    private TextField reg_login;

    @FXML
    private PasswordField reg_pass;

    @FXML
    private CheckBox reg_rights;

    private DB db = new DB();

    @FXML
    void initialize() {
        reg_btn.setOnAction(event -> {
            try {
                registrationUser();
                Parent UserProfile = FXMLLoader.load(getClass().getResource("user_profile.fxml"));
                Scene UserProfileScene = new Scene(UserProfile);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(UserProfileScene);
                app_stage.show();
            } catch (SQLException | ClassNotFoundException | IOException e) {
                throw new RuntimeException(e);
            }
        });
        auth_btn.setOnAction(event -> {
            try {
                authUser();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }




    private void authUser() throws SQLException, ClassNotFoundException {
        String login = auth_login.getCharacters().toString();
        String password = auth_pass.getCharacters().toString();

        auth_login.setStyle("-fx-border-color: #fafafa");
        auth_pass.setStyle("-fx-border-color: #fafafa");
        auth_btn.setText("Войти");

        if (login.length() <= 1)
            auth_login.setStyle("-fx-border-color: #e06249");
        else if (password.length() <= 3)
            auth_pass.setStyle("-fx-border-color: #e06249");
        else if (!db.authUser(login, UserProfileController.md5String(password))) {
            auth_btn.setText("Неверный логин или пароль");
        } else {
            auth_login.setText("");
            auth_pass.setText("");
            auth_btn.setText("Всё готово :)");
        }
    }

    private void registrationUser() throws SQLException, ClassNotFoundException {
        String login = reg_login.getCharacters().toString();
        String email = reg_email.getCharacters().toString();
        String password = reg_pass.getCharacters().toString();

        reg_login.setStyle("-fx-border-color: #fafafa");
        reg_email.setStyle("-fx-border-color: #fafafa");
        reg_pass.setStyle("-fx-border-color: #fafafa");
        reg_btn.setText("Зарегестрироваться");

        if (login.length() <= 1)
            reg_login.setStyle("-fx-border-color: #e06249");
        else if (email.length() <= 5 || !email.contains("@") || !email.contains("."))
            reg_email.setStyle("-fx-border-color: #e06249");
        else if (password.length() <= 3)
            reg_pass.setStyle("-fx-border-color: #e06249");
        else if (!reg_rights.isSelected())
            reg_btn.setText("Поставьте галочку");
        else if (db.isExistsUser(login)) {
            reg_btn.setText("Введите другой логин");
        } else {
            db.regUser(login, email, UserProfileController.md5String(password));
            reg_login.setText("");
            reg_email.setText("");
            reg_pass.setText("");
            reg_btn.setText("Всё готово :)");
        }
    }

}

