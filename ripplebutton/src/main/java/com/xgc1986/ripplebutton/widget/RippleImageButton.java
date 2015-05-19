package com.xgc1986.ripplebutton.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageButton;

import com.xgc1986.ripplebutton.R;

public class RippleImageButton extends ImageButton {


    // TODO get style color;
    private int buttonColor = 0xffd6d7d7;
    private int rippleColor = 0x40000000;

    public RippleImageButton(Context context) {
        super(context);
    }

    public RippleImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        manageAttibuteSet(attrs);
    }

    public RippleImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        manageAttibuteSet(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RippleImageButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        manageAttibuteSet(attrs);
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
                                rippleColor
                        }
                );

                rippleDrawable.setColor(colorStateList);
            } else {
                Log.w("RippleButton", "The Background must be a RippleDrawable instance.");
            }
        }
    }

    public void setButtonColor(int color) {
        buttonColor = color;
        Drawable drawable = getBackground();

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (drawable instanceof RippleDrawable) {
                RippleDrawable rippleDrawable = (RippleDrawable) drawable.mutate().getConstantState().newDrawable();
                InsetDrawable insetDrawable = (InsetDrawable) rippleDrawable.getDrawable(0);
                GradientDrawable gradientDrawable = (GradientDrawable) insetDrawable.getDrawable();

                setBackground(rippleDrawable);
                gradientDrawable.setColor(color);
            } else {
                Log.w("RippleButton", "The Background must be a RippleDrawable instance.");
            }
        } else {
            setBackground(getResources().getDrawable(R.drawable.btn_default_ripple));
            getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
        }
    }

    private void manageAttibuteSet(AttributeSet attrs) {
        if (!isInEditMode()) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.RippleButton);

            int nColor = a.getInt(R.styleable.RippleButton_buttonColor, buttonColor);
            int hColor = a.getInt(R.styleable.RippleButton_rippleColor, rippleColor);

            setButtonColor(nColor);
            setRippleColor(hColor);

            a.recycle();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean b = super.onTouchEvent(event);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            if (event.getActionMasked() == MotionEvent.ACTION_UP) {
                if (buttonColor != 0) {
                    getBackground().setColorFilter(buttonColor, PorterDuff.Mode.MULTIPLY);
                } else {
                    getBackground().clearColorFilter();
                }
            } else {
                if (rippleColor != 0) {
                    setBackground(getResources().getDrawable(R.drawable.btn_default_normal_ripple));
                    getBackground().setColorFilter(rippleColor, PorterDuff.Mode.MULTIPLY);
                }
            }
        }

        return b;
    }
}
