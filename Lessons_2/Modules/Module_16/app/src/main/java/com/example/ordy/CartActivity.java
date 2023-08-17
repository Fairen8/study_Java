package com.example.ordy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ordy.Helpers.CartItemAdapter;
import com.example.ordy.Helpers.JSONHelper;
import com.example.ordy.Models.Cart;
import com.example.ordy.Models.Order;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private ListView listView;
    private Button btnMakeOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        btnMakeOrder = findViewById(R.id.btnMakeOrder);
        listView = findViewById(R.id.shopping_cart);
        List<Cart> cartList = JSONHelper.importFromJSON(this);

        if (cartList != null) {
            CartItemAdapter arrayAdapter = new CartItemAdapter(CartActivity.this, R.layout.cart_item, cartList);
            listView.setAdapter(arrayAdapter);

            Toast.makeText(this, "Данные востановленны", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Не удалось подгрузить данные", Toast.LENGTH_SHORT).show();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tabel = database.getReference("Order");

        btnMakeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tabel.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        List<Cart> cartList = JSONHelper.importFromJSON(CartActivity.this);
                        if (cartList == null) {
                            Toast.makeText(CartActivity.this, "Корзина не сформирована", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        String activeUser = SignIn.getDefaults("phone", CartActivity.this);
                        Order order = new Order(JSONHelper.createJSONString(cartList), activeUser);

                        Long tsLong = System.currentTimeMillis() / 1000;

                        tabel.child(tsLong.toString()).setValue(order).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                List<Cart> cartList = new ArrayList<>();
                                JSONHelper.exportToJSON(CartActivity.this, cartList);

                                CartItemAdapter arrayAdapter = new CartItemAdapter(CartActivity.this, R.layout.cart_item, cartList);
                                listView.setAdapter(arrayAdapter);

                                Toast.makeText(CartActivity.this, "Заказ сформирован", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}