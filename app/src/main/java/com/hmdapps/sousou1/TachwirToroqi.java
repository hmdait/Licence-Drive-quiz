package com.hmdapps.sousou1;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TachwirToroqi extends AppCompatActivity {
    TextView txt,one,two,tree,foor,num,oress;
    String ones,twos,trees,foors,interos,repons;
    counter cn;
    long s;
    int m=0;
    int x=m+1;
    int y=1;
    final ArrayList<String> resultasSayr = new ArrayList<>();
    ImageView imageView1;
    int[] imagestachwir =new int[]{R.drawable.taxwir1,R.drawable.taxwir2,R.drawable.taxwir3,R.drawable.taxwir4,R.drawable.taxwir5,R.drawable.taxwir6
            ,R.drawable.taxwir7,R.drawable.taxwir8,R.drawable.taxwir9,R.drawable.taxwir10,R.drawable.taxwir11,R.drawable.taxwir12,R.drawable.taxwir13
            ,R.drawable.taxwir14,R.drawable.taxwir15,R.drawable.taxwir16,R.drawable.taxwir17,R.drawable.taxwir18,R.drawable.taxwir19,R.drawable.taxwir20
            ,R.drawable.taxwir21,R.drawable.taxwir22,R.drawable.taxwir23,R.drawable.taxwir24,R.drawable.taxwir25,R.drawable.taxwir26,R.drawable.taxwir27
            ,R.drawable.taxwir28,R.drawable.taxwir29,R.drawable.taxwir30,R.drawable.taxwir31,R.drawable.taxwir32,R.drawable.taxwir33,R.drawable.taxwir34
            ,R.drawable.taxwir35,R.drawable.taxwir36,R.drawable.taxwir37,R.drawable.taxwir38,R.drawable.taxwir39,R.drawable.taxwir40,R.drawable.taxwir40};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tachwir_toroqi);
        txt=(TextView)findViewById(R.id.textView);
        num=(TextView)findViewById(R.id.textView13);
        one=(TextView)findViewById(R.id.textView9);
        two=(TextView)findViewById(R.id.textView12);
        tree=(TextView)findViewById(R.id.textView11);
        foor=(TextView)findViewById(R.id.textView10);
        oress=(TextView)findViewById(R.id.textView14);

        ones=twos=trees=foors=interos="";
        imageView1=(ImageView)findViewById(R.id.imageViewtajawoz);
        imageView1.setImageResource(imagestachwir[m]);
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
            imageView1.setImageResource(imagestachwir[m]);
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
        cn= new TachwirToroqi.counter(31000,  1000);
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
                imageView1.setImageResource(imagestachwir[m]);
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
        Intent myintent1 =new Intent(this,CorrigeTachwir.class);
        myintent1.putStringArrayListExtra("arrayList", resultasSayr);
        startActivity(myintent1);
    }


}