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

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    @BindView (R.id.etUsername) EditText etUsername;
    @BindView(R.id.etPassword) EditText etPassword;
    @BindView(R.id.btnLogin) Button btnLogin;
    @BindView(R.id.btnSignup) Button btnSignup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                login(username, password);
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
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
                    Toast.makeText(getApplicationContext(),"Username or Password incorrect", Toast.LENGTH_LONG).show();
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


    private void signup() {
        Log.d(TAG, "Navigating to Register Activity");
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
        finish();
    } // end goSignupActivity()


} // end class: LoginActivity