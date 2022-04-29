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

public class CorrigeIsaafat extends AppCompatActivity {
    TextView txt;
    int r=40;
    int x=100;
    String[] corrigeisaafat = new String[]{"1","124","1","2","12","14","2","1","1","2","2","23","1","12","1","2","1","2","13","13","2",
            "23","14","23","2","23","2","2","123","2","1","23","1","2","3","1","1","234","2","14","2"};
    ImageView imageView1;
    int[] imagesSayer =new int[]{R.drawable.isaafats1,R.drawable.isaafats2,R.drawable.isaafats3,R.drawable.isaafats4,R.drawable.isaafats5,R.drawable.isaafats6
            ,R.drawable.isaafats7,R.drawable.isaafats8,R.drawable.isaafats9,R.drawable.isaafats10,R.drawable.isaafats11,R.drawable.isaafats12,
            R.drawable.isaafats13,R.drawable.isaafats14,R.drawable.isaafats15,R.drawable.isaafats16,R.drawable.isaafats17,R.drawable.isaafats18,R.drawable.isaafats19
            ,R.drawable.isaafats20,R.drawable.isaafats21,R.drawable.isaafats22,R.drawable.isaafats23,R.drawable.isaafats24,R.drawable.isaafats25,R.drawable.isaafats26
            ,R.drawable.isaafats27,R.drawable.isaafats28,R.drawable.isaafats29,R.drawable.isaafats30,R.drawable.isaafats31,R.drawable.isaafats32,R.drawable.isaafats33
            ,R.drawable.isaafats34,R.drawable.isaafats35,R.drawable.isaafats36,R.drawable.isaafats37,R.drawable.isaafats38,R.drawable.isaafats39,R.drawable.isaafats40,R.drawable.isaafats40};

    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corrige_isaafat);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_isaafat));
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
            if (resltasaaraba.get(i).equals(corrigeisaafat[i])){
                resltasaaraba.set(i,"السؤال "+(i+1)+" : "+resltasaaraba.get(i)+"         ===>  صحيح "); }

            else { resltasaaraba.set(i, "السؤال "+(i+1)+" : "+resltasaaraba.get(i) +"         ===>  خطا الجواب الصحيح هو : "+"   "+ corrigeisaafat[i]);
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