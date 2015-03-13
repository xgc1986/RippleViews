package com.xgc1986.ripplebuttonsample.demo_v19;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;

import com.xgc1986.ripplebutton.widget.RippleImageButton;
import com.xgc1986.ripplebuttonsample.R;


public class RippleImageButtonDemoV19Activity extends ActionBarActivity {

    private int i = 1;

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
        rb.setColors(colors[0], 0xff000000);

        final int[] images = {
                R.drawable.stop,
                R.drawable.play,
                R.drawable.pause,
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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        onBackPressed();

        return super.onOptionsItemSelected(item);
    }
}