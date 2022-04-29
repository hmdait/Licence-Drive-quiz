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

public class CorrigeAlwoqof extends AppCompatActivity {
    TextView txt;
    int r=40;
    int x=100;
    String[] corrigetajawoz = new String[]{"2","13","1","2","23","2","24","2","14","2","1","24","13","23","23","24","13","24","2","2","2",
            "2","14","3","23","2","24","2","23","13","24","1","2","24","2","23","12","3","24","23","2"};
    ImageView imageView1;

    int[] imageswoqof =new int[]{R.drawable.woqofs1,R.drawable.woqofs2,R.drawable.woqofs3,R.drawable.woqofs4,R.drawable.woqofs5,R.drawable.woqofs6,
            R.drawable.woqofs7,R.drawable.woqofs8,R.drawable.woqofs9,R.drawable.woqofs10,R.drawable.woqofs11,R.drawable.woqofs12,R.drawable.woqofs13,
            R.drawable.woqofs14,R.drawable.woqofs15,R.drawable.woqofs16,R.drawable.woqofs17,R.drawable.woqofs18,R.drawable.woqofs19,R.drawable.woqofs20,
            R.drawable.woqofs21,R.drawable.woqofs22,R.drawable.woqofs23,R.drawable.woqofs24,R.drawable.woqofs25,R.drawable.woqofs26,R.drawable.woqofs27,
            R.drawable.woqofs28,R.drawable.woqofs29,R.drawable.woqofs30,R.drawable.woqofs31,R.drawable.woqofs32,R.drawable.woqofs33,R.drawable.woqofs34,
            R.drawable.woqofs35,R.drawable.woqofs36,R.drawable.woqofs37,R.drawable.woqofs38,R.drawable.woqofs39,R.drawable.woqofs40,R.drawable.woqofs40};

    private InterstitialAd mInterstitialAd;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corrige_alwoqof);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_alworof));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());



        imageView1= findViewById(R.id.imageView);
        txt= findViewById(R.id.textView3);
        final ListView listView = findViewById(R.id.listview2);
        txt.setText("Résultat :");

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
                    imageView1.setImageResource(imageswoqof[posotion]);
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