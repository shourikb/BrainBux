package com.example.losaltoshackseducation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ManageRewards extends AppCompatActivity {

    public ArrayList<String> rewards;
    public ArrayList<Reward> actualRewards;

    private RecyclerView rewardView;
    public RewardAdapter rAdapter;
    private Button addGoal;

    private AlertDialog.Builder alert;

    private static String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_rewards);

        rewardView = findViewById(R.id.rewardList);
        addGoal = findViewById(R.id.addReward);

        alert = new AlertDialog.Builder(this);

        addGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView rCategory = new TextView(ManageRewards.this);
                rCategory.setText("Reward Category");
                final EditText rewardCategory = new EditText(ManageRewards.this);
                final TextView rName = new TextView(ManageRewards.this);
                rName.setText("Reward Name");
                final EditText rewardName = new EditText(ManageRewards.this);
                final TextView rDescription = new TextView(ManageRewards.this);
                rDescription.setText("Reward Description");
                final EditText rewardDesription = new EditText(ManageRewards.this);
                final TextView rPV = new TextView(ManageRewards.this);
                rPV.setText("Reward Point Value");
                final EditText rewardPV = new EditText(ManageRewards.this);

                final LinearLayout ll = new LinearLayout(ManageRewards.this);
                ll.setOrientation(LinearLayout.VERTICAL);
                ll.addView(rCategory);
                ll.addView(rewardCategory);
                ll.addView(rName);
                ll.addView(rewardName);
                ll.addView(rDescription);
                ll.addView(rewardDesription);
                ll.addView(rPV);
                ll.addView(rewardPV);
                alert.setView(ll);

                alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        addReward(rewardName.getText().toString());
                    }
                });

                alert.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alert.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        ((ViewGroup)ll.getParent()).removeView(ll);
                    }
                });

                alert.show();

            }
        });



        rewards = new ArrayList<String>();
        actualRewards = new ArrayList<Reward>();
        rewards.add("Get a hint on a test");

        rAdapter = new RewardAdapter(this, rewards);
        rewardView.setAdapter(rAdapter);
        rewardView.setLayoutManager(new LinearLayoutManager(this));

    }

    public static void setName(String cName) {
        name = cName;
    }

    public void addReward(Reward r) {
        actualRewards.add(r);
    }

    public void addReward(String name) {
        rewards.add(name);
        rAdapter.notifyDataSetChanged();
    }

    public ArrayList<String> getReward() {
        return rewards;
    }

    public RecyclerView getRewardView() {
        return rewardView;
    }


}