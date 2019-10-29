package com.example.hdandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    TextView countdown;
    TextView alreadyCheckedIn;
    Button checkInButton;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countdown = findViewById(R.id.countdown);
        alreadyCheckedIn = findViewById(R.id.textView6);
        checkInButton = findViewById(R.id.checkin);
        BottomNavigationView navigation = findViewById(R.id.nav_view);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_help:
                        Intent a = new Intent(MainActivity.this,HelpActivity.class);
                        startActivity(a);
                        break;
                    case R.id.navigation_dashboard:
                        Intent b = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(b);
                        break;
                    case R.id.navigation_map:
                        Intent c = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(c);
                        break;
                }
                return false;
            }
        });

        checkInButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Clicked", "checkin clicked");
                toCheckIn(v);
            }
        });

        SharedPreferences settings = getApplicationContext().getSharedPreferences("settings", 0);
        String isChecked = settings.getString("is_checked_in", "false");
        if(isChecked.equals("true")) {
            checkInButton.setVisibility(View.GONE);
            alreadyCheckedIn.setVisibility(View.VISIBLE);
        }

        bottomNavigationView = findViewById(R.id.nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d("Clicked", "bottomNavClicked");
                if (item.getItemId() == R.id.navigation_schedule) {
                    // on schedule clicked
                    Log.d("Clicked", "schedule clicked");
                    Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
                    startActivity(intent);
                    return true;
                }
                else if( item.getItemId() == R.id.navigation_map) {
                    Log.d("Clicked", "map clicked");
                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                    startActivity(intent);
                    return true;
                }
                else {
                    Log.d("Clicked", "help clicked");
                    Intent intent = new Intent(MainActivity.this, HelpActivity.class);
                    startActivity(intent);
                    return true;
                }
            }
        });


    }

    public Date StringToDate(String s){

        Date result = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result  = dateFormat.parse(s);
        }

        catch(ParseException e){
            e.printStackTrace();

        }
        return result;
    }

    public void toCheckIn(View view) {
        Log.d("Clicked", "checkin clicked");
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * Returns a formatted string containing the amount of time (days, hours,
     * minutes, seconds) between the current time and the specified future date.
     *
     * @param context
     * @param futureDate
     * @return
     */
    public static CharSequence getCountdownText(Context context, Date futureDate) {
        StringBuilder countdownText = new StringBuilder();

        // Calculate the time between now and the future date.
        long timeRemaining = futureDate.getTime() - new Date().getTime();

        // If there is no time between (ie. the date is now or in the past), do nothing
        if (timeRemaining > 0) {
            Resources resources = context.getResources();

            // Calculate the days/hours/minutes/seconds within the time difference.
            //
            // It's important to subtract the value from the total time remaining after each is calculated.
            // For example, if we didn't do this and the time was 25 hours from now,
            // we would get `1 day, 25 hours`.
            int days = (int) TimeUnit.MILLISECONDS.toDays(timeRemaining);
            timeRemaining -= TimeUnit.DAYS.toMillis(days);
            int hours = (int) TimeUnit.MILLISECONDS.toHours(timeRemaining);
            timeRemaining -= TimeUnit.HOURS.toMillis(hours);
            int minutes = (int) TimeUnit.MILLISECONDS.toMinutes(timeRemaining);
            timeRemaining -= TimeUnit.MINUTES.toMillis(minutes);
            int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(timeRemaining);

            // For each time unit, add the quantity string to the output, with a space.
            if (days > 0) {
                countdownText.append(resources.getQuantityString(R.plurals.days, days, days));
                countdownText.append(" ");
            }
            if (days > 0 || hours > 0) {
                countdownText.append(resources.getQuantityString(R.plurals.hours, hours, hours));
                countdownText.append(" ");
            }
            if (days > 0 || hours > 0 || minutes > 0) {
                countdownText.append(resources.getQuantityString(R.plurals.minutes, minutes, minutes));
                countdownText.append(" ");
            }
            if (days > 0 || hours > 0 || minutes > 0 || seconds > 0) {
                countdownText.append(resources.getQuantityString(R.plurals.seconds, seconds, seconds));
                countdownText.append(" ");
            }
        }

        return countdownText.toString();
    }



    /**
     * The time (in ms) interval to update the countdown TextView.
     */
    private static final int COUNTDOWN_UPDATE_INTERVAL = 500;

    private Handler countdownHandler;

    /**
     * Stops the  countdown timer.
     */
    private void stopCountdown() {
        if (countdownHandler != null) {
            countdownHandler.removeCallbacks(updateCountdown);
            countdownHandler = null;
        }
    }

    /**
     * (Optionally stops) and starts the countdown timer.
     */
    private void startCountdown() {
        stopCountdown();

        countdownHandler = new Handler();
        updateCountdown.run();
    }

    /**
     * Updates the countdown.
     */
    private Runnable updateCountdown = new Runnable() {
        @Override
        public void run() {
            try {
                Date futureDate = StringToDate("2019-11-02 9:00:00");
                countdown.setText(getCountdownText(countdown.getContext(), futureDate));
            } finally {
                countdownHandler.postDelayed(updateCountdown, COUNTDOWN_UPDATE_INTERVAL);
            }
        }
    };

    @Override
    public void onStart() {
        super.onStart();
        startCountdown();
    }

    @Override
    public void onStop() {
        super.onStop();
        stopCountdown();
    }

}
