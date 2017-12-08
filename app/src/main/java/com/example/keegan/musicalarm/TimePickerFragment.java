package com.example.keegan.musicalarm;


import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.app.TimePickerDialog;
import java.util.Calendar;
import android.os.Bundle;
import android.app.Fragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimePickerFragment extends DialogFragment
                                    implements TimePickerDialog.OnTimeSetListener{


    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hour, int minute) {
        String AMPM;
        if(hour >= 12)
            AMPM = "PM";
        else
            AMPM = "AM";
        Toast.makeText(this.getActivity(), (hour%12) + ":" + minute + " " + AMPM, Toast.LENGTH_LONG).show();

        alarmMgr = (AlarmManager)getContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getContext(), AlarmReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(getContext(), 0, intent, 0);

// Set the alarm to start at 8:30 a.m.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);

        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, alarmIntent);
    }

}
