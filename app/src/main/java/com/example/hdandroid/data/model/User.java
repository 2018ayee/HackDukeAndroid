package com.example.hdandroid.data.model;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {

    public String firstName;
    public String lastName;
    public String pronouns;
    public String school;
    public String classYear;
    public String category;
    public String email;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String firstName, String lastName, String email, String pronouns, String school, String classYear, String category) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pronouns = pronouns;
        this.school = school;
        this.classYear = classYear;
        this.category = category;
    }

}