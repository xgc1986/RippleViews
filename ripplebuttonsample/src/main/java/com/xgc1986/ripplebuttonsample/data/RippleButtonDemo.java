package com.xgc1986.ripplebuttonsample.data;

import android.app.Activity;

import com.xgc1986.ripplebuttonsample.MainActivity;

/**
 * Created by xgc1986 on 03/03/15.
 */
public class RippleButtonDemo {

    public Class<?> mActivity;
    public String mTitle;
    public String mSubtitle;
    public String mGithub;
    public int mImageResource;

    public RippleButtonDemo(Class<?> activity, String title, String subtitle, String github, int resource) {
        mActivity = activity;
        mTitle = title;
        mSubtitle = subtitle;
        mGithub = github;
        mImageResource = resource;
    }
}
