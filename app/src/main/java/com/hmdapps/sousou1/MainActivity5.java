package com.hmdapps.sousou1;

import android.annotation.SuppressLint;
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

public class MainActivity5 extends AppCompatActivity {
    TextView txt;
    int r=40;
    int x=100;
    String[] corrige = new String[]{"1","13","234","14","14","3","1","2","2","1","13","12","13","13","3","23","13","234","124","13","124",
                                     "2","123", "13","13","13","13","2","2","14","14","2","1","1","2","1","13","13","24","23","1"};
    ImageView imageView1;

    int[] images=new int[]{R.drawable.aarabas1,R.drawable.aarabas2,R.drawable.aarabas3,R.drawable.aarabas4,R.drawable.aarabas5,
            R.drawable.aarabas6,R.drawable.aarabas7, R.drawable.aarabas8,R.drawable.aarabas9,R.drawable.aarabas10,R.drawable.aarabas11,
            R.drawable.aarabas12, R.drawable.aarabas13, R.drawable.aarabas14,R.drawable.aarabas15,R.drawable.aarabas16,R.drawable.aarabas17,
            R.drawable.aarabas18,R.drawable.aarabas19, R.drawable.aarabas20,R.drawable.aarabas21,R.drawable.aarabas22,
            R.drawable.aarabas23,R.drawable.aarabas24,R.drawable.aarabas25,R.drawable.aarabas26,R.drawable.aarabas27,R.drawable.aarabas28,
            R.drawable.aarabas29,R.drawable.aarabas30,R.drawable.aarabas31,R.drawable.aarabas32,R.drawable.aarabas33, R.drawable.aarabas34,
            R.drawable.aarabas35,R.drawable.aarabas36,R.drawable.aarabas37,R.drawable.aarabas38,R.drawable.aarabas39,R.drawable.aarabas40};


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        txt=findViewById(R.id.textView3);

        imageView1= findViewById(R.id.imageView);
        final ListView listView = findViewById(R.id.listview2);
        txt.setText("Résultat :");

        getIntent();
        Bundle bundle = getIntent().getExtras();
        final ArrayList<String> resltasaaraba = bundle.getStringArrayList("arrayList");
        final ArrayAdapter<String> items = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resltasaaraba);
        listView.setAdapter(items);
        Toast.makeText(getApplicationContext(),"اضغط على الجواب الخاطئ لترى التصحيح",Toast.LENGTH_LONG).show();

        for (int i=0; i<=39 ;i++){
            if (resltasaaraba.get(i).equals(corrige[i])){
                resltasaaraba.set(i,"السؤال "+(i+1)+" : "+resltasaaraba.get(i)+"         ===>  صحيح "); }

            else { resltasaaraba.set(i, "السؤال "+(i+1)+" : "+resltasaaraba.get(i) +"         ===>  خطا الجواب الصحيح هو : "+"   "+corrige[i]);
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
                    imageView1.setImageResource(images[posotion]);
                    imageView1.getBackground();
                }
            }});

    }

    public void replay(View view) {

            Intent myintent1 =new Intent(this,MainActivity.class);
            startActivity(myintent1);

    }
}