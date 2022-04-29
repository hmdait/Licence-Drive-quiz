package com.hmdapps.sousou1;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AtaqaboWaAtajawoz extends AppCompatActivity {
    TextView txt,one,two,tree,foor,num,oress;
    String ones,twos,trees,foors,interos,repons;
    counter cn;
    long s;
    int m=0;
    int x=m+1;
    int y=1;
    final ArrayList<String> resultasTajawoz = new ArrayList<>();
    ImageView imageView1;
    int[] imagesTajawoz =new int[]{R.drawable.tajawoz1,R.drawable.tajawoz2,R.drawable.tajawoz3,R.drawable.tajawoz4,R.drawable.tajawoz5,R.drawable.tajawoz6,R.drawable.tajawoz7,
            R.drawable.tajawoz8,R.drawable.tajawoz9,R.drawable.tajawoz10,R.drawable.tajawoz11,R.drawable.tajawoz12,R.drawable.tajawoz13,R.drawable.tajawoz14,
            R.drawable.tajawoz15,R.drawable.tajawoz16,R.drawable.tajawoz17,R.drawable.tajawoz18,R.drawable.tajawoz19,R.drawable.tajawoz20,R.drawable.tajawoz21,
            R.drawable.tajawoz22,R.drawable.tajawoz23,R.drawable.tajawoz24,R.drawable.tajawoz25,R.drawable.tajawoz26,R.drawable.tajawoz27,R.drawable.tajawoz28,
            R.drawable.tajawoz29,R.drawable.tajawoz30,R.drawable.tajawoz31,R.drawable.tajawoz32,R.drawable.tajawoz33,R.drawable.tajawoz34,R.drawable.tajawoz35,
            R.drawable.tajawoz36,R.drawable.tajawoz37,R.drawable.tajawoz38,R.drawable.tajawoz39,R.drawable.tajawoz40,R.drawable.tajawoz40};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ataqabo_wa_atajawoz);

        txt= findViewById(R.id.textView);
        num= findViewById(R.id.textView13);
        one= findViewById(R.id.textView9);
        two= findViewById(R.id.textView12);
        tree= findViewById(R.id.textView11);
        foor= findViewById(R.id.textView10);
        oress= findViewById(R.id.textView14);

        ones=twos=trees=foors=interos="";
        imageView1= findViewById(R.id.imageViewtajawoz);
        imageView1.setImageResource(imagesTajawoz[m]);
        num.setText("السؤال  :"+(x));
        starttime();

    }

    public void busuivant(View view) {
        cn.cancel();
        repons=(ones+""+twos+""+trees+""+foors+""+interos);
        x=x+1;
        if (m<=39){

            resultasTajawoz.add(m,repons);
            m=m+1;
            imageView1.setImageResource(imagesTajawoz[m]);
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
        cn= new AtaqaboWaAtajawoz.counter(31000,  1000);
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

                resultasTajawoz.add(m,repons);
                m=m+1;
                imageView1.setImageResource(imagesTajawoz[m]);
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
        Intent myintent1 =new Intent(this,CorrigeTajawoz.class);
        myintent1.putStringArrayListExtra("arrayList", resultasTajawoz);
        startActivity(myintent1);
    }


}