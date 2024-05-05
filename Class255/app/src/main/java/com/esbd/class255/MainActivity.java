package com.esbd.class255;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    ListView listView;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        listView = findViewById(R.id.listView);

        progressBar.setVisibility(View.VISIBLE);

        String url = "https://esbd.xyz/get_data.php";
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
                    progressBar.setVisibility(View.GONE);
                    try {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject jsonObject = response.getJSONObject(i);
                            HashMap<String, String> map = new HashMap<>();
                            map.put("id", String.valueOf(jsonObject.getInt("id")));
                            map.put("name", jsonObject.getString("name"));
                            map.put("mobile", jsonObject.getString("mobile"));
                            map.put("email", jsonObject.getString("email"));
                            arrayList.add(map);
                        }
                        MyAdapter myAdapter = new MyAdapter();
                        listView.setAdapter(myAdapter);
                    } catch (JSONException e) {
                        Log.e("MainActivity", "JSON Parsing error: " + e.getMessage());
                    }
                },
                error -> {
                    progressBar.setVisibility(View.GONE);
                    Log.e("MainActivity", "Volley Error: " + error.toString());
                }
        );
        queue.add(arrayRequest);
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

            HashMap<String, String> map = (HashMap<String, String>) getItem(position);
            tvId.setText(map.get("id"));
            tvName.setText(map.get("name"));
            tvMobile.setText(map.get("mobile"));
            tvEmail.setText(map.get("email"));
            return convertView;
        }
    }
}
