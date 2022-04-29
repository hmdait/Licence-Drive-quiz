package com.hmdapps.sousou1;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity4 extends AppCompatActivity {
     TextView txt;
     TextView one;
     TextView two;
     TextView tree;
    TextView foor;
     TextView num;
    TextView oress;
     String ones;
     String twos;
     String trees;
     String foors;
     String interos;
     String repons;
     counter cn;
     long s;
    int m=0;
     int x=1;
    int y=1;
     final ArrayList<String> resultasaaraba = new ArrayList<>();
    ImageView imageView1;

    int[] imagesAarabaa =new int[] {R.drawable.aaraba1,R.drawable.aaraba2,R.drawable.aaraba3,R.drawable.aaraba4,R.drawable.aaraba5, R.drawable.aaraba6,
            R.drawable.aaraba7,R.drawable.aaraba8,R.drawable.aaraba9,R.drawable.aaraba10,R.drawable.aaraba11,R.drawable.aaraba12,
    R.drawable.aaraba13,R.drawable.aaraba14,R.drawable.aaraba15,R.drawable.aaraba16,R.drawable.aaraba17,R.drawable.aaraba18,R.drawable.aaraba19,
    R.drawable.aaraba20,R.drawable.aaraba21,R.drawable.aaraba22,R.drawable.aaraba23,R.drawable.aaraba24,R.drawable.aaraba25,R.drawable.aaraba26,
    R.drawable.aaraba27,R.drawable.aaraba28,R.drawable.aaraba29,R.drawable.aaraba30,R.drawable.aaraba31,R.drawable.aaraba32,R.drawable.aaraba33,
    R.drawable.aaraba34,R.drawable.aaraba35,R.drawable.aaraba36,R.drawable.aaraba37,R.drawable.aaraba38,R.drawable.aaraba39,R.drawable.aaraba40,R.drawable.aaraba40};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        txt= findViewById(R.id.textView);
        num= findViewById(R.id.textView13);
        one= findViewById(R.id.textView9);
        two= findViewById(R.id.textView12);
        tree= findViewById(R.id.textView11);
        foor= findViewById(R.id.textView10);
        oress= findViewById(R.id.textView14);
        ones=twos=trees=foors=interos="";

        imageView1= findViewById(R.id.imageViewtajawoz);
        imageView1.setImageResource(imagesAarabaa[m]);



        num.setText(" السؤال  :"+(x));
        starttime();

    }

    public void busuivant(View view) {
        cn.cancel();
        repons=(ones+""+twos+""+trees+""+foors+""+interos);
        x=x+1;
        if (m<=39){

            resultasaaraba.add(m,repons);
            m=m+1;
            imageView1.setImageResource(imagesAarabaa[m]);
            one.setText("");
            two.setText("");
            tree.setText("");
            foor.setText("");
            oress.setText("");
            repons=(ones+""+twos+""+trees+""+foors);
            ones=twos=trees=foors=interos="";
            num.setText("السؤال  : "+(x));
            starttime();
        }
        else { pass(); }
    }

    public void pause(View view){
        cn.cancel();
    }

    public void starttime() {
        cn= new MainActivity4.counter(31000,  1000);
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
        interos="?";    }

    public void corrige(View view) {
        one.setText("");
        two.setText("");
        tree.setText("");
        foor.setText("");
        oress.setText("");
        ones=twos=trees=foors=interos="";
    }

    public class counter extends CountDownTimer {
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
            repons=(ones+""+twos+""+trees+""+foors+""+interos);

            if (m<=39){
                x++;

                resultasaaraba.add(m,repons);
                m=m+1;
                imageView1.setImageResource(imagesAarabaa[m]);
                one.setText("");
                two.setText("");
                tree.setText("");
                foor.setText("");
                starttime();
                repons=interos="";
                num.setText("السؤال  :"+(m+1));
            }
            else { pass(); }
            if (m==39){ pass(); }
        }}

    private void pass() {
        m=0;
        x=1;

        Intent myintent1 =new Intent(this,MainActivity5.class);
        myintent1.putStringArrayListExtra("arrayList", resultasaaraba);
        startActivity(myintent1);
    }


}
