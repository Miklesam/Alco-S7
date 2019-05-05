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

public class seven_p extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    ArrayList cardlist= new ArrayList();
    boolean not_first_init;
    int num;
    boolean[] had_have=new boolean[7];
    boolean[] had_eight=new boolean[7];
    boolean card_is_taken;
    ImageView Cards;
    ArrayList<ImageView> TenList = new ArrayList<ImageView>();
    ArrayList<ImageView> PlayerList = new ArrayList<ImageView>();
    ArrayList<ImageView> TurnList = new ArrayList<ImageView>();
    TextView NumCards;
    ImageView[] Eight= new ImageView[7];
    Button InfoButton;
    ImageView Cardtaken;
    Button Throwcard;
    Button Backtomenu;
    boolean[] card_takes = new boolean[9];
    LinearLayout InfoHint;
    ImageView BigPic;
    TextView MainText;
    LinearLayout SureEight;
    Button sure_yes;
    Button sure_no;


    ImageView turn[] = new ImageView[7];
    ImageView Player[] = new ImageView[7];
    ImageView Ten[] = new ImageView[7];

    int what_eight;
    boolean sure_eight;
    boolean info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven_p);




        final LinearLayout Ace = findViewById(R.id.Ace);
        final LinearLayout King = findViewById(R.id.king);
        final LinearLayout Queen = findViewById(R.id.Queen);

        final LinearLayout Jack = findViewById(R.id.Jack);
        final LinearLayout TenInfo = findViewById(R.id.Ten);
        final LinearLayout Nine = findViewById(R.id.Nine);

        final LinearLayout EightInfo = findViewById(R.id.Eight);
        final LinearLayout Seven = findViewById(R.id.Seven);
        final LinearLayout Six = findViewById(R.id.Six);
        final TextView Help_Text =findViewById(R.id.Help_Text);
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



        BigPic.setImageResource(R.drawable.mid_ace);
        MainText.setText("Выбери кто пьет");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        final Intent tomenuintent = new Intent(this, MainActivity.class);
        turn[0]=findViewById(R.id.turn2);
        turn[1]=findViewById(R.id.turn3);
        turn[2]=findViewById(R.id.turn4);
        turn[3]=findViewById(R.id.turn5);
        turn[4]=findViewById(R.id.turn7);
        turn[5]=findViewById(R.id.turn8);
        turn[6]=findViewById(R.id.turn11);

        Player[0]=findViewById(R.id.player2);
        Player[1]=findViewById(R.id.player3);
        Player[2]=findViewById(R.id.player4);
        Player[3]=findViewById(R.id.player5);
        Player[4]=findViewById(R.id.player7);
        Player[5]=findViewById(R.id.player8);
        Player[6]=findViewById(R.id.player11);

        Ten[0]=findViewById(R.id.ten_2);
        Ten[1]=findViewById(R.id.ten_3);
        Ten[2]=findViewById(R.id.ten_4);
        Ten[3]=findViewById(R.id.ten_5);
        Ten[4]=findViewById(R.id.ten_7);
        Ten[5]=findViewById(R.id.ten_8);
        Ten[6]=findViewById(R.id.ten_11);

        Eight[0]=findViewById(R.id.eight_2);
        Eight[1]=findViewById(R.id.eight_3);
        Eight[2]=findViewById(R.id.eight_4);
        Eight[3]=findViewById(R.id.eight_5);
        Eight[4]=findViewById(R.id.eight_7);
        Eight[5]=findViewById(R.id.eight_8);
        Eight[6]=findViewById(R.id.eight_11);

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
                card_takes=savedInstanceState.getBooleanArray("card_takes");
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
                Random initradn = new Random();
                num=initradn.nextInt(PlayerList.size());
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
                        card_takes[4]=true;
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
                        card_takes[6]=true;

                    }

                    else if ((cardlist.get(whattacard).equals(R.drawable.ace_vini))||(cardlist.get(whattacard).equals(R.drawable.ace_kresti))||
                            (cardlist.get(whattacard).equals(R.drawable.ace_chervi))||(cardlist.get(whattacard).equals(R.drawable.new_ace)))
                    {
                        card_takes[0]=true;
                    }
                    else if ((cardlist.get(whattacard).equals(R.drawable.k_vini))||(cardlist.get(whattacard).equals(R.drawable.k_kresti))||
                            (cardlist.get(whattacard).equals(R.drawable.k_chervi))||(cardlist.get(whattacard).equals(R.drawable.k_bubi)))
                    {
                        card_takes[1]=true;
                    }
                    else if ((cardlist.get(whattacard).equals(R.drawable.q_vini))||(cardlist.get(whattacard).equals(R.drawable.q_kresti))||
                            (cardlist.get(whattacard).equals(R.drawable.q_chervi))||(cardlist.get(whattacard).equals(R.drawable.q_bubi)))
                    {
                        card_takes[2]=true;
                    }
                    else if ((cardlist.get(whattacard).equals(R.drawable.j_vini))||(cardlist.get(whattacard).equals(R.drawable.j_kresti))||
                            (cardlist.get(whattacard).equals(R.drawable.j_chervi))||(cardlist.get(whattacard).equals(R.drawable.j_bubi)))
                    {
                        card_takes[3]=true;
                    }
                    else if ((cardlist.get(whattacard).equals(R.drawable.nine_vini))||(cardlist.get(whattacard).equals(R.drawable.nine_kresti))||
                            (cardlist.get(whattacard).equals(R.drawable.nine_chervi))||(cardlist.get(whattacard).equals(R.drawable.nine_bubi)))
                    {
                        card_takes[5]=true;
                    }

                    else if ((cardlist.get(whattacard).equals(R.drawable.seven_vini))||(cardlist.get(whattacard).equals(R.drawable.seven_kresti))||
                            (cardlist.get(whattacard).equals(R.drawable.seven_chervi))||(cardlist.get(whattacard).equals(R.drawable.seven_bubi)))
                    {
                        card_takes[7]=true;
                    }

                    else if ((cardlist.get(whattacard).equals(R.drawable.six_vini))||(cardlist.get(whattacard).equals(R.drawable.six_kresti))||
                            (cardlist.get(whattacard).equals(R.drawable.six_chervi))||(cardlist.get(whattacard).equals(R.drawable.six_bubi)))
                    {
                        card_takes[8]=true;
                    }





                    InitCardTaken();
                    cardlist.remove(whattacard);




                }
                else if (cardlist.size()==1)
                {
                    whattacard=0;
                    Cardtaken.setImageResource((Integer) cardlist.get(whattacard));


                    if ((cardlist.get(whattacard).equals(R.drawable.ten_vini))||(cardlist.get(whattacard).equals(R.drawable.ten_kresti))||
                            (cardlist.get(whattacard).equals(R.drawable.ten_chervi))||(cardlist.get(whattacard).equals(R.drawable.ten_bubi)))
                    {
                        card_takes[4]=true;

                    }
                    else if ((cardlist.get(whattacard).equals(R.drawable.eight_vini))||(cardlist.get(whattacard).equals(R.drawable.eight_kresti))||
                            (cardlist.get(whattacard).equals(R.drawable.eight_chervi))||(cardlist.get(whattacard).equals(R.drawable.eight_bubi)))
                    {
                        card_takes[6]=true;

                    }

                    else if ((cardlist.get(whattacard).equals(R.drawable.ace_vini))||(cardlist.get(whattacard).equals(R.drawable.ace_kresti))||
                            (cardlist.get(whattacard).equals(R.drawable.ace_chervi))||(cardlist.get(whattacard).equals(R.drawable.new_ace)))
                    {
                        card_takes[0]=true;
                    }
                    else if ((cardlist.get(whattacard).equals(R.drawable.k_vini))||(cardlist.get(whattacard).equals(R.drawable.k_kresti))||
                            (cardlist.get(whattacard).equals(R.drawable.k_chervi))||(cardlist.get(whattacard).equals(R.drawable.k_bubi)))
                    {
                        card_takes[1]=true;
                    }
                    else if ((cardlist.get(whattacard).equals(R.drawable.q_vini))||(cardlist.get(whattacard).equals(R.drawable.q_kresti))||
                            (cardlist.get(whattacard).equals(R.drawable.q_chervi))||(cardlist.get(whattacard).equals(R.drawable.q_bubi)))
                    {
                        card_takes[2]=true;
                    }
                    else if ((cardlist.get(whattacard).equals(R.drawable.j_vini))||(cardlist.get(whattacard).equals(R.drawable.j_kresti))||
                            (cardlist.get(whattacard).equals(R.drawable.j_chervi))||(cardlist.get(whattacard).equals(R.drawable.j_bubi)))
                    {
                        card_takes[3]=true;
                    }
                    else if ((cardlist.get(whattacard).equals(R.drawable.nine_vini))||(cardlist.get(whattacard).equals(R.drawable.nine_kresti))||
                            (cardlist.get(whattacard).equals(R.drawable.nine_chervi))||(cardlist.get(whattacard).equals(R.drawable.nine_bubi)))
                    {
                        card_takes[5]=true;
                    }

                    else if ((cardlist.get(whattacard).equals(R.drawable.seven_vini))||(cardlist.get(whattacard).equals(R.drawable.seven_kresti))||
                            (cardlist.get(whattacard).equals(R.drawable.seven_chervi))||(cardlist.get(whattacard).equals(R.drawable.seven_bubi)))
                    {
                        card_takes[7]=true;
                    }

                    else if ((cardlist.get(whattacard).equals(R.drawable.six_vini))||(cardlist.get(whattacard).equals(R.drawable.six_kresti))||
                            (cardlist.get(whattacard).equals(R.drawable.six_chervi))||(cardlist.get(whattacard).equals(R.drawable.six_bubi)))
                    {
                        card_takes[8]=true;
                    }


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
                if(num <PlayerList.size()-1)
                {
                    num++;
                }
                else
                {
                    num =0;
                }
                InitGameTable();
                HideCardTaken();
                InfoButton.setVisibility(View.INVISIBLE);

                for(int i=0;i<card_takes.length;i++)
                {
                    card_takes[i]=false;
                }

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
                    HideCardTaken();
                    InfoButton.setText("Back");
                    NumCards.setVisibility(View.INVISIBLE);
                    InfoButton.setVisibility(View.VISIBLE);
                    if (card_takes[0]==true)
                    {
                        BigPic.setImageResource(R.drawable.ace_chervi);
                        MainText.setText("Выбери кто пьет.");
                        Help_Text.setText("");
                    }

                    else if(card_takes[1]==true)
                    {
                        BigPic.setImageResource(R.drawable.k_chervi);
                        MainText.setText("Запрет");
                        Help_Text.setText("Установите запрет, который нельзя нарушать за столом.\n" +
                                "Например: Нельзя пить правой рукой.\n" +
                                "Нарушитель пьет.");
                    }
                    else if(card_takes[2]==true)
                    {
                        BigPic.setImageResource(R.drawable.q_chervi);
                        MainText.setText("Рука");
                        Help_Text.setText("Нужно поднять руку вверх.\n" +
                                "Последний поднявший пьет.");
                    }
                    else if(card_takes[3]==true)
                    {
                        BigPic.setImageResource(R.drawable.j_chervi);
                        MainText.setText("Действие");
                        Help_Text.setText("Установите действие, которое необходимо совершить перед тем как выпить.\n" +
                                "Тот, кто забудет выполнить действие, пьет.");
                    }
                    else if(card_takes[4]==true)
                    {
                        BigPic.setImageResource(R.drawable.ten_chervi);
                        MainText.setText("Вопрос");
                        Help_Text.setText("У вас появится индикатор 10.\n" +
                                "На любой ваш вопрос нельзя отвечать.\n" +
                                "Тот, кто ответит на ваш вопрос, пьет.\n" +
                                "Когда выпадает другая десятка, предыдущая аннулируется.");
                    }
                    else if(card_takes[5]==true)
                    {
                        BigPic.setImageResource(R.drawable.nine_chervi);
                        MainText.setText("Тема");
                        Help_Text.setText("Задайте тему.\n" +
                                "Например: Марки машин. \n" +
                                "Все по очереди называют марки машин.\n" +
                                "Тот, кто повторится или не сможет назвать, пьет.");
                    }
                    else if(card_takes[6]==true)
                    {
                        BigPic.setImageResource(R.drawable.eight_chervi);
                        MainText.setText("Щит");
                        Help_Text.setText("У вас появится индикатор 8.\n" +
                                "Вы можете использовать Восьмерку, чтобы не пить один раз.\n" +
                                "Для этого нажмите на нее и сбросьте.");
                    }

                    else if(card_takes[7]==true)
                    {
                        BigPic.setImageResource(R.drawable.seven_chervi);
                        MainText.setText("Счет");
                        Help_Text.setText("С того кто вытянул 7 начинается счет.\n" +
                                "Все по очереди считают, нельзя называть числа кратные 7 и числа где присутсвует 7.\n" +
                                "Тот, кто ошибется, пьет.");
                    }

                    else if(card_takes[8]==true)
                    {
                        BigPic.setImageResource(R.drawable.six_chervi);
                        MainText.setText("Пьешь сам.");
                        Help_Text.setText("Выпей сам.");
                    }




                }

                else if(InfoButton.getText().equals("Back"))
                {
                    InfoHint.setVisibility(View.INVISIBLE);
                    info=false;
                    InitCardTaken();
                    InfoButton.setText("Info");

                }

            }
        });

        for (int i=0;i<PlayerList.size();i++)
        {
            final int finalI = i;
            Eight[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    what_eight= finalI;
                    sure_eight=true;
                    SureEight.setVisibility(View.VISIBLE);
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
        //InfoButton.setVisibility(View.VISIBLE);
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
        savedInstanceStance.putBooleanArray("card_takes",card_takes);
        savedInstanceStance.putBooleanArray("had_eight",had_eight);
        savedInstanceStance.putInt("num",num);

    }
}
