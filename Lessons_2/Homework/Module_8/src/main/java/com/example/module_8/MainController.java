package com.example.module_8;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> conversion_ChoiceBox;

    @FXML
    private Label grams_output;

    @FXML
    private Label kilograms_output;

    @FXML
    private TextField num_input;

    @FXML
    private Label tons_output;

    String tons_text = "Значение в тоннах:\n";
    String kilograms_text = "Значение в килограммах:\n";
    String grams_text = "Значение в граммах:\n";
    String label_num = "";
    String choose = "Килограммы";

    private final int[] true_nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final String[] con_list = {"Килограммы", "Граммы", "Тонны"};

    @FXML
    void initialize() {
        conversion_ChoiceBox.setValue(con_list[0]);
        conversion_ChoiceBox.getItems().addAll(con_list);
        conversion_ChoiceBox.setOnAction(this::getChoose);
        set_res(0d, 0d, 0d);
    }

    public void res() {
        switch (choose) {
            case "Килограммы":
                set_res(Double.parseDouble(label_num) / 1000d, Double.parseDouble(label_num), Double.parseDouble(label_num) * 1000d);
                break;
            case "Граммы":
                set_res(Double.parseDouble(label_num) / 1000000d, Double.parseDouble(label_num) / 1000d, Double.parseDouble(label_num));
                break;
            case "Тонны":
                set_res(Double.parseDouble(label_num), Double.parseDouble(label_num) * 1000d, Double.parseDouble(label_num) * 1000000d);
        }
    }

    public void set_res(double tons, double kilograms, double grams) {
        tons_output.setText(tons_text + tons);
        kilograms_output.setText(kilograms_text + kilograms);
        grams_output.setText(grams_text + grams);
    }
    @FXML
    void clear(ActionEvent event) {
        label_num = "";
        num_input.clear();
        set_res(0d, 0d, 0d);
    }

    @FXML
    void getText(KeyEvent event) {
        int i = 0;
        while (i < true_nums.length) {
            if (event.getText().equals(Integer.toString(true_nums[i]))) {
                label_num += event.getText();
                res();
                break;
            } else if (event.getText().equals("")) {
                label_num = label_num.substring(0, label_num.length() - 1);
                if (!label_num.equals("")) {
                    res();
                } else
                    set_res(0d, 0d, 0d);
                break;
            } else if ((i + 1) == true_nums.length) {
                label_num = "";
                num_input.clear();
                set_res(0d, 0d, 0d);
            }
            i++;
        }
    }
    public void getChoose(ActionEvent event) {
        choose = conversion_ChoiceBox.getValue();
        if (!label_num.equals(""))
            res();
    }
}