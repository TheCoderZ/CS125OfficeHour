package com.example.cs125officehours;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.EventListener;

public class StudentActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    public Button mButton;
    EditText mEdit;
    TextView mText;
    String name;
    Student user;
    Student dbStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_interface);
        mEdit = (EditText)findViewById(R.id.editText3);
        //mEdit.getText().toString();

    }

    public void send(View view) {
        mButton = (Button)findViewById(R.id.request_TA);
        name = mEdit.getText().toString();
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (name != "") {
                    writeNewStudent(name, name, name);
                    TextView textView = findViewById(R.id.textView2);
                    textView.setText("Looking for a TA/CA...");
                    seek(name);
                }
            }
        });
        //System.out.println(mDatabase.child("Students").child(name).getKey());
       /* while(mDatabase.child(user.username).child("match").) {

        }*/
    }

    private void writeNewStudent(String userId, String name, String email) {
        user = new Student(name, email);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Student").push().child(userId).setValue(user);
        user.key = mDatabase.child("Student").child(userId).push().getKey();
        //mDatabase.push();
        //mDatabase.orderByKey();
    }

    private void seek(String name) {
        mDatabase.child(user.key).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                TextView textView = findViewById(R.id.textView2);
                textView.setText("matched");
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //postListener.onDataChange();
        //System.out.println(mDatabase.child("Student").child(name).child("match").addValueEventListener(postListener));
        //System.out.println(dbSt)
        //while (!user.match) {
            /*final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms
                    //buttons[inew][jnew].setBackgroundColor(Color.BLACK);
                }
            }, 5000);*/
            //System.out.println("hello");
        //}
    }
}
