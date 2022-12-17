package com.cosminionescu.androidfall2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 *
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewDisplayAccount;

    private Button buttonDisplayAndroid;


    /**
     * Legatura dintre layout si activitate
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // clasa R pt resurse -> ia layout
        setContentView(R.layout.login);
        setupViews();

        // onClick actions config
        textViewDisplayAccount.setOnClickListener(this::loginOnClick);
        buttonDisplayAndroid.setOnClickListener(view -> {
            Intent moveFromMainToAboutAndroid =
                    new Intent(MainActivity.this, AboutAndroid.class);
            startActivity(moveFromMainToAboutAndroid);
        });
    }

    /**
     * Better to have this in it's own method
     */
    private void setupViews() {

        editTextEmail = findViewById(R.id.editTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextPassword);
        textViewDisplayAccount = findViewById(R.id.textViewDisplayAccount);
        buttonDisplayAndroid = findViewById(R.id.buttonAboutAndroid);
    }

    public void loginOnClick(View view) {

        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if (email.length() > 0 && password.length() > 0) {

            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                textViewDisplayAccount.setText(
                        new StringBuilder()
                                .append(email)
                                .append(" ")
                                .append(password)
                );

                moveToMoviesActivity(email, password);
            } else {
                invalidEmailFormat(
                        editTextEmail,
                        "Please enter valid email",
                        "email doesn't have a valid format"
                );
            }
        } else if (email.length() <= 0) {
            invalidEmailLength();
        } else if (password.length() <= 0) {
            editTextPassword.setError("Please add your password");
            Log.e(TAG, "password is empty");
        }
    }

    private void moveToMoviesActivity(String email, String password) {
        textViewDisplayAccount
                .setText(new StringBuilder().append(email).append(", ").append(password).toString());
        Intent displayMoviesActivity =
                new Intent(MainActivity.this, MoviesActivity.class);

        startActivity(displayMoviesActivity);
    }

    private void invalidEmailLength() {
        editTextEmail.setError("Please add your email address");
        // Log.e <=> Log.error
        // Log.e(TAG, "email is empty"); // log valid
        Toast.makeText(
                MainActivity.this,
                "Email adress is not valid",
                Toast.LENGTH_SHORT
        ).show();
    }

    private void invalidEmailFormat(EditText editTextEmail, String Please_enter_valid_email, String msg) {
        editTextEmail.setError(Please_enter_valid_email);
        Log.e(TAG, msg);
    }

    /*
       ******** Boilerplate code **********
     */

    public EditText getEditTextEmail() {
        return editTextEmail;
    }

    public void setEditTextEmail(EditText editTextEmail) {
        this.editTextEmail = editTextEmail;
    }

    public EditText getEditTextPassword() {
        return editTextPassword;
    }

    public void setEditTextPassword(EditText editTextPassword) {
        this.editTextPassword = editTextPassword;
    }

    public TextView getTextViewDisplayAccount() {
        return textViewDisplayAccount;
    }

    public void setTextViewDisplayAccount(TextView textViewDisplayAccount) {
        this.textViewDisplayAccount = textViewDisplayAccount;
    }

    public Button getButtonDisplayAndroid() {
        return buttonDisplayAndroid;
    }

    public void setButtonDisplayAndroid(Button buttonDisplayAndroid) {
        this.buttonDisplayAndroid = buttonDisplayAndroid;
    }
}