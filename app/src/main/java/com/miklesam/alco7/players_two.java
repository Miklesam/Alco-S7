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
    boolean not_first_init;
    int num;
    boolean[] had_have=new boolean[4];
    boolean[] had_eight=new boolean[4];
    boolean card_is_taken;
    ImageView Cards;
    ArrayList<ImageView> TenList = new ArrayList<ImageView>();
    ArrayList<ImageView> PlayerList = new ArrayList<ImageView>();
    ArrayList<ImageView> TurnList = new ArrayList<ImageView>();
    TextView NumCards;
    ImageView[] Eight= new ImageView[4];
    Button InfoButton;
    ImageView Cardtaken;
    Button Throwcard;
    Button Backtomenu;

    LinearLayout InfoHint;
    ImageView BigPic;
    TextView MainText;
    LinearLayout SureEight;
    Button sure_yes;
    Button sure_no;


    ImageView turn[] = new ImageView[4];
    ImageView Player[] = new ImageView[4];
    ImageView Ten[] = new ImageView[4];

    int what_eight;
    boolean sure_eight;
    boolean info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);








        setContentView(R.layout.activity_players_two);
        NumCards=findViewById(R.id.NumCards);
        Cards= findViewById(R.id.deck_of_cards);
        Cardtaken=findViewById(R.id.card_taken);
        final Button StartGame=findViewById(R.id.startgame);
        Backtomenu = findViewById(R.id.back_to_menu);
       Throwcard = findViewById(R.id.throwcard);
       InfoButton = findViewById(R.id.Info_butt);
       InfoHint = findViewById(R.id.info_hint);
        BigPic= findViewById(R.id.big_pic);
        MainText = findViewById(R.id.Main_Text);
        SureEight = findViewById(R.id.sure_eight);
        sure_yes=findViewById(R.id.sure_yes);
        sure_no=findViewById(R.id.sure_no);
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
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        final Intent tomenuintent = new Intent(this, MainActivity.class);
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
        Eight[0]=findViewById(R.id.eight_2);
        Eight[1]=findViewById(R.id.eight_5);
        Eight[2]=findViewById(R.id.eight_8);
        Eight[3]=findViewById(R.id.eight_11);

        for(int i=0;i<Player.length;i++)
        {
            PlayerList.add(Player[i]);
            TurnList.add(turn[i]);
            TenList.add(Ten[i]);
        }
        //Init Info_rools end
        if (savedInstanceState!=null)
        {  not_first_init=savedInstanceState.getBoolean("not_first_init");
            if  (not_first_init==false)
            {
                not_first_init =true;
                StartGame.setVisibility(View.VISIBLE);
                cardlist.addAll(InitCards());
                NumCards.setText(String.valueOf(cardlist.size()));
            }
            else
            {
                not_first_init =true;
                StartGame.setVisibility(View.INVISIBLE);
                cardlist=savedInstanceState.getIntegerArrayList("cardlist");
                NumCards.setText(String.valueOf(cardlist.size()));
                card_is_taken=savedInstanceState.getBoolean("card_is_taken");
                had_have=savedInstanceState.getBooleanArray("had_have");
                had_eight=savedInstanceState.getBooleanArray("had_eight");
                num=savedInstanceState.getInt("num");
                sure_eight=savedInstanceState.getBoolean("sure_eight");
                info=savedInstanceState.getBoolean("info");


                if (card_is_taken ==true)
                {
                    InitCardTaken();
                }
                else
                {
                    InitGameTable();
                }

            }


        }
        else
        {

            StartGame.setVisibility(View.VISIBLE);
            cardlist.addAll(InitCards());
            NumCards.setText(String.valueOf(cardlist.size()));
        }
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);



        StartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StartGame.setVisibility(View.INVISIBLE);
                InitGameTable();
            }
        });


        Cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_is_taken =true;
                Collections.shuffle(cardlist);
                String count = (String) NumCards.getText();
                int cnt=Integer.parseInt(count);

                HideGameTable();


                Random randomcard = new Random();
                int whattacard=0;
                if (cardlist.size()>1)
                {
                    whattacard=randomcard.nextInt(cardlist.size());
                    Cardtaken.setImageResource((Integer) cardlist.get(whattacard));
                    if ((cardlist.get(whattacard).equals(R.drawable.ten_vini))||(cardlist.get(whattacard).equals(R.drawable.ten_kresti))||
                            (cardlist.get(whattacard).equals(R.drawable.ten_chervi))||(cardlist.get(whattacard).equals(R.drawable.ten_bubi)))
                    {
                        for(int i=0;i<had_have.length;i++)
                        {
                            had_have[i]=false;
                        }
                        had_have[num]=true;
                    }
                    else if ((cardlist.get(whattacard).equals(R.drawable.eight_vini))||(cardlist.get(whattacard).equals(R.drawable.eight_kresti))||
                            (cardlist.get(whattacard).equals(R.drawable.eight_chervi))||(cardlist.get(whattacard).equals(R.drawable.eight_bubi)))
                    {
                        had_eight[num]=true;
                    }
                    InitCardTaken();
                    cardlist.remove(whattacard);

                }
                else if (cardlist.size()==1)
                {
                    whattacard=0;
                    Cardtaken.setImageResource((Integer) cardlist.get(whattacard));
                    cardlist.remove(whattacard);
                    InitCardTaken();
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
                card_is_taken=false;
                if(num <4-1)
                {
                    num++;
                }
                else
                {
                    num =0;
                }
                InitGameTable();
                HideCardTaken();

                if (cardlist.size()==0)
                {
                    NumCards.setText("Конец колоды");
                    Backtomenu.setVisibility(View.VISIBLE);
                    HideGameTable();
                    InfoButton.setVisibility(View.INVISIBLE);

                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();


                    } else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }
                }

            }
        });

        InfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoHint.setVisibility(View.VISIBLE);
                if(InfoButton.getText().equals("Info"))
                {
                    info=true;

               if (card_is_taken==true)
               {
                   HideCardTaken();
               }
               else
               {
                   HideGameTable();
               }

                    InfoButton.setText("Back");
                    NumCards.setVisibility(View.INVISIBLE);
                    InfoButton.setVisibility(View.VISIBLE);

                }

                else if(InfoButton.getText().equals("Back"))
                {
                    InfoHint.setVisibility(View.INVISIBLE);
                    info=false;
                    if (card_is_taken ==true)
                    {
                        InitCardTaken();
                        InfoButton.setText("Info");
                                            }
                    else
                    {
                        InfoButton.setText("Info");
                        InitGameTable();
                    }





                }

            }
        });

        for (int i=0;i<4;i++)
        {
            final int finalI = i;
            Eight[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    what_eight= finalI;
                    sure_eight=true;
                    SureEight.setVisibility(View.VISIBLE);
                    InfoButton.setVisibility(View.INVISIBLE);
                   HideGameTable();

                }
            });
        }

        sure_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              had_eight[what_eight]=false;
              Eight[what_eight].setVisibility(View.INVISIBLE);
              SureEight.setVisibility(View.INVISIBLE);
                InfoButton.setVisibility(View.VISIBLE);
                sure_eight=false;
               InitGameTable();


            }
        });

        sure_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sure_eight=false;
                SureEight.setVisibility(View.INVISIBLE);
                InitGameTable();
                InfoButton.setVisibility(View.VISIBLE);

            }
        });

        Backtomenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(tomenuintent);

            }
        });




    }

    private void InitGameTable() {
        NumCards.setVisibility(View.VISIBLE);
        Cards.setVisibility(View.VISIBLE);
        TurnList.get(num).setVisibility(View.VISIBLE);
        InfoButton.setText("Info");
        InfoButton.setVisibility(View.VISIBLE);
        for(int i= 0;i<PlayerList.size();i++ )
        {
            PlayerList.get(i).setVisibility(View.VISIBLE);
            if(had_have[i]==true)
            {
                TenList.get(i).setVisibility(View.VISIBLE);
            }
            if (had_eight[i]==true)
            {
                Eight[i].setVisibility(View.VISIBLE);
            }

        }

    }

    private void HideGameTable(){
        NumCards.setVisibility(View.VISIBLE);
        Cards.setVisibility(View.INVISIBLE);
        TurnList.get(num).setVisibility(View.INVISIBLE);

        for(int i= 0;i<PlayerList.size();i++ )
        {
            PlayerList.get(i).setVisibility(View.INVISIBLE);
            if(had_have[i]==true)
            {
                TenList.get(i).setVisibility(View.INVISIBLE);
            }
            if (had_eight[i]==true)
            {
                Eight[i].setVisibility(View.INVISIBLE);
            }

        }
    }

    private void InitCardTaken(){
        Cardtaken.setVisibility(View.VISIBLE);
        Throwcard.setVisibility(View.VISIBLE);
        InfoButton.setText("Info");
        InfoButton.setVisibility(View.VISIBLE);
        NumCards.setVisibility(View.VISIBLE);
    }
    private void HideCardTaken(){
        Cardtaken.setVisibility(View.INVISIBLE);
        Throwcard.setVisibility(View.INVISIBLE);
        NumCards.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceStance) {
        super.onSaveInstanceState(savedInstanceStance);
        savedInstanceStance.putBoolean("not_first_init",not_first_init);
        savedInstanceStance.putIntegerArrayList("cardlist",cardlist);
        savedInstanceStance.putBoolean("card_is_taken",card_is_taken);
        savedInstanceStance.putBooleanArray("had_have",had_have);
        savedInstanceStance.putBooleanArray("had_eight",had_eight);
        savedInstanceStance.putInt("num",num);

    }





}
