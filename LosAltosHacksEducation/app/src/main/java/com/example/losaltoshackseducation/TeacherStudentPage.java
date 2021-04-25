package com.example.losaltoshackseducation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TeacherStudentPage extends AppCompatActivity {

    private ArrayList<String[]> nameAndValue;
    private ArrayList<String> onlyName;

    private RecyclerView view1;
    private RecyclerView view2;

    public TeacherStudentAdapter adapter1;
    public TeacherStudentAdapter2 adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_student_page);

        view1 = findViewById(R.id.recyclerView1);
        view2 = findViewById(R.id.recyclerView2);

        nameAndValue = new ArrayList<String[]>();
        onlyName = new ArrayList<String>();

        String[] goalAndValue = new String[2];
        goalAndValue[0] = "Complete the extra credit worksheet";
        goalAndValue[1] = "100";

        nameAndValue.add(goalAndValue);

        adapter1 = new TeacherStudentAdapter(onlyName);
        adapter2 = new TeacherStudentAdapter2(this, nameAndValue);
        view1.setAdapter(adapter1);
        view1.setLayoutManager(new LinearLayoutManager(this));
        view2.setAdapter(adapter2);
        view2.setLayoutManager(new LinearLayoutManager(this));
    }

    public RecyclerView getView1() {
        return view1;
    }

    public RecyclerView getView2() {
        return view2;
    }

    public ArrayList<String> getOnlyName() {
        return onlyName;
    }

    public ArrayList<String[]> getNameAndValue() {
        return nameAndValue;
    }

}
