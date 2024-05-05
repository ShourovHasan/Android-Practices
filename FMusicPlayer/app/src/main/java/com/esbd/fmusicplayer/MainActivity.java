package com.esbd.fmusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgPlay1;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imgPlay1 = findViewById(R.id.imgPlay1);

        imgPlay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(imgPlay1.getTag() != null && imgPlay1.getTag().toString().contains("NOT_PLAYING")){
                    if (mediaPlayer != null) mediaPlayer.release();

                    mediaPlayer = mediaPlayer.create(MainActivity.this, R.raw.iphone_ringtone);
                    mediaPlayer.start();
                    imgPlay1.setImageResource(R.drawable.pause);
                    imgPlay1.setTag("PLAYING");

                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            imgPlay1.setImageResource(R.drawable.play);
                            imgPlay1.setTag("NOT_PLAYING");
                        }
                    });
                } else {
                    if (mediaPlayer != null) mediaPlayer.release();
                    imgPlay1.setImageResource(R.drawable.play);
                    imgPlay1.setTag("NOT_PLAYING");
                }

            }
        });

    }
}