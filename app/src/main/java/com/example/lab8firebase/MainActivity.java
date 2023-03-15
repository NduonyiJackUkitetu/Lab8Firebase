package com.example.lab8firebase;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab8firebase.model.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class MainActivity extends AppCompatActivity {

    /** Link to the root node in the DB */
    FirebaseDatabase database;
    int initialID = 0;
    /** */
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addTask(View view) {
// Read the txt from the input text
        @SuppressLint("WrongViewCast") EditText taskEditText =
                findViewById(R.id.taskDescription);
        String taskDescription = taskEditText.getText().toString();
        initialID ++;
        Task newTask = new Task(String.valueOf(initialID), taskDescription);
        // Login to Firebase project and get instance of the DB and point to the root node of the DB
        database = FirebaseDatabase.getInstance("https://lab8firebase-474c2-default-rtdb.firebaseio.com/");
// Set reference to the Tasks table
        databaseReference = database.getReference("tasks");
        databaseReference.child(newTask.toString()).setValue(newTask);
    }


}