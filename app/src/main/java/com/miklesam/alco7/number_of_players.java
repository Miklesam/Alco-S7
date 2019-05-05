package com.miklesam.alco7;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class number_of_players extends AppCompatActivity {
    int cnt;
    String count;
    int PlayerNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_number_of_players);

        final TextView PlayersNum= (TextView)findViewById(R.id.count);


        Button Plus = (Button)findViewById(R.id.plus);
        Button Minus = (Button)findViewById(R.id.minus);
        Button Start = (Button)findViewById(R.id.start);



        final Intent four = new Intent(this, players_two.class);
        final Intent five = new Intent(this, five_p.class);
        final Intent six = new Intent(this, six_p.class);
        final Intent seven = new Intent(this, seven_p.class);
        final Intent eight = new Intent(this, eight_p.class);


        if (savedInstanceState!=null)
        {
            PlayerNum =savedInstanceState.getInt("number_players");
            PlayersNum.setText(String.valueOf(PlayerNum));
        }
        else
        {
            PlayersNum.setText("4");
        }

        count = (String) PlayersNum.getText();


        Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count = (String) PlayersNum.getText();
                int pluscnt=Integer.parseInt(count);
                if(pluscnt<8)
                {
                    pluscnt++;
                    PlayersNum.setText(String.valueOf(pluscnt));
                    PlayerNum =pluscnt;
                }



            }
        });



        Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String count = (String) PlayersNum.getText();
                int minuscnt=Integer.parseInt(count);
                if(minuscnt>4)
                {
                    minuscnt--;
                    PlayersNum.setText(String.valueOf(minuscnt));
                    PlayerNum =minuscnt;
                }


            }
        });


        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int extra=  Integer.parseInt((String) PlayersNum.getText());

                if (extra==4)
                {
                    startActivity(four);
                }
                else if (extra==5)
                {
                    startActivity(five);
                }
                else if (extra==6)
                {
                    startActivity(six);
                }
                else if (extra==7)
                {
                    startActivity(seven);
                }
                else if (extra==8)
                {
                    startActivity(eight);
                }



            }
        });






    }



    @Override
    public void onSaveInstanceState(Bundle savedInstanceStance) {
        super.onSaveInstanceState(savedInstanceStance);
        savedInstanceStance.putInt("number_players",PlayerNum);



    }


}
