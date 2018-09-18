package com.example.todolist;

import android.widget.ArrayAdapter;

import java.io.Serializable;
import java.util.ArrayList;

public class Tasks implements Serializable{
    ArrayList<String> tasks;
    ArrayList<Integer> priorities;

    public Tasks(){
        tasks = new ArrayList<String>();
        priorities = new ArrayList<Integer>();
    }

    public Tasks(ArrayList<String> tasks, ArrayList<Integer> priorities){
        this.tasks = tasks;
        this.priorities = priorities;
    }


}
