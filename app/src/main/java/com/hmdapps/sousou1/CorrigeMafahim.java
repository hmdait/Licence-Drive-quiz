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

public class CorrigeMafahim extends AppCompatActivity {
    TextView txt;
    int r=40;
    int x=100;
    String[] corrigeasbaqia = new String[]{"1","1","1","2","3","1","1","23","2","3","2","2","1","2","24","2","1","3","3","2",
            "1","3","1","3","2","2","2","23","2","2","1","1","1","2","2","2","24","1","2","12","12"};
    ImageView imageView1;

    int[] imagesMafahims =new int[]{R.drawable.mafahims1,R.drawable.mafahims2,R.drawable.mafahims3,R.drawable.mafahims4,R.drawable.mafahims5
            ,R.drawable.mafahims6,R.drawable.mafahims7,R.drawable.mafahims8,R.drawable.mafahims9,R.drawable.mafahims10,R.drawable.mafahims11
            ,R.drawable.mafahims12,R.drawable.mafahims13,R.drawable.mafahims14,R.drawable.mafahims15,R.drawable.mafahims16,R.drawable.mafahims17,
            R.drawable.mafahims18,R.drawable.mafahims19,R.drawable.mafahims20,R.drawable.mafahims21,R.drawable.mafahims22,R.drawable.mafahims23
            ,R.drawable.mafahims24,R.drawable.mafahims25,R.drawable.mafahims26,R.drawable.mafahims27,R.drawable.mafahims28,R.drawable.mafahims29
            ,R.drawable.mafahims30,R.drawable.mafahims31,R.drawable.mafahims32,R.drawable.mafahims33,R.drawable.mafahims34,R.drawable.mafahims35
            ,R.drawable.mafahims36,R.drawable.mafahims37,R.drawable.mafahims38,R.drawable.mafahims39,R.drawable.mafahims40,R.drawable.mafahims40};

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corrige_mafahim);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_mafahim));
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
            } }

        resltasaaraba.add("النتيجة : "+r+"/40");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posotion, long id) {
                if(posotion!=x & posotion!=40){
                    x=posotion;
                    view.setSelected(true);
                    Toast.makeText(getApplicationContext(),"  السؤال "+(posotion+1)+" خاطئ  ",Toast.LENGTH_LONG).show();
                    imageView1.setImageResource(imagesMafahims[posotion]);
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
