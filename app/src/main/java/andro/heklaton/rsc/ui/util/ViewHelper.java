package andro.heklaton.rsc.ui.util;

import android.content.Context;
import android.util.TypedValue;

public class ViewHelper {

    /**
     * Calculate pixels from density pixels
     * @param dp Density pixels
     * @return Pixel value of Density Pixel
     */
    public static float getPxFromDp(Context context, int dp) {
        return  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

}
