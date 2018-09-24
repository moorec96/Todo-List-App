package com.example.todolist;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private FloatingActionButton addItemBtn;
    private ListView itemsList;

    private Tasks tasks;
    private TaskAdapter adapter;   //Android studio uses this to help fill in lists


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemBtn = findViewById(R.id.add_item_btn);
        itemsList = findViewById(R.id.items_list);
        tasks = FileHelper.readData(this);

        adapter = new TaskAdapter(this, tasks.tasks, tasks.priorities);
        itemsList.setAdapter(adapter);


        addItemBtn.setOnClickListener(this);
        itemsList.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.add_item_btn:
                Intent intent = new Intent(this, AddItem.class);
                startActivityForResult(intent,1);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tasks.tasks.remove(position);
        tasks.priorities.remove(position);
        adapter.notifyDataSetChanged();
        FileHelper.writeData(tasks, this);
        Toast.makeText(this,"Delete", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                String itemEntered = data.getStringExtra("editTextValue");
                Integer priority = Integer.parseInt(data.getStringExtra("priorityValue"));
                adapter.tasks.add(itemEntered);
                adapter.priorities.add(priority);
                adapter.notifyDataSetChanged();
                FileHelper.writeData(tasks, this);
                Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
