package com.example.losaltoshackseducation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogIn extends AppCompatActivity {

    private FirebaseAuth auth;
    private DatabaseReference dataAccess;
    private EditText email;
    private EditText password;
    private Button logIn;
    private Button signUp;
    private TextView welcome;
    static boolean isStudent = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        auth = FirebaseAuth.getInstance();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        dataAccess = database.getReference();

        email = findViewById(R.id.emailLogin);
        password = findViewById(R.id.passwordLogin);
        logIn = findViewById(R.id.logInBtn);
        signUp = findViewById(R.id.signUpBtn);
        welcome = findViewById(R.id.welcomeText);

        if (isStudent) {
            welcome.setText("Student");
        } else {
            welcome.setText("Teacher");
        }

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!email.getText().toString().equals("") && !password.getText().toString().equals("")) {
                    auth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                              String id = auth.getCurrentUser().getUid();
                                dataAccess.child("Users").child(id).child("Occupation").setValue(welcome.getText().toString());
                                Toast toast = Toast.makeText(LogIn.this, "Sign Up Successful", Toast.LENGTH_LONG);
                                toast.show();
                            } else {
                                Toast toast = Toast.makeText(LogIn.this, "Unsuccessful Sign Up", Toast.LENGTH_LONG);
                                toast.show();
                            }
                        }
                    });
                } else {
                    Toast toast = Toast.makeText(LogIn.this, "Unsuccessful Sign Up", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!email.getText().toString().equals("") && !password.getText().toString().equals("")) {
                    auth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                String id = auth.getCurrentUser().getUid();
                                dataAccess.child("Users").child(id).child("Occupation").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                                        if (task.getResult().getValue().toString().equals("Teacher") && !isStudent) {
                                            startActivity(new Intent(LogIn.this, TeacherClassView.class));
                                            Toast toast = Toast.makeText(LogIn.this, "Log In Successful", Toast.LENGTH_LONG);
                                            toast.show();
                                        } else if (task.getResult().getValue().toString().equals("Student") && isStudent) {
                                            startActivity(new Intent(LogIn.this, StudentMain.class));
                                            Toast toast = Toast.makeText(LogIn.this, "Log In Successful", Toast.LENGTH_LONG);
                                            toast.show();
                                        } else {
                                            Toast toast = Toast.makeText(LogIn.this, "Incorrect Log In Info", Toast.LENGTH_LONG);
                                            toast.show();
                                        }
                                    }
                                });

                            } else {
                                Toast toast = Toast.makeText(LogIn.this, "Incorrect Log In Info", Toast.LENGTH_LONG);
                                toast.show();
                            }
                        }
                    });
                } else {
                    Toast toast = Toast.makeText(LogIn.this, "Incorrect Log In Info", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });


    }
}