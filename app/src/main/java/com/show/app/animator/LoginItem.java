package com.show.app.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.RelativeLayout;
import com.show.app.R;

public class LoginItem extends RelativeLayout {

    private View vHead;
    private View vHeart;
    private View vLight;

    private AnimatorSet animatorSet;

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
        ObjectAnimator headAnimator = ObjectAnimator.ofPropertyValuesHolder(vHead, headScaleX, headScaleY);
        headAnimator.setDuration(1000);
        headAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                vHeart.setVisibility(GONE);
            }
            @Override
            public void onAnimationEnd(Animator animation) { }
            @Override
            public void onAnimationCancel(Animator animation) { }
            @Override
            public void onAnimationRepeat(Animator animation) { }
        });

        Keyframe heartKF1 = Keyframe.ofFloat(0, 0);
        Keyframe heartKF2 = Keyframe.ofFloat(1, 1);
        heartKF2.setInterpolator(new BounceInterpolator());
        PropertyValuesHolder heartScaleX = PropertyValuesHolder.ofKeyframe("scaleX", heartKF1, heartKF2);
        PropertyValuesHolder heartScaleY = PropertyValuesHolder.ofKeyframe("scaleY", heartKF1, heartKF2);
        ObjectAnimator heartAnimator = ObjectAnimator.ofPropertyValuesHolder(vHeart, heartScaleX, heartScaleY);
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

        Keyframe lightKF1 = Keyframe.ofFloat(0, 0);
        Keyframe lightKF2 = Keyframe.ofFloat(0.67f, 1);
        Keyframe lightKF3 = Keyframe.ofFloat(1, 1);
        Keyframe lightKF4 = Keyframe.ofFloat(0, 1);
        Keyframe lightKF5 = Keyframe.ofFloat(0.67f, 1);
        Keyframe lightKF6 = Keyframe.ofFloat(1, 0);
        PropertyValuesHolder lightScaleX = PropertyValuesHolder.ofKeyframe("scaleX", lightKF1, lightKF2, lightKF3);
        PropertyValuesHolder lightScaleY = PropertyValuesHolder.ofKeyframe("scaleY", lightKF1, lightKF2, lightKF3);
        PropertyValuesHolder lightAlpha = PropertyValuesHolder.ofKeyframe("alpha", lightKF4, lightKF5, lightKF6);
        ObjectAnimator lightAnimator = ObjectAnimator.ofPropertyValuesHolder(vLight, lightScaleX, lightScaleY, lightAlpha);
        lightAnimator.setStartDelay(300);
        lightAnimator.setDuration(500);
        lightAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                vLight.setVisibility(VISIBLE);
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                vLight.setVisibility(GONE);
            }
            @Override
            public void onAnimationCancel(Animator animation) { }
            @Override
            public void onAnimationRepeat(Animator animation) { }
        });

        animatorSet = new AnimatorSet();
        animatorSet.playTogether(headAnimator, heartAnimator, lightAnimator);
    }

    public void startAnimator(){
        animatorSet.start();
    }
}
