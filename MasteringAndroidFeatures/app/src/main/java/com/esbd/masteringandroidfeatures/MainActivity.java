package com.esbd.masteringandroidfeatures;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edText;
    Button playBtn, alertBtn, exitBtn;
    TextToSpeech txtToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edText = findViewById(R.id.edText);
        playBtn = findViewById(R.id.playBtn);
        alertBtn = findViewById(R.id.alertBtn);
        exitBtn = findViewById(R.id.exitBtn);


        txtToSpeech = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_edText = edText.getText().toString();
                if(s_edText.length() > 0){
                    txtToSpeech.speak(s_edText, TextToSpeech.QUEUE_FLUSH,null, null);
                } else {
                    edText.setError("Please write something for make it into voice.");
                }
            }
        });


        alertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("This is a title")
                        .setMessage("Hello, Shourov")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                alertBtn.setText("Dialog Cancelled");
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                alertBtn.setText("Dialog Accepted");
                            }
                        })
                        .setNeutralButton("Okay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Hello! Welcome to ST App", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setCancelable(true)
                        .show();
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Confirm Exit!")
                        .setMessage("Do you really want to exit!")
                        .setIcon(R.drawable.alert)
                        .setPositiveButton("Yes, Exit!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
//                        finishAndRemoveTask();
                                finish();
                            }
                        })
                        .setNegativeButton("No thanks!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setCancelable(true)
                        .show();
            }
        });

    }


    //for system exit button
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Confirm Exit!")
                .setMessage("Do you really want to exit!")
                .setIcon(R.drawable.alert)
                .setPositiveButton("Yes, Exit!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finishAndRemoveTask();
//                        finish();
                    }
                })
                .setNegativeButton("No thanks!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(true)
                .show();
    }




}