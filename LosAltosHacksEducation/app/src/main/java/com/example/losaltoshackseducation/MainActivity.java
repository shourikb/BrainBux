package com.example.losaltoshackseducation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button student;
    private Button teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        student = findViewById(R.id.studentBtn);
        teacher = findViewById(R.id.teacherBtn);

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogIn.isStudent = true;
                startActivity(new Intent(MainActivity.this, LogIn.class));
            }
        });

        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogIn.isStudent = false;
                startActivity(new Intent(MainActivity.this, LogIn.class));
            }
        });


    }
}