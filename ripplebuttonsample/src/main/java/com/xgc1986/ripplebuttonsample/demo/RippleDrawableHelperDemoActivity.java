package com.xgc1986.ripplebuttonsample.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.xgc1986.ripplebutton.utils.RippleDrawableHelper;
import com.xgc1986.ripplebuttonsample.R;

public class RippleDrawableHelperDemoActivity extends Activity {

    public static String NAME = "RippleDrawableHelper";
    public static String DESCRIPTION = "Adding ripple effect to your view easier then ever!";
    public static String GITHUB = "https://github.com/xgc1986/RippleViews/blob/master/ripplebuttonsample/src/main/res/layout/ripple_drawable_helper_demo.xml";
    public static int IMAGE_RESOURCE = 0;
    public static boolean JELLY = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ripple_drawable_helper_demo);

        View b1 = findViewById(R.id.heart);
        b1.setBackground(RippleDrawableHelper.createRippleDrawable(b1, 0x80ffffff, R.mipmap.heart_dark));

        View b4 = findViewById(R.id.heart2);
        b4.setBackground(RippleDrawableHelper.createRippleDrawable(b4, 0x88000000, R.mipmap.android_dark));

        View b3 = findViewById(R.id.rLayout);
        b3.setBackground(RippleDrawableHelper.createRippleDrawable(b3, getResources().getColor(android.R.color.holo_green_light)));

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // needed to make the ripple effect, because of google
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        onBackPressed();

        return super.onOptionsItemSelected(item);
    }
}
