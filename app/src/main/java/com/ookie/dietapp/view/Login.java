package com.ookie.dietapp.view;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ookie.dietapp.R;

public class Login extends AppCompatActivity {

    public static String facebookUrl = "http://www.facebook.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Check to see if user is already logged in from previous sign in


        //If user is not signed in, Allow him to sign in
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        Button logIn = findViewById(R.id.btn_login);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Gather username and password and compare it to see if we have in our database

                //If match is found, authenticate user and proceed to main menu


                //For the moment we will just use a toast
                Toast.makeText(Login.this, "Thank you for logging into the demo",
                        Toast.LENGTH_LONG).show();

                Intent dummyLoginIntent = new Intent(Login.this, MainActivity.class);
                startActivity(dummyLoginIntent);
                finish();
            }
        });

        TextView facebookLoginButton = findViewById(R.id.facebook_login);
        facebookLoginButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Uri facebookUri = Uri.parse(facebookUrl);
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW, facebookUri);

                //Checks to see if Facebook app can open intent
                facebookIntent.setPackage("com.facebook.android");

                try {
                    startActivity(facebookIntent);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.facebook.com")));
                }
                return false;
            }
        });



        //If user decides to skip log-in
        TextView continueWithoutLogin = findViewById(R.id.continue_no_login);
        continueWithoutLogin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent noLoginContinue = new Intent(Login.this, MainActivity.class);
                startActivity(noLoginContinue);
                finish();
                return false;
            }
        });

    }


}
