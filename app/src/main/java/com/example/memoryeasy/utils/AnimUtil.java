package com.example.memoryeasy.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.OvershootInterpolator;


/**
 * 在该方法中使用了属性动画里的ObjectAnimator，现在点击的view就是要传入的oldView参数，该view先会绕自身中间的x轴向上旋转90度；
 * 然后设置了对上述动画动作的监听，当oldView的动画animator1完成时，将oldView设为不可见，
 * 开始要在翻转后显示的view的动画animator2，即newView从水平位置向下翻转90度，设为可见，这样就完成了整个翻转的动画动作，
 * 另外给第二个动画设置了一个OvershootInterpolator的插值器，这样在动画即将完成时会有一个弹性回弹的效果，视觉效果更好。
 */

public class AnimUtil {

    public static void FlipAnimatorXViewShow(final View oldView, final View newView, final long time) {

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(oldView, "rotationX", 0, 90);
        final ObjectAnimator animator2 = ObjectAnimator.ofFloat(newView, "rotationX", -90, 0);
        animator2.setInterpolator(new OvershootInterpolator(2.0f));

        animator1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                oldView.setVisibility(View.GONE);
                animator2.setDuration(time).start();
                newView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator1.setDuration(time).start();
    }
}