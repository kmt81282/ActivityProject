package com.example.eighthgradeactivityapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    Connection connection;
    private Student currentStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton ibSave = findViewById(R.id.saveButton);
        ibSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView Total = (TextView) findViewById(R.id.textNumCalAmtToPay);
                    ConSQL c = new ConSQL();
                    connection = c.conclass();

                    try {
                        if (c != null) {
                            String sqlStatement = "Select * from student.Student";
                            Statement smt = connection.createStatement();
                            ResultSet set = smt.executeQuery(sqlStatement);
                            while (set.next()) {
                                Total.setText(set.getString(3));


                            }
                            connection.close();
                        }
                    } catch (Exception e) {
                        Log.e("Error: ", String.valueOf(e));
                    }
                }


            });
        }
 }

