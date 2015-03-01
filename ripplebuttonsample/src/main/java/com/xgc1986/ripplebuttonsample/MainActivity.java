package com.xgc1986.ripplebuttonsample;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.xgc1986.ripplebutton.widget.RippleButton;


public class MainActivity extends ActionBarActivity {

    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int[] colors = {
                getResources().getColor(android.R.color.holo_blue_light),
                getResources().getColor(android.R.color.holo_red_light),
                getResources().getColor(android.R.color.holo_green_light)
        };
        final String[] texts = {"AWESOME", "THIS", "IS"};

        RippleButton rb = (RippleButton)findViewById(R.id.btn3);
        rb.setColors(colors[0], colors[2]);

        final RippleButton rb2 = (RippleButton)findViewById(R.id.btn4);
        rb2.setColors(getResources().getColor(android.R.color.holo_red_light), getResources().getColor(android.R.color.holo_blue_light));
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = (i + 1) % 3;
                rb2.setColors(colors[(i + 1) % 3], colors[(i + 2) % 3]);
                rb2.setText(texts[i]);


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

        return super.onOptionsItemSelected(item);
    }
}
