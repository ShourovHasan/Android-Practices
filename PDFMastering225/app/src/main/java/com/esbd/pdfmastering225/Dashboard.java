package com.esbd.pdfmastering225;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    Button book1, book2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        book1 = findViewById(R.id.book1);
        book2 = findViewById(R.id.book2);

        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.assetName = "bgs.pdf";
                Intent myIntent = new Intent(Dashboard.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
        book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.assetName = "thesis.pdf";
                Intent myIntent = new Intent(Dashboard.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}