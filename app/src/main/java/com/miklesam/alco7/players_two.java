package com.miklesam.alco7;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdRequest;

import static com.miklesam.alco7.Cards.InitCards;


public class players_two extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    ArrayList cardlist= new ArrayList();
    int num;
    boolean[] had_have=new boolean[4];
    boolean[] had_eight=new boolean[4];
    ImageView Cards;
    ArrayList<ImageView> TenList = new ArrayList<ImageView>();
    ArrayList<ImageView> PlayerList = new ArrayList<ImageView>();
    ArrayList<ImageView> TurnList = new ArrayList<ImageView>();
    TextView NumCards;
    final int[] Ocnt = new int[1];
    boolean not_first_init;

    ImageView turn[] = new ImageView[4];
    ImageView Player[] = new ImageView[4];
    ImageView Ten[] = new ImageView[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_two);
        NumCards=findViewById(R.id.NumCards);
        Cards= findViewById(R.id.deck_of_cards);
        final Button StartGame=findViewById(R.id.startgame);
        if (savedInstanceState!=null)
        {  not_first_init=savedInstanceState.getBoolean("not_first_init");
            if  (not_first_init==false)
            {
                not_first_init =true;
                NumCards.setText("16");
                StartGame.setVisibility(View.VISIBLE);
            }
            else
            {
                NumCards.setText("54");
                StartGame.setVisibility(View.INVISIBLE);
                //Ocnt[0]=54;
            }


        }
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        turn[0]=findViewById(R.id.turn2);
        turn[1]=findViewById(R.id.turn5);
        turn[2]=findViewById(R.id.turn8);
        turn[3]=findViewById(R.id.turn11);
        Player[0]=findViewById(R.id.player2);
        Player[1]=findViewById(R.id.player5);
        Player[2]=findViewById(R.id.player8);
        Player[3]=findViewById(R.id.player11);
        Ten[0]=findViewById(R.id.ten_2);
        Ten[1]=findViewById(R.id.ten_5);
        Ten[2]=findViewById(R.id.ten_8);
        Ten[3]=findViewById(R.id.ten_11);

        for(int i=0;i<Player.length;i++)
        {
            PlayerList.add(Player[i]);
            TurnList.add(turn[i]);
            TenList.add(Ten[i]);
        }

        StartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StartGame.setVisibility(View.INVISIBLE);
                Cards.setVisibility(View.VISIBLE);
                for(int i=0;i<PlayerList.size();i++)
                {
                    PlayerList.get(i).setVisibility(View.VISIBLE);
                }
                TurnList.get(num).setVisibility(View.VISIBLE);


            }
        });



    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceStance) {
        super.onSaveInstanceState(savedInstanceStance);
        savedInstanceStance.putInt("number_players",Ocnt[0]);
        savedInstanceStance.putBoolean("not_first_init",not_first_init);


    }





}
