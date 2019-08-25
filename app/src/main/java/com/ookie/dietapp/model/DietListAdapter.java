package com.ookie.dietapp.model;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ookie.dietapp.R;

import java.util.ArrayList;

public class DietListAdapter extends ArrayAdapter<Diet> {

    private Context mContext;
    private ArrayList<Diet> mDietIds;

    public DietListAdapter(Activity context, ArrayList<Diet> diets) {
        super(context, 0, diets);
        mContext = context;
        mDietIds = diets;
    }

    @Override
    public int getCount() {
        //Return array length
        return mDietIds.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        //Create a view to reference
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Diet currentDiet = getItem(position);

        TextView dietNameTextView = listItemView.findViewById(R.id.diet_name);

        if (currentDiet != null) {
            dietNameTextView.setText(currentDiet.getDietName());
        }

        ImageView dietImage = listItemView.findViewById(R.id.diet_image);

        if (currentDiet != null) {
            //Check to see if there is an image
            if (currentDiet.hasImage()) {
                dietImage.setImageResource(currentDiet.getImageResourceID());
                dietImage.setVisibility(View.VISIBLE);
            } else {
                //If no Image, blank space to keep the view consistent
                dietImage.setVisibility(View.GONE);
            }
        }

        //Return the View created
        return listItemView;
    }
}
