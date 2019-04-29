package com.example.cs125officehours;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONObject;

public class StaffActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    public Button mButton;


    private static final String TAG =
            StaffActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mDatabase = FirebaseDatabase.getInstance().getReference("Student");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ta_interface);
    }

    public void done(View view) {
        //Student[] students =
        //final Query students = mDatabase.snapshot;
        Query students = mDatabase.orderByKey();
        //DataSnapshot something = students.
        System.out.println("this works");
        //System.out.println(students);
        mButton = (Button)findViewById(R.id.ta_done);
        students.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    System.out.println(postSnapshot.getKey());
                    // TODO: handle the post
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });
        //System.out.println(students);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }
        });
    }
}
