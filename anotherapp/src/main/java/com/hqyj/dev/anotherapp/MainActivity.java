package com.hqyj.dev.anotherapp;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

    private Intent serviceIntent;
    private ComponentName componentName;
    private final String TAG = MainActivity.class.getSimpleName();
    private final String DESTROY = "Destroy";
    private final String START = "start service";
    private final String STOP = "stop service";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_start).setOnClickListener(this);
        findViewById(R.id.btn_stop).setOnClickListener(this);
        serviceIntent = new Intent();
        componentName = new ComponentName("com.hqyj.dev.farsightremoteservice","com.hqyj.dev.farsightremoteservice.RemoteService");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                serviceIntent.setComponent(componentName);
                Log.e(TAG, String.format("Another app %s", START));
                startService(serviceIntent);
//                startActivity(serviceIntent);
                Log.e(TAG, String.format("Another app %s", START));
                break;
            case R.id.btn_stop:
                serviceIntent.setComponent(componentName);
                stopService(serviceIntent);
                Log.e(TAG, String.format("Another app %s", STOP));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, String.format("Another app %s", DESTROY));
    }
}
