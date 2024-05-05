package com.esbd.shopcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDisplay;
    EditText edBuyingPrice, edSellPrice;
    Button buttonCalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//id declaration
        edBuyingPrice = findViewById(R.id.edBuyingPrice);
        edSellPrice = findViewById(R.id.edSellPrice);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        tvDisplay = findViewById(R.id.tvDisplay);

//
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float BuyingPrice, SellingPrice, profit, profitPercent;
                String ss_BuyingPrice = edBuyingPrice.getText().toString();
                BuyingPrice = Float.parseFloat(ss_BuyingPrice);

                String ss_SellingPrice = edSellPrice.getText().toString();
                SellingPrice = Float.parseFloat(ss_SellingPrice);

                profit = SellingPrice-BuyingPrice;
                profitPercent = ((profit/BuyingPrice)*100);

                tvDisplay.setText("Buying Price: "+BuyingPrice+"\nSelling Price: "+SellingPrice+"\nProfit is: "+profit+" tk"+"\nProfit in Percent: "+String.format("%.2f", profitPercent)+"%");

            }
        });













    }
}