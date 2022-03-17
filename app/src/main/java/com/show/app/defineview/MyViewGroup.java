package com.show.app.defineview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2019/5/8
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 */
public class MyViewGroup extends ViewGroup {

    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
