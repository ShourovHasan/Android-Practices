package com.esbd.section4sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//=================
    EditText edName;
    Button btnSave, btnNext;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
//==========================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//======================
        edName = findViewById(R.id.edName);
        btnSave = findViewById(R.id.btnSave);
        btnNext = findViewById(R.id.btnNext);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        editor = sharedPreferences.edit();
//===========================
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edName_s = edName.getText().toString();
                if (!edName_s.isEmpty()) {
                    editor.putString("u_name", edName_s);
                    editor.putInt("u_age", 18);
                    editor.apply();
                }
                else{
                    edName.setError("Please enter your name here.");
                }
            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));

            }
        });





//===========================
    }
}