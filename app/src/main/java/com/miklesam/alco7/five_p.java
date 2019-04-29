package com.miklesam.alco7;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static com.miklesam.alco7.Cards.InitCards;

public class five_p extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    ArrayList cardlist= new ArrayList();
    int num;
    boolean[] had_have=new boolean[5];
    ArrayList<ImageView> TenList = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_p);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        final ImageView BigPic= findViewById(R.id.big_pic);
        final TextView MainText = findViewById(R.id.Main_Text);
        final ImageView Cards= (ImageView) findViewById(R.id.deck_of_cards);
        final ImageView Cardtaken=findViewById(R.id.card_taken);
        final Button Throwcard = findViewById(R.id.throwcard);
        final Button Backtomenu = findViewById(R.id.back_to_menu);
        final ImageView[] turn = new ImageView[5];
        final ImageView[] Player = new ImageView[5];
        final ImageView[] Ten = new ImageView[5];

        //Init Info_rools

        ImageView MinAce= findViewById(R.id.minAce);
        ImageView MinKing= findViewById(R.id.minKing);
        ImageView MinQueen= findViewById(R.id.minQueen);
        ImageView MinJack= findViewById(R.id.minJack);
        ImageView MinTen= findViewById(R.id.minTen);
        ImageView MinNine= findViewById(R.id.minNine);
        ImageView MinEight= findViewById(R.id.minEight);
        ImageView MinSeven= findViewById(R.id.minSeven);
        ImageView MinSix= findViewById(R.id.minSix);


        MinAce.setImageResource(R.drawable.mini_ace_chervi);
        MinKing.setImageResource(R.drawable.mini_k_chervi);
        MinQueen.setImageResource(R.drawable.mini_q_chervi);
        MinJack.setImageResource(R.drawable.mini_j_chervi);
        MinTen.setImageResource(R.drawable.mini_ten_chervi);
        MinNine.setImageResource(R.drawable.mini_nine_chervi);
        MinEight.setImageResource(R.drawable.mini_eight_chervi);
        MinSeven.setImageResource(R.drawable.mini_seven_chervi);
        MinSix.setImageResource(R.drawable.mini_six_chervi);
        BigPic.setImageResource(R.drawable.middle_ace_chervi);
        MainText.setText("Выбери кто пьет");
        //Init Info_rools end

        final Button InfoButton = findViewById(R.id.Info_butt);

        final LinearLayout InfoHint = findViewById(R.id.info_hint);

        InfoHint.setVisibility(View.INVISIBLE);




        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        turn[0]=findViewById(R.id.turn2);
        turn[1]=findViewById(R.id.turn5);
        turn[2]=findViewById(R.id.turn7);
        turn[3]=findViewById(R.id.turn8);
        turn[4]=findViewById(R.id.turn11);
        Player[0]=findViewById(R.id.player2);
        Player[1]=findViewById(R.id.player5);
        Player[2]=findViewById(R.id.player7);
        Player[3]=findViewById(R.id.player8);
        Player[4]=findViewById(R.id.player11);
        Ten[0]=findViewById(R.id.ten_2);
        Ten[1]=findViewById(R.id.ten_5);
        Ten[2]=findViewById(R.id.ten_7);
        Ten[3]=findViewById(R.id.ten_8);
        Ten[4]=findViewById(R.id.ten_11);




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
            cardlist.addAll(InitCards());
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

                if(num <5-1)
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

        InfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(InfoButton.getText().equals("Info"))
                {
                    InfoHint.setVisibility(View.VISIBLE);
                    InfoButton.setText("Back");
                    Cards.setVisibility(View.INVISIBLE);

                    Cardtaken.setVisibility(View.INVISIBLE);
                    Throwcard.setVisibility(View.INVISIBLE);

                    for(int i= 0;i<PlayerList.size();i++ )
                    {
                        PlayerList.get(i).setVisibility(View.INVISIBLE);
                        TenList.get(i).setVisibility(View.INVISIBLE);
                        TurnList.get(i).setVisibility(View.INVISIBLE);
                    }
                    NumCards.setVisibility(View.INVISIBLE);
                }

                else if(InfoButton.getText().equals("Back"))
                {

                    if (card_is_taken[0] ==true)

                    {
                        Cardtaken.setVisibility(View.VISIBLE);
                        Throwcard.setVisibility(View.VISIBLE);
                        InfoHint.setVisibility(View.INVISIBLE);
                        InfoButton.setText("Info");
                        NumCards.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        InfoHint.setVisibility(View.INVISIBLE);
                        InfoButton.setText("Info");

                        NumCards.setVisibility(View.VISIBLE);
                        Cards.setVisibility(View.VISIBLE);
                        TurnList.get(num).setVisibility(View.VISIBLE);

                        for(int i= 0;i<PlayerList.size();i++ )
                        {
                            PlayerList.get(i).setVisibility(View.VISIBLE);
                            //TenList.get(i).setVisibility(View.INVISIBLE);
                            //TurnList.get(i).setVisibility(View.INVISIBLE);
                            if(had_have[i]==true)
                            {
                                TenList.get(i).setVisibility(View.VISIBLE);
                            }

                        }

                    }





                }

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
