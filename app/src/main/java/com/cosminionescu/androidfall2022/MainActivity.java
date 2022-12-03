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

        editTextEmail = findViewById(R.id.editTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonDisplayAndroid = findViewById(R.id.buttonAboutAndroid);
        buttonDisplayAndroid.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent moveFromMainToAboutAndroid =
                        new Intent(MainActivity.this, AboutAndroid.class);
                startActivity(moveFromMainToAboutAndroid);
            }
        });

        textViewDisplayAccount = findViewById(R.id.textViewDisplayAccount);
        textViewDisplayAccount.setOnClickListener(this::loginOnClick);
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
            } else {
                editTextEmail.setError("Please enter valid email");
                Log.e(TAG, "email doesn't have a valid format");
            }
        } else if (email.length() <= 0) {
            editTextEmail.setError("Please add your email address");
            // Log.e <=> Log.error
            // Log.e(TAG, "email is empty"); // log valid
            Toast.makeText(
                            MainActivity.this,
                            "Email adress is not valid",
                            Toast.LENGTH_SHORT
                    ).show();
        } else if (password.length() <= 0) {
            editTextPassword.setError("Please add your password");
            Log.e(TAG, "password is empty");
        }
    }
}