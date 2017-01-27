package com.davidroach.blackjack_assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Disable title bar */
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_start);

        /* Buttons and their listensers */

        final Button playButton = (Button) findViewById(R.id.play_button);

        playButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

            }

        });


        final Button aboutButton = (Button) findViewById(R.id.about_button);

        aboutButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

            }

        });



        final Button exitButton = (Button) findViewById(R.id.exit_button);

        exitButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

            }

        });



    }
}
