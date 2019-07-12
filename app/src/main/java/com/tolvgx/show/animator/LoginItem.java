package com.tolvgx.show.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.RelativeLayout;
import com.tolvgx.show.R;

public class LoginItem extends RelativeLayout {

    private View vHead;
    private View vHeart;
    private View vLight;

    ObjectAnimator headAnimator;
    ObjectAnimator heartAnimator;
    ObjectAnimator lightAnimator;

    public LoginItem(Context context) {
        super(context);
        initView();
    }

    public LoginItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LoginItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.animator_login, this, true);
        vHead = findViewById(R.id.iv_head);
        vHeart = findViewById(R.id.iv_heart);
        vLight = findViewById(R.id.iv_light);

        initAnimatorSet();
    }

    private void initAnimatorSet() {
        Keyframe headKF1 = Keyframe.ofFloat(0, 1);
        Keyframe headKF2 = Keyframe.ofFloat(0.3f,0);
        Keyframe headKF3 = Keyframe.ofFloat(1,1);
        PropertyValuesHolder headScaleX = PropertyValuesHolder.ofKeyframe("scaleX", headKF1,headKF2,headKF3);
        PropertyValuesHolder headScaleY = PropertyValuesHolder.ofKeyframe("scaleY", headKF1,headKF2,headKF3);
        headAnimator = ObjectAnimator.ofPropertyValuesHolder(vHead, headScaleX, headScaleY);
        headAnimator.setDuration(1000);

        Keyframe heartKF1 = Keyframe.ofFloat(0, 0);
        Keyframe heartKF2 = Keyframe.ofFloat(1, 1);
        heartKF2.setInterpolator(new BounceInterpolator());
        PropertyValuesHolder heartScaleX = PropertyValuesHolder.ofKeyframe("scaleX", heartKF1, heartKF2);
        PropertyValuesHolder heartScaleY = PropertyValuesHolder.ofKeyframe("scaleY", heartKF1, heartKF2);
        heartAnimator = ObjectAnimator.ofPropertyValuesHolder(vHeart, heartScaleX, heartScaleY);
        heartAnimator.setStartDelay(300);
        heartAnimator.setDuration(500);
        heartAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                vHeart.setVisibility(VISIBLE);
            }
            @Override
            public void onAnimationEnd(Animator animation) { }
            @Override
            public void onAnimationCancel(Animator animation) { }
            @Override
            public void onAnimationRepeat(Animator animation) { }
        });
    }

    public void startAnimator(){
        headAnimator.start();
        heartAnimator.start();
    }
}
