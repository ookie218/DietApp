package com.ookie.dietapp.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.ookie.dietapp.R;

public class DietDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Create intent to receive information
        Intent intent = getIntent();

        //Extract Name using the name string we passed in
        String dietName = intent.getStringExtra("Diet Name");


        //Extract Description
        int extraResourceId = getIntent().getIntExtra("Diet Description", 0);

        //Convert XML int resource into a String
        String dietDescription = getString(extraResourceId);


/*
        //Extract Photo
        Bundle extras = getIntent().getExtras();
        byte[] byteArray = new byte[0];
        if (extras != null) {
            byteArray = extras.getByteArray("Diet Picture");
        }

        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray,0, byteArray.length);
        ImageView dietPhoto = findViewById(R.id.diet_image);
*/


        //Placing the pieces
        TextView dietNamePlacement = findViewById(R.id.diet_name);
        TextView dietDescriptionPlacement = findViewById(R.id.diet_description);

        dietNamePlacement.setText(dietName);
        dietDescriptionPlacement.setText(dietDescription);
//      dietPhoto.setImageBitmap(bmp);


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
