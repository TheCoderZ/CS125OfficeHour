package com.example.cs125officehours;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.example.cs125officehours.LoginActivity;

import org.w3c.dom.Text;

import java.util.concurrent.TimeUnit;

public class StaffActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    public Button mButton;
    EditText mEdit;
    TextView mText;




    private static final String TAG =
            StaffActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mDatabase = FirebaseDatabase.getInstance().getReference("Student");
        mEdit = (EditText)findViewById(R.id.editText);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ta_interface);

    }

    private void checker() {
        //while ()
    }

    public void done(View view) {
        //Student[] students =
        //final Query students = mDatabase.snapshot;
        final Query students = mDatabase.orderByKey();
        //DataSnapshot something = students.
        System.out.println("this works");
        System.out.println(Staff.email);
        //System.out.println(students);
        mButton = (Button)findViewById(R.id.ta_done);
        students.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    //System.out.println(postSnapshot.getKey());
                    //TimeUnit.SECONDS.to;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        continue;
                    }
                }
                int count = 0;
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    count++;
                    if (count == 1) {
                        //String student = postSnapshot.getKey(); //students.limitToFirst(1).toString();
                        System.out.print(postSnapshot.getKey());
                        break;
                    }
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }



        });
        String nameToString= students.limitToFirst(1).toString();
        System.out.println(nameToString);
        //System.out.println(students);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }
        });
    }
}
