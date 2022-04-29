package com.hmdapps.sousou1;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Roaya extends AppCompatActivity {
    TextView txt,one,two,tree,foor,num,oress;
    String ones,twos,trees,foors,interos,repons;
    counter cn;
    long s;
    int m=0;
    int x=m+1;
    int y=1;
    final ArrayList<String> resultasRoaya = new ArrayList<>();
    ImageView imageView1;
    int[] imagesRoaya =new int[]{R.drawable.roaya1,R.drawable.roaya2,R.drawable.roaya3,R.drawable.roaya4,R.drawable.roaya5,R.drawable.roaya6
            ,R.drawable.roaya7,R.drawable.roaya8,R.drawable.roaya9,R.drawable.roaya10,R.drawable.roaya11,R.drawable.roaya12,R.drawable.roaya13
            ,R.drawable.roaya14,R.drawable.roaya15,R.drawable.roaya16,R.drawable.roaya17,R.drawable.roaya18,R.drawable.roaya19,R.drawable.roaya20
            ,R.drawable.roaya21,R.drawable.roaya22,R.drawable.roaya23,R.drawable.roaya24,R.drawable.roaya25,R.drawable.roaya26,R.drawable.roaya27
            ,R.drawable.roaya28,R.drawable.roaya29,R.drawable.roaya30,R.drawable.roaya31,R.drawable.roaya32,R.drawable.roaya33,R.drawable.roaya34
            ,R.drawable.roaya35,R.drawable.roaya36,R.drawable.roaya37,R.drawable.roaya38,R.drawable.roaya39,R.drawable.roaya40,R.drawable.roaya40};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roaya);
        txt=(TextView)findViewById(R.id.textView);
        num=(TextView)findViewById(R.id.textView13);
        one=(TextView)findViewById(R.id.textView9);
        two=(TextView)findViewById(R.id.textView12);
        tree=(TextView)findViewById(R.id.textView11);
        foor=(TextView)findViewById(R.id.textView10);
        oress=(TextView)findViewById(R.id.textView14);

        ones=twos=trees=foors=interos="";
        imageView1=(ImageView)findViewById(R.id.imageViewtajawoz);
        imageView1.setImageResource(imagesRoaya[m]);
        num.setText("السؤال  :"+(x));
        starttime();

    }

    public void busuivant(View view) {
        cn.cancel();
        repons=(ones+""+twos+""+trees+""+foors+""+interos);
        x=x+1;
        if (m<=39){

            resultasRoaya.add(m,repons);
            m=m+1;
            imageView1.setImageResource(imagesRoaya[m]);
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
        cn= new Roaya.counter(31000,  1000);
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

                resultasRoaya.add(m,repons);
                m=m+1;
                imageView1.setImageResource(imagesRoaya[m]);
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
        Intent myintent1 =new Intent(this,CorrigeRoaya.class);
        myintent1.putStringArrayListExtra("arrayList", resultasRoaya);
        startActivity(myintent1);
    }


}