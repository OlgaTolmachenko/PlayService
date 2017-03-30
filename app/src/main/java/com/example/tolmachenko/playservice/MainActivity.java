package com.example.tolmachenko.playservice;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = (Button) findViewById(R.id.button_start);
        Button stop = (Button) findViewById(R.id.button_stop);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        ActivityManager activityManager = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(50);

        for (int i = 0; i < runningServices.size(); i++) {
            ActivityManager.RunningServiceInfo runningServiceInfo = runningServices.get(i);
            Log.d("SERVICES", "Process " + runningServiceInfo.process + " with component " + runningServiceInfo.service.getClassName());
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button_start:
                startService(new Intent(MainActivity.this, PlayService.class));
                break;
            case R.id.button_stop:
                stopService(new Intent(MainActivity.this, PlayService.class));
                break;
        }
    }
}
