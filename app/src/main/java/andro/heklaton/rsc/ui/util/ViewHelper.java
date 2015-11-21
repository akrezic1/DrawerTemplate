package andro.heklaton.rsc.ui.util;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.util.TypedValue;
import android.view.View;

public class ViewHelper {

    /**
     * Calculate pixels from density pixels
     * @param dp Density pixels
     * @return Pixel value of Density Pixel
     */
    public static float getPxFromDp(Context context, int dp) {
        return  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static void animateFabColorChange(Context context, final FloatingActionButton fab, int startColor, int endColor) {
        Resources res = context.getResources();

        ValueAnimator anim = new ValueAnimator();
        anim.setIntValues(res.getColor(startColor), res.getColor(endColor));
        anim.setEvaluator(new ArgbEvaluator());
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                fab.setBackgroundTintList(ColorStateList.valueOf((Integer) valueAnimator.getAnimatedValue()));
            }
        });

        anim.setDuration(300);
        anim.start();
    }

}
