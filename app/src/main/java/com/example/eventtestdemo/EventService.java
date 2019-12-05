package com.example.eventtestdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class EventService extends Service {


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Service Started ", "****************");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        keepAlive();
        Log.e("Service Started ", "  2222 22222  22222 ");
        return START_STICKY;
    }

    private void keepAlive() {
        while (true) {
            try {
                Thread.sleep(5000);
                CommunicationService communicationService = new CommunicationService(this);
                communicationService.createService();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        onCreate();
    }
}
