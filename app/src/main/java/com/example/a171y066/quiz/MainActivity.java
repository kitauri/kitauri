package com.example.a171y066.quiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Quiz.init();
    }
    public void openQuiz(View view){
        Intent intent = new Intent(getApplication(),QuizActivity.class);
        intent.putExtra("Quiz", Quiz.getQuiz(0));
        startActivity(intent);
    }

}
