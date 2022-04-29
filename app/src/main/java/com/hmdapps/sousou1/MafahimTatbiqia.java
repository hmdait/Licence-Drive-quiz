package com.hmdapps.sousou1;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MafahimTatbiqia extends AppCompatActivity {
    TextView txt,one,two,tree,foor,num,oress;
    String ones,twos,trees,foors,interos,repons;
    counter cn;
    long s;
    int m=0;
    int x=m+1;
    int y=1;
    final ArrayList<String> resultasTajawoz = new ArrayList<>();
    ImageView imageView1;
    int[] imagesMafahim =new int[]{R.drawable.mafahim1,R.drawable.mafahim2,R.drawable.mafahim3,R.drawable.mafahim4,R.drawable.mafahim5
            ,R.drawable.mafahim6,R.drawable.mafahim7,R.drawable.mafahim8,R.drawable.mafahim9,R.drawable.mafahim10,R.drawable.mafahim11
            ,R.drawable.mafahim12,R.drawable.mafahim13,R.drawable.mafahim14,R.drawable.mafahim15,R.drawable.mafahim16,R.drawable.mafahim17,
            R.drawable.mafahim18,R.drawable.mafahim19,R.drawable.mafahim20,R.drawable.mafahim21,R.drawable.mafahim22,R.drawable.mafahim23
            ,R.drawable.mafahim24,R.drawable.mafahim25,R.drawable.mafahim26,R.drawable.mafahim27,R.drawable.mafahim28,R.drawable.mafahim29
            ,R.drawable.mafahim30,R.drawable.mafahim31,R.drawable.mafahim32,R.drawable.mafahim33,R.drawable.mafahim34,R.drawable.mafahim35
            ,R.drawable.mafahim36,R.drawable.mafahim37,R.drawable.mafahim38,R.drawable.mafahim39,R.drawable.mafahim40,R.drawable.mafahim40};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mafahim_tatbiqia);


        txt=(TextView)findViewById(R.id.textView);
        num=(TextView)findViewById(R.id.textView13);
        one=(TextView)findViewById(R.id.textView9);
        two=(TextView)findViewById(R.id.textView12);
        tree=(TextView)findViewById(R.id.textView11);
        foor=(TextView)findViewById(R.id.textView10);
        oress=(TextView)findViewById(R.id.textView14);

        ones=twos=trees=foors=interos="";
        imageView1=(ImageView)findViewById(R.id.imageViewtajawoz);
        imageView1.setImageResource(imagesMafahim[m]);
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
            imageView1.setImageResource(imagesMafahim[m]);
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
        cn= new MafahimTatbiqia.counter(31000,  1000);
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
                imageView1.setImageResource(imagesMafahim[m]);
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
        Intent myintent1 =new Intent(this,CorrigeMafahim.class);
        myintent1.putStringArrayListExtra("arrayList", resultasTajawoz);
        startActivity(myintent1);
    }

}
