package com.example.work2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class resultActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        Intent intent =getIntent();
        intent.putExtra("data","今天是肖老师讲授的安卓课。\n"+
                Calendar.getInstance().getTime());
        setResult(666,intent);



    }
}