package com.example.module_14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @SuppressLint("NonConstantResourceId")
    public void FragmentChange(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (v.getId() == R.id.fragment_btn_1) {
            FistFragment fistFragment = new FistFragment();
            fragmentTransaction.replace(R.id.fragmentContainerView, fistFragment);
        } else if (v.getId() == R.id.fragment_btn_2) {
            SecondFragment secondFragment = new SecondFragment();
            fragmentTransaction.replace(R.id.fragmentContainerView, secondFragment);
        }
        fragmentTransaction.commit();
    }
}