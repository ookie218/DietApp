package com.ookie.dietapp.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ookie.dietapp.R;
import com.ookie.dietapp.model.CategoryAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create ViewPager and ref xml id
        ViewPager viewPager = findViewById(R.id.viewpager);

        //Create instance of CategoryAdapter and pass in context and Support FragmentManager
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(categoryAdapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}