package com.example.losaltoshackseducation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentClass extends AppCompatActivity {

    private ArrayList<String> goalsComplete;
    private static String name;

    private RecyclerView view;

    private TeacherStudentAdapter scAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_class);

        view = findViewById(R.id.complete);

        goalsComplete = new ArrayList<String>();
        goalsComplete.add("Finish the extra credit assignment");

        scAdapter = new TeacherStudentAdapter(goalsComplete);
        view.setAdapter(scAdapter);
        view.setLayoutManager(new LinearLayoutManager(this));
    }

    public static void setName(String cName) {
        name = cName;
    }

}
