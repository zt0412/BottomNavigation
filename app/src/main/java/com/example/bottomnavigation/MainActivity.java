package com.example.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // nav view
        BottomNavigationView bottomNavView = findViewById(R.id.bottonNavView);
        // nav host
        NavController navController = Navigation.findNavController(this, R.id.fragment);
        // AppBarConfiguration
        AppBarConfiguration configuration = new AppBarConfiguration.Builder(bottomNavView.getMenu()).build();
        // NavigationUI
        NavigationUI.setupActionBarWithNavController(this, navController, configuration);
        NavigationUI.setupWithNavController(bottomNavView, navController);
    }
}
