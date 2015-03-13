package com.xgc1986.ripplebuttonsample.data;

import android.os.Build;

public class RippleButtonDemo {

    private Class<?> mV21Activity;
    private Class<?> mV10Activity;
    private Class<?> mV19Activity;

    public String mTitle;
    public String mSubtitle;
    public String mGithub;
    public int mImageResource;

    public RippleButtonDemo(Class<?> v21Activity, Class<?> v19Activity, Class<?> v10Activity, String title, String subtitle, String github, int resource) {
        mV21Activity = v21Activity;
        mV10Activity = v10Activity;
        mV19Activity = v19Activity;
        mTitle = title;
        mSubtitle = subtitle;
        mGithub = github;
        mImageResource = resource;
    }

    public Class<?> getActivity() {

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (mV21Activity != null) {
                return mV21Activity;
            }
            return null;
        }

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            if (mV19Activity != null) {
                return mV19Activity;
            } else {
                return mV21Activity;
            }
        }

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            if (mV10Activity != null) {
                return mV10Activity;
            } else if (mV19Activity != null) {
                return mV19Activity;
            } else {
                return mV21Activity;
            }
        }

        return null;
    }
}
