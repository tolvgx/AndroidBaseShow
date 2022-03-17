package com.show.app.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2019/5/31
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 */
public class HandlerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();

                Handler handler1 = new Handler(Looper.myLooper()) {
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        Log.e("---", "handler1-" + msg.what);
                    }
                };
                Handler handler2 = new Handler(Looper.myLooper()) {
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        Log.e("---", "handler2-" + msg.what);
                    }
                };


                handler1.sendEmptyMessage(1);
                handler2.sendEmptyMessage(2);

                Looper.loop();
            }
        });
        t.start();
    }
}
