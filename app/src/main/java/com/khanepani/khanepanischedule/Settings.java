package com.khanepani.khanepanischedule;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends AppCompatActivity {
    Toolbar toolbar;
    TextView notime;
    AlertDialog.Builder dialogbuilder;

    public void notifyTimeDialog(){
        dialogbuilder=new AlertDialog.Builder(this);
        final String strSize[]={"5 minutes before","10 minutes before","15 minutes before","20 minutes before","30 minutes before","45 minutes before","60 minutes before"};

        dialogbuilder.setTitle("Notification Time");
        dialogbuilder.setSingleChoiceItems(strSize, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                SharedPreferences sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                switch (which){
                    case 0:
                        editor.putInt("notifications",5);
                        break;
                    case 1:
                        editor.putInt("notifications",10);
                        break;
                    case 2:
                        editor.putInt("notifications",15);
                        break;
                    case 3:
                        editor.putInt("notifications",20);
                        break;
                    case 4:
                        editor.putInt("notifications",30);
                        break;
                    case 5:
                        editor.putInt("notifications",45);
                        break;
                    case 6:
                        editor.putInt("notifications",60);
                        break;
                }

                editor.apply(); //now it stores value or editor.commit()


//                Toast.makeText(Settings.this, strSize[which], Toast.LENGTH_SHORT).show();
            }

        });

      AlertDialog dialogNotifyTime=dialogbuilder.create();
        dialogNotifyTime.show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        toolbar=(Toolbar) findViewById(R.id.toolbar);
        notime=(TextView) findViewById(R.id.notime);

        notime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyTimeDialog();

            }
        });


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Settings");


    }
}
