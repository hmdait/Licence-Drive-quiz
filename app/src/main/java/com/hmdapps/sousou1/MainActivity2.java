package com.hmdapps.sousou1;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    TextView txt,one,two,tree,foor,num,oress;
    String ones,twos,trees,foors,interos,repons;
    counter cn;
    long s;
    int m=0;
    int x=1;
    int y=1;
    final ArrayList<String> resultas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        txt=(TextView)findViewById(R.id.textView);
        num=(TextView)findViewById(R.id.textView13);
        one=(TextView)findViewById(R.id.textView9);
        two=(TextView)findViewById(R.id.textView12);
        tree=(TextView)findViewById(R.id.textView11);
        foor=(TextView)findViewById(R.id.textView10);
        oress=(TextView)findViewById(R.id.textView14);
        num.setText(" السؤال : "+(x));
        ones=twos=trees=foors=interos="";
        starttime();
    }
    private void pass() {
        Intent myintent =new Intent(this,MainActivity3.class);
        myintent.putStringArrayListExtra("arrayList", resultas);
        startActivity(myintent);
    }

    public void busuivant(View view) {
        cn.cancel();
        repons=(ones+""+twos+""+trees+""+foors+" "+interos);

        if (m<=39){
            resultas.add(m,repons);
            if (x==41){ pass(); }
            m=m+1;
            one.setText("");
            two.setText("");
            tree.setText("");
            foor.setText("");
            oress.setText("");
            starttime();
            ones=twos=trees=foors=interos="";
            num.setText(" السؤال : "+(m+1));
        }
        else { pass(); }
    }

    public void pause(View view){
        cn.cancel();
    }

    public void starttime() {
        cn=new counter(31000,  1000);
        txt.setText(String.valueOf(s));
        cn.start();
    }

    public void one(View view) { one.setText(String.valueOf(1));
    ones="1";}
    public void two(View view) { two.setText(String.valueOf(2));
    twos="2";}
    public void tree(View view) { tree.setText(String.valueOf(3));
    trees="3";}
    public void foor(View view) { foor.setText(String.valueOf(4));
    foors="4";}
    public void intero(View view) { oress.setText("?");
        interos=" ??? ";     }

    public void corrige(View view) {
        one.setText("");
        two.setText("");
        tree.setText("");
        foor.setText("");
        oress.setText("");
        ones=twos=trees=foors=interos="";
    }

    public class counter extends CountDownTimer{
        public counter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onTick(long millisInFuture) {
            s=millisInFuture/1000;
            txt.setText(String.valueOf(s));
        }
        @Override
        public void onFinish() {
            cn.cancel();

            if (m<=39){
                x++;
                resultas.add(m,repons);
                if (x==41){
                    pass();
                }
                m=m+1;
                one.setText("");
                two.setText("");
                tree.setText("");
                foor.setText("");
                starttime();
                repons="";
                num.setText((m+1)+"السؤال  :");
            }
            else { pass(); }
        }}


}