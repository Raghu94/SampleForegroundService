package claptopostapp.nymbus.com.sampleforegroundservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("FS", "onCreate");


        //is the service runnning now?

        // I'm starting the service

        // 1st time
        Intent myService = new Intent(this, SampleService.class).setAction("PLAY");
        startService(myService);




        AlarmManager myAlarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);




        Intent alarmIntent_min = new Intent(this, SampleService.class);
        alarmIntent_min.setAction("PAUSE");

        int interval = 60 * 1000;
        PendingIntent alarmPendingIntent_min = PendingIntent.getService(this, 668, alarmIntent_min, 0);
        Intent alarmInfoIntent = new Intent(this, MainActivity.class);
        PendingIntent alarmInfoPendingIntent = PendingIntent.getActivity(this, 777,alarmInfoIntent,0);
        AlarmManager.AlarmClockInfo alarmClockInfo = new AlarmManager.AlarmClockInfo(System.currentTimeMillis()+interval, alarmInfoPendingIntent);
        myAlarmManager.setAlarmClock(alarmClockInfo, alarmPendingIntent_min);


    }
}
