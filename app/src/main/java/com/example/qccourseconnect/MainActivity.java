package com.example.qccourseconnect;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.qccourseconnect.fragments.ChatFragment;
import com.example.qccourseconnect.fragments.ParseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
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

}