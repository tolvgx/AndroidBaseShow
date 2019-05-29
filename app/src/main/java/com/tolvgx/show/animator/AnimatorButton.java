package com.tolvgx.show.animator;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2019/5/7
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 */
public class AnimatorButton extends AppCompatButton {

    private boolean flag;

    private VelocityTracker tracker;

    public AnimatorButton(Context context) {
        super(context);
    }

    public AnimatorButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AnimatorButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    public float getAaa() {
//        return aaa;
//    }

    public void setAaa(float aaa) {
//        Log.e("----", aaa+"");
        if (flag){
            setTextColor(Color.parseColor("#000000"));
            setText("11      ");
        } else {
            setTextColor(Color.parseColor("#ff0000"));
            setText("      22");
        }

        flag = !flag;
        setAlpha(aaa/500);
//        setTranslationY(aaa);
        getLayoutParams().height = (int) aaa;
        requestLayout();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (tracker == null){
            tracker = VelocityTracker.obtain();
        }
        tracker.addMovement(event);

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                tracker.computeCurrentVelocity(1000);
                int xVelocity = (int) tracker.getYVelocity();
                int yVelocity = (int) tracker.getXVelocity();

//                Log.e("----", xVelocity+", "+yVelocity);
                break;
            case MotionEvent.ACTION_UP:
                tracker.clear();
                tracker.recycle();
                tracker = null;
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void offsetLeftAndRight(int offset) {
        super.offsetLeftAndRight(offset);
    }
}
