package com.example.servieprac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // service : foreground, background

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startMyService(View view) {

        i = new Intent(MainActivity.this,MyBackgroundService.class);
        startService(i);

    }

    public void stoptMyService(View view) {
        stopService(i);
    }
}