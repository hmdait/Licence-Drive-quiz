package com.hmdapps.sousou1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Feedback extends AppCompatActivity {
    String to, subject, message;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        Button send = findViewById(R.id.fb_submit);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateFeedback();
            }
        });
    }
    @SuppressLint("IntentReset")
    private void generateFeedback() {
        RadioGroup type = findViewById(R.id.fb_type);
        EditText feed = findViewById(R.id.fb_text);
        RatingBar ratingBar = findViewById(R.id.app_ratings);
        int tp= type.getCheckedRadioButtonId();
        RadioButton selectedType = findViewById(tp);
        String feedtype= selectedType.getText().toString();
        String feedback= feed.getText().toString();
        float rating= ratingBar.getRating();
        View focusView = null;
        boolean cancel = false;

        feed.setError(null);


        if (TextUtils.isEmpty(feedback)) {
            feed.setError(getString(R.string.error_field_required));
            focusView = feed;
            cancel = true;
        }
        if (cancel) {
            focusView.requestFocus();
        }
        else
        {
            to="hmd1apps@gmail.com";
            subject=feedtype;
            message=feedback +"\n\nRating : "+rating+ "\n\nFrom امتحان السياقة";
            Intent sendmail = new Intent(Intent.ACTION_SEND);
            sendmail.setData(Uri.parse("mailto:"));
            sendmail.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
            sendmail.putExtra(Intent.EXTRA_SUBJECT, subject);
            sendmail.putExtra(Intent.EXTRA_TEXT, message);


            //need this to prompts email client only
            sendmail.setType("message/rfc822");

//            startActivity(Intent.createChooser(sendmail, "Choose an Email client :"));
            try {
                startActivityForResult(Intent.createChooser(sendmail, "Send mail..."),0);
                //finish();
                Log.i("شكرا لك", "");
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(Feedback.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(Feedback.this, "Thank you for your feedback!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Feedback.this, MainActivity.class);
        startActivity(intent);
    }
}