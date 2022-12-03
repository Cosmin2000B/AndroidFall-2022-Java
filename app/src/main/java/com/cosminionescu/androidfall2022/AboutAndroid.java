package com.cosminionescu.androidfall2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class AboutAndroid extends AppCompatActivity {

    private static final String SANTA_URL = "https://www.google.com/";

    private RatingBar androidRatingBar;
    private ProgressBar progressBarAboutAndroid;
    private SwitchCompat switchBackup;
    private WebView webViewChristmas;
    private Spinner spinnerCities;

    private List<String> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_android);

        setupViews();
        float rating = androidRatingBar.getRating();

        if(switchBackup.isChecked()) {
            //do something
        }
    }

    private void setupViews() {
        androidRatingBar.findViewById(R.id.androidRatingBar);
        switchBackup.findViewById(R.id.switchBackup);
        /* TODO make it work
        progressBarAboutAndroid.findViewById(R.id.progressBarAboutAndroid);
        progressBarAboutAndroid.setVisibility(View.INVISIBLE);
         */
        webViewChristmas.loadUrl(SANTA_URL);
        webViewChristmas.getSettings().setJavaScriptEnabled(true);

        setupSpinner();
    }

    // STEP 0: Add Spinner in xml Yap, spinnerCitiesList

    // STEP1: define the data source
    private void setCities() {
        cities = new ArrayList<>();
        cities.add("Pitesti");
        cities.add("Iasi");
        cities.add("Oradea");
        cities.add("Zalau");
        cities.add("Braila");
        cities.add("Galati");
        cities.add("Brasov");
        cities.add("Ploiesti");
        cities.add("Timisoara");
    }

    // STEP 2: Define Adaptor
    private ArrayAdapter<String> getDefaultAdapter() {
        return new ArrayAdapter<>(
                AboutAndroid.this, android.R.layout.simple_spinner_item, cities);
    }

    // STEP 3: Setare adaptor
    private void setupSpinner() {
        spinnerCities.findViewById(R.id.spinnerCitiesList);
        setCities();
        spinnerCities.setAdapter(getDefaultAdapter());
    }

}