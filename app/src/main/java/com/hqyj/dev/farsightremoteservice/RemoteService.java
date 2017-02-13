package com.hqyj.dev.farsightremoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class RemoteService extends Service {
    private final String TAG = RemoteService.class.getSimpleName();
    private final String START = "Service Start";
    private final String STOP = "Service Stop";

    public RemoteService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, String.format("#######--> %s", START));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, String.format("#######--> %s", STOP));
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
