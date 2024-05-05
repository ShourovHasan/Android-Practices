package com.esbd.a263;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    EditText edName, edMobile, edEmail;
    Button buttonInsert;
    ListView listView;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        edName = findViewById(R.id.edName);
        edMobile = findViewById(R.id.edMobile);
        edEmail = findViewById(R.id.edEmail);
        buttonInsert = findViewById(R.id.buttonInsert);
        listView = findViewById(R.id.listView);
        requestQueue = Volley.newRequestQueue(MainActivity.this);

        loadData();

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isValid = validateFields();
                if (isValid) {
                    insertData();
                }
            }
        });
    }

    private void loadData() {
        String url = "https://esbd.xyz/get_data.php";
        progressBar.setVisibility(View.VISIBLE);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            progressBar.setVisibility(View.GONE);
            arrayList.clear(); // Clear old data
            try {
                for (int i = 0; i < response.length(); i++) {
                    JSONObject jsonObject = response.getJSONObject(i);
                    HashMap<String, String> map = new HashMap<>();
                    map.put("id", jsonObject.getString("id"));
                    map.put("name", jsonObject.getString("name"));
                    map.put("mobile", jsonObject.getString("mobile"));
                    map.put("email", jsonObject.getString("email"));
                    arrayList.add(map);
                }
                updateListView();
            } catch (JSONException e) {
                Log.e("MainActivity", "JSON Parsing error: " + e.getMessage());
            }
        }, error -> {
            progressBar.setVisibility(View.GONE);
            Log.e("MainActivity", "Volley Error: " + error.toString());
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void insertData() {
        String name = edName.getText().toString().trim();
        String mobile = edMobile.getText().toString().trim();
        String email = edEmail.getText().toString().trim();
        String url = "https://esbd.xyz/data.php?n=" + name + "&m=" + mobile + "&e=" + email;

        progressBar.setVisibility(View.VISIBLE);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response -> {
            progressBar.setVisibility(View.GONE);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Server Response")
                    .setMessage(response)
                    .show();
            loadData(); // Refresh the list
        }, error -> {
            progressBar.setVisibility(View.GONE);
            Log.e("MainActivity", "Volley Error: " + error.toString());
        });
        requestQueue.add(stringRequest);
    }

    private void updateListView() {
        if (arrayList.size() > 0) {
            MyAdapter myAdapter = new MyAdapter();
            listView.setAdapter(myAdapter);

            edName.setText("");
            edMobile.setText("");
            edEmail.setText("");
        }
    }

    private boolean validateFields() {
        boolean isValid = true;
        if (edName.getText().toString().trim().isEmpty()) {
            edName.setError("Name is required");
            isValid = false;
        }
        if (edMobile.getText().toString().trim().isEmpty()) {
            edMobile.setError("Mobile is required");
            isValid = false;
        }
        if (edEmail.getText().toString().trim().isEmpty()) {
            edEmail.setError("Email is required");
            isValid = false;
        }
        return isValid;
    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = convertView == null ? LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false) : convertView;
            TextView tvId = convertView.findViewById(R.id.tvId);
            TextView tvName = convertView.findViewById(R.id.tvName);
            TextView tvMobile = convertView.findViewById(R.id.tvMobile);
            TextView tvEmail = convertView.findViewById(R.id.tvEmail);
            Button buttonUpdate = convertView.findViewById(R.id.buttonUpdate);
            Button buttonDelete = convertView.findViewById(R.id.buttonDelete);


            HashMap<String, String> map = (HashMap<String, String>) getItem(position);
            tvId.setText(map.get("id"));
            tvName.setText(map.get("name"));
            tvMobile.setText(map.get("mobile"));
            tvEmail.setText(map.get("email"));




//            ==========================
            buttonUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    progressBar.setVisibility(View.VISIBLE);
                    //update data
                    String name = edName.getText().toString();
                    String mobile = edMobile.getText().toString();
                    String email = edEmail.getText().toString();
                    String url = "https://esbd.xyz/update_data.php?id="+map.get("id")+ "&n=" + name + "&m=" + mobile + "&e=" + email;


                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressBar.setVisibility(View.GONE);

                            new AlertDialog.Builder(MainActivity.this)
                                    .setTitle("Server Response")
                                    .setMessage(response)
                                    .show();

                            loadData();

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressBar.setVisibility(View.GONE);

                        }
                    });
                    requestQueue.add(stringRequest);

                }
            });
//            ==========================
            buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    progressBar.setVisibility(View.VISIBLE);
                    //Delete data
                    String url = "https://esbd.xyz/delete_data.php?id="+map.get("id");


                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressBar.setVisibility(View.GONE);

                            new AlertDialog.Builder(MainActivity.this)
                                    .setTitle("Server Response")
                                    .setMessage(response)
                                    .show();

                            loadData();

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressBar.setVisibility(View.GONE);

                        }
                    });
                    requestQueue.add(stringRequest);

                }
            });













            return convertView;
        }
    }
}
