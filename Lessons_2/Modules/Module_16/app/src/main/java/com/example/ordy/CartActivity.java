package com.example.ordy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ordy.Helpers.CartItemAdapter;
import com.example.ordy.Helpers.JSONHelper;
import com.example.ordy.Models.Cart;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        listView = findViewById(R.id.shopping_cart);
        List<Cart> cartList = JSONHelper.importFromJSON(this);

        if (cartList != null) {
            CartItemAdapter arrayAdapter = new CartItemAdapter(CartActivity.this, R.layout.cart_item, cartList);
            listView.setAdapter(arrayAdapter);

            Toast.makeText(this, "Данные востановленны", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Не удалось подгрузить данные", Toast.LENGTH_SHORT).show();
    }
}