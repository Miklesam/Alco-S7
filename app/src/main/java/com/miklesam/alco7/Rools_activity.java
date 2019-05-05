package com.miklesam.alco7;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Rools_activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_rools_activity);



       final Intent to_menu = new Intent(this, MainActivity.class);

        ImageView MinAce= findViewById(R.id.minAce);
        ImageView MinKing= findViewById(R.id.minKing);
        ImageView MinQueen= findViewById(R.id.minQueen);
        ImageView MinJack= findViewById(R.id.minJack);
        ImageView MinTen= findViewById(R.id.minTen);
        ImageView MinNine= findViewById(R.id.minNine);
        ImageView MinEight= findViewById(R.id.minEight);
        ImageView MinSeven= findViewById(R.id.minSeven);
        ImageView MinSix= findViewById(R.id.minSix);

        final ImageView BigPic= findViewById(R.id.big_pic);
        final TextView MainText = findViewById(R.id.Main_Text);
        final  TextView Help_Text =findViewById(R.id.Help_Text);

        MinAce.setImageResource(R.drawable.small_ace);
        MinKing.setImageResource(R.drawable.small_king);
        MinQueen.setImageResource(R.drawable.small_queen);
        MinJack.setImageResource(R.drawable.small_jack);
        MinTen.setImageResource(R.drawable.small_ten);
        MinNine.setImageResource(R.drawable.small_nine);
        MinEight.setImageResource(R.drawable.small_eight);
        MinSeven.setImageResource(R.drawable.small_seven);
        MinSix.setImageResource(R.drawable.small_six);
        BigPic.setImageResource(R.drawable.mid_ace);
        MainText.setText("Выбери кто пьет.");

        final LinearLayout Ace = findViewById(R.id.Ace);
        final LinearLayout King = findViewById(R.id.king);
        final LinearLayout Queen = findViewById(R.id.Queen);

        final LinearLayout Jack = findViewById(R.id.Jack);
        final LinearLayout Ten = findViewById(R.id.Ten);
        final LinearLayout Nine = findViewById(R.id.Nine);

        final LinearLayout Eight = findViewById(R.id.Eight);
        final LinearLayout Seven = findViewById(R.id.Seven);
        final LinearLayout Six = findViewById(R.id.Six);





        Ace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigPic.setImageResource(R.drawable.ace_chervi);
                MainText.setText("Выбери кто пьет.");
                Help_Text.setText("");

            }
        });

        King.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigPic.setImageResource(R.drawable.k_chervi);
                MainText.setText("Запрет");
                Help_Text.setText("Установите запрет, который нельзя нарушать за столом.\n" +
                        "Например: Нельзя пить правой рукой.\n" +
                        "Нарушитель пьет.");

            }
        });

        Queen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigPic.setImageResource(R.drawable.q_chervi);
                MainText.setText("Рука");
                Help_Text.setText("Нужно поднять руку вверх.\n" +
                        "Последний поднявший пьет.");

            }
        });

        Jack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigPic.setImageResource(R.drawable.j_chervi);
                MainText.setText("Действие");
                Help_Text.setText("Установите действие, которое необходимо совершить перед тем как выпить.\n" +
                        "Тот, кто забудет выполнить действие, пьет.");

            }
        });

        Ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigPic.setImageResource(R.drawable.ten_chervi);
                MainText.setText("Вопрос");
                Help_Text.setText("У вас появится индикатор 10.\n" +
                        "На любой ваш вопрос нельзя отвечать.\n" +
                        "Тот, кто ответит на ваш вопрос, пьет.\n" +
                        "Когда выпадает другая десятка, предыдущая аннулируется.");

            }
        });

        Nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigPic.setImageResource(R.drawable.nine_chervi);
                MainText.setText("Тема");
                Help_Text.setText("Задайте тему.\n" +
                        "Например: Марки машин. \n" +
                        "Все по очереди называют марки машин.\n" +
                        "Тот, кто повторится или не сможет назвать, пьет.");

            }
        });

        Eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigPic.setImageResource(R.drawable.eight_chervi);
                MainText.setText("Щит");
                Help_Text.setText("У вас появится индикатор 8.\n" +
                        "Вы можете использовать Восьмерку, чтобы не пить один раз.\n" +
                        "Для этого нажмите на нее и сбросьте.");

            }
        });

        Seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigPic.setImageResource(R.drawable.seven_chervi);
                MainText.setText("Счет");
                Help_Text.setText("С того кто вытянул 7 начинается счет.\n" +
                        "Все по очереди считают, нельзя называть числа кратные 7 и числа где присутсвует 7.\n" +
                        "Тот, кто ошибется, пьет.");


            }
        });

        Six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigPic.setImageResource(R.drawable.six_chervi);
                MainText.setText("Пьешь сам.");
                Help_Text.setText("Выпей сам.");
            }
        });


    }





}

