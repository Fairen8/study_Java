package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num_input;
    private Spinner spinner;
    private TextView tons, kilograms, grams;

    String[] items = new String[]{"Тонны", "Килограммы", "Граммы"};

    private String choose = "Тонны";
    private String nums = "";

    String tons_text = "Количество тон:\n";
    String kilograms_text = "Количество кг:\n";
    String grams_text = "Количество грамм:\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num_input = findViewById(R.id.num_input);
        spinner = findViewById(R.id.spinner);
        tons = findViewById(R.id.tones);
        kilograms = findViewById(R.id.killograms);
        grams = findViewById(R.id.grams);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, items);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);

        getInput();
    }

    private void res() {
        switch (choose) {
            case "Килограммы":
                set_res(Float.parseFloat(nums) / 1000f, Float.parseFloat(nums), Float.parseFloat(nums) * 1000f);
                break;
            case "Граммы":
                set_res(Float.parseFloat(nums) / 1000000f, Float.parseFloat(nums) / 1000f, Float.parseFloat(nums));
                break;
            case "Тонны":
                set_res(Float.parseFloat(nums), Float.parseFloat(nums) * 1000f, Float.parseFloat(nums) * 1000000f);
        }
    }

    private void set_res(float tons, float kilograms, float grams) {
        this.tons.setText(tons_text + tons);
        this.kilograms.setText(kilograms_text + kilograms);
        this.grams.setText(grams_text + grams);
    }

    private void getInput() {
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                choose = (String) adapterView.getItemAtPosition(i);
                if (!nums.equals(""))
                    res();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);

        num_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                nums = String.valueOf(num_input.getText());
                if(!nums.equals(""))
                    res();
                else
                    set_res(0, 0, 0);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }
}