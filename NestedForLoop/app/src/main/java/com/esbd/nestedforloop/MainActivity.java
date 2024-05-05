package com.esbd.nestedforloop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    String[] names={
            "Shourov",
            "Hasan",
            "Raju"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //=====================
        tvDisplay = findViewById(R.id.tvDisplay);

        for (int x=0; x<names.length; x++) {
            tvDisplay.append(" "+names[x]+"\n");
        }



//        int number = 26;

//        for (int x=2; x<number; x++){
//
//            if(number%x==0){
//                tvDisplay.setText(number+" is not a prime number");
//                break;
//            } else{
//                tvDisplay.setText(number+" is a prime number");
//            }
//        }
//        for (int x=1; x<=10; x++){
//
//            for (int y=1; y<=x; y++){
//                tvDisplay.append(" * ");
//            }
//            tvDisplay.append("\n");
//        }

    }//==================
}