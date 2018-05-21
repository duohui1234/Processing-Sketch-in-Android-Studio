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
    int cnt =40;
    float degree = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FrameLayout frameLayout = findViewById(R.id.container);
        sketch = new Sketch();
        PFragment fragment = new PFragment(sketch);
        fragment.setView(frameLayout, this);

        timerTask = new TimerTask() {
            @Override
            public void run() {
                sketch.setSpeed(cnt);
                cnt++;

            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask,0,3000);




    }



}
