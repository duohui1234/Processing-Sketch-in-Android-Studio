package com.duohui.example.android_processing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import processing.android.CompatUtils;
import processing.android.PFragment;
import processing.core.PApplet;

public class MainActivity extends AppCompatActivity {

    private Sketch sketch;
    TimerTask timerTask,timerTask2;
    int cnt = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FrameLayout frameLayout = findViewById(R.id.container);
        sketch = new Sketch();
        PFragment fragment = new PFragment(sketch);
        fragment.setView(frameLayout, this);






        final int speed[] = new int[]{50,70,120,150,130,160,190,160,80,100,110,140,130,150,100,130,150};


       timerTask = new TimerTask() {

           int i =0;

           @Override
            public void run() {
                sketch.setSpeed(speed[i]);

                 i++;
                 if(i == speed.length) timerTask.cancel();
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask,0,1000);





    }



}
