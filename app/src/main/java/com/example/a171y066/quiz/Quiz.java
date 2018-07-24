package com.example.a171y066.quiz;

import java.io.Serializable;

/**
 * Created by 171y066 on 2018/06/08.
 */

public class Quiz implements Serializable{
    int q_num; // 問題番号
    String q_string;// 第○問というString
    String bun;
    int image; // 画像ID
    String[] choices = new String[4]; // 選択肢
    String answer_index; // 正解の選択肢


    private static Quiz[] quizzes = new Quiz[10]; // クイズの配列

    private Quiz(int q_num, String q_string,String bun,int image, String[] choices, String answer_index) {
        this.q_num = q_num;
        this.q_string = q_string;
        this.bun = bun;
        this.image = image;
        this.choices = choices;
        this.answer_index = answer_index;
    }



    // 問題の登録(ここでは1問のみ)
    public static void init() {
        quizzes[0] = new Quiz(0, "第1問","このキャラクターは", R.drawable.aaa, new String[]{"どらえもん", "ドラえもん", "どらエモン", "とらえもん"}, "ドラえもん");
        quizzes[1] = new Quiz(1, "第2問","このキャラクターはなんぞや", R.drawable.bbb, new String[]{"じゃっじゃ", "じゃーん", "ニャンちゅう", "だにゃーん"},  "ニャンちゅう");
        quizzes[2] = new Quiz(2, "第3問","このキャラクターはなんぞや", R.drawable.ccc, new String[]{"来ヶ谷", "西園", "棗", "朱鷺戸"}, "来ヶ谷");
        quizzes[3] = new Quiz(3, "第4問","このキャラクターはなんぞや", R.drawable.numa, new String[]{"ぬまたひろき", "ぬまたこうき", "うんこまん", "きたうり"}, "ぬまたひろき");
        quizzes[4] = new Quiz(4, "第4問","このキャラクターはなんぞや", R.drawable.ddd, new String[]{"もらきー", "ぽらきー", "どらきー", "どらえもん"}, "どらきー");
    }

    // 問題を取得する
    public static Quiz getQuiz(int num) {
        if (num >= quizzes.length) {
            return null;
        }
        return quizzes[num];
    }
}