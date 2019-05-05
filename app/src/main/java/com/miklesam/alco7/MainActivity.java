package com.miklesam.alco7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    AdView mAdview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Game = findViewById(R.id.game);
        Button Rools = findViewById(R.id.rools);



        final Intent intent = new Intent(this, number_of_players.class);
        final Intent rools_intent = new Intent(this, Rools_activity.class);



        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");

        mAdview=(AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);




        Game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);

            }
        });



        Rools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(rools_intent);

            }
        });


    }
}
