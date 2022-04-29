package com.hmdapps.sousou1;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class QawaidSayr extends AppCompatActivity {
    TextView txt,one,two,tree,foor,num,oress;
    String ones,twos,trees,foors,interos,repons;
    counter cn;
    long s;
    int m=0;
    int x=m+1;
    int y=1;
    final ArrayList<String> resultasSayr = new ArrayList<>();
    ImageView imageView1;
    int[] imagesSayer =new int[]{R.drawable.sayrc1,R.drawable.sayrc2,R.drawable.sayrc3,R.drawable.sayrc4,R.drawable.sayrc5,R.drawable.sayrc6,
            R.drawable.sayrc7,R.drawable.sayrc8,R.drawable.sayrc9,R.drawable.sayrc10,R.drawable.sayrc11,R.drawable.sayrc12,R.drawable.sayrc13,
            R.drawable.sayrc14,R.drawable.sayrc15,R.drawable.sayrc16,R.drawable.sayrc17,R.drawable.sayrc18,R.drawable.sayrc19,R.drawable.sayrc20,
            R.drawable.sayrc21,R.drawable.sayrc22,R.drawable.sayrc23,R.drawable.sayrc24,R.drawable.sayrc25,R.drawable.sayrc26,R.drawable.sayrc27,
            R.drawable.sayrc28,R.drawable.sayrc29,R.drawable.sayrc30,R.drawable.sayrc31,R.drawable.sayrc32,R.drawable.sayrc33,R.drawable.sayrc34,
            R.drawable.sayrc35,R.drawable.sayrc36,R.drawable.sayrc37,R.drawable.sayrc38,R.drawable.sayrc39,R.drawable.sayrc40,R.drawable.sayrc40};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qawaid_sayr);
        txt=(TextView)findViewById(R.id.textView);
        num=(TextView)findViewById(R.id.textView13);
        one=(TextView)findViewById(R.id.textView9);
        two=(TextView)findViewById(R.id.textView12);
        tree=(TextView)findViewById(R.id.textView11);
        foor=(TextView)findViewById(R.id.textView10);
        oress=(TextView)findViewById(R.id.textView14);

        ones=twos=trees=foors=interos="";
        imageView1=(ImageView)findViewById(R.id.imageViewtajawoz);
        imageView1.setImageResource(imagesSayer[m]);
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
            imageView1.setImageResource(imagesSayer[m]);
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
        cn= new QawaidSayr.counter(31000,  1000);
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
                imageView1.setImageResource(imagesSayer[m]);
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
        Intent myintent1 =new Intent(this,CorrigerQawaidSair.class);
        myintent1.putStringArrayListExtra("arrayList", resultasSayr);
        startActivity(myintent1);
    }


}