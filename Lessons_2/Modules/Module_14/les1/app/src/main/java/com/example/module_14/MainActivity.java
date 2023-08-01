package com.example.module_14;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button conver_btn;
    private EditText user_textfielt;
    private TextView result_textview;
    private ImageButton btn_next_activity;
    private ImageView imageViewSimple,imageViewVector;

    private int count = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conver_btn = findViewById(R.id.conver_btn);
        user_textfielt = findViewById(R.id.user_textfielt);
        result_textview = findViewById(R.id.result_textview);
        btn_next_activity = findViewById(R.id.btn_next_activity);
        imageViewVector = findViewById(R.id.imageViewVector);
        imageViewSimple = findViewById(R.id.imageViewSimple);

        int orientation = this.getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            imageViewVector.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count++;
                    count = count > 3 ? 1 : count;
                    switch (count) {
                        case 1:
                            imageViewSimple.setImageResource(R.drawable.boykisser1);
                            break;
                        case 2:
                            imageViewSimple.setImageResource(R.drawable.boykisser3);
                            break;
                        case 3:
                            imageViewSimple.setImageResource(R.drawable.boykisser2);
                        default:
                            imageViewSimple.setImageResource(R.drawable.boykisser2);
                    }
                }
            });
        }

        if(orientation == Configuration.ORIENTATION_PORTRAIT) {
            conver_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Вы хотите произвести конвертацию");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ConvertSpeed();
                        }
                    });
                    builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(), "Вы отменили действие", Toast.LENGTH_LONG).show();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.setTitle("Конвертация данных");
                    alertDialog.show();
                }
            });
        }

        btn_next_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.exemle.app.SecondActivity");
                startActivity(intent);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void ConvertSpeed() {
        EditText user_textfielt = findViewById(R.id.user_textfielt);
        TextView result_textview = findViewById(R.id.result_textview);

        String text = user_textfielt.getText().toString();
        if (!text.equals("")) {
            float numer = Float.parseFloat(text);
            numer *= 1.6;
            result_textview.setText(Float.toString(numer));

            conver_btn.setText("Готово");
            conver_btn.setBackgroundColor(Color.GREEN);

        } else {
            conver_btn.setText("Ошибка");
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