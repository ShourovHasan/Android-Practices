package com.esbd.news247bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    HashMap<String, String> hashMap = new HashMap<>();
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ============================
        listView = findViewById(R.id.listView);

        createTable();


        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);




//        ============================
//        ============================
    }
//        ============================
//        ============================
private class MyAdapter extends BaseAdapter{

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
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myView = layoutInflater.inflate(R.layout.news_item, parent, false);

        ImageView tvCover = myView.findViewById(R.id.tvCover);

        TextView tvCategory = myView.findViewById(R.id.tvCategory);
        TextView tvTitle = myView.findViewById(R.id.tvTitle);
        TextView tvDescription = myView.findViewById(R.id.tvDescription);
        LinearLayout layItem = myView.findViewById(R.id.layItem);

        HashMap<String, String> hashMap = arrayList.get(position);
        String category = hashMap.get("category");
        String title = hashMap.get("title");
        String img_url = hashMap.get("img_url");
        String description = hashMap.get("description");

        Picasso.get().load(img_url)
                .placeholder(R.drawable.boy)
                .into(tvCover);
        tvCategory.setText(category);
        tvTitle.setText(title);
        tvDescription.setText(description);

        //for random background color of those categories
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        tvCategory.setBackgroundColor(color);

        layItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsDetails.Title = title;
                NewsDetails.Description = description;

                Bitmap bitmap = ((BitmapDrawable) tvCover.getDrawable()).getBitmap();
                NewsDetails.MyImageBitMap = bitmap;

                startActivity(new Intent(MainActivity.this, NewsDetails.class));
            }
        });


        return myView;
    }
}


//        ============================
//        ============================

