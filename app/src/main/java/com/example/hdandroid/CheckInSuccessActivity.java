package com.example.hdandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CheckInSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_success);
    }

    public void backToMain(View view) {
        startActivity(new Intent(CheckInSuccessActivity.this, MainActivity.class));
    }
}
