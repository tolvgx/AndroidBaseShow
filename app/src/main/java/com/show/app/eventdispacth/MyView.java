package com.show.app.eventdispacth;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2019/4/27
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 */
public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
        boolean flag = false;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d(getClass().getSimpleName(),"onTouchEvent:ACTION_DOWN");
                flag = true;
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(getClass().getSimpleName(),"onTouchEvent:ACTION_MOVE");
                flag = false;
                break;
            case MotionEvent.ACTION_UP:
                Log.d(getClass().getSimpleName(),"onTouchEvent:ACTION_UP");
                flag = true;
                break;
        }
//        return flag;
        return super.onTouchEvent(event);
    }
}
