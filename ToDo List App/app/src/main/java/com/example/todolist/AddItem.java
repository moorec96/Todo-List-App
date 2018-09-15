package com.example.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItem extends Activity implements View.OnClickListener {

    private Button enterTaskBtn;
    private EditText currentTask;
    private EditText currentPriority;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_item_popup_window);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8), (int)(height*0.6));         //Makes window smaller so it doesnt cover activity behind it

        enterTaskBtn = findViewById(R.id.submit_task_btn);
        enterTaskBtn.setOnClickListener(this);
        currentTask = findViewById(R.id.enter_item_field);
        currentPriority = findViewById(R.id.priority_view);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.submit_task_btn:
                Intent intent = new Intent();
                intent.putExtra("editTextValue",currentTask.getText().toString() );
                intent.putExtra("priorityValue",currentPriority.getText().toString());
                setResult(RESULT_OK,intent);
                currentTask.setText("");
                finish();
                break;
        }
    }
}
