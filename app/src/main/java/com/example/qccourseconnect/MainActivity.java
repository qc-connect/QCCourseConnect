package com.example.qccourseconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final ParseUser[] currentUser = {ParseUser.getCurrentUser()};
        if (currentUser[0] == null) {
            goLoginActivity();
        }
        final FragmentManager fragmentManager = getSupportFragmentManager();


/*
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch(menuItem.getItemId()){
                    case R.id.action_chat:

                        fragment = new ChatFragment();
                        Toast.makeText(MainActivity.this, "Home!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_parse:
                    default:
                        fragment = new ParseFragment();
                        Toast.makeText(MainActivity.this, "Compose!", Toast.LENGTH_SHORT).show();


                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.action_chat);*/
    }

    private void goLoginActivity() {
        Log.d(TAG, "Navigating to Login Activity");
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish(); // remove loginactivity from backstack
    } // end goMainActivity()


}