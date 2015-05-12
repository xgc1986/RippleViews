package com.xgc1986.ripplebutton.utils;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.View;

public class RippleDrawableHelper {


    public static Drawable createRippleDrawable(final View v, final int color) {
        return createRippleDrawable(v, color, null);
    }

    public static Drawable createRippleDrawable(final View v, final int color, int drawableResource) {
        return createRippleDrawable(v, color, v.getContext().getResources().getDrawable(drawableResource));
    }

    public static Drawable createRippleDrawable(final View v, final int color, Drawable pressed) {

        Drawable drawable = v.getBackground();

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            if (drawable instanceof RippleDrawable) {
                drawable = ((RippleDrawable) drawable).getDrawable(0);

                RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(
                        new int[][]{
                                new int[]{android.R.attr.state_pressed},
                                new int[]{0}
                        },
                        new int[]{color, 0}
                ), drawable, null);


                return rippleDrawable;
            } else {
                if (drawable == null) {
                    drawable = new ColorDrawable(0);
                    v.setBackground(drawable);
                    RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(
                            new int[][]{
                                    new int[]{android.R.attr.state_pressed},
                                    new int[]{0}
                            },
                            new int[]{color, 0}
                    ), drawable, new ColorDrawable(0xffffffff));
                    return rippleDrawable;
                } else {
                    RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(
                            new int[][]{
                                    new int[]{android.R.attr.state_pressed},
                                    new int[]{0}
                            },
                            new int[]{color, 0}
                    ), drawable, null);
                    return rippleDrawable;
                }
            }
        } else {

            if (drawable == null) {
                drawable = new ColorDrawable(color);
            }

            if (pressed == null) {
                pressed = drawable;
            }


            StateListDrawable sld = new StateListDrawable();
            sld.addState(
                    new int[] {
                            android.R.attr.state_pressed,
                    },
                    pressed
            );


            if (v.getBackground() != null) {
                sld.addState(
                        new int[]{
                                0,
                        },
                        drawable
                );
            }

            return sld;
        }
    }


}