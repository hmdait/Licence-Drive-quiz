package com.hmdapps.sousou1;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class IsaafatAwalia extends AppCompatActivity {
    TextView txt,one,two,tree,foor,num,oress;
    String ones,twos,trees,foors,interos,repons;
    counter cn;
    long s;
    int m=0;
    int x=m+1;
    int y=1;
    final ArrayList<String> resultasSayr = new ArrayList<>();
    ImageView imageView1;
    int[] imagesisaafat =new int[]{R.drawable.isaafat1,R.drawable.isaafat2,R.drawable.isaafat3,R.drawable.isaafat4,R.drawable.isaafat5,
            R.drawable.isaafat6,R.drawable.isaafat7,R.drawable.isaafat8,R.drawable.isaafat9,R.drawable.isaafat10,R.drawable.isaafat11,
            R.drawable.isaafat12,R.drawable.isaafat13,R.drawable.isaafat14,R.drawable.isaafat15,R.drawable.isaafat16,R.drawable.isaafat17,
            R.drawable.isaafat18,R.drawable.isaafat19,R.drawable.isaafat20,R.drawable.isaafat21,R.drawable.isaafat22,R.drawable.isaafat23,
            R.drawable.isaafat24,R.drawable.isaafat25,R.drawable.isaafat26,R.drawable.isaafat27,R.drawable.isaafat28,R.drawable.isaafat29,
            R.drawable.isaafat30,R.drawable.isaafat31,R.drawable.isaafat32,R.drawable.isaafat33,R.drawable.isaafat34,R.drawable.isaafat35,
            R.drawable.isaafat36,R.drawable.isaafat37,R.drawable.isaafat38,R.drawable.isaafat39,R.drawable.isaafat40,R.drawable.isaafat40};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isaafat_awalia);
        txt=(TextView)findViewById(R.id.textView);
        num=(TextView)findViewById(R.id.textView13);
        one=(TextView)findViewById(R.id.textView9);
        two=(TextView)findViewById(R.id.textView12);
        tree=(TextView)findViewById(R.id.textView11);
        foor=(TextView)findViewById(R.id.textView10);
        oress=(TextView)findViewById(R.id.textView14);

        ones=twos=trees=foors=interos="";
        imageView1=(ImageView)findViewById(R.id.imageViewtajawoz);
        imageView1.setImageResource(imagesisaafat[m]);
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
            imageView1.setImageResource(imagesisaafat[m]);
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
        cn= new IsaafatAwalia.counter(31000,  1000);
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
                imageView1.setImageResource(imagesisaafat[m]);
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
        Intent myintent1 =new Intent(this,CorrigeIsaafat.class);
        myintent1.putStringArrayListExtra("arrayList", resultasSayr);
        startActivity(myintent1);
    }


}