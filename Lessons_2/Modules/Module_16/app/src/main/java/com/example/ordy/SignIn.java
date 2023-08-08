package com.example.ordy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ordy.Models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {

    private Button btnSingIn;
    private EditText editPhone, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btnSingIn = findViewById(R.id.btnSignIn);
        editPhone = findViewById(R.id.editTextPhone);
        editPassword = findViewById(R.id.editTextPassword);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tabel = database.getReference("User");

        btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tabel.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.child(editPhone.getText().toString()).exists()) {
                            User user = snapshot.child(editPhone.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(editPassword.getText().toString())) {
                                setDefaults("phone", editPhone.getText().toString(), SignIn.this);
                                setDefaults("name", user.getName(), SignIn.this);

                                 Intent intent = new Intent(SignIn.this, FoodPage.class);
                                 startActivity(intent);
                            } else
                                Toast.makeText(SignIn.this, "Неверный логин или пароль", Toast.LENGTH_LONG).show();
                        } else
                            Toast.makeText(SignIn.this, "Такого пользователя нет", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(SignIn.this, "Нет интернет соединения", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    public static void setDefaults(String key, String value, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getDefaults(String key, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(key, null);
    }

}