package com.example.module_8;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button comma_btn;

    @FXML
    private URL location;

    @FXML
    private Button clear_btn;

    @FXML
    private Button divide_btn;

    @FXML
    private Button equal_btn;

    @FXML
    private Label label_res;

    @FXML
    private Button minus_btn;

    @FXML
    private Button minus_plus_btn;

    @FXML
    private Button mult_btn;

    @FXML
    private Button percent_btn;

    @FXML
    private Button plus_btn;

    String label_text = "";
    float fist_num = 0f;
    char operation = '|';
    @FXML
    void addNumber(ActionEvent event) {
        label_text += ((Button) event.getSource()).getText();
        label_res.setText(label_text);
    }

    @FXML
    void initialize() {
        plus_btn.setOnAction(event -> {
            mathAction('+');
        });
        minus_btn.setOnAction(event -> {
            mathAction('-');
        });
        divide_btn.setOnAction(event -> {
            mathAction('/');
        });
        mult_btn.setOnAction(event -> {
            mathAction('*');
        });
        equal_btn.setOnAction(event -> {
            if (operation == '+' || operation == '-' || operation == '/' || operation == '*')
                equalBtn();
        });
        comma_btn.setOnAction(even -> {
            if (!label_text.contains(".")){
                label_text += ".";
                label_res.setText(label_text);
            }
        });
        percent_btn.setOnAction(even -> {
            if (!label_text.equals("")){
                float num = Float.parseFloat(label_text) * 0.1f;
                label_text = Float.toString(num);
                label_res.setText(label_text);
            }
        });
        minus_plus_btn.setOnAction(even -> {
            if (!label_text.equals("")){
                float num = Float.parseFloat(label_text) * -1f;
                label_text = Float.toString(num);
                label_res.setText(label_text);
            }
        });
        clear_btn.setOnAction(event -> {
            label_res.setText("0");
            label_text = "";
            operation = '|';
            fist_num = 0f;
        });

    }

    private void equalBtn() {
        float result = 0f;
        switch (operation) {
            case '+':
                result = fist_num + Float.parseFloat(label_text);
                break;
            case '-':
                result = fist_num - Float.parseFloat(label_text);
                break;
            case '*':
                result = fist_num * Float.parseFloat(label_text);
                break;
            case '/':
                float second_num = Float.parseFloat(label_text);
                if (second_num == 0)
                    result = 0;
                else
                    result = fist_num / second_num;
        }
        label_res.setText(Float.toString(result));
        label_text = "";
        operation = '|';
        fist_num = 0;
    }

    private void mathAction(char action) {
        if (operation != '+' && operation != '-' && operation != '/' && operation != '*') {
            fist_num = Float.parseFloat(label_text);
            label_res.setText(String.valueOf(action));
            label_text = "";
            operation = action;
        }
    }

}



