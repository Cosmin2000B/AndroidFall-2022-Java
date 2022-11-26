package com.cosminionescu.androidfall2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewDisplayAccount;


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

        textViewDisplayAccount = findViewById(R.id.textViewDisplayAccount);
        textViewDisplayAccount.setOnClickListener(this::loginOnClick);
    }

    public void loginOnClick(View view) {

        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        textViewDisplayAccount.setText(
                new StringBuilder()
                        .append(email)
                        .append(" ")
                        .append(password)
        );
    }
}