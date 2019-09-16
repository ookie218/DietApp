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
        return new DietMasterFragment();
    }

    //Since only one class being referenced, no swipe!
    //Still using category adapter to show fragment on app start-up
    @Override
    public int getCount() {
        return 1;
    }


}
