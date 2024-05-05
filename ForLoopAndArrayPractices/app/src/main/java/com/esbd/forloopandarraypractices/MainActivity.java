package com.esbd.forloopandarraypractices;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputStart, inputEnd;
    Button evenBtn;
    TextView evenDisplay;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //===========================
        inputStart = findViewById(R.id.inputStart);
        inputEnd = findViewById(R.id.inputEnd);
        evenBtn = findViewById(R.id.evenBtn);
        evenDisplay = findViewById(R.id.evenDisplay);

        evenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputStart_s = inputStart.getText().toString();
                String inputEnd_s = inputEnd.getText().toString();

                evenDisplay.setText("");
                if(inputStart_s.length()==4 && inputEnd_s.length()==4){
                    int initialNumber = Integer.parseInt(inputStart_s);
                    int targetNumber = Integer.parseInt(inputEnd_s);

                    for (int year=initialNumber; year<=targetNumber; year++){
                        if (year%400==0 || (year%4==0 && year%100!=0)){
                            evenDisplay.append("\nThe "+year+" is Leap Year");
                        }
                    }


//                    for (int x=initialNumber; x<=targetNumber; x++){
//                        if (x%2==0){
//                            evenDisplay.append("\nEven number: " + x);
//                        } else{
//                            continue;
//                        }
//                    }

                } else {
                    if (inputStart_s.length()!=4){
                        inputStart.setError("Please Enter the starting year.");
                    }
                    if(inputEnd_s.length()!=4){
                        inputEnd.setError("Please Enter the ending year.");
                    }
                }
            }
        });
//        evenBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                evenDisplay.setText(""); // Clear previous results
//                String inputStart_s = inputStart.getText().toString();
//                String inputEnd_s = inputEnd.getText().toString();
//
//                if(!inputStart_s.isEmpty() && !inputEnd_s.isEmpty()){
//                    int numberFrom = Integer.parseInt(inputStart_s);
//                    int numberTo = Integer.parseInt(inputEnd_s);
//
//                    for (int x = numberFrom; x <= numberTo; x++){
//                        if (x % 2 == 0) {
//                            evenDisplay.append("Even number: " + x + "\n");
//                        }
//                    }
//                } else {
//                    if (inputStart_s.isEmpty()){
//                        inputStart.setError("Please Enter the starting number.");
//                    }
//                    if(inputEnd_s.isEmpty()){
//                        inputEnd.setError("Please Enter the ending number.");
//                    }
//                }
//            }
//        });

    }//========================
}
//        for (int x=1; x<=50; x++){
//            factorial = factorial*x;
//            tvDisplay.append("Factorial of "+x+" is:" +factorial+"\n");
//        }
//        for (int x=1; x<=10; x++){
//            mul = 5*x;
//            tvDisplay.append("5*"+x+" = "+mul+"\n");
//        }
//        for (int x=1; x<=100; x++){
//            sum = sum+x;
////            if(x==5) break;
//            tvDisplay.append(" "+sum);
//        }
//        tvDisplay.append("\n \n 1+2+...+100 = "+sum);

