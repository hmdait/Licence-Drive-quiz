package com.hmdapps.sousou1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;



public class ExamenSeries extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen_series);

    }

    public void aaraba(View view) {

        Intent myintent1 =new Intent(this,MainActivity4.class);
        startActivity(myintent1);
    }

    public void tajawoz(View view) {
        Intent myintent1 =new Intent(this,AtaqaboWaAtajawoz.class);
        startActivity(myintent1);
    }

    public void alwoqof(View view) {
        Intent myintent1 =new Intent(this,AlwoqoWaTawqof.class);
        startActivity(myintent1);
    }

    public void sayer(View view) {
        Intent myintent1 =new Intent(this,QawaidSayr.class);
        startActivity(myintent1);
    }

    public void tachwir(View view) {
        Intent myintent1 =new Intent(this,TachwirToroqi.class);
        startActivity(myintent1);
    }

    public void isaafat(View view) {
        Intent myintent1 =new Intent(this,IsaafatAwalia.class);
        startActivity(myintent1);
    }

    public void saiq(View view) {
        Intent myintent1 =new Intent(this,Saiq.class);
        startActivity(myintent1);
    }

    public void mafahim(View view) {
        Intent myintent1 =new Intent(this,MafahimTatbiqia.class);
        startActivity(myintent1);
    }

    public void roaya(View view) {
        Intent myintent1 =new Intent(this,Roaya.class);
        startActivity(myintent1);
    }

    public void tachwirrr(View view) {
        Intent myintent1 =new Intent(this,TachirToroqi2.class);
        startActivity(myintent1);
    }

    public void asbaqia(View view) {
        Intent myintent1 =new Intent(this,Asbaqia.class);
        startActivity(myintent1);

    }
}