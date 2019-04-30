package com.example.cs125officehours;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.example.cs125officehours.Staff;
import java.util.Arrays;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private DatabaseReference mDatabase;
    public Button mButton;
    EditText emailInput;
    EditText passwordInput;
    TextView mText;
    String email;
    String password;

    private FirebaseAuth mAuth;
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    // Choose authentication providers
    /*List<AuthUI.IdpConfig> providers = Arrays.asList(
            new AuthUI.IdpConfig.EmailBuilder().build(),
            new AuthUI.IdpConfig.PhoneBuilder().build(),
            new AuthUI.IdpConfig.GoogleBuilder().build(),
            new AuthUI.IdpConfig.FacebookBuilder().build(),
            new AuthUI.IdpConfig.TwitterBuilder().build());

    // Create and launch sign-in intent
    startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
    RC_SIGN_IN);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_login);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        emailInput = (EditText)findViewById(R.id.editText);

        passwordInput = findViewById(R.id.editText2);
    }

    public void signIn(View view) {
        mButton = (Button)findViewById(R.id.signIn);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                password = passwordInput.getText().toString();
                writeNewUser(email, email);
                //openStaff(view);
                //writeNewStudent(name, name, name);
                if (mAuth.signInWithEmailAndPassword(email, password).isSuccessful()) {
                    //Intent intent = new Intent(this, StaffActivity.class);
                    //startActivity(intent);
                }
            }
        });
    }

    public void onClick(View view) {

    }
    @Override



    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        //FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    /*public void openStaff(View view) {
        Log.d(TAG, "Button clicked!");
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }*/

    /*private boolean signIn(String email, String password) {
        //Log.d(LOG_TAG, "signIn:" + email);

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            return true;
                            updateUI(user);

                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(LOG_TAG, "signInWithEmail:failure", task.getException());
                            //Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                    //Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // [START_EXCLUDE]
                        //hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
        // [END sign_in_with_email]
    }

    private void updateUI(FirebaseUser user) {
        //hideProgressDialog();
        if (user != null) {
            *//*mStatusTextView.setText(getString(R.string.emailpassword_status_fmt,
                    user.getEmail(), user.isEmailVerified()));
            ..mDetailTextView.setText(getString(R.string.firebase_status_fmt, user.getUid()));*//*

            findViewById(R.id.signIn).setVisibility(View.GONE);
            findViewById(R.id.editText).setVisibility(View.GONE);
            findViewById(R.id.editText2).setVisibility(View.VISIBLE);

            //findViewById(R.id.verifyEmailButton).setEnabled(!user.isEmailVerified());
        } else {
            *//*mStatusTextView.setText(R.string.signed_out);
            mDetailTextView.setText(null);

            findViewById(R.id.emailPasswordButtons).setVisibility(View.VISIBLE);
            findViewById(R.id.emailPasswordFields).setVisibility(View.VISIBLE);
            findViewById(R.id.signedInButtons).setVisibility(View.GONE);*//*
        }
    }*/

    public void openStaff(View view) {
        Intent intent = new Intent(this, StaffActivity.class);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        email = emailInput.getText().toString();
        System.out.println(email);
        writeNewUser(email, email);
        startActivity(intent);
        //writeNewUser("zfaizal2", "Zayyan", "zfaizal2@illinois.edu");
    }

    private void writeNewUser(String userId, String name) {
        Staff user = new Staff(name, email);

        mDatabase.child("Staff").child(userId).setValue(user);
    }
}
