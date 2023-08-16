package com.example.ordy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ordy.Helpers.FoodListAdapter;
import com.example.ordy.Models.Category;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FoodPage extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_page);

        listView = findViewById(R.id.list_of_food);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tabel = database.getReference("Category");

        tabel.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ArrayList<Category> allFood = new ArrayList<>();
                for (DataSnapshot obj : snapshot.getChildren()) {
                    Category category = obj.getValue(Category.class);
                    allFood.add(category);

                    FoodListAdapter arrayAdapter = new FoodListAdapter(FoodPage.this, R.layout.food_item_in_list, allFood);
                    listView.setAdapter(arrayAdapter);
                }
            }

            @Override
             public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(FoodPage.this, "Нет интернет соединения", Toast.LENGTH_LONG).show();
            }
        });
    }
}