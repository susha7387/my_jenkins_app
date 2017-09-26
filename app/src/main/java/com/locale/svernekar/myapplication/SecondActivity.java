package com.locale.svernekar.myapplication;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by svernekar003 on 10/09/17.
 */

public class SecondActivity extends AppCompatActivity {

    Thread thread;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(getApplicationContext(), MyCustomService.class));

       /* bindService(new Intent(getApplicationContext(), MyCustomService.class), new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.d("SecondActivity", "onServiceConnected --->");
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Log.d("SecondActivity", "onServiceDisconnected --->");
            }
        }, Service.BIND_AUTO_CREATE);*/
        getSupportFragmentManager().beginTransaction().replace(R.id.main_ll, new CursorLoaderListFragment(), "").commit();
        requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SecondActivity", "onResume --->");
        Toast.makeText(SecondActivity.this, " " + count++
                , Toast.LENGTH_SHORT).show();


        new AsyncTask<Void, Void, Void>() {


            @Override
            protected Void doInBackground(Void... voids) {
                while (true && count < 4) {
                    try {
                        count++;
                        Thread.sleep(2000);
                        Log.d("Thread", "sleep -> " + count);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(MainActivity.this, Thread.currentThread().getName()
                        , Toast.LENGTH_SHORT).show();
            }
        }.execute();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_ll, new CursorLoaderListFragment(), "").commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SecondActivity", "onPause --->");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SecondActivity", "onStart --->");
    }

}
