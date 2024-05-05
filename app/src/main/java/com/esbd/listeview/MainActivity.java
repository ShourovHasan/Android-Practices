package com.esbd.listeview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    LayoutInflater layoutInflater;
    ArrayList <HashMap <String, String>> arrayList = new ArrayList();
    HashMap <String, String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        =================
        myListView = findViewById(R.id.myListView);

        hashMap = new HashMap<>();
        hashMap.put("name", "Shourov");
        hashMap.put("mobile", "0178655");
//        hashMap.put("email", "Shourov@gmail.com");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Hasan");
        hashMap.put("mobile", "01777");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Ahsan");
        hashMap.put("mobile", "01888");
        arrayList.add(hashMap);


        MyAdapter myAdapter = new MyAdapter();
        myListView.setAdapter(myAdapter);

//        =================
    }

//    ==================
private class MyAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myView;
        myView = layoutInflater.inflate(R.layout.item, parent, false);
        ImageView imageView = myView.findViewById(R.id.imageView);
        TextView textView = myView.findViewById(R.id.textView);
        TextView textView2 = myView.findViewById(R.id.textView2);

        HashMap<String, String> hashMap = arrayList.get(position);
        textView.setText(hashMap.get("name"));
        textView2.setText(hashMap.get("mobile"));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hello, "+hashMap.get("name"), Toast.LENGTH_SHORT).show();
            }
        });


//        if (convertView == null) {
//        } else {
//            myView = convertView;
//        }
        return myView;
    }
}


//    ===============================
}