package com.example.qccourseconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnSignup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);

        etPassword = findViewById(R.id.etPassword);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                login(username, password);
            }
        });


    } // end onCreate()


    private void login(String username, String password) {
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e != null) {
                    Log.e(TAG, "Issue with login" + e);
                    e.printStackTrace();
                    return;
                }
                // navigate to new activity if the user has logged in properly
                goMainActivity();
            }
        });
    } // end login()


    private void goMainActivity() {
        Log.d(TAG, "Navigating to Main Activity");
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish(); // remove loginactivity from backstack
    } // end goMainActivity()


    private void signup(String username, String password) {
        ParseUser user = new ParseUser();

        user.setUsername(username);
        user.setPassword(password);
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null) {
                    Log.d(TAG, "Sign up successful");
                    Toast.makeText(LoginActivity.this, "Sign up successful!", Toast.LENGTH_SHORT).show();
                    goMainActivity();
                } else {
                    Log.e(TAG, "Problem with sign up");
                    return;
                }
            }
        });
    } // end goSignupActivity()


} // end class: LoginActivity