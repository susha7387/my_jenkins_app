package com.locale.svernekar.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class MyCustomService extends Service {
    public MyCustomService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyCustomService", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);

    }
}
