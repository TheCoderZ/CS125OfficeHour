package com.example.cs125officehours;

public class Student {
    public String username;
    public String email;
    public boolean match;
    public String key;

    public Student() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Student(String username, String email) {
        this.username = username;
        this.email = email;
        match = false;
    }
}