private void createTable(){
        hashMap = new HashMap<>();
        hashMap.put("category", "Tech");
        hashMap.put("title", "১৩ কোটিতে সিম্ফনি");
        hashMap.put("img_url", "https://techzoom.tv/wp-content/uploads/2024/02/Symphony-PR-2402170800-350x250.jpg");
        hashMap.put("description", "বাংলাদেশের সবচাইতে বেশী বিক্রিত হ্যান্ডসেট ব্র্যান্ড সিম্ফনি মোবাইল ১৩ কোটি তম গ্রাহকের মাইলফলক স্পর্শ করেছে। বরিশালের মাধবপাশা গ্রামের মোঃ জাহিদ বরিশাল শহরে অবস্থিত হ্যালো নেক্সট নামক মোবাইল ফোনের দোকান থেকে Symphony Z60 Plus ফোন টি ক্রয় করার মাধ্যমে সিম্ফনি মোবাইলের ১৩ কোটি তম গ্রাহক হয়ে যান। এ উপলক্ষে সিম্ফনি মোবাইলের ম্যানেজিং ডিরেক্টর জাকারিয়া শাহিদ নিজেই বরিশালের মাধবপাশা গ্রামে গিয়ে ১৩ কোটি তম গ্রাহক মোঃ জাহিদের হাতে শুভেচ্ছা উপহার তুলে দেন।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("category", "Game");
        hashMap.put("title", "জয়সোয়ালের দিনে ছক্কার সঙ্গে জয়ের রেকর্ড ভারতের");
        hashMap.put("img_url", "https://images.prothomalo.com/prothomalo-bangla%2F2024-02%2Fb8dba892-5fcb-4b5d-802b-50782704f3ea%2F2024_02_18T080315Z_1961473799_UP1EK2I0MDD3Q_RTRMADP_3_CRICKET_TEST_IND_ENG.JPG?rect=0%2C0%2C3126%2C1758&auto=format%2Ccompress&fmt=webp&format=webp&w=640&dpr=1.0");
        hashMap.put("description", "রাজকোটে দাপুটে এক দিনে ইংল্যান্ডকে গুঁড়িয়ে দিয়ে সিরিজে এগিয়ে গেছে ভারত। যে ম্যাচে দেখা গেছে বেশ কিছু রেকর্ড—\n" +
                "\n" +
                "রানের হিসাবে ভারতের বৃহত্তম জয়। আগের সর্বোচ্চ ছিল ২০২১ সালে নিউজিল্যান্ডের বিপক্ষে ওয়াংখেড়েতে। ভারত সেবার জিতেছিল ৩৭২ রানে।\n");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("category", "Trending");
        hashMap.put("title", "সিলেটে পিনাকী ভট্টাচার্যের বিরুদ্ধে সাইবার নিরাপত্তা আইনে মামলা");
        hashMap.put("img_url", "https://images.prothomalo.com/prothomalo-bangla%2F2024-02%2Ffb20fe35-475a-4c58-8e0c-9ff2b87ff82a%2Fpinaki_vottacharya_01.jpg?auto=format%2Ccompress&fmt=webp&format=webp&w=300&dpr=1.0");
        hashMap.put("description", "বিদেশে অবস্থানরত লেখক ও অনলাইন অ্যাকটিভিস্ট পিনাকী ভট্টাচার্যের বিরুদ্ধে সিলেটে সাইবার নিরাপত্তা আইনে মামলা হয়েছে। রোববার দুপুরে সিলেটের সাইবার ট্রাইব্যুনালের বিচারক মো. মনির কামালের আদালতে বাংলাদেশ মুক্তিযুদ্ধ মঞ্চ সিলেট জেলা শাখার সহসভাপতি আবদুর রহমান এ মামলা করেন। মামলায় পিনাকী ভট্টাচার্যসহ সাতজনের বিরুদ্ধে প্রধানমন্ত্রীর ছবি বিকৃত করা এবং জাতির জনক বঙ্গবন্ধু শেখ মুজিবুর রহমান, প্রধানমন্ত্রী শেখ হাসিনা ও তাঁর ভাই শেখ কামালকে নিয়ে মিথ্যা বানোয়াট, কুরুচিপূর্ণ ও কাল্পনিক ভিডিও সম্পাদনা করে ছাড়ানোর অভিযোগ আনা হয়।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("category", "Tips");
        hashMap.put("title", "ডায়াবেটিস রয়েছে এদিকে শখ হয়েছে ট্যাটু করানোর, কোনটা বাছবেন?");
        hashMap.put("img_url", "https://images.tv9bangla.com/wp-content/uploads/2024/02/Tattoos.jpeg?w=280&ar=16:9");
        hashMap.put("description", "যদি ত্বকের ফোলাভাব লালভাব না কমে দু দিন পর, ত্বকে চুলকানি অস্বস্তি বাড়ে তাহলে চিকিৎসকের পরামর্শ নিন। এর সঙ্গে যদি ব্যথা, জ্বর, ঠান্ডা লাগা এবং কোনও রকম রঙিন কোনও কিছু নিষ্কাশিত হতে থাকে তাহলে সাবধান। তবে ডায়াবেটিসে বডি আ্রট করাবেন না, কোনও জটিল ট্যাটু করাবেন না। তবে গোড়ালিস পা, নিতম্ব কিংবা পিঠে ট্যাটু করাবেন না। করতে হলে হাতে করুন ট্যাটু অনেকেরই খুব পছন্দের। ফ্যাশনের অন্যতম পার্টও বটে। এই জেনরেশনের মধ্যে যেমন ট্যাটুর ক্রেজ বেড়েছে তেমনই মধ্যবয়সীদেরও বেশ পছন্দ ট্যাটু।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("category", "Money");
        hashMap.put("title", "গ্রাহকের ২০ কোটি টাকা নিয়ে বিদেশে পালাচ্ছিলেন এনজিও মালিক");
        hashMap.put("img_url", "https://images.prothomalo.com/prothomalo-bangla%2F2024-02%2Fa68d395d-c105-4598-b05b-025485a371d3%2FScreenshot_2024_02_18_192822.png?rect=0%2C0%2C864%2C486&auto=format%2Ccompress&fmt=webp&format=webp&w=640&dpr=1.0");
        hashMap.put("description", "নওগাঁয় এনজিও খুলে প্রতারণার অভিযোগে ছয় ব্যক্তিকে গ্রেপ্তার করা হয়েছে। গতকাল শনিবার দিবাগত রাতে নারায়ণগঞ্জের রূপগঞ্জ থানার তারাব বাসস্ট্যান্ড ও নওগাঁ জেলার বিভিন্ন এলাকা থেকে তাঁদের গ্রেপ্তার করে র\u200D্যাব-৫-এর একটি দল। আজ রোববার দুপুরে নওগাঁ সার্কিট হাউস মিলনায়তনে এক সম্মেলনে এসব তথ্য জানান র\u200D্যাব-৫-এর অধিনায়ক লেফটেন্যান্ট কর্নেল মুনীম ফেরদৌস।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("category", "Jobs");
        hashMap.put("title", "পরিবেশ, বন ও জলবায়ু পরিবর্তন মন্ত্রণালয় নিয়োগ");
        hashMap.put("img_url", "https://www.banglacyber.com/wp-content/uploads/2021/09/MOEF-Job-circular-696x392.jpg");
        hashMap.put("description", "পরিবেশ, বন ও জলবায়ু পরিবর্তন মন্ত্রণালয়ের শূন্য পদসমূহে জনবল নিয়োগ দেয়া হবে। পরিবেশ, বন ও জলবায়ু পরিবর্তন মন্ত্রণালয় ০৪ টি পদে মোট ২৬ জনকে নিয়োগ দেবে। পদগুলোতে নারী ও পুরুষ উভয়েই আবেদন করতে পারবেন। আগ্রহী প্রার্থীরা অনলাইনে আবেদন করতে পারবেন। আগ্রহ ও যোগ্যতা থাকলে আপনিও আবেদন করতে পারেন। সম্পূর্ণ বিজ্ঞপ্তি বিস্তারিত দেওয়া হল।");
        arrayList.add(hashMap);




//        =======================================
}

//        ============================

}