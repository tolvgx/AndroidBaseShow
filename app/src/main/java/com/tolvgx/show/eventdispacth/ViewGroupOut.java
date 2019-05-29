package com.tolvgx.show.eventdispacth;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2019/4/27
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 */
public class ViewGroupOut extends RelativeLayout {


    public ViewGroupOut(Context context) {
        super(context);
    }

    public ViewGroupOut(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewGroupOut(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d(getClass().getSimpleName(),"onInterceptTouchEvent:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(getClass().getSimpleName(),"onInterceptTouchEvent:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(getClass().getSimpleName(),"onInterceptTouchEvent:ACTION_UP");
                break;
        }
        return super.onInterceptTouchEvent(ev);
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
