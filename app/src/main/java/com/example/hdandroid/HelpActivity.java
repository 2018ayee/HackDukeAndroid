package com.example.hdandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.hdandroid.R;

import org.w3c.dom.Text;


public class HelpActivity extends AppCompatActivity {
    String number = "573-642-2800";
    Button callDukePolice;
    Button backButton;
    Button vickisNumber;
    Button samsNumber;
    Button slackLink;
    Button devpostLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        callDukePolice = findViewById(R.id.dukePoliceNumber);
        backButton = findViewById(R.id.backButton);
        vickisNumber = findViewById(R.id.vickisNumber);
        samsNumber = findViewById(R.id.samsNumber);
        slackLink = findViewById(R.id.slackLink);
        devpostLink = findViewById(R.id.devpostLink);

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Clicked", "backButton clicked");
                toMain(v);
            }
        });

        callDukePolice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                String p = "tel:9196842444";
                i.setData(Uri.parse(p));
                startActivity(i);
            }
        });

        vickisNumber.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                String p = "tel:9089388667";
                i.setData(Uri.parse(p));
                startActivity(i);
            }
        });

        samsNumber.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                String p = "tel:4104282378";
                i.setData(Uri.parse(p));
                startActivity(i);
            }
        });

        slackLink.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://tinyurl.com/JoinHDSlack/"));
                startActivity(intent);
            }
        });

        devpostLink.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://hackduke-2019.devpost.com/"));
                startActivity(intent);
            }
        });

    }

    public void toMain(View view) {
        Log.d("Clicked", "backButton clicked");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}

