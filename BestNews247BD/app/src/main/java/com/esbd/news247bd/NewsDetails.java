package com.esbd.news247bd;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NewsDetails extends AppCompatActivity {
    ImageView newsCover;
    TextView newsTitle, newsDesc;
    FloatingActionButton fabBtn;


    public static String Title="";
    public static String Description="";
    public static Bitmap MyImageBitMap=null;

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
//        =======================

        newsCover = findViewById(R.id.newsCover);
        newsTitle = findViewById(R.id.newsTitle);
        newsDesc = findViewById(R.id.newsDesc);
        fabBtn = findViewById(R.id.fabBtn);

        newsTitle.setText(Title);
        newsDesc.setText(Description);
        if (MyImageBitMap != null){
            newsCover.setImageBitmap(MyImageBitMap);
        }

        textToSpeech = new TextToSpeech(NewsDetails.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });

        fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = newsDesc.getText().toString();
                textToSpeech.speak(text, textToSpeech.QUEUE_FLUSH, null, null);
            }
        });



//        =======================
//        =======================
    }
}