package com.example.module_14;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button conver_btn;
    EditText user_textfielt;
    TextView result_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conver_btn = findViewById(R.id.conver_btn);
        user_textfielt = findViewById(R.id.user_textfielt);
        result_textview = findViewById(R.id.result_textview);

        conver_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConvertSpeed(view);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void ConvertSpeed(View v) {
        EditText user_textfielt = findViewById(R.id.user_textfielt);
        TextView result_textview = findViewById(R.id.result_textview);

        String text = user_textfielt.getText().toString();
        if (!text.equals("")) {
            float numer = Float.parseFloat(text);
            numer *= 1.6;
            result_textview.setText(Float.toString(numer));
        } else {
            Toast.makeText(getApplicationContext(), "Введите какой либо текст", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}