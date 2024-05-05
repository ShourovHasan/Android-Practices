package com.esbd.section4sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView tvDisplay;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvDisplay = findViewById(R.id.tvDisplay);
        sharedPreferences = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);

        String name = sharedPreferences.getString("u_name", "Ahsan");
        Integer age = sharedPreferences.getInt("u_age", 20);
        tvDisplay.setText(name+"\n"+age);
        Toast.makeText(this, name+"\n"+age, Toast.LENGTH_SHORT).show();
//        Toast.makeText(MainActivity2.this, name, Toast.LENGTH_SHORT).show();


    }
}