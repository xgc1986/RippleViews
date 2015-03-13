package com.xgc1986.ripplebuttonsample;

import android.app.Activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import com.xgc1986.ripplebuttonsample.adapter.MyAdapter;
import com.xgc1986.ripplebuttonsample.data.RippleButtonDemo;
import com.xgc1986.ripplebuttonsample.demo.RippleButtonDemoActivity;
import com.xgc1986.ripplebuttonsample.demo.RippleImageButtonDemoActivity;
import com.xgc1986.ripplebuttonsample.demo_v19.RippleButtonDemoV19Activity;
import com.xgc1986.ripplebuttonsample.demo_v19.RippleImageButtonDemoV19Activity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RippleButtonDemo[] myDataset = {
                new RippleButtonDemo(null, null, null, null, null, null, 0),
                new RippleButtonDemo(RippleButtonDemoActivity.class, RippleButtonDemoV19Activity.class, null, "Basic buttons demo", "RippleButton class", "https://github.com/xgc1986/RippleButton", R.drawable.ripple_button),
                new RippleButtonDemo(RippleImageButtonDemoActivity.class, RippleImageButtonDemoV19Activity.class, null, "Image Buttons demo", "RippleImageButton class", "https://github.com/xgc1986/RippleButton", R.drawable.ripple_imagebutton)
        };

        // specify an adapter (see also next example)
        RecyclerView.Adapter mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}
