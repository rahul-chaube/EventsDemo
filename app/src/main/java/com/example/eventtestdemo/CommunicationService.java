package com.example.eventtestdemo;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;

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

public class CommunicationService {

    Context context;
    Socket socket;
    String  mesaage;

    PrefManager prefManager ;


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



    public CommunicationService(Context context) {
        this.context = context;
        prefManager= new PrefManager(context);
        mesaage = getDate() + SEPERATOR + getTime() + SEPERATOR
                + prefManager.getMobileNUmber() + SEPERATOR + "" + SEPERATOR
                + Build.MODEL + SEPERATOR + 7083 + SEPERATOR + ""
                + SEPERATOR + 1 + SEPERATOR + "EMM"
                + SEPERATOR + "test" + SEPERATOR + "test"
                + SEPERATOR + "test";
    }

    public void createService()
    {
                Thread thread = new Thread(runnable);
                thread.start();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                PrefManager prefManager = new PrefManager(context);
                socket = new Socket();
                socket.connect(new InetSocketAddress(prefManager.getServerName(), 2225), 5000);
                socket.setSoTimeout(5000);

                Log.e("Socket is Connected ", "Test "+mesaage);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream()));
                String inMsg = in.readLine()
                        + System.getProperty("line.separator");

                Log.e("Debug 1", " " + inMsg);

                out.write(mesaage + "\n\r");

                out.flush();

                String msg2 = in.readLine();
                Log.e("Message 2 ", " " + msg2);


            } catch (SocketException e) {
                Log.e("Exception 1", " " + e.getMessage());

                e.printStackTrace();
            } catch (IOException e) {
                Log.e("Exception 2", " " + e.getMessage());

                e.printStackTrace();
            }
        }
    };

}
