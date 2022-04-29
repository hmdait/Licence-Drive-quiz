package com.hmdapps.sousou1;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AlwoqoWaTawqof extends AppCompatActivity {
    TextView txt,one,two,tree,foor,num,oress;
    String ones,twos,trees,foors,interos,repons;
    counter cn;
    long s;
    int m=0;
    int x=m+1;
    int y=1;
    final ArrayList<String> resultasSayr = new ArrayList<>();
    ImageView imageView1;
    int[] imageswoqof =new int[]{R.drawable.woqof1,R.drawable.woqof2,R.drawable.woqof3,R.drawable.woqof4,R.drawable.woqof5,R.drawable.woqof6,
            R.drawable.woqof7,R.drawable.woqof8,R.drawable.woqof9,R.drawable.woqof10,R.drawable.woqof11,R.drawable.woqof12,R.drawable.woqof13,
            R.drawable.woqof14,R.drawable.woqof15,R.drawable.woqof16,R.drawable.woqof17,R.drawable.woqof18,R.drawable.woqof19,R.drawable.woqof20,
            R.drawable.woqof21,R.drawable.woqof22,R.drawable.woqof23,R.drawable.woqof24,R.drawable.woqof25,R.drawable.woqof26,R.drawable.woqof27,
            R.drawable.woqof28,R.drawable.woqof29,R.drawable.woqof30,R.drawable.woqof31,R.drawable.woqof32,R.drawable.woqof33,R.drawable.woqof34,
            R.drawable.woqof35,R.drawable.woqof36,R.drawable.woqof37,R.drawable.woqof38,R.drawable.woqof39,R.drawable.woqof40,R.drawable.woqof40};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alwoqo_wa_tawqof);

        txt=(TextView)findViewById(R.id.textView);
        num=(TextView)findViewById(R.id.textView13);
        one=(TextView)findViewById(R.id.textView9);
        two=(TextView)findViewById(R.id.textView12);
        tree=(TextView)findViewById(R.id.textView11);
        foor=(TextView)findViewById(R.id.textView10);
        oress=(TextView)findViewById(R.id.textView14);

        ones=twos=trees=foors=interos="";
        imageView1=(ImageView)findViewById(R.id.imageViewtajawoz);
        imageView1.setImageResource(imageswoqof[m]);
        num.setText("السؤال  :"+(x));
        starttime();

    }

    public void busuivant(View view) {
        cn.cancel();
        repons=(ones+""+twos+""+trees+""+foors+""+interos);
        x=x+1;
        if (m<=39){

            resultasSayr.add(m,repons);
            m=m+1;
            imageView1.setImageResource(imageswoqof[m]);
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
        cn= new AlwoqoWaTawqof.counter(31000,  1000);
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

                resultasSayr.add(m,repons);
                m=m+1;
                imageView1.setImageResource(imageswoqof[m]);
                one.setText("");
                two.setText("");
                tree.setText("");
                foor.setText("");
                starttime();
                repons=interos="";
                num.setText("السؤال  :"+(m+1));
            }
            else { pass(); } }}

    private void pass() {
        m=0;
        x=1;
        Intent myintent1 =new Intent(this,CorrigeAlwoqof.class);
        myintent1.putStringArrayListExtra("arrayList", resultasSayr);
        startActivity(myintent1);
    }


}