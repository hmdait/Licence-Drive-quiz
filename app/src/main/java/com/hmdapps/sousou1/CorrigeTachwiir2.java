package com.hmdapps.sousou1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CorrigeTachwiir2 extends AppCompatActivity {
    TextView txt;
    int r=40;
    int x=100;
    String[] corrigetajawoz = new String[]{"3","2","13","13","3","13","3","2","23","1","2","2","1","1","2","1","2","2","2","12","23",
            "2","2","2","2","1","1","2","1","2","12","2","3","1","12","1","1","1","2","1","1"};
    ImageView imageView1;
    int[] imagestachwiir =new int[]{R.drawable.taxwirrs1,R.drawable.taxwirrs2,R.drawable.taxwirrs3,R.drawable.taxwirrs4,R.drawable.taxwirrs5,R.drawable.taxwirrs6
            ,R.drawable.taxwirrs7,R.drawable.taxwirrs8,R.drawable.taxwirrs9,R.drawable.taxwirrs10,R.drawable.taxwirrs11,R.drawable.taxwirrs12,R.drawable.taxwirrs13
            ,R.drawable.taxwirrs14,R.drawable.taxwirrs15,R.drawable.taxwirrs16,R.drawable.taxwirrs17,R.drawable.taxwirrs18,R.drawable.taxwirrs19,R.drawable.taxwirrs20
            ,R.drawable.taxwirrs21,R.drawable.taxwirrs22,R.drawable.taxwirrs23,R.drawable.taxwirrs24,R.drawable.taxwirrs25,R.drawable.taxwirrs26,R.drawable.taxwirrs27
            ,R.drawable.taxwirrs28,R.drawable.taxwirrs29,R.drawable.taxwirrs30,R.drawable.taxwirrs31,R.drawable.taxwirrs32,R.drawable.taxwirrs33,R.drawable.taxwirrs34
            ,R.drawable.taxwirrs35,R.drawable.taxwirrs36,R.drawable.taxwirrs37,R.drawable.taxwirrs38,R.drawable.taxwirrs39,R.drawable.taxwirrs40,R.drawable.taxwirrs40};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corrige_tachwiir2);


        imageView1= findViewById(R.id.imageView);
        txt= findViewById(R.id.textView3);
        final ListView listView = findViewById(R.id.listview2);
        txt.setText("Résultat :");

        getIntent();
        Bundle bundle = getIntent().getExtras();
        final ArrayList<String> resltasaaraba = bundle.getStringArrayList("arrayList");

        final ArrayAdapter<String> items = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,resltasaaraba);
        listView.setAdapter(items);
        Toast.makeText(getApplicationContext(),"اضغط على الجواب الخاطئ لترى التصحيح",Toast.LENGTH_LONG).show();

        for (int i=0; i<=39 ;i++){
            if (resltasaaraba.get(i).equals(corrigetajawoz[i])){
                resltasaaraba.set(i,"السؤال "+(i+1)+" : "+resltasaaraba.get(i)+"         ===>  صحيح "); }

            else { resltasaaraba.set(i, "السؤال "+(i+1)+" : "+resltasaaraba.get(i) +"         ===>  خطا الجواب الصحيح هو : "+"   "+ corrigetajawoz[i]);
                r=r-1;
            }
        }
        resltasaaraba.add("النتيجة : "+r+"/40");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posotion, long id) {
                if(posotion!=x & posotion!=40){
                    x=posotion;
                    view.setSelected(true);
                    Toast.makeText(getApplicationContext(),"  السؤال "+(posotion+1)+" خاطئ  ",Toast.LENGTH_LONG).show();
                    imageView1.setImageResource(imagestachwiir[posotion]);
                    imageView1.getBackground();
                }
            }});
    }

    public void replay(View view) {
            Intent myintent1 =new Intent(this,MainActivity.class);
            startActivity(myintent1);

    }
}