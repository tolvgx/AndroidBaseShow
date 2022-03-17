package com.show.app.defineview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2019/5/8
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 */
public class MyView extends View {

    private Paint mPaint;
    private boolean isAnimator;
    private float xxx;
    private float duration;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(1.5f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(200, 200);
        } else if(widthMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(200, heightSize);
        } else if(heightMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(widthSize, 200);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (!isAnimator){
            isAnimator = true;
            createAnimation();
        }
    }

    private void createAnimation() {
        ValueAnimator scaleAnim=ValueAnimator.ofFloat(0,1,0);
        scaleAnim.setInterpolator(new LinearInterpolator());
        scaleAnim.setDuration(3000);
        scaleAnim.setRepeatCount(-1);
        scaleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                xxx = (float) animation.getAnimatedValue();
                duration = animation.getAnimatedFraction();
                postInvalidate();
            }
        });
        scaleAnim.start();

//        ValueAnimator alphaAnim=ValueAnimator.ofInt(255, 0);
//        alphaAnim.setInterpolator(new LinearInterpolator());
//        alphaAnim.setDuration(1000);
//        alphaAnim.setRepeatCount(-1);
//        alphaAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                alpha = (int) animation.getAnimatedValue();
//                postInvalidate();
//            }
//        });
//        alphaAnim.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int height = getHeight();
        int width = getWidth();

        canvas.translate(0, height*xxx);
        mPaint.setAlpha(255);
        canvas.drawRect(0, 0, width, 10, mPaint);

        if (duration<0.5f){
            for (float i=0; i<10; i++){
                canvas.save();
                canvas.translate(0, -i/9.0f*(height*xxx/2f));
                float alpha = (1.0f-i/9.0f)*50.0f;
                mPaint.setAlpha((int) alpha);
                canvas.drawRect(0, 0, width, i/9.0f*(height*xxx/2f), mPaint);
                canvas.restore();
            }
        } else {
            for (float i=0; i<10; i++){
                canvas.save();
                canvas.translate(0, i/9.0f*(height*(1f-xxx)/2f));
                float alpha = (1.0f-i/9.0f)*50.0f;
                mPaint.setAlpha((int) alpha);
                canvas.drawRect(0, 0, width, i/9.0f*(height*xxx/2f), mPaint);
                canvas.restore();
            }
        }

    }
}
