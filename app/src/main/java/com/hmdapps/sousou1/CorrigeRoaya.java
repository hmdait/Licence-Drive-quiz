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

public class CorrigeRoaya extends AppCompatActivity {
    TextView txt;
    int r=40;
    int x=100;
    String[] corrigetajawoz = new String[]{"23","12","12","2","3","14","23","2","24","1","12","13","2","3","23","3","13","14","23","14","2",
            "2","2","23","3","23","2","23","1","2","1","23","1","12","2","23","2","2","1","2","2"};
    ImageView imageView1;
    int[] imagesRoaya =new int[]{R.drawable.roayas1,R.drawable.roayas2,R.drawable.roayas3,R.drawable.roayas4,R.drawable.roayas5,R.drawable.roayas6
            ,R.drawable.roayas7,R.drawable.roayas8,R.drawable.roayas9,R.drawable.roayas10,R.drawable.roayas11,R.drawable.roayas12,R.drawable.roayas13
            ,R.drawable.roayas14,R.drawable.roayas15,R.drawable.roayas16,R.drawable.roayas17,R.drawable.roayas18,R.drawable.roayas19,R.drawable.roayas20
            ,R.drawable.roayas21,R.drawable.roayas22,R.drawable.roayas23,R.drawable.roayas24,R.drawable.roayas25,R.drawable.roayas26,R.drawable.roayas27
            ,R.drawable.roayas28,R.drawable.roayas29,R.drawable.roayas30,R.drawable.roayas31,R.drawable.roayas32,R.drawable.roayas33,R.drawable.roayas34
            ,R.drawable.roayas35,R.drawable.roayas36,R.drawable.roayas37,R.drawable.roayas38,R.drawable.roayas39,R.drawable.roayas40,R.drawable.roayas40};

    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corrige_roaya);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_roaya));
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
                    imageView1.setImageResource(imagesRoaya[posotion]);
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