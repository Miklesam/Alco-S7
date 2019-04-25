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



        final Button ToMenu = findViewById(R.id.rools_to_menu);
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
        MinAce.setImageResource(R.drawable.mini_ace_chervi);
        MinKing.setImageResource(R.drawable.mini_k_chervi);
        MinQueen.setImageResource(R.drawable.mini_q_chervi);
        MinJack.setImageResource(R.drawable.mini_j_chervi);
        MinTen.setImageResource(R.drawable.mini_ten_chervi);
        MinNine.setImageResource(R.drawable.mini_nine_chervi);
        MinEight.setImageResource(R.drawable.mini_eight_chervi);
        MinSeven.setImageResource(R.drawable.mini_seven_chervi);
        MinSix.setImageResource(R.drawable.mini_six_chervi);
        BigPic.setImageResource(R.drawable.ace_chervi);
        MainText.setText("Выбери кто пьет");

        final LinearLayout Ace = findViewById(R.id.Ace);
        final LinearLayout King = findViewById(R.id.king);
        final LinearLayout Queen = findViewById(R.id.Queen);

        final LinearLayout Jack = findViewById(R.id.Jack);
        final LinearLayout Ten = findViewById(R.id.Ten);
        final LinearLayout Nine = findViewById(R.id.Nine);

        final LinearLayout Eight = findViewById(R.id.Eight);
        final LinearLayout Seven = findViewById(R.id.Seven);
        final LinearLayout Six = findViewById(R.id.Six);






        ToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(to_menu);

            }
        });

        Ace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigPic.setImageResource(R.drawable.ace_chervi);
                MainText.setText("Выбери кто пьет");

            }
        });

        King.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigPic.setImageResource(R.drawable.k_chervi);
                MainText.setText("Запрет");

            }
        });

        Queen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigPic.setImageResource(R.drawable.q_chervi);
                MainText.setText("Поднять руку");

            }
        });

        Jack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigPic.setImageResource(R.drawable.j_chervi);
                MainText.setText("Действие");

            }
        });

        Ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigPic.setImageResource(R.drawable.ten_chervi);
                MainText.setText("Вопрос");

            }
        });

        Nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigPic.setImageResource(R.drawable.nine_chervi);
                MainText.setText("Тема");

            }
        });

        Eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigPic.setImageResource(R.drawable.eight_chervi);
                MainText.setText("Щит");
            }
        });

        Seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigPic.setImageResource(R.drawable.seven_chervi);
                MainText.setText("Счет");
            }
        });

        Six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigPic.setImageResource(R.drawable.six_chervi);
                MainText.setText("Пьешь сам");
            }
        });


    }





}

