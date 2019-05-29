package com.tolvgx.show.animator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;

import com.tolvgx.show.R;

public class AnimatorActivity extends AppCompatActivity {

    private GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);

        //ObjectAnimator ValueAnimator
        Button btn = findViewById(R.id.btn);
        AnimatorButton animatorBtn = findViewById(R.id.animatorBtn);

        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 3);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
//                Log.e("------------------", animation.getCurrentPlayTime()+"");
            }
        });
        valueAnimator.start();

        float translationX = btn.getTranslationX();
        ObjectAnimator animator = ObjectAnimator.ofFloat(btn, "translationX", translationX, 1500, -100, translationX);
        animator.setDuration(5000);
        animator.start();

        ObjectAnimator temp = ObjectAnimator.ofFloat(animatorBtn, "aaa", 0, 500);
        temp.setDuration(5000);
        temp.start();


        //GestureDetector
        findViewById(R.id.scroll).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                boolean consume = detector.onTouchEvent(event);
                return consume;
            }
        });
        detector = new GestureDetector(new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                Log.e("----", "onDown");
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                Log.e("----", "onShowPress");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Log.e("----", "onSingleTapUp");
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Log.e("----", "onScroll");
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                Log.e("----", "onLongPress");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Log.e("----", "onFling");
                return false;
            }
        });
    }
}
