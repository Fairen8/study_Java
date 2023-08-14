package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText full_link;
    private EditText abbreviated_link;
    private Button main_btn;
    private ListView link_list;

    private ArrayList<Link> allLinks= new ArrayList<Link>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        full_link = findViewById(R.id.full_link);
        abbreviated_link = findViewById(R.id.abbreviated_link);
        main_btn = findViewById(R.id.main_btn);
        link_list = findViewById(R.id.link_list);

        main_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addLink();
            }
        });

        link_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Link link = LinkListAdapter.getLink(i);

                openWebPage(link.getFull_link());
            }
        });
    }

    //ToDo сделать расцыетку надписи каждого столпца градиентом

    private void loadAllLinks() {
        LinkListAdapter arrayAdapter = new LinkListAdapter(MainActivity.this, R.layout.link_list_row, allLinks);
        link_list.setAdapter(arrayAdapter);
    }

    private void addLink() {
        String full = full_link.getText().toString();
        String abbreviated = abbreviated_link.getText().toString();

        main_btn.setText("Добавить");

        if (LinkListAdapter.isExists(abbreviated))
            main_btn.setText("Такое сокращение недоступно");
        else if (full_link.length() < 2)
            main_btn.setText("Некорректная ссылка");
        else if (abbreviated.length() < 1)
            main_btn.setText("Некорректное сокращение");
        else {
            main_btn.setText("Готово");
            full_link.setText("");
            abbreviated_link.setText("");

            Link link = new Link(full, abbreviated);
            allLinks.add(link);
            loadAllLinks();
        }
    }

    public void openWebPage(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://"))
            url = "http://" + url;
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}