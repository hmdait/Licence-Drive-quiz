package com.hmdapps.sousou1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.analytics.FirebaseAnalytics;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseAnalytics.getInstance(this);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    public void start(View view) {
        Intent myintent =new Intent(this,MainActivity2.class);
        startActivity(myintent);
    }

    public void feedback(View view) {

        Intent myintent1 =new Intent(this,Feedback.class);
        startActivity(myintent1);
    }

    public void question_examen(View view) {

        Intent myintent =new Intent(this,ExamenSeries.class);
        startActivity(myintent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        item.getItemId();
        try {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plaine");
            intent.putExtra(Intent.EXTRA_SUBJECT, "sousou");
            intent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id=com.hmdapps.sousou1");
            startActivity(Intent.createChooser(intent,"Share Via"));

        }catch (Exception e){
            Toast.makeText(this, "unable to share this app",Toast.LENGTH_LONG).show();
        }
        return true;}


}