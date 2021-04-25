package com.example.losaltoshackseducation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StudentMain extends AppCompatActivity {
    //private FirebaseAuth auth;

    ArrayList<String> listOfClasses;

    Button addClass;
    Button redeem;
    RecyclerView courses;
    AlertDialog.Builder alert;

    StudentMainAdapter sAdapter;
//    final FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference ref = database.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_main);
        addClass = findViewById(R.id.addClass);
        redeem = findViewById(R.id.button);
        courses = findViewById(R.id.classList);
        alert = new AlertDialog.Builder(this);

        listOfClasses = new ArrayList<String>();

        //auth = FirebaseAuth.getInstance();

        final EditText input = new EditText(StudentMain.this);

        redeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentMain.this, StudentRedeem.class));
            }
        });

        addClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText input = new EditText(StudentMain.this);
                alert.setView(input);
                System.out.println("here printed");
                alert.setTitle("Course Name").setMessage("Enter the course code").setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

//                        ref.child("Classes").child(input.getText().toString()).child("Students").child(auth.getCurrentUser().getUid()).setValue("");
//                        ref.child("Classes").child(input.getText().toString()).child("Name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                            @Override
//                            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                                try {
//                                    ref.child("Users").child(auth.getCurrentUser().getUid()).child("Classes").child(task.getResult().getValue().toString()).setValue("");
//                                }catch(NullPointerException np){};
//                            }
//                        });
                        listOfClasses.add("Math");
                        sAdapter.notifyDataSetChanged();
                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = Toast.makeText(StudentMain.this, "No Classes Added", Toast.LENGTH_LONG);
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

        sAdapter = new StudentMainAdapter(this, listOfClasses);
        courses.setAdapter(sAdapter);
        courses.setLayoutManager(new LinearLayoutManager(this));
    }

}