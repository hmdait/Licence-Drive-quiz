package com.hmdapps.sousou1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class MainActivity3 extends AppCompatActivity {
    TextView txt;
    int r=40;
    int x=100;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_silsila_jadida));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        txt=(TextView) findViewById(R.id.textView3);
        txt.setText(String.valueOf("Résultat :"));
        Intent myintent = getIntent();
        Bundle bundle = getIntent().getExtras();
        final ArrayList<String>  resltastest = bundle.getStringArrayList("arrayList");
        final ListView listView = findViewById(R.id.listview);
        final ArrayAdapter<String> items = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,resltastest);
       for (int i=0; i<=39;i++){
           resltastest.set(i,"  السؤال "+(i+1)+" : "+resltastest.get(i)); }
        listView.setAdapter(items);
        Toast.makeText(getApplicationContext(),"اضغط على الجواب الخاطئ",Toast.LENGTH_LONG).show();
        resltastest.add("Résultas final est :"+r+"/40");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posotion, long id) {
                if(posotion!=x){
                    x=posotion;
                    view.setSelected(true);
                    r=r-1;
                    Toast.makeText(getApplicationContext(),"  السؤال "+(posotion+1)+" خاطئ  ",Toast.LENGTH_LONG).show();
                    resltastest.set(posotion, resltastest.get(posotion)+"          ===> خطا  ");
                    resltastest.remove(40);
                    resltastest.add("Résultas final est:"+r+"/40");
                    listView.setAdapter(items);
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