package com.xgc1986.ripplebuttonsample;

import android.app.Activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xgc1986.ripplebuttonsample.adapter.MyAdapter;
import com.xgc1986.ripplebuttonsample.data.RippleButtonDemo;
import com.xgc1986.ripplebuttonsample.demo.RippleButtonDemoActivity;

public class MainActivity extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RippleButtonDemo[] myDataset = {
                new RippleButtonDemo(null, null, null, null, 0),
                new RippleButtonDemo(RippleButtonDemoActivity.class, "Basic buttons demo", "RippleButton class", "https://github.com/xgc1986/RippleButton", R.drawable.ripplebutton)
        };

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
}
