package com.esbd.a276;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Button badgeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ====================================
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        badgeBtn = findViewById(R.id.badgeBtn);
//        ====================================
        badgeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomNavigationView.getOrCreateBadge(R.id.profile).setNumber(10);
                bottomNavigationView.getOrCreateBadge(R.id.notification).clearNumber();
            }
        });

        bottomNavigationView.getOrCreateBadge(R.id.notification).setNumber(12);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.home){
                    Toast.makeText(getApplicationContext(), "From Home", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId()==R.id.notification) {
                    Toast.makeText(getApplicationContext(), "From Notification", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId()==R.id.profile) {
                    Toast.makeText(getApplicationContext(), "From Profile", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });
//        ====================================
//        ====================================
//        ====================================

    }
}