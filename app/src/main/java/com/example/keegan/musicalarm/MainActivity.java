package com.example.keegan.musicalarm;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextClock alarm = (TextClock) findViewById(R.id.alarmClock);
        Button setAlarm = (Button) findViewById(R.id.setAlarmBtn);
        Button viewAlarms = (Button) findViewById(R.id.viewAlarms);

        setAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view);
            }
        });

        viewAlarms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open to activity with all alarms listed and able to edit whether they are on or not
            }
        });

    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
}
