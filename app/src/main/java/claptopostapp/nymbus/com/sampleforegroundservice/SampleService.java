package claptopostapp.nymbus.com.sampleforegroundservice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by RaghuTeja on 3/6/18.
 */

public class SampleService extends Service {



    //each time when you send an action to the service. Or call startService!
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("FS", "onStartCommmand");
        if(intent.getAction()!=null) {
            if(intent.getAction().equals("PLAY")) {
                Log.d("FS", "onStartCommand: PLAY");
                // write code to play music.
            }
            else if(intent.getAction().equals("PAUSE")) {
                //write code to pause music
                Log.d("FS", "onStartCommand: PAUSING MUSIC AFTER 1 MINUTE");

            }
        }
        return super.onStartCommand(intent, flags, startId);


    }

    // is only called once! The first time service starts!
    @Override
    public void onCreate() {
        Log.d("FS", "onCreate");
        showSurveyNotif();
        super.onCreate();
    }


    @Override
    public void onDestroy() {
        Log.d("FS", "onDestroy");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void showSurveyNotif() {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, "666");
        notificationBuilder.setAutoCancel(false)
                .setWhen(System.currentTimeMillis())
                .setContentTitle("UPMC Dash Survey")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentText("Sample Foreground")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setGroup("Survey")
                .setContentInfo("info");
        // important line
        startForeground(1,notificationBuilder.build());


    }

}
