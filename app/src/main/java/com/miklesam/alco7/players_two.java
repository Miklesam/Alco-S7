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


public class players_two extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    ArrayList cardlist= new ArrayList();
    int num;
    boolean[] had_have=new boolean[4];
    ArrayList<ImageView> TenList = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_two);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        final ImageView Cards= (ImageView) findViewById(R.id.deck_of_cards);
        final ImageView Cardtaken=findViewById(R.id.card_taken);
        final Button Throwcard = findViewById(R.id.throwcard);
        final Button Backtomenu = findViewById(R.id.back_to_menu);
        final ImageView[] turn = new ImageView[4];
        final ImageView[] Player = new ImageView[4];
        final ImageView[] Ten = new ImageView[4];



        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

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








        final TextView NumCards=(TextView) findViewById(R.id.NumCards);

        final Random random = new Random();




        final Intent tomenuintent = new Intent(this, MainActivity.class);


        final boolean[] card_is_taken = new boolean[1];

        if (savedInstanceState!=null)
        {
            cardlist=savedInstanceState.getIntegerArrayList("cardlist");
            num=savedInstanceState.getInt("seq_num");
            had_have=savedInstanceState.getBooleanArray("had_have");
            for (int i=0;i<had_have.length;i++)
            {
                if(had_have[i]==true)
                {
                    TenList.get(i).setVisibility(View.VISIBLE);
                }

            }

         }
        else
        {
            num= random.nextInt(4);
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
        }



        Collections.shuffle(cardlist);

        NumCards.setText(String.valueOf(cardlist.size()));


        final ArrayList<ImageView> PlayerList = new ArrayList<ImageView>();
        final ArrayList<ImageView> TurnList = new ArrayList<ImageView>();


        for(int i=0;i<Player.length;i++)
        {
            PlayerList.add(Player[i]);
            TurnList.add(turn[i]);
            TenList.add(Ten[i]);
        }


        for(int i= 0;i<PlayerList.size();i++ )
        {
            PlayerList.get(i).setVisibility(View.VISIBLE);
        }

        TurnList.get(num).setVisibility(View.VISIBLE);

        Cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_is_taken[0] =true;

                Collections.shuffle(cardlist);
                String count = (String) NumCards.getText();
                int cnt=Integer.parseInt(count);
                TurnList.get(num).setVisibility(View.INVISIBLE);

                Cards.setVisibility(View.INVISIBLE);

                for(int i= 0;i<PlayerList.size();i++ )
                {
                    PlayerList.get(i).setVisibility(View.INVISIBLE);
                    TenList.get(i).setVisibility(View.INVISIBLE);
                }


                Random randomcard = new Random();
                int whattacard=0;
                if (cardlist.size()>1)
                {
                    whattacard=randomcard.nextInt(cardlist.size());
                    Cardtaken.setImageResource((Integer) cardlist.get(whattacard));

                    Cardtaken.setVisibility(View.VISIBLE);
                    if ((cardlist.get(whattacard).equals(R.drawable.ten_vini))||(cardlist.get(whattacard).equals(R.drawable.ten_kresti))||
                            (cardlist.get(whattacard).equals(R.drawable.ten_chervi))||(cardlist.get(whattacard).equals(R.drawable.ten_bubi)))
                    {
                        for(int i=0;i<had_have.length;i++)
                        {
                            had_have[i]=false;
                        }

                        had_have[num]=true;

                    }
                    Throwcard.setVisibility(View.VISIBLE);

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
                card_is_taken[0]=false;
                for (int i=0;i<had_have.length;i++)
                {
                    if(had_have[i]==true)
                    {
                        TenList.get(i).setVisibility(View.VISIBLE);
                    }

                }

                Cards.setVisibility(View.VISIBLE);
                for(int i= 0;i<PlayerList.size();i++ )
                {
                    PlayerList.get(i).setVisibility(View.VISIBLE);
                }

                if(num <4-1)
                {

                    num++;
                    TurnList.get(num).setVisibility(View.VISIBLE);
                }
                else
                {
                    num =0;
                    TurnList.get(num).setVisibility(View.VISIBLE);
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


    public void onSaveInstanceState(Bundle savedInstanceStance) {
        super.onSaveInstanceState(savedInstanceStance);
        savedInstanceStance.putIntegerArrayList("cardlist", cardlist);
        savedInstanceStance.putInt("seq_num",num);
        savedInstanceStance.putBooleanArray("had_have", had_have);




    }





}
