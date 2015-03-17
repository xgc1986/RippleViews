package com.xgc1986.ripplebuttonsample;

import android.app.Activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import com.xgc1986.ripplebuttonsample.adapter.MyAdapter;
import com.xgc1986.ripplebuttonsample.data.RippleButtonDemo;
import com.xgc1986.ripplebuttonsample.demo.RippleButtonDemoActivity;
import com.xgc1986.ripplebuttonsample.demo.RippleDrawableHelperDemoActivity;
import com.xgc1986.ripplebuttonsample.demo.RippleImageButtonDemoActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RippleButtonDemo[] myDataset = {
                new RippleButtonDemo(null, null, null, null, null, 0, false),
                new RippleButtonDemo(RippleButtonDemoActivity.class, null, RippleButtonDemoActivity.NAME, RippleButtonDemoActivity.DESCRIPTION, RippleButtonDemoActivity.GITHUB, RippleButtonDemoActivity.IMAGE_RESOURCE, RippleButtonDemoActivity.JELLY),
                new RippleButtonDemo(RippleImageButtonDemoActivity.class, null, RippleImageButtonDemoActivity.NAME, RippleImageButtonDemoActivity.DESCRIPTION, RippleImageButtonDemoActivity.GITHUB, RippleImageButtonDemoActivity.IMAGE_RESOURCE, RippleImageButtonDemoActivity.JELLY),
                new RippleButtonDemo(RippleDrawableHelperDemoActivity.class, null, RippleDrawableHelperDemoActivity.NAME, RippleDrawableHelperDemoActivity.DESCRIPTION, RippleDrawableHelperDemoActivity.GITHUB, RippleDrawableHelperDemoActivity.IMAGE_RESOURCE, RippleDrawableHelperDemoActivity.JELLY),
        };

        RecyclerView.Adapter mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}
