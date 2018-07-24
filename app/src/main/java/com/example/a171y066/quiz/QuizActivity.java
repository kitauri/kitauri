package com.example.a171y066.quiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class QuizActivity extends Activity {
    private TextView tv_num;
    private TextView bun;
    private TextView test;
    private TableLayout table;
    private ImageView imageView;
    private Button[] buttons;
    private TextView result;
    private Quiz quiz;
    private Button next;
    private int seikaisuu = 0;
    private int mondaisuu = 0;

    QuizActivity(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // 画面上のウィジェットを取得しておく
        tv_num = (TextView) findViewById(R.id.textView3);
        bun = (TextView) findViewById(R.id.textView2);
        test = (TextView) findViewById(R.id.textview4);
        result = (TextView) findViewById(R.id.result);
        imageView = (ImageView) findViewById(R.id.imageView);
        table= (TableLayout) findViewById(R.id.table);
        next = (Button) findViewById(R.id.next);
        buttons = new Button[4];
        buttons[0] = (Button) findViewById(R.id.button2);
        buttons[1] = (Button) findViewById(R.id.button3);
        buttons[2] = (Button) findViewById(R.id.button4);
        buttons[3] = (Button) findViewById(R.id.button5);


        // データを受け取る
        Intent intent = getIntent();
        if (intent != null) {
            quiz = (Quiz) intent.getSerializableExtra("Quiz");
            show();
        }
    }

   public void answer(View view) {

        for (int i = 0; i < buttons.length; i++) {
            if (view.getId() == buttons[i].getId()) {
                if (buttons[i].getText() == quiz.answer_index) {
                    seikaisuu++;
                    mondaisuu++;
                    result.setText("正解!");
                    next.setVisibility(View.VISIBLE);
                    table.setVisibility(View.INVISIBLE);

                } else {
                    mondaisuu++;
                    result.setText("不正解...");
                    next.setVisibility(View.VISIBLE);
                    table.setVisibility(View.INVISIBLE);
                }
            }
        }
    }
    private static int[] ransuu(){
        ArrayList<Integer> list = new ArrayList<Integer>();

        // listに値を入れる。この段階では昇順
        for (int i = 0; i <= 3; i++) {
            list.add(i);
        }
        // シャッフルして、順番を変える
        Collections.shuffle(list);
        int[] foo;
        foo = new int[4];
        for (int i = 0,j = 0; i <= 3; i++,j++) {
            int kazu = 0;
            kazu = list.get(i);
            foo[j] = kazu;
        }
        return foo;

    }
        // 次の問題へ移る

    public void next(View view){
        int foo[];
        foo = ransuu();
        int i = 0;
        quiz = Quiz.getQuiz(foo[mondaisuu]);
       // test.setText(foo[i]);

        if (quiz != null) {
            result.setText("");
            show();
        } else {
            Intent intent = new Intent(getApplication(),kekka.class);
            intent.putExtra("intent", seikaisuu);
            startActivity(intent);
            finish();  //最後の問題の時は移る先がないので一旦MainActivityに戻す

        }
    }



    // 表示に反映させる
        void show() {
        if (quiz != null) {
            tv_num.setText(quiz.q_string);
            bun.setText(quiz.bun);
            imageView.setImageResource(quiz.image);
            next.setVisibility(View.INVISIBLE);
            table.setVisibility(View.VISIBLE);

            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setText(quiz.choices[i]);
            }
        }
    }




}

