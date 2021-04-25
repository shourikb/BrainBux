package com.example.losaltoshackseducation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class TeacherClassView extends AppCompatActivity {

    private ArrayList<String> listOfClasses;

    private RecyclerView view;
    private TeacherClassAdapter adapter;

    private Button addBtn;
    private AlertDialog.Builder alert;

    private FirebaseAuth auth;
    private DatabaseReference dataAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_class_view);

        view = findViewById(R.id.classList);
        addBtn = findViewById(R.id.addClass);

        alert = new AlertDialog.Builder(this);

        auth = FirebaseAuth.getInstance();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        dataAccess = database.getReference();

        dataAccess.child("Users").child(auth.getCurrentUser().getUid()).child("Classes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listOfClasses.clear();
                for (DataSnapshot data : snapshot.getChildren()) {
                    try {
                        addClass(data.getKey());
                    } catch (NullPointerException e) {

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText input = new EditText(TeacherClassView.this);
                alert.setView(input);
                alert.setTitle("Course Name").setMessage("Enter the name of your course").setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!input.getText().toString().equals("")) {
                            String id = auth.getCurrentUser().getUid();
                            dataAccess.child("Users").child(id).child("Classes").child(input.getText().toString()).child("Categories").setValue("");
                            dataAccess.child("Classes").child(generateCode()).child("Name").setValue(input.getText().toString());
                            addClass(input.getText().toString());
                        Toast toast = Toast.makeText(TeacherClassView.this, "Class Added", Toast.LENGTH_LONG);
                        toast.show();

                        } else {
                            Toast toast = Toast.makeText(TeacherClassView.this, "No text in the field", Toast.LENGTH_LONG);
                           toast.show();
                        }
                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = Toast.makeText(TeacherClassView.this, "No Classes Added", Toast.LENGTH_LONG);
                        toast.show();
                    }
                });

                alert.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        ((ViewGroup)input.getParent()).removeView(input);
                    }
                });

                alert.show();



            }
        });

        listOfClasses = new ArrayList<String>();

        adapter = new TeacherClassAdapter(this, listOfClasses);
        view.setAdapter(adapter);
        view.setLayoutManager(new LinearLayoutManager(this));

    }

    public void addClass(String className) {
        listOfClasses.add(className);
        adapter.notifyDataSetChanged();
    }

    public String generateCode(){
        /*
        Random r = new Random();
        String s = "";
        for(int i=0;i<4;i++){
            Integer n = r.nextInt(10);
            s+= n.toString();
        }
        return s;
         */
        return "7482";
    }



}
