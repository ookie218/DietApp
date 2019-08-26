package com.ookie.dietapp.model;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ookie.dietapp.view.DietMasterFragment;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new DietMasterFragment();
        } if (position == 1) {
            return new DietMasterFragment();
        } if (position == 2) {
            return new DietMasterFragment();
        } else {
            return new DietMasterFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
/*
    public CharSequence getPageTitle(int position){
        if (position == 0) {
            return mContext.getString(R.string.home_tab);
        } if (position == 1) {
            return mContext.getString(R.string.artist_tab);
        } if (position == 2) {
            return mContext.getString(R.string.media_tab);
        } else {
            return mContext.getString(R.string.contact_tab);
        }
    }
*/
}
