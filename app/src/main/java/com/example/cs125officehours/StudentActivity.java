package com.example.cs125officehours;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    public Button mButton;
    EditText mEdit;
    TextView mText;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_interface);
        mEdit = (EditText)findViewById(R.id.editText3);
        //mEdit.getText().toString();

    }

    public void send(View view) {
        mButton = (Button)findViewById(R.id.request_TA);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                name = mEdit.getText().toString();
                writeNewStudent(name, name, name);
                System.out.println("hello!");
                TextView textView = findViewById(R.id.textView2);
                textView.setText("Looking for a TA/CA...");
            }
        });
    }

    private void writeNewStudent(String userId, String name, String email) {
        Staff user = new Staff(name, email);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Student").child(userId).setValue(user);
    }
}
