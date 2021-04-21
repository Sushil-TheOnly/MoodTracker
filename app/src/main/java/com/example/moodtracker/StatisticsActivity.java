package com.example.moodtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class StatisticsActivity extends AppCompatActivity {

    private Spinner moodSpinner;
    private String selectedMood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        setTitle("Statistics");

        moodSpinner = findViewById(R.id.spinner_sleep_stats_mood);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.moods, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        moodSpinner.setAdapter(adapter);

        moodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedMood = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void launchSleepStatsActivity(View view) {
        if (selectedMood.equals("All")) {
            launchSleepStatsAllActivity();
        }
        else {
            launchSleepStatsMoodActivity();
        }
    }

    public void launchMoodCountActivity(View view) {
        startActivity(new Intent(getApplicationContext(), MoodCountActivity.class));
    }

    public void launchMoodVariationActivity(View view) {
        startActivity(new Intent(getApplicationContext(), MoodVariationActivity.class));
    }

    private void launchSleepStatsAllActivity() {
        startActivity(new Intent(getApplicationContext(), SleepStatsAllActivity.class));
    }

    private void launchSleepStatsMoodActivity() {
        Intent intent = new Intent(getApplicationContext(), SleepStatsMoodActivity.class);
        intent.putExtra("Mood", selectedMood);
        startActivity(intent);
    }
}