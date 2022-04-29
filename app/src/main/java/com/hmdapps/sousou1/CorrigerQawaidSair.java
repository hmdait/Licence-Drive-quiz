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

public class CorrigerQawaidSair extends AppCompatActivity {
    TextView txt;
    int r=40;
    int x=100;
    String[] corrigetajawoz = new String[]{"2","1","2","2","2","23","23","12","1","2","2","1","2","23","2","1","2","2","2","3","2",
            "14","134","23","1","23","1","1","2","12","2","2","2","12","2","1","24","13","2","14","1"};
    ImageView imageView1;
    int[] imagesSayer =new int[]{R.drawable.sayr1,R.drawable.sayr2,R.drawable.sayr3,R.drawable.sayr4,R.drawable.sayr5,R.drawable.sayr6,
            R.drawable.sayr7,R.drawable.sayr8,R.drawable.sayr9,R.drawable.sayr10,R.drawable.sayr11,R.drawable.sayr12,R.drawable.sayr13,
            R.drawable.sayr14,R.drawable.sayr15,R.drawable.sayr16,R.drawable.sayr17,R.drawable.sayr18,R.drawable.sayr19,R.drawable.sayr20,
            R.drawable.sayr21,R.drawable.sayr22,R.drawable.sayr23,R.drawable.sayr24,R.drawable.sayr25,R.drawable.sayr26,R.drawable.sayr27,
            R.drawable.sayr28,R.drawable.sayr29,R.drawable.sayr30,R.drawable.sayr31,R.drawable.sayr32,R.drawable.sayr33,R.drawable.sayr34,
            R.drawable.sayr35,R.drawable.sayr36,R.drawable.sayr37,R.drawable.sayr38,R.drawable.sayr39,R.drawable.sayr40,R.drawable.sayr40};

    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corriger_qawaid_sair);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_qawaid_sayr));
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
                    imageView1.setImageResource(imagesSayer[posotion]);
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