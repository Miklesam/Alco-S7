package com.miklesam.alco7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class number_of_players extends AppCompatActivity {
    int cnt;
    String count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_number_of_players);

        final TextView PlayersNum= (TextView)findViewById(R.id.count);
        Button Plus = (Button)findViewById(R.id.plus);
        Button Minus = (Button)findViewById(R.id.minus);
        Button Start = (Button)findViewById(R.id.start);



        final Intent intent = new Intent(this, players_two.class);

        if (savedInstanceState!=null)
        {
            cnt=savedInstanceState.getInt("number_players");
            PlayersNum.setText(String.valueOf(cnt));
        }

        count = (String) PlayersNum.getText();
        cnt=Integer.parseInt(count);

        Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count = (String) PlayersNum.getText();
                cnt=Integer.parseInt(count);
                if(cnt<8)
                {
                    cnt++;
                    PlayersNum.setText(String.valueOf(cnt));
                }



            }
        });



        Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String count = (String) PlayersNum.getText();
                int cnt=Integer.parseInt(count);
                if(cnt>4)
                {
                    cnt--;
                    PlayersNum.setText(String.valueOf(cnt));
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
        savedInstanceStance.putInt("number_players",cnt);



    }


}
