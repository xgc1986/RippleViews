package com.xgc1986.ripplebuttonsample.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.xgc1986.ripplebutton.utils.RippleDrawableHelper;
import com.xgc1986.ripplebutton.widget.RippleButton;
import com.xgc1986.ripplebuttonsample.R;


public class RippleButtonDemoActivity extends Activity {

    public static String NAME = "RippleButton";
    public static String DESCRIPTION = "";
    public static String GITHUB = "https://github.com/xgc1986/RippleViews/blob/master/ripplebuttonsample/src/main/res/layout/ripple_button_demo.xml";
    public static int IMAGE_RESOURCE = R.mipmap.ripple_button;
    public static boolean JELLY = true;

    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ripple_button_demo);

        final int[] colors = {
                0xff33b5e5,
                0xffff4444,
                0xff99cc00
        };

        final int[] colors2 = {
                0xff1183c3,
                0xffdd2222,
                0xff77aa00
        };

        final String[] texts = {"AWESOME", "THIS", "IS"};

        RippleButton rb = (RippleButton) findViewById(R.id.btn3);
        rb.setColors(colors[0], 0xffffffff);

        final RippleButton rb2 = (RippleButton) findViewById(R.id.btn4);

        rb2.setColors(colors[1], colors2[2]);
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = (i + 1) % 3;
                rb2.setColors(colors[(i) % 3], colors2[(i + 1) % 3]);
                rb2.setText(texts[i]);
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