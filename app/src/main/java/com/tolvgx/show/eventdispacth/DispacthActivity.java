package com.tolvgx.show.eventdispacth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tolvgx.show.R;

public class DispacthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispacth);

        View myView = findViewById(R.id.myView);
        RelativeLayout inVG = findViewById(R.id.inVG);
        RelativeLayout outVG = findViewById(R.id.outVG);
        Button btn = findViewById(R.id.btn);

        myView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("myView--------", "onTouch");
                return false;
            }
        });

        inVG.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("inVG--------", "onTouch");
                return false;
            }
        });

        outVG.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("outVG--------", "onTouch");
                return false;
            }
        });

        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("btn--------", "onTouch");
                return false;
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d(getClass().getSimpleName(),"dispatchTouchEvent:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(getClass().getSimpleName(),"dispatchTouchEvent:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(getClass().getSimpleName(),"dispatchTouchEvent:ACTION_UP");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d(getClass().getSimpleName(),"onTouchEvent:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(getClass().getSimpleName(),"onTouchEvent:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(getClass().getSimpleName(),"onTouchEvent:ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }
}
