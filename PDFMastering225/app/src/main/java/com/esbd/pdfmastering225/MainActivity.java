package com.esbd.pdfmastering225;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;

public class MainActivity extends AppCompatActivity {
    PDFView pdfView;
    LottieAnimationView animationView;
    public static String assetName = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pdfView = findViewById(R.id.pdfView);
        animationView = findViewById(R.id.animationView);

        pdfView.setVisibility(View.INVISIBLE);
        animationView.setVisibility(View.VISIBLE);

        pdfView.fromAsset(assetName)
                .onLoad(new OnLoadCompleteListener() {
                    @Override
                    public void loadComplete(int nbPages) {
                        pdfView.setVisibility(View.VISIBLE);
//                        Toast.makeText(MainActivity.this, "Loaded", Toast.LENGTH_SHORT).show();
                        animationView.setVisibility(View.GONE);
                    }
                })
                .load();

    }
}