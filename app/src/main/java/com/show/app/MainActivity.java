package com.show.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.show.app.animator.AnimatorActivity;
import com.show.app.binder.NewProcessActivity;
import com.show.app.defineview.DefineActivity;
import com.show.app.eventdispacth.DispatchActivity;
import com.show.app.handler.HandlerActivity;
import com.show.app.jetpack.JetpackActivity;
import com.show.app.launchmode.Launch1Activity;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");
    }

    public void jumpLaunchMode(View view) {
        Intent intent = new Intent(MainActivity.this, Launch1Activity.class);
        startActivity(intent);
    }

    public void jumpDispatch(View view) {
        Intent intent = new Intent(MainActivity.this, DispatchActivity.class);
        startActivity(intent);
    }

    public void jumpDefineView(View view) {
        Intent intent = new Intent(MainActivity.this, DefineActivity.class);
        startActivity(intent);
    }

    public void jumpAnimator(View view) {
        Intent intent = new Intent(MainActivity.this, AnimatorActivity.class);
        startActivity(intent);
    }

    public void jumpBinder(View view) {
        Intent intent = new Intent(MainActivity.this, NewProcessActivity.class);
        startActivity(intent);
    }

    public void jumpHandler(View view) {
        Intent intent = new Intent(MainActivity.this, HandlerActivity.class);
        startActivity(intent);
    }

    public void jumpJetpack(View view) {
        Intent intent = new Intent(MainActivity.this, JetpackActivity.class);
        startActivity(intent);
    }
}
