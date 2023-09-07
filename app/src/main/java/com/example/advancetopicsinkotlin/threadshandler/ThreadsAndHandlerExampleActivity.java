package com.example.advancetopicsinkotlin.threadshandler;


import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;

import com.example.advancetopicsinkotlin.R;

//To see the behaviour you should run the app the entire application once on emulator/device
class ThreadsAndHandlerExampleActivity extends ComponentActivity {

    private static String TAG = "ThreadsAndHandlerExampleActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_thread_example);

        findViewById(R.id.start).setOnClickListener(v -> onclickButton(v));
    }

    private void onclickButton(View v) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //Shows toast without any problem
                Log.i(TAG, "Thread Name 2 : " + Thread.currentThread().getName());//Background thread/ new thread
                Toast.makeText(ThreadsAndHandlerExampleActivity.this, getResources().getText(R.string.app_name), Toast.LENGTH_SHORT).show();

                synchronized (this) {
                    try {
                        wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ThreadsAndHandlerExampleActivity.this, "Download finished....", Toast.LENGTH_SHORT).show();//It will crash due to coding
                        //no getting executed in main thread, so how to achieve this use handler
                        Log.i("Activity", "Run download finished");
                    }
                });


                Toast.makeText(ThreadsAndHandlerExampleActivity.this, "Download finished....", Toast.LENGTH_SHORT).show();//It will crash due to coding
                //no getting executed in main thread, so how to achieve this use handler
                Log.i("Activity", "Run download finished");
            }
        };

        //runnable.run();
        Log.i(TAG, "Thread Name 1 : " + Thread.currentThread().getName());//UI thread
        Thread thread = new Thread(runnable);
        thread.start();
        thread.run();//It run in same Thread Name 1
    }


}