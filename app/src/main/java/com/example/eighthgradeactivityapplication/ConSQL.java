package com.example.eighthgradeactivityapplication;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConSQL {

    Connection con;
    @SuppressLint("NewApi")

    public Connection conclass() {

        String ip ="myschoolcashapp.c3gv3mh94fd4.us-east-2.rds.amazonaws.com:3306/student", username="admin", password="Ryleigh081919!@#";

        StrictMode.ThreadPolicy a = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(a);
        String ConnectionURL = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(ip,username,password);
        }
        catch (Exception e)
        {
            Log.e("Error is ", e.getMessage());
        }
        return con;

    }

}
