package com.example.a171y066.quiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class kekka extends Activity {


    private TextView kekka;
    private int kazu;
    private Button finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kekka);
        kekka = (TextView) findViewById(R.id.kekka);
        Intent intent = getIntent();
        kazu = intent.getIntExtra("intent",0);
        kekka.setText(kazu + "うんち");

    }
    public void Onclick(View view) {
        finish();
    }
}

