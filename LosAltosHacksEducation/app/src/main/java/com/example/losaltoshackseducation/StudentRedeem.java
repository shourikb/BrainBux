package com.example.losaltoshackseducation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentRedeem extends AppCompatActivity {

    ArrayList<String[]> rewards;

    RecyclerView buy;
    StudentRedeemAdapter srAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_redeem);

        rewards = new ArrayList<String[]>();
        String[] toAdd = new String[2];
        toAdd[0] = "Get a hint on a test";
        toAdd[1] = "100";

        rewards.add(toAdd);

        buy = findViewById(R.id.buy);

        srAdapter = new StudentRedeemAdapter(this, rewards);
        buy.setAdapter(srAdapter);
        buy.setLayoutManager(new LinearLayoutManager(this));
    }
}
