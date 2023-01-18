package com.cosminionescu.androidfall2022.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.cosminionescu.androidfall2022.R;

/**
 * TODO: See for Activity lifecycle
 */
public class FirstActivity extends AppCompatActivity {

    private final String TAG = "FirstActivity";
    private Button buttonDial;
    private Button buttonOpenWebsite;
    private Button buttonSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Log.e(TAG, "onCreate");

        setupButtonDial();
        setupButtonOpenWebsite();
        setupButtonSecondActivity();
    }

    /**
     * TODO: see example of implicit intent
     *  - Se poate utiliza si pt Google Maps
     */
    private void setupButtonDial() {
        buttonDial = findViewById(R.id.buttonDial);
        buttonDial.setOnClickListener(view -> {
            /* ---- Poate crea probleme privacy -> getPackageManager poate fi utilizat fraudulos
            Intent dialActivity = new Intent(Intent.ACTION_DIAL);
            dialActivity.setData(Uri.parse("tel:0711312244"));

            // TODO SEE: good check against starting an Activity when it can't actually start !!
            if(dialActivity.resolveActivity(getPackageManager()) != null) {
                // implicit intent -> no context needed for the activity to start
                startActivity(dialActivity);
            }
             */
            // Alternativa:
            try {
                Intent dialActivity = new Intent(Intent.ACTION_DIAL);
                dialActivity.setData(Uri.parse("tel:0711312244"));
                startActivity(dialActivity);
            }
            catch (Exception e) {
                // Handle exception when activity can't start
            }
        });
    }

    private void setupButtonOpenWebsite() {
        buttonOpenWebsite = findViewById(R.id.buttonOpenWebsite);
        buttonOpenWebsite.setOnClickListener(view -> {
            try {
                Intent webActivity = new Intent(Intent.ACTION_VIEW);
                webActivity.setData(Uri.parse("https://www.google.ro"));
                startActivity(webActivity);
            }
            catch (Exception e) {
                // Handle exception when activity can't start
            }
        });
    }

    /**
     * TODO: see for Fragment example
     */
    private void setupButtonSecondActivity() {
        buttonSecondActivity = findViewById(R.id.buttonSecondActivity);
        buttonSecondActivity.setOnClickListener(view -> {
            try {
                Intent moveToSecondActivity = new Intent(this, SecondActivity.class);
                startActivity(moveToSecondActivity);
            }
            catch (Exception e) {
                // Handle exception when activity can't start
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }
}