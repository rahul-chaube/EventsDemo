package com.example.eventtestdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class Utility {
    public static final int SERVICE_CHECKING=10001;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    public void setServiceCheckAlarm(Context context)
    {
        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent alarmIntent = new Intent(context, ServiceWakeUpReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(context, SERVICE_CHECKING, alarmIntent, 0);

        startAlarm();
    }

    private void startAlarm() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 2*60*1000, pendingIntent);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 2*60*1000,pendingIntent);
        } else {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 2*60*1000, pendingIntent);
        }


    }
}
