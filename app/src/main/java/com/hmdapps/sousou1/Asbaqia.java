package com.hmdapps.sousou1;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Asbaqia extends AppCompatActivity {
    TextView txt,one,two,tree,foor,num,oress;
    String ones,twos,trees,foors,interos,repons;
    counter cn;
    long s;
    int m=0;
    int x=m+1;
    int y=1;
    final ArrayList<String> resultasAsbaqia = new ArrayList<>();
    ImageView imageView1;
    int[] imagesAsbaqia =new int[]{R.drawable.asbaqia1,R.drawable.asbaqia2,R.drawable.asbaqia3,R.drawable.asbaqia4,R.drawable.asbaqia5
            ,R.drawable.asbaqia6,R.drawable.asbaqia7,R.drawable.asbaqia8,R.drawable.asbaqia9,R.drawable.asbaqia10,R.drawable.asbaqia11,R.drawable.asbaqia12
            ,R.drawable.asbaqia13,R.drawable.asbaqia14,R.drawable.asbaqia15,R.drawable.asbaqia16,R.drawable.asbaqia17,R.drawable.asbaqia18
            ,R.drawable.asbaqia19,R.drawable.asbaqia20,R.drawable.asbaqia21,R.drawable.asbaqia22,R.drawable.asbaqia23,R.drawable.asbaqia24
            ,R.drawable.asbaqia25,R.drawable.asbaqia26,R.drawable.asbaqia27,R.drawable.asbaqia28,R.drawable.asbaqia29,R.drawable.asbaqia30
            ,R.drawable.asbaqia31,R.drawable.asbaqia32,R.drawable.asbaqia33,R.drawable.asbaqia34,R.drawable.asbaqia35,R.drawable.asbaqia36
            ,R.drawable.asbaqia37,R.drawable.asbaqia38,R.drawable.asbaqia39,R.drawable.asbaqia40,R.drawable.asbaqia40};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asbaqia);

        txt=(TextView)findViewById(R.id.textView);
        num=(TextView)findViewById(R.id.textView13);
        one=(TextView)findViewById(R.id.textView9);
        two=(TextView)findViewById(R.id.textView12);
        tree=(TextView)findViewById(R.id.textView11);
        foor=(TextView)findViewById(R.id.textView10);
        oress=(TextView)findViewById(R.id.textView14);

        ones=twos=trees=foors=interos="";
        imageView1=(ImageView)findViewById(R.id.imageViewtajawoz);
        imageView1.setImageResource(imagesAsbaqia[m]);
        num.setText("السؤال  :"+(x));
        starttime();

    }

    public void busuivant(View view) {
        cn.cancel();
        repons=(ones+""+twos+""+trees+""+foors+""+interos);
        x=x+1;
        if (m<=39){

            resultasAsbaqia.add(m,repons);
            m=m+1;
            imageView1.setImageResource(imagesAsbaqia[m]);
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
        cn= new Asbaqia.counter(31000,  1000);
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

                resultasAsbaqia.add(m,repons);
                m=m+1;
                imageView1.setImageResource(imagesAsbaqia[m]);
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
        Intent myintent1 =new Intent(this,CorrigeAsbaqia.class);
        myintent1.putStringArrayListExtra("arrayList", resultasAsbaqia);
        startActivity(myintent1);
    }


}
