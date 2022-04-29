package com.hmdapps.sousou1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class CorrigeTajawoz extends AppCompatActivity {
    TextView txt;
    int r=40;
    int x=100;
    String[] corrigetajawoz = new String[]{"1","24","23","2","2","2","14","1","1","1","2","1","2","1","13","2","2","2","2","1","2",
            "1","2","2","1","1","1","1","2","14","13","1","2","2","1","2","2","14","23","1","13"};
    ImageView imageView1;
    int[] imagesTajawoz =new int[]{R.drawable.tajawos1,R.drawable.tajawos2,R.drawable.tajawos3,R.drawable.tajawos4,R.drawable.tajawos5,R.drawable.tajawos6,R.drawable.tajawos7,
            R.drawable.tajawos8,R.drawable.tajawos9,R.drawable.tajawos10,R.drawable.tajawos11,R.drawable.tajawos12,R.drawable.tajawos13,R.drawable.tajawos14,
            R.drawable.tajawos15,R.drawable.tajawos16,R.drawable.tajawos17,R.drawable.tajawos18,R.drawable.tajawos19,R.drawable.tajawos20,R.drawable.tajawos21,
            R.drawable.tajawos22,R.drawable.tajawos23,R.drawable.tajawos24,R.drawable.tajawos25,R.drawable.tajawos26,R.drawable.tajawos27,R.drawable.tajawos28,
            R.drawable.tajawos29,R.drawable.tajawos30,R.drawable.tajawos31,R.drawable.tajawos32,R.drawable.tajawos33,R.drawable.tajawos34,R.drawable.tajawos35,
            R.drawable.tajawos36,R.drawable.tajawos37,R.drawable.tajawos38,R.drawable.tajawos39,R.drawable.tajawos40};

    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corrige_tajawoz);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_tajawoz));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        imageView1=(ImageView)findViewById(R.id.imageView);
        txt=(TextView) findViewById(R.id.textView3);
        final ListView listView = findViewById(R.id.listview2);
        txt.setText("Résultat :");

        Intent myintent1 = getIntent();
        Bundle bundle = getIntent().getExtras();
        final ArrayList<String> resltasaaraba = bundle.getStringArrayList("arrayList");

        final ArrayAdapter<String> items = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,resltasaaraba);
        listView.setAdapter(items);
        Toast.makeText(getApplicationContext(),"اضغط على الجواب الخاطئ لترى التصحيح",Toast.LENGTH_LONG).show();

        for (int i=0; i<=39 ;i++){
            if (resltasaaraba.get(i).equals(corrigetajawoz[i])){
                resltasaaraba.set(i,"السؤال "+(i+1)+" : "+resltasaaraba.get(i)+"         ===>  صحيح "); }

            else { resltasaaraba.set(i, "السؤال "+(i+1)+" : "+resltasaaraba.get(i) +"         ===>  خطا الجواب الصحيح هو : "+"   "+ corrigetajawoz[i]);
                r=r-1;
            }
        }
        resltasaaraba.add("النتيجة : "+r+"/40");



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posotion, long id) {
                if(posotion!=x & posotion!=40){
                    x=posotion;
                    view.setSelected(true);
                    Toast.makeText(getApplicationContext(),"  السؤال "+(posotion+1)+" خاطئ  ",Toast.LENGTH_LONG).show();
                    imageView1.setImageResource(imagesTajawoz[posotion]);
                    imageView1.getBackground();
                }

            }});

    }

    public void replay(View view) {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
            Intent myintent1 =new Intent(this,MainActivity.class);
            startActivity(myintent1);
        }
    }
}