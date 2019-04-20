package com.miklesam.alco7;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdRequest;


public class players_two extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;



    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_two);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Intent newintent = getIntent();
        final int Num =newintent.getIntExtra("num",0);

        final ImageView Cards= (ImageView) findViewById(R.id.deck_of_cards);
        final ImageView Cardtaken=findViewById(R.id.card_taken);

        final Button Throwcard = findViewById(R.id.throwcard);
        final Button Backtomenu = findViewById(R.id.back_to_menu);

        final ImageView[] turn = new ImageView[12];
        final ImageView[] Player = new ImageView[12];
        final ImageView[] Ten = new ImageView[12];


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        turn[0]=findViewById(R.id.turn1);
        turn[1]=findViewById(R.id.turn2);
        turn[2]=findViewById(R.id.turn3);
        turn[3]=findViewById(R.id.turn4);
        turn[4]=findViewById(R.id.turn5);
        turn[5]=findViewById(R.id.turn6);
        turn[6]=findViewById(R.id.turn7);
        turn[7]=findViewById(R.id.turn8);
        turn[8]=findViewById(R.id.turn9);
        turn[9]=findViewById(R.id.turn10);
        turn[10]=findViewById(R.id.turn11);
        turn[11]=findViewById(R.id.turn12);



        Player[0]=findViewById(R.id.player1);
        Player[1]=findViewById(R.id.player2);
        Player[2]=findViewById(R.id.player3);
        Player[3]=findViewById(R.id.player4);
        Player[4]=findViewById(R.id.player5);
        Player[5]=findViewById(R.id.player6);
        Player[6]=findViewById(R.id.player7);
        Player[7]=findViewById(R.id.player8);
        Player[8]=findViewById(R.id.player9);
        Player[9]=findViewById(R.id.player10);
        Player[10]=findViewById(R.id.player11);
        Player[11]=findViewById(R.id.player12);


        Ten[0]=findViewById(R.id.ten_1);
        Ten[1]=findViewById(R.id.ten_2);
        Ten[2]=findViewById(R.id.ten_3);
        Ten[3]=findViewById(R.id.ten_4);
        Ten[4]=findViewById(R.id.ten_5);
        Ten[5]=findViewById(R.id.ten_6);
        Ten[6]=findViewById(R.id.ten_7);
        Ten[7]=findViewById(R.id.ten_8);
        Ten[8]=findViewById(R.id.ten_9);
        Ten[9]=findViewById(R.id.ten_10);
        Ten[10]=findViewById(R.id.ten_11);
        Ten[11]=findViewById(R.id.ten_12);


        final TextView NumCards=(TextView) findViewById(R.id.NumCards);
        NumCards.setText(String.valueOf(Num));
        final Random random = new Random();
        final int[] num = {random.nextInt(Num)};
        final Intent tomenuintent = new Intent(this, MainActivity.class);
        final ArrayList cardlist= new ArrayList();

        cardlist.add(R.drawable.new_ace);
        cardlist.add(R.drawable.ace_chervi);
        cardlist.add(R.drawable.ace_kresti);
        cardlist.add(R.drawable.ace_vini);

        cardlist.add(R.drawable.k_bubi);
        cardlist.add(R.drawable.k_chervi);
        cardlist.add(R.drawable.k_kresti);
        cardlist.add(R.drawable.k_vini);

        cardlist.add(R.drawable.q_bubi);
        cardlist.add(R.drawable.q_chervi);
        cardlist.add(R.drawable.q_kresti);
        cardlist.add(R.drawable.q_vini);

        cardlist.add(R.drawable.j_bubi);
        cardlist.add(R.drawable.j_chervi);
        cardlist.add(R.drawable.j_kresti);
        cardlist.add(R.drawable.j_vini);

        cardlist.add(R.drawable.ten_bubi);
        cardlist.add(R.drawable.ten_chervi);
        cardlist.add(R.drawable.ten_kresti);
        cardlist.add(R.drawable.ten_vini);

        cardlist.add(R.drawable.nine_bubi);
        cardlist.add(R.drawable.nine_chervi);
        cardlist.add(R.drawable.nine_kresti);
        cardlist.add(R.drawable.nine_vini);

        cardlist.add(R.drawable.eight_bubi);
        cardlist.add(R.drawable.eight_chervi);
        cardlist.add(R.drawable.eight_kresti);
        cardlist.add(R.drawable.eight_vini);

        cardlist.add(R.drawable.seven_bubi);
        cardlist.add(R.drawable.seven_chervi);
        cardlist.add(R.drawable.seven_kresti);
        cardlist.add(R.drawable.seven_vini);

        cardlist.add(R.drawable.six_bubi);
        cardlist.add(R.drawable.six_chervi);
        cardlist.add(R.drawable.six_kresti);
        cardlist.add(R.drawable.six_vini);

        Collections.shuffle(cardlist);


        final ArrayList<ImageView> PlayerList = new ArrayList<ImageView>();
        final ArrayList<ImageView> TurnList = new ArrayList<ImageView>();
        final ArrayList<ImageView> TenList = new ArrayList<ImageView>();
        if(Num==4)
        {
            PlayerList.add(Player[1]);
            PlayerList.add(Player[4]);
            PlayerList.add(Player[7]);
            PlayerList.add(Player[10]);

            TurnList.add(turn[1]);
            TurnList.add(turn[4]);
            TurnList.add(turn[7]);
            TurnList.add(turn[10]);

            TenList.add(Ten[1]);
            TenList.add(Ten[4]);
            TenList.add(Ten[7]);
            TenList.add(Ten[10]);

        }
        else if(Num==5)
        {
            PlayerList.add(Player[1]);
            PlayerList.add(Player[4]);
            PlayerList.add(Player[6]);
            PlayerList.add(Player[8]);
            PlayerList.add(Player[10]);

            TurnList.add(turn[1]);
            TurnList.add(turn[4]);
            TurnList.add(turn[6]);
            TurnList.add(turn[8]);
            TurnList.add(turn[10]);


        }
        else if(Num==6)
        {
            PlayerList.add(Player[0]);
            PlayerList.add(Player[2]);
            PlayerList.add(Player[4]);
            PlayerList.add(Player[6]);
            PlayerList.add(Player[8]);
            PlayerList.add(Player[10]);

            TurnList.add(turn[0]);
            TurnList.add(turn[2]);
            TurnList.add(turn[4]);
            TurnList.add(turn[6]);
            TurnList.add(turn[8]);
            TurnList.add(turn[10]);

        }
        else if(Num==7)
        {
            PlayerList.add(Player[0]);
            PlayerList.add(Player[2]);
            PlayerList.add(Player[3]);
            PlayerList.add(Player[5]);
            PlayerList.add(Player[6]);
            PlayerList.add(Player[8]);
            PlayerList.add(Player[10]);

            TurnList.add(turn[0]);
            TurnList.add(turn[2]);
            TurnList.add(turn[3]);
            TurnList.add(turn[5]);
            TurnList.add(turn[6]);
            TurnList.add(turn[8]);
            TurnList.add(turn[10]);

        }
        else if(Num==8)
        {
            PlayerList.add(Player[0]);
            PlayerList.add(Player[2]);
            PlayerList.add(Player[3]);
            PlayerList.add(Player[5]);
            PlayerList.add(Player[6]);
            PlayerList.add(Player[8]);
            PlayerList.add(Player[9]);
            PlayerList.add(Player[11]);

            TurnList.add(turn[0]);
            TurnList.add(turn[2]);
            TurnList.add(turn[3]);
            TurnList.add(turn[5]);
            TurnList.add(turn[6]);
            TurnList.add(turn[8]);
            TurnList.add(turn[9]);
            TurnList.add(turn[11]);

        }



        for(int i= 0;i<PlayerList.size();i++ )
        {
            PlayerList.get(i).setVisibility(View.VISIBLE);
        }

        TurnList.get(num[0]).setVisibility(View.VISIBLE);

        Cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Collections.shuffle(cardlist);
                String count = (String) NumCards.getText();
                int cnt=Integer.parseInt(count);
                TurnList.get(num[0]).setVisibility(View.INVISIBLE);

                Cards.setVisibility(View.INVISIBLE);

                for(int i= 0;i<PlayerList.size();i++ )
                {
                    PlayerList.get(i).setVisibility(View.INVISIBLE);
                }

                //Player[1].setVisibility(View.INVISIBLE);
                //Player[3].setVisibility(View.INVISIBLE);

                Random randomcard = new Random();
                int whattacard=0;
                if (cardlist.size()>1)
                {
                    whattacard=randomcard.nextInt(cardlist.size());
                    Cardtaken.setImageResource((Integer) cardlist.get(whattacard));

                    Cardtaken.setVisibility(View.VISIBLE);
                    Throwcard.setVisibility(View.VISIBLE);
                    if (cardlist.get(whattacard).equals(R.drawable.ten_vini))
                    {
                        TenList.get(num[0]).setVisibility(View.VISIBLE);
                    }

                    cardlist.remove(whattacard);

                }
                else if (cardlist.size()==1)
                {
                    whattacard=0;
                    Cardtaken.setImageResource((Integer) cardlist.get(whattacard));
                    cardlist.remove(whattacard);
                    Cardtaken.setVisibility(View.VISIBLE);
                    Throwcard.setVisibility(View.VISIBLE);
                }




                if(cnt>0)
                {
                    cnt--;
                    NumCards.setText(String.valueOf(cardlist.size()));


                }



            }
        });



        Throwcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cards.setVisibility(View.VISIBLE);
                for(int i= 0;i<PlayerList.size();i++ )
                {
                    PlayerList.get(i).setVisibility(View.VISIBLE);
                }

                if(num[0] <Num-1)
                {

                    num[0]++;
                    TurnList.get(num[0]).setVisibility(View.VISIBLE);
                }
                else
                {
                    num[0] =0;
                    TurnList.get(num[0]).setVisibility(View.VISIBLE);
                }


                Cardtaken.setVisibility(View.INVISIBLE);
                Throwcard.setVisibility(View.INVISIBLE);



                if (cardlist.size()==0)
                {
                    NumCards.setText("Конец колоды");
                    Cards.setVisibility(View.INVISIBLE);
                    Backtomenu.setVisibility(View.VISIBLE);
                    for(int i= 0;i<PlayerList.size();i++ )
                    {
                        PlayerList.get(i).setVisibility(View.INVISIBLE);
                    }
                    for(int i= 0;i<TurnList.size();i++ )
                    {
                        TurnList.get(i).setVisibility(View.INVISIBLE);
                    }

                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();


                    } else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }
                }




            }
        });



        Backtomenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(tomenuintent);

            }
        });



    }


}
