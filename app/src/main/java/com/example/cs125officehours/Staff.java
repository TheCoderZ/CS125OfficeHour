package com.example.cs125officehours;

public class Staff {
    public String username;
    public static String email;
    public boolean match;

    public Staff() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Staff(String username, String email) {
        this.username = username;
        this.email = email;
        this.match = false;
    }
}
