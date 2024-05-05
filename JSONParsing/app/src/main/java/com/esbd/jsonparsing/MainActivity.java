package com.esbd.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button buttonLoad;
    TextView tvName, tvMobile, tvEmail, tvAddress;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        [====================]
        buttonLoad = findViewById(R.id.buttonLoad);
        tvName = findViewById(R.id.tvName);
        tvMobile = findViewById(R.id.tvMobile);
        tvEmail = findViewById(R.id.tvEmail);
        tvAddress = findViewById(R.id.tvAddress);
        progressBar = findViewById(R.id.progressBar);



        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);

                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "https://esbd24.000webhostapp.com/apps/person.json";

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                progressBar.setVisibility(View.GONE);
//                                Log.d("ServerRes:", response);
                                try {
                                    JSONObject jsonObject = new JSONObject(response);

                                    String name = jsonObject.getString("name");
                                    String mobile = jsonObject.getString("mobile");
                                    String email = jsonObject.getString("email");
                                    String address = jsonObject.getString("address");

                                    tvName.setText(name);
                                    tvMobile.setText(mobile);
                                    tvEmail.setText(email);
                                    tvAddress.setText(address);



                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }


                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        buttonLoad.setText("Volley didn't work!");
                        progressBar.setVisibility(View.GONE);
                    }
                });

// Add the request to the RequestQueue.
                queue.add(stringRequest);



            }
        });



//        =====================


    }
}