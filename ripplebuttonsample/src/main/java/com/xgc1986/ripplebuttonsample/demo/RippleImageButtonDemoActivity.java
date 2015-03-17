package com.xgc1986.ripplebuttonsample.demo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.xgc1986.ripplebutton.widget.RippleImageButton;
import com.xgc1986.ripplebuttonsample.R;

public class RippleImageButtonDemoActivity extends Activity {

    public static String NAME = "RippleImageButton";
    public static String DESCRIPTION = "";
    public static String GITHUB = "https://github.com/xgc1986/RippleViews/blob/master/ripplebuttonsample/src/main/res/layout/ripple_image_demo.xml";
    public static int IMAGE_RESOURCE = R.mipmap.ripple_imagebutton;
    public static boolean JELLY = true;

    private int i = 1;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ripple_image_button_demo);

        final int[] colors = {
                0xff33b5e5,
                0xffff4444,
                0xff99cc00
        };

        RippleImageButton rb = (RippleImageButton) findViewById(R.id.btn3);
        rb.setColors(colors[0], 0xffffffff);

        final int[] images = {
                R.mipmap.stop,
                R.mipmap.play,
                R.mipmap.pause,
        };

        final RippleImageButton rb2 = (RippleImageButton) findViewById(R.id.btn4);
        rb2.setColors(colors[1], colors[2]);
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = (i + 1) % 3;
                rb2.setColors(colors[(i) % 3], colors[(i + 1) % 3]);
                rb2.setImageResource(images[(i) % 3]);
            }
        });

        if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
            getActionBar().show();
        }
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