package com.example.ordy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ordy.Helpers.JSONHelper;
import com.example.ordy.Models.Cart;
import com.example.ordy.Models.Category;
import com.example.ordy.Models.Food;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FoodDetail extends AppCompatActivity {

    public static int ID = 0;

    private ImageView mainPhoto;
    private TextView foodMainName, price, foodFullName;
    private Button btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mainPhoto = findViewById(R.id.mainPhoto);
        foodMainName = findViewById(R.id.foodMainName);
        price = findViewById(R.id.price);
        foodFullName = findViewById(R.id.foodFullName);
        btnGoToCart = findViewById(R.id.btnGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FoodDetail.this, CartActivity.class));
            }
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tabel = database.getReference("Category");

        tabel.child(String.valueOf(ID)).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Category category = snapshot.getValue(Category.class);

                foodMainName.setText(category.getName());
                int id = getApplicationContext().getResources().getIdentifier("drawable/" + category.getImage(), null, getApplicationContext().getPackageName());
                mainPhoto.setImageResource(id);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(FoodDetail.this, "Нет интернет соединения", Toast.LENGTH_LONG).show();
            }
        });

        final DatabaseReference tabel_food = database.getReference("Food");
        tabel_food.child(String.valueOf(ID)).addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Food foodItem = snapshot.getValue(Food.class);

                price.setText(foodItem.getPrice() + " рублей");
                foodFullName.setText(foodItem.getFull_text());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(FoodDetail.this, "Нет интернет соединения", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void btnAddToCart(View view) {
        List<Cart> cartList = JSONHelper.importFromJSON(this);
        if (cartList == null) {
            cartList = new ArrayList<>();
            cartList.add(new Cart(ID, 1));
        } else {
            boolean isFound = false;
            for (Cart el : cartList) {
                if (el.getCategoryID() == ID) {
                    el.setAmount(el.getAmount() + 1);
                    isFound = true;
                }
            }
            if (!isFound) {
                cartList.add(new Cart(ID, 1));
            }
        }

        boolean result = JSONHelper.exportToJSON(this, cartList);
        if (result) {
            Toast.makeText(this, "Добавленно", Toast.LENGTH_SHORT).show();
            Button btnCart = (Button) view;
            btnCart.setText("Добавлеенно");
        } else {
            Toast.makeText(this, "Не добавленно", Toast.LENGTH_SHORT).show();
        }
    }
}