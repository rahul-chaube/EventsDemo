package com.example.eventtestdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Date;

public class ServiceWakeUpReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Alarm is Working  "," "+new Date());

        Intent intent1=new Intent(context,EventService.class);
        context.stopService(intent);
        context.startService(intent1);
    }
}
