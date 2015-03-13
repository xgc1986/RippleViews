package com.xgc1986.ripplebuttonsample.adapter;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xgc1986.ripplebutton.utils.RippleDrawableHelper;
import com.xgc1986.ripplebuttonsample.R;
import com.xgc1986.ripplebuttonsample.data.RippleButtonDemo;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RippleButtonDemo[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTitle;
        public TextView mSubtitle;
        public ImageView mImage;
        public TextView mGithub;
        public LinearLayout mContent;

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public ViewHolder(View v) {
            super(v);
            mTitle = (TextView) v.findViewById(R.id.title);
            mSubtitle = (TextView) v.findViewById(R.id.subtitle);
            mImage = (ImageView) v.findViewById(R.id.image);
            mContent = (LinearLayout) v.findViewById(R.id.top);
            mGithub = (TextView) v.findViewById(R.id.github);
        }
    }

    public static class ViewHolder2 extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public ViewHolder2(View v) {
            super(v);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == mDataset.length -1) {
            return 2;
        } else {
            return 1;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(RippleButtonDemo[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        if (viewType == 0) {
            View v2 = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.logo, parent, false);

            return new ViewHolder2(v2);
        } else {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(viewType == 2?R.layout.cards2:R.layout.cards, parent, false);
            return new ViewHolder(v);
        }
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder h, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        if (position > 0) {

            final ViewHolder holder = (ViewHolder) h;

            holder.mTitle.setText(mDataset[position].mTitle);
            holder.mSubtitle.setText(mDataset[position].mSubtitle);
            holder.mImage.setImageResource(mDataset[position].mImageResource);

            /** github button */
            Drawable githubDrawable = RippleDrawableHelper.createRippleDrawable(holder.mGithub, 0xfffafafa, 0xff0099cc);

            if (android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
                holder.mGithub.setBackground(githubDrawable);
            } else {
                holder.mGithub.setBackgroundDrawable(githubDrawable);
            }

            holder.mGithub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mDataset[position].mGithub));
                    holder.mGithub.getContext().startActivity(browserIntent);
                }
            });

            /** Demo button */
            Drawable demoDrawable = RippleDrawableHelper.createRippleDrawable(holder.mContent, 0xfffafafa, 0xff0099cc);

            if (android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
                holder.mContent.setBackground(demoDrawable);
            } else {
                holder.mContent.setBackgroundDrawable(demoDrawable);
            }

            holder.mContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(holder.mContent.getContext(), mDataset[position].getActivity());
                    holder.mContent.getContext().startActivity(intent);
                }
            });


        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}