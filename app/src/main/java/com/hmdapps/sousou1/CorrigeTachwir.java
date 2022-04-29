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

public class CorrigeTachwir extends AppCompatActivity {
    TextView txt;
    int r=40;
    int x=100;
    String[] corrigetachwir = new String[]{"1","2","13","2","13","2","23","123","12","2","124","2","14","12","2","2","12","12","2","14","12",
            "2","13","23","24","1","2","1","2","3","3","2","2","2","1","1234","2","12","23","1","1"};
    ImageView imageView1;
    int[] imagestachwir =new int[]{R.drawable.taxwirs1,R.drawable.taxwirs2,R.drawable.taxwirs3,R.drawable.taxwirs4,R.drawable.taxwirs5,R.drawable.taxwirs6
            ,R.drawable.taxwirs7,R.drawable.taxwirs8,R.drawable.taxwirs9,R.drawable.taxwirs10,R.drawable.taxwirs11,R.drawable.taxwirs12,R.drawable.taxwirs13
            ,R.drawable.taxwirs14,R.drawable.taxwirs15,R.drawable.taxwirs16,R.drawable.taxwirs17,R.drawable.taxwirs18,R.drawable.taxwirs19,R.drawable.taxwirs20
            ,R.drawable.taxwirs21,R.drawable.taxwirs22,R.drawable.taxwirs23,R.drawable.taxwirs24,R.drawable.taxwirs25,R.drawable.taxwirs26,R.drawable.taxwirs27
            ,R.drawable.taxwirs28,R.drawable.taxwirs29,R.drawable.taxwirs30,R.drawable.taxwirs31,R.drawable.taxwirs32,R.drawable.taxwirs33,R.drawable.taxwirs34
            ,R.drawable.taxwirs35,R.drawable.taxwirs36,R.drawable.taxwirs37,R.drawable.taxwirs38,R.drawable.taxwirs39,R.drawable.taxwirs40,R.drawable.taxwirs40};

    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corrige_tachwir);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_tachwir));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        imageView1= findViewById(R.id.imageView);
        txt= findViewById(R.id.textView3);
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
                    Toast.makeText(getApplicationContext(),"  السؤال "+(posotion+1)+" خاطئ  ",Toast.LENGTH_LONG).show();
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