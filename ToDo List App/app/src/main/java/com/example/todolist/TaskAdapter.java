package com.example.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<String> {

    public Context context;
    public ArrayList<String> tasks;
    public ArrayList<Integer> priorities;

    public TaskAdapter(Context c, ArrayList<String> tasks, ArrayList<Integer> priorities){
        super(c,R.layout.task,R.id.task_textView,tasks);
        this.context = c;
        this.tasks = tasks;
        this.priorities = priorities;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater layoutInf = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View taskView = layoutInf.inflate(R.layout.task, parent,false);
        TextView taskText = (TextView) taskView.findViewById(R.id.task_textView);
        TextView priority = (TextView) taskView.findViewById(R.id.textView4);
        if(tasks != null) {
            taskText.setText(tasks.get(position));
        }
        if(priorities!= null) {
            priority.setText("Priority: " + priorities.get(position).toString());
        }
        return taskView;
    }
}