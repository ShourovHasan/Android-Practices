package com.esbd.condition;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edText;
    Button btnCalculate;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edText = findViewById(R.id.edText);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvDisplay = findViewById(R.id.tvDisplay);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_edText = edText.getText().toString();

                if (s_edText.length() == 11){
                    float myNumber = Float.parseFloat(s_edText);
                    if (myNumber%2 == 0){
                        Toast.makeText(MainActivity.this, myNumber+" is Even number.", Toast.LENGTH_LONG).show();
                        tvDisplay.setText("You input number is: Even");
                    } else {
                        Toast.makeText(MainActivity.this, myNumber+" is Odd number.", Toast.LENGTH_LONG).show();
                        tvDisplay.setText("You input number is: Odd");
                    }
                }
                else {
                    edText.setError("Please enter 11 digit mobile number");
                    Toast.makeText(MainActivity.this, "Please enter valid mobile number", Toast.LENGTH_LONG).show();
                }


            }
        });









    }
}