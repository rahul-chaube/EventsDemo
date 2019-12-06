package com.example.eventtestdemo;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static final String PREF_NAME="DebugTool";
    public static final String SERBVER_NAME="serverName";
    public static final String MOBILE_NUMBER="mobile_number";
    public static final String IS_SERVICE_STARTED="isServiceStated";

    public PrefManager(Context context) {
        this.context = context;
        sharedPreferences=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    public void setServerName(String serverName)
    {
        editor.putString(SERBVER_NAME,serverName).apply();
    }
    public String getServerName()
    {
        return sharedPreferences.getString(SERBVER_NAME,"");
    }

    public void setMobileNumber(String mobileNumber)
    {
        editor.putString(MOBILE_NUMBER,mobileNumber).apply();
    }
    public String getMobileNUmber()
    {
        return sharedPreferences.getString(MOBILE_NUMBER,"");
    }


    public void  setServiceStatrted(boolean status)
    {
        editor.putBoolean(IS_SERVICE_STARTED,status).apply();
    }

    public boolean getServiceIstarted()
    {
       return sharedPreferences.getBoolean(IS_SERVICE_STARTED,false);
    }
}
