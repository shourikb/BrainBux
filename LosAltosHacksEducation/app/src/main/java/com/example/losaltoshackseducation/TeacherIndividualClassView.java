package com.example.losaltoshackseducation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TeacherIndividualClassView extends AppCompatActivity {

    private ArrayList<String> studentNames;

    private Button manageGoals;
    private Button manageRewards;

    private RecyclerView students;
    private TeacherIndividualAdapter tiaAdapter;

    private static String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_individual_class_view);

        manageGoals = findViewById(R.id.manageGoals);
        manageRewards = findViewById(R.id.manageRewards);

        students = findViewById(R.id.listOfStudents);

        studentNames = new ArrayList<String>();

        studentNames.add("shourikbanerjee@gmail.com");

        manageGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ManageGoals.setName(name);
                startActivity(new Intent(TeacherIndividualClassView.this, ManageGoals.class));
            }
        });

        manageRewards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ManageRewards.setName(name);
                startActivity(new Intent(TeacherIndividualClassView.this, ManageRewards.class));
            }
        });

        tiaAdapter = new TeacherIndividualAdapter(this, studentNames);
        students.setAdapter(tiaAdapter);
        students.setLayoutManager(new LinearLayoutManager(this));
    }

    public static void setName(String cName) {
        name = cName;
    }

}
