package com.example.hdandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.hdandroid.data.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void checkIn(View view) {
        EditText firstName = (EditText) findViewById(R.id.firstName);
        EditText lastName = (EditText) findViewById(R.id.lastName);
        EditText pronouns = (EditText) findViewById(R.id.pronouns);
        EditText school = (EditText) findViewById(R.id.school);
        EditText classYear = (EditText) findViewById(R.id.classfield);
        EditText category = (EditText) findViewById(R.id.category);
        EditText email = (EditText) findViewById(R.id.email);

        User user = new User(firstName.getText().toString(), lastName.getText().toString(), pronouns.getText().toString(),
                school.getText().toString(), classYear.getText().toString(), category.getText().toString());
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("hd-code-for-good").child(email.getText().toString()).setValue(user);
        startActivity(new Intent(LoginActivity.this, CheckInSuccessActivity.class));
    }
}
