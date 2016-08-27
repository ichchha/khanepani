package com.khanepani.khanepanischedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class Tole3 extends AppCompatActivity {
    private ListView listView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tole1);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("TOLE-3");

        List<RoutineData> routineDataList=new ArrayList<>();

        listView= (ListView) findViewById(R.id.rlist);

        String[] day={"SUN","MON","TUE","WED","THU","FRI","SAT"};
        String[] startTime={"6pm","7pm","8pm","4am","5pm","5pm","6pm"};

        String[] endTime={"7pm","8pm","9pm","5am","6pm","6pm","7pm"};
        for(int i=0;i<day.length;i++){
            routineDataList.add(new RoutineData(day[i],startTime[i],endTime[i]));
        }
        listView.setAdapter(new DayListAdapter(this, routineDataList));
    }
}



