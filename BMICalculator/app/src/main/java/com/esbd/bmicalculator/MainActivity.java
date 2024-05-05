package com.esbd.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edWeight, edHeightFeet, edHeightInch;
    Button btnBMICalculate;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // for id introduce
        edWeight = findViewById(R.id.edWeight);
        edHeightFeet = findViewById(R.id.edHeightFeet);
        edHeightInch = findViewById(R.id.edHeightInch);
        btnBMICalculate = findViewById(R.id.btnBMICalculate);
        tvDisplay = findViewById(R.id.tvDisplay);

        btnBMICalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_edWeight, s_edHeightFeet, s_edHeightInch;
                float Weight, HeightFeet, HeightInch;

                s_edWeight = edWeight.getText().toString();
                s_edHeightFeet = edHeightFeet.getText().toString();
                s_edHeightInch = edHeightInch.getText().toString();

                if(s_edWeight.length() > 0 && s_edHeightFeet.length() > 0 && s_edHeightInch.length() > 0) {
                    Weight = Float.parseFloat(s_edWeight);
                    HeightFeet = Float.parseFloat(s_edHeightFeet);
                    HeightInch = Float.parseFloat(s_edHeightInch);

                    float Height = (float) ((HeightFeet * 0.3048) + (HeightInch * 0.0254));
                    float bmiIndex = Weight / (Height * Height);

                    if (bmiIndex > 24) {
                        tvDisplay.setText("Your BMI Index is: " + String.format("%.2f", bmiIndex) + "\n Bhai tumi mota");
                    } else if (bmiIndex > 18) {
                        tvDisplay.setText("Your BMI Index is: " + String.format("%.2f", bmiIndex) + "\n Bhai perfect");
                    } else {
                        tvDisplay.setText("Your BMI Index is: " + String.format("%.2f", bmiIndex) + "\n Bhai tumi underweight, beshi beshi khau");

                    }
                }
                else{
                    edWeight.setError("Please input your weight");
                    edHeightFeet.setError("Please input your height in feet");
                    edHeightInch.setError("Please input your  height in Inch");
                    Toast.makeText(MainActivity.this, "Please input all fields", Toast.LENGTH_SHORT).show();
                }


            }
        });




    }
}