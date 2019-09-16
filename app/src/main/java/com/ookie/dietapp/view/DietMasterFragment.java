package com.ookie.dietapp.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ookie.dietapp.R;
import com.ookie.dietapp.model.Diet;
import com.ookie.dietapp.model.DietListAdapter;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class DietMasterFragment extends Fragment {

    public DietMasterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_diet_master, container, false);

        //Create LIST of diets
        final ArrayList<Diet> diets = new ArrayList<>();
        diets.add(new Diet("Paleo", R.drawable.is_it_paleo, R.string.paleo_description));
        diets.add(new Diet("Vegan", R.drawable.vegan_food_pyramid, R.string.vegan_description));
        diets.add(new Diet("Keto", R.drawable.keto_do_dont, R.string.keto_description));
        diets.add(new Diet("Dukan", R.drawable.dukan_food_list, R.string.dukan_description));
        diets.add(new Diet("HCG", R.drawable.hcg_two, R.string.hcg_description));
        diets.add(new Diet("Zone", R.drawable.zone_diet_plate, R.string.zone_description));

        ListView dietListView = rootview.findViewById(R.id.diet_list);

        DietListAdapter dietListAdapter = new DietListAdapter(getActivity(), diets);

        dietListView.setAdapter(dietListAdapter);

        dietListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Diet currentDiet = diets.get(position); //Reference specific diet

                //Get reference to details of current item
                String dietName = currentDiet.getDietName();

                //Get Diet Photo *Convert to Bitmap, then Byte Array*
/*
                Bitmap bmp = BitmapFactory.decodeResource(getResources(), currentDiet.getImageResourceID());
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
*/

                //Passing in (int) since we are referencing xml
                int dietDescription = currentDiet.getDescription();

                //Create Intent and pass items
                Intent dietDetailIntent = new Intent(getContext(), DietDetail.class);
                dietDetailIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
                dietDetailIntent.putExtra("Diet Name", dietName);
//              dietDetailIntent.putExtra("Diet Picture", byteArray);
                dietDetailIntent.putExtra("Diet Description", dietDescription);

                //Start activity with the new intent
                startActivity(dietDetailIntent);
            }
        });

        //Return inflated view of custom layout
        return rootview;
    }


}
