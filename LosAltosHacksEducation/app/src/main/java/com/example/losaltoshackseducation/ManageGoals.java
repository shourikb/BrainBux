package com.example.losaltoshackseducation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ManageGoals extends AppCompatActivity {

    private ArrayList<String> goals;
    public ArrayList<Goal> actualGoals;

    private RecyclerView goalView;
    public GoalAdapter gAdapter;
    private Button addGoal;

    private AlertDialog.Builder alert;

    private static String name;

//    private FirebaseAuth auth;
//    private DatabaseReference dataAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_goals);

//        auth = FirebaseAuth.getInstance();
//        final FirebaseDatabase database = FirebaseDatabase.getInstance();
//        dataAccess = database.getReference();


//        dataAccess.child("Users").child(auth.getCurrentUser().getUid()).child("Classes").child(name).child("Categories").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                actualGoals.clear();
//                for (DataSnapshot data : snapshot.getChildren()) {
//                    for (DataSnapshot d : data.getChildren()) {
//                        try {
//                            addGoal(new Goal(data.getKey(), d.getKey(), d.child("Description").getValue().toString(), d.child("Value").getValue().toString(), "Math"));
//
//                        } catch (NullPointerException e) {
//
//                        }
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        goalView = findViewById(R.id.goalList);
        addGoal = findViewById(R.id.addGoal);

        alert = new AlertDialog.Builder(this);

        addGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AddGoal.setName(name);
//                AddGoal.setmGoals(ManageGoals.this);
//                startActivity(new Intent(ManageGoals.this, AddGoal.class));
                final TextView gCategory = new TextView(ManageGoals.this);
                gCategory.setText("Goal Category");
                final EditText goalCategory = new EditText(ManageGoals.this);
                final TextView gName = new TextView(ManageGoals.this);
                gName.setText("Goal Name");
                final EditText goalName = new EditText(ManageGoals.this);
                final TextView gDescription = new TextView(ManageGoals.this);
                gDescription.setText("Goal Description");
                final EditText goalDesription = new EditText(ManageGoals.this);
                final TextView gPV = new TextView(ManageGoals.this);
                gPV.setText("Goal Point Value");
                final EditText goalPV = new EditText(ManageGoals.this);

                final LinearLayout ll = new LinearLayout(ManageGoals.this);
                ll.setOrientation(LinearLayout.VERTICAL);
                ll.addView(gCategory);
                ll.addView(goalCategory);
                ll.addView(gName);
                ll.addView(goalName);
                ll.addView(gDescription);
                ll.addView(goalDesription);
                ll.addView(gPV);
                ll.addView(goalPV);
                alert.setView(ll);

                alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        goals.add(goalName.getText().toString());
                        gAdapter.notifyDataSetChanged();
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

        goals = new ArrayList<String>();
        actualGoals = new ArrayList<Goal>();
        goals.add("Finish the extra credit assignment");

        gAdapter = new GoalAdapter(this, goals);
        goalView.setAdapter(gAdapter);
        goalView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void addGoal(Goal g) {
        actualGoals.add(g);
    }

    public static void setName(String cName) {
        name = cName;
    }

    public ArrayList<String> getGoals() {
        return goals;
    }

    public RecyclerView getGoalView() {
        return goalView;
    }
}
