package com.esbd.androidanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    Button button1;
    ImageView imageView;
    Animation myAnim;
    LottieAnimationView lottieView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button1 = findViewById(R.id.button1);
        imageView = findViewById(R.id.imageView);
        myAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.my_anim);
        lottieView = findViewById(R.id.lottieView);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.startAnimation(myAnim);
                lottieView.setAnimation(R.raw.gift);
                lottieView.playAnimation();
            }
        });

//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                lottieView.setAnimation(R.raw.gift);
//            }
//        });


    }
}