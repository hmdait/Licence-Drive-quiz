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

public class CorrigeAsbaqia extends AppCompatActivity {
    TextView txt;
    int r=40;
    int x=100;
    String[] corrigeasbaqia = new String[]{"2","2","2","2","23","2","2","2","1","2","1","234","23","2","2","14","1","3","2","2","3",
            "2","13","1","1","2","2","2","134","1","23","2","2","2","23","2","1","1","13","3","3"};
    ImageView imageView1;
    int[] imagesAsbaqia =new int[]{R.drawable.asbaqias1,R.drawable.asbaqias2,R.drawable.asbaqias3,R.drawable.asbaqias4,R.drawable.asbaqias5
            ,R.drawable.asbaqias6,R.drawable.asbaqias7,R.drawable.asbaqias8,R.drawable.asbaqias9,R.drawable.asbaqias10,R.drawable.asbaqias11,R.drawable.asbaqias12
            ,R.drawable.asbaqias13,R.drawable.asbaqias14,R.drawable.asbaqias15,R.drawable.asbaqias16,R.drawable.asbaqias17,R.drawable.asbaqias18
            ,R.drawable.asbaqias19,R.drawable.asbaqias20,R.drawable.asbaqias21,R.drawable.asbaqias22,R.drawable.asbaqias23,R.drawable.asbaqias24
            ,R.drawable.asbaqias25,R.drawable.asbaqias26,R.drawable.asbaqias27,R.drawable.asbaqias28,R.drawable.asbaqias29,R.drawable.asbaqias30
            ,R.drawable.asbaqias31,R.drawable.asbaqias32,R.drawable.asbaqias33,R.drawable.asbaqias34,R.drawable.asbaqias35,R.drawable.asbaqias36
            ,R.drawable.asbaqias37,R.drawable.asbaqias38,R.drawable.asbaqias39,R.drawable.asbaqias40,R.drawable.asbaqias40};

    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corrige_asbaqia);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_asbaqia));
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
            if (resltasaaraba.get(i).equals(corrigeasbaqia[i])){
                resltasaaraba.set(i,"السؤال "+(i+1)+" : "+resltasaaraba.get(i)+"         ===>  صحيح "); }

            else { resltasaaraba.set(i, "السؤال "+(i+1)+" : "+resltasaaraba.get(i) +"         ===>  خطا الجواب الصحيح هو : "+"   "+ corrigeasbaqia[i]);
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
                    imageView1.setImageResource(imagesAsbaqia[posotion]);
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