package com.tolvgx.show.jetpack;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import com.tolvgx.show.R;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2019/5/28
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 */
public class JetpackActivity extends AppCompatActivity {

    public static String TAG = "JetpackActivity------";

    private TestViewModel viewModel;
    private TextView text;

    /**
     * 1.不设置Activity的Android:configChanges时，切屏会重新调用各个生命周期
     * 2.设置Activity的android:configChanges=”orientation|keyboardHidden|screenSize”时，切屏不会重新调用各个生命周期，只会执行onConfigurationChanged方法。
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jetpack);

        text = findViewById(R.id.text);
        viewModel = ViewModelProviders.of(this).get(TestViewModel.class);

        viewModel.getLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                text.setText(s);
            }
        });

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);

                    viewModel.getLiveData().postValue("改变啦");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        Log.e(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e(TAG, "onNewIntent");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState");
        outState.putString("RoadChange", "1111");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String roadChange = savedInstanceState.getString("RoadChange");
        Log.e(TAG, "onRestoreInstanceState: "+roadChange);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e(TAG, "onConfigurationChanged");
    }
}
