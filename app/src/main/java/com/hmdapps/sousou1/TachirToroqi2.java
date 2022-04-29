package com.hmdapps.sousou1;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TachirToroqi2 extends AppCompatActivity {
    TextView txt,one,two,tree,foor,num,oress;
    String ones,twos,trees,foors,interos,repons;
    counter cn;
    long s;
    int m=0;
    int x=m+1;
    int y=1;
    final ArrayList<String> resultasTachwiir = new ArrayList<>();
    ImageView imageView1;
    int[] imagestachwiir =new int[]{R.drawable.taxwirr1,R.drawable.taxwirr2,R.drawable.taxwirr3,R.drawable.taxwirr4,R.drawable.taxwirr5,R.drawable.taxwirr6
            ,R.drawable.taxwirr7,R.drawable.taxwirr8,R.drawable.taxwirr9,R.drawable.taxwirr10,R.drawable.taxwirr11,R.drawable.taxwirr12,R.drawable.taxwirr13
            ,R.drawable.taxwirr14,R.drawable.taxwirr15,R.drawable.taxwirr16,R.drawable.taxwirr17,R.drawable.taxwirr18,R.drawable.taxwirr19,R.drawable.taxwirr20
            ,R.drawable.taxwirr21,R.drawable.taxwirr22,R.drawable.taxwirr23,R.drawable.taxwirr24,R.drawable.taxwirr25,R.drawable.taxwirr26,R.drawable.taxwirr27
            ,R.drawable.taxwirr28,R.drawable.taxwirr29,R.drawable.taxwirr30,R.drawable.taxwirr31,R.drawable.taxwirr32,R.drawable.taxwirr33,R.drawable.taxwirr34
            ,R.drawable.taxwirr35,R.drawable.taxwirr36,R.drawable.taxwirr37,R.drawable.taxwirr38,R.drawable.taxwirr39,R.drawable.taxwirr40,R.drawable.taxwirr40};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tachir_toroqi2);
        txt=(TextView)findViewById(R.id.textView);
        num=(TextView)findViewById(R.id.textView13);
        one=(TextView)findViewById(R.id.textView9);
        two=(TextView)findViewById(R.id.textView12);
        tree=(TextView)findViewById(R.id.textView11);
        foor=(TextView)findViewById(R.id.textView10);
        oress=(TextView)findViewById(R.id.textView14);

        ones=twos=trees=foors=interos="";
        imageView1=(ImageView)findViewById(R.id.imageViewtajawoz);
        imageView1.setImageResource(imagestachwiir[m]);
        num.setText("السؤال  :"+(x));
        starttime();

    }

    public void busuivant(View view) {
        cn.cancel();
        repons=(ones+""+twos+""+trees+""+foors+""+interos);
        x=x+1;
        if (m<=39){

            resultasTachwiir.add(m,repons);
            m=m+1;
            imageView1.setImageResource(imagestachwiir[m]);
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
        cn= new TachirToroqi2.counter(31000,  1000);
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

                resultasTachwiir.add(m,repons);
                m=m+1;
                imageView1.setImageResource(imagestachwiir[m]);
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
        Intent myintent1 =new Intent(this,CorrigeTachwiir2.class);
        myintent1.putStringArrayListExtra("arrayList", resultasTachwiir);
        startActivity(myintent1);
    }


}