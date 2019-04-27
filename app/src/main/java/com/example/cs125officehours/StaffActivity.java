package com.example.cs125officehours;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class StaffActivity extends AppCompatActivity {
    private static final String LOG_TAG =
            StaffActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ta_interface);
    }

    public void openStaff(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, StaffActivity.class);
        startActivity(intent);
    }
}
