package com.example.eventtestdemo;



import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class OperationActivity extends AppCompatActivity {
    Button buttonSendEvents;
    String mesaage;
    Socket socket;
    private static final String SEPERATOR = ";";

    public static String getDate() {
        SimpleDateFormat dateFormate = new SimpleDateFormat("yyyyMMdd");
        String date = dateFormate.format(new Date());
        return date;
    }

    public static String getDateSimpleFormate() {
        SimpleDateFormat dateFormate = new SimpleDateFormat("MM/dd/yyyy");
        String date = dateFormate.format(new Date());
        return date;
    }

    public static String getTime() {
        SimpleDateFormat dateFormate = new SimpleDateFormat("HH:mm:ss");
        String time = dateFormate.format(new Date());
        return time;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);
        buttonSendEvents = (Button) findViewById(R.id.buttonSendEvents);

        PrefManager prefManager = new PrefManager(this);



        buttonSendEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(OperationActivity.this,EventService.class);
                startService(intent);
//                CommunicationService communicationService = new CommunicationService(OperationActivity.this);
//                communicationService.createService();
            }
        });

    }
}
