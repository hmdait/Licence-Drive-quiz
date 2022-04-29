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

public class CorrigeSaiq extends AppCompatActivity {
    TextView txt;
    int r=40;
    int x=100;
    String[] corrigetachwir = new String[]{"13","2","1","2","12","13","1","13","13","2","1","2","2","12","1","134","3","1","2","13","2",
            "2","2","13","2","23","2","3","1","13","13","23","1","3","1","2","2","2","23","2","2"};
    ImageView imageView1;
    int[] imagestachwir =new int[]{R.drawable.saiqs1,R.drawable.saiqs2,R.drawable.saiqs3,R.drawable.saiqs4,R.drawable.saiqs5,R.drawable.saiqs6
            ,R.drawable.saiqs7,R.drawable.saiqs8,R.drawable.saiqs9,R.drawable.saiqs10,R.drawable.saiqs11,R.drawable.saiqs12,R.drawable.saiqs13
            ,R.drawable.saiqs14,R.drawable.saiqs15,R.drawable.saiqs16,R.drawable.saiqs17,R.drawable.saiqs18,R.drawable.saiqs19,R.drawable.saiqs20
            ,R.drawable.saiqs21,R.drawable.saiqs22,R.drawable.saiqs23,R.drawable.saiqs24,R.drawable.saiqs25,R.drawable.saiqs26,R.drawable.saiqs27
            ,R.drawable.saiqs28,R.drawable.saiqs29,R.drawable.saiqs30,R.drawable.saiqs31,R.drawable.saiqs32,R.drawable.saiqs33,R.drawable.saiqs34
            ,R.drawable.saiqs35,R.drawable.saiqs36,R.drawable.saiqs37,R.drawable.saiqs38,R.drawable.saiqs39,R.drawable.saiqs40,R.drawable.saiqs40};

    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corrige_saiq);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_saiq));
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
            if (resltasaaraba.get(i).equals(corrigetachwir[i])){
                resltasaaraba.set(i,"السؤال "+(i+1)+" : "+resltasaaraba.get(i)+"         ===>  صحيح "); }

            else { resltasaaraba.set(i, "السؤال "+(i+1)+" : "+resltasaaraba.get(i) +"         ===>  خطا الجواب الصحيح هو : "+"   "+ corrigetachwir[i]);
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
                    Toast.makeText(getApplicationContext(),"Question  "+(posotion+1)+" est faut",Toast.LENGTH_LONG).show();
                    imageView1.setImageResource(imagestachwir[posotion]);
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