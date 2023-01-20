package com.cosminionescu.androidfall2022.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.cosminionescu.androidfall2022.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        insertBlankActivity();
    }


    private void insertBlankActivity() {
        // begin transaction
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // replace the contents of the container with the new fragment
        // change in the wanted frame (the placeholder) the fragment displayed
        transaction.replace(R.id.frameLayoutPlaceholder,new BlankFragment());

        // commit the transaction
        transaction.commit();
    }
}