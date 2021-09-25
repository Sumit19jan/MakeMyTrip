package com.example.makemytrip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;

import com.example.makemytrip.fragment.HomeFragment;
import com.example.makemytrip.fragment.MyTripFragment;
import com.example.makemytrip.fragment.OffersFragment;
import com.example.makemytrip.fragment.TripIdeasFragment;
import com.example.makemytrip.fragment.TripMoneyFragment;
import com.example.makemytrip.splashScreen.SplashScreen;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.flContainer, new HomeFragment()).commit();

        bottomNavigationView.setSelectedItemId(R.id.item1);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.item1:
                        fragment = new HomeFragment();
                        break;
                    case R.id.item2:
                        fragment = new MyTripFragment();
                        break;
                    case R.id.item3:
                        fragment = new OffersFragment();
                        break;
                    case R.id.item4:
                        fragment = new TripIdeasFragment();
                        break;
                    case R.id.item5:
                        fragment = new TripMoneyFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.flContainer,fragment).commit();
                return true;
            }
        });
    }
}