package com.example.module_10.controlles;


import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.module_10.DB;
import com.example.module_10.HelloApplication;
import com.example.module_10.model.User;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserProfileController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button change_btn;

    @FXML
    private Button back_btn;

    @FXML
    private TextField email;

    @FXML
    private Label error_login;

    @FXML
    private Label error_pass;

    @FXML
    private Label error_email;

    @FXML
    private TextField login;

    @FXML
    private PasswordField pass;

    private DB db = new DB();

    private int Userid;
    private String Userlogin;
    private String UserEmail;

    @FXML
    void initialize() {
        getUserParameters();
        change_btn.setOnAction(event -> {
            setUserParameters(event);
        });
        back_btn.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                HelloApplication.setScene("articles-panel.fxml" , stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void setUserParameters(Event event) {
        String newLogin = login.getCharacters().toString();
        String newEmail = email.getCharacters().toString();
        String newPassword = pass.getCharacters().toString();

        error_login.setText("");
        error_email.setText("");
        error_pass.setText("");

        try {
            if (db.isExistsUser(newLogin) && !Userlogin.equals(newLogin))
                error_login.setText("Этот логин уже существует");
            else if (newLogin.length() <= 1)
                error_login.setText("Слишком короткий логин");
            else if (!newEmail.contains("@") || !newEmail.contains(".") || newEmail.length() <= 5)
                error_email.setText("Некорректный email");
            else if (newPassword.length() <= 3)
                error_pass.setText("Слишком короткий пароль");
            else {
                db.setUserParameters(Userid, newLogin, newEmail, md5String(newPassword));

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                try {
                    HelloApplication.setScene("articles-panel.fxml" , stage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void getUserParameters() {
        try {
            FileInputStream fis = new FileInputStream("user.settings");
            ObjectInputStream ois = new ObjectInputStream(fis);
            User user = (User) ois.readObject();
            ois.close();
            Userlogin = user.getLogin();
            Userid = db.getUserid(Userlogin);
            UserEmail = db.getUserEmail(Userid);
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        login.setText(Userlogin);
        email.setText(UserEmail);
    }

    @FXML
    private void exitUser(ActionEvent event) throws IOException {
        File file = new File("user.settings");
        file.delete();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HelloApplication.setScene("main.fxml", stage);
    }

    public static String md5String(String pass) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(pass.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        BigInteger bigInteger = new BigInteger(1, digest);
        String m5dHex = bigInteger.toString(16);

        while(m5dHex.length() < 32)
            m5dHex = "0" + m5dHex;

        return m5dHex;
    }

}
