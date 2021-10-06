package com.example.servieprac;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class MyBackgroundService extends Service {

    private static final String TAG = "myService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

//
//        Notification n = new Notification.Builder(getApplicationContext())
//                .setContentText("foreground srvice").setContentTitle("service title").build();

        createNotificationChannel();

        Notification notification = new  NotificationCompat.Builder(MyBackgroundService.this, String.valueOf(200))
                .setContentTitle("foreground srvice")
                .setContentText("service title")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .build();


        Log.d(TAG, "onStartCommand: ");

        startForeground(10,notification);

        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy: ");
    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    "200",
                    "Foreground Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }
    }

}