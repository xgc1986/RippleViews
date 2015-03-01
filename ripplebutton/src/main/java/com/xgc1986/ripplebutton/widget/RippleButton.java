package com.xgc1986.ripplebutton.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.xgc1986.ripplebutton.R;

public class RippleButton extends Button {
    public RippleButton(Context context) {
        super(context);
    }

    private int buttonColor = 0;
    private int rippleColor = 0;

    public RippleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        manageAttibuteSet(attrs);
    }

    public RippleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RippleButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setColors(int buttonColor, int controlHighlightColor) {
        setButtonColor(buttonColor);
        setRippleColor(controlHighlightColor);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setRippleColor(final int color) {
        rippleColor = color;
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Drawable drawable = getBackground();

            if (drawable instanceof RippleDrawable) {
                RippleDrawable rippleDrawable = (RippleDrawable) drawable;

                ColorStateList colorStateList = new ColorStateList(
                        new int[][]{
                                new int[]{android.R.attr.state_pressed}
                        },
                        new int[]{
                                color
                        }
                );

                rippleDrawable.setColor(colorStateList);
            } else {
                Log.w("RippleButton", "The Background must be a RippleDrawable instance.");
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setButtonColor(int color) {
        buttonColor = color;
        Drawable drawable = getBackground();

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (drawable instanceof RippleDrawable) {
                RippleDrawable rippleDrawable = (RippleDrawable) drawable;

                InsetDrawable insetDrawable = (InsetDrawable) rippleDrawable.getDrawable(0);
                GradientDrawable gradientDrawable = (GradientDrawable) insetDrawable.getDrawable();
                gradientDrawable.setColor(color);
            } else {
                Log.w("RippleButton", "The Background must be a RippleDrawable instance.");
            }
        } else {
            getBackground().setColorFilter(color, PorterDuff.Mode.SRC_IN);
        }
    }

    private void manageAttibuteSet(AttributeSet attrs) {

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.RippleButton);

        int nColor = a.getInt(R.styleable.RippleButton_buttonColor, 0);
        int hColor = a.getInt(R.styleable.RippleButton_rippleColor, 0);

        if (nColor != 0) {
            setButtonColor(nColor);
        }

        if (hColor != 0) {
            setRippleColor(hColor);
        }

        a.recycle();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean b = super.onTouchEvent(event);

        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            if (event.getActionMasked() == event.ACTION_UP) {
                if (buttonColor != 0) {
                    getBackground().setColorFilter(buttonColor, PorterDuff.Mode.SRC_IN);
                }
            } else {
                if (rippleColor != 0) {
                    getBackground().setColorFilter(rippleColor, PorterDuff.Mode.SRC_IN);
                }
            }
        }

        return b;
    }
}
