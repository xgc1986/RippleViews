package com.xgc1986.ripplebuttonsample.data;

import android.os.Build;

public class RippleButtonDemo {

    private Class<?> mV21Activity;
    private Class<?> mV19Activity;

    public String mTitle;
    public String mSubtitle;
    public String mGithub;
    public int mImageResource;
    public boolean mIsForJelly;

    public RippleButtonDemo(Class<?> v21Activity, Class<?> v19Activity, String title, String subtitle, String github, int resource, boolean isForJelly) {
        mV21Activity = v21Activity;
        mV19Activity = v19Activity;
        mTitle = title;
        mSubtitle = subtitle;
        mGithub = github;
        mImageResource = resource;
        mIsForJelly = isForJelly;
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
                if (mIsForJelly) {
                    return mV21Activity;
                }
            }
        }

        return null;
    }
}
