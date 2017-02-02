package com.davidroach.blackjack_assignment1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by droach-dev on 1/26/17.
 * Joined by bcrozier on 1/28/17.
 */

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Disable title bar */
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_game);



        Game game = new Game();
        gameResult(game);
    }


    public void betPopup(){

    }




    public void gameResult(Game gameObject){
        //show you win popup
        //remove bet size from player pot.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(gameObject.winnerString)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();


        //restart game
        gameObject.restartGame();
    }
}
