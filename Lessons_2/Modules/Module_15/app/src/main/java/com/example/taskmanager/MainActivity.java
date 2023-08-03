package com.example.taskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DataBase dataBase;
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBase = new DataBase(this);
        listView = findViewById(R.id.task_list);

        loadAllTask();
    }

    private void loadAllTask() {
        ArrayList<String> allTask = dataBase.getAllTask();
        if (arrayAdapter == null) {
            arrayAdapter = new ArrayAdapter<String>(this, R.layout.task_list_row, R.id.text_label_row, allTask);
            listView.setAdapter(arrayAdapter);
        } else {
            arrayAdapter.clear();
            arrayAdapter.addAll(allTask);
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        Drawable icon = menu.getItem(0).getIcon();
        icon.mutate();
        icon.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_new_task) {
            final EditText userTaskFild = new EditText(this);
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("Добавление нового задания")
                    .setMessage("Чтобы вы хотели добавить?")
                    .setView(userTaskFild)
                    .setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String task = String.valueOf(userTaskFild.getText());
                            dataBase.insertData(task);
                            loadAllTask();
                        }
                    })
                    .setNegativeButton("Отмена", null)
                    .create();
            dialog.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void deleteTask(View button) {
        View parent = (View) button.getParent();
        TextView textView = parent.findViewById(R.id.text_label_row);
        String task = String.valueOf(textView.getText());
        dataBase.deleteData(task);
        loadAllTask();
    }
}