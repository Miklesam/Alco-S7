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
    final int[] Ocnt = new int[1];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_number_of_players);

        final TextView PlayersNum= (TextView)findViewById(R.id.count);


        Button Plus = (Button)findViewById(R.id.plus);
        Button Minus = (Button)findViewById(R.id.minus);
        Button Start = (Button)findViewById(R.id.start);



        final Intent intent = new Intent(this, players_two.class);

        if (savedInstanceState!=null)
        {
            Ocnt[0] =savedInstanceState.getInt("number_players");
            PlayersNum.setText(String.valueOf(Ocnt[0]));
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
                    Ocnt[0] =pluscnt;
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
                    Ocnt[0] =minuscnt;
                }


            }
        });


        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int extra=  Integer.parseInt((String) PlayersNum.getText());
                intent.putExtra("num",extra);

                startActivity(intent);


            }
        });






    }



    @Override
    public void onSaveInstanceState(Bundle savedInstanceStance) {
        super.onSaveInstanceState(savedInstanceStance);
        savedInstanceStance.putInt("number_players",Ocnt[0]);



    }


}
