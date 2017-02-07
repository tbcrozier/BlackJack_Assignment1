package com.davidroach.blackjack_assignment1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.EditText;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;




import java.util.Objects;

/**
 * Created by droach-dev on 1/26/17.
 * Joined by bcrozier on 1/28/17.
 */

public class GameActivity extends AppCompatActivity {

    public int betSize;
    Player dealerObj;
    Player playerObj;

    String winnerString;
    String DEALER_WINS = "Dealer Wins.";
    String YOU_WIN = "You Win!!!";
    String PUSH = "Push.";

    /* For card file names */
    String[] playerCardsInHand;
    String[] dealerCardsInHand;

    int overlap_int = 1;

    Deck deck;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Disable title bar */
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_game);

        //init variables
        betSize = 0;

        //create deck object
        //deck = new Deck();

        //create player objects
        dealerObj = new Player();
        playerObj = new Player();

        dealerObj.name = "Dealer";
        playerObj.name = "You";

        playerObj.chipCount = 100;
        /* Dealer does not need a chip count */




        //run main loop
        play();
        //restart game

    }


    public void betPopup(){



        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title);

        final EditText input = new EditText(GameActivity.this);
        input.setText("1");

        input.setRawInputType(Configuration.KEYBOARD_12KEY); //show number keybord for input

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        builder.setView(input);


        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                /* get value of edittext and assign it to betsize */
                betSize = Integer.parseInt(input.getText().toString());
                TextView betCountTv = (TextView)findViewById(R.id.bet_label_tv);
                betCountTv.setText("Bet: " + Integer.toString(betSize));


                setHandScore(playerObj);
                setHandScore(dealerObj);
            }
        });



        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();
        dialog.show();

    }



    public void play(){

        /*Place bet*/
        betPopup();

        /* Bind to UI */


        TextView chipCountTv = (TextView)findViewById(R.id.chip_count_tv);
        chipCountTv.setText(Integer.toString(playerObj.chipCount));

        TextView playerHandScore = (TextView)findViewById(R.id.player_score_tv);
        TextView dealerHandScore = (TextView)findViewById(R.id.dealer_score_tv);

        /* Resets textviews for subsequent hands*/
        playerHandScore.setText("");
        dealerHandScore.setText("");
        playerObj.handScore = 0;
        dealerObj.handScore = 0;

        Button hitButton = (Button)findViewById(R.id.hit_button);
        Button standButton = (Button)findViewById(R.id.stand_button);


        //create deck object and shuffle deck
        deck = new Deck();
        deck.shuffleDeck();



       /*Initial deal*/
        deck.dealCard(playerObj);
        showCardImage(playerObj);

        deck.dealCard(dealerObj);
        showCardImage(dealerObj);


        deck.dealCard(playerObj);
        showCardImage(playerObj);

        deck.dealCard(dealerObj);
        showCardImage(dealerObj);

        /* check player hand for blackjack */
        if(hasBlackJack(playerObj) == true){
            winnerString = YOU_WIN;


        }

        /* hit button onclick listener */
        hitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeHit(playerObj);
            }
        });

        /* standbutton onclick listener */
        standButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeStand(playerObj);
            }
        });


        int i = 1+1; //debug stopper


    }//end of play


    public void setHandScore(Player playerIn){
        TextView handScoreTv;
        String outString;
        boolean inCheck = playerIn.name.equals("Dealer");

        if(inCheck){

            outString = "Dealer: ";
            handScoreTv = (TextView)findViewById(R.id.dealer_score_tv);
            handScoreTv.setText(outString + playerIn.handScore);
        }
        else{
            handScoreTv = (TextView)findViewById(R.id.player_score_tv);
            outString = "You: ";
            handScoreTv.setText(outString + playerIn.handScore );

        }


    }




    public void gameResult(){

        TextView chipCountTv = (TextView)findViewById(R.id.chip_label_tv);

        //show you win popup
        //remove bet size from player pot.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(winnerString)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        restartGame();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();


        if(winnerString.equals(YOU_WIN)){
            /* Add betsize to chipcount, update chipcount text view*/
            playerObj.chipCount += betSize;
            chipCountTv.setText("$ " + Integer.toString(playerObj.chipCount));


        }
        else{
            /* subtract betsize to chipcount, update chipcount text view */
            playerObj.chipCount -= betSize;
            chipCountTv.setText("$ " + Integer.toString(playerObj.chipCount));

        }

    }




    public void takeHit(Player playerIn){
        deck.dealCard(playerIn);
        showCardImage(playerIn);
        setHandScore(playerIn);



    }

    public void dealerTurn(){
        //dealer takes turns card and takes hits until >16 or bust

        if(playerObj.handScore <= 21) {  //if player busts no need to draw cards.
            while (dealerObj.handScore < 17) {
                deck.dealCard(dealerObj);
                showCardImage(dealerObj);
                setHandScore(dealerObj);

            }
        }
        takeStand(dealerObj);
    }

    public void finishHand(){
        compareScores(dealerObj,playerObj);

        /*  check player wins boolean here */
        gameResult();



    }



    public void takeStand(Player playerIn){
        if(Objects.equals("Dealer",playerIn.name)){
            //dealerStands = true;
            finishHand();
        }
        else{
            //playerStands = true;
            dealerTurn();

        }

    }


    public void compareScores(Player dealerObj, Player playerObj){
        if(dealerObj.handScore == playerObj.handScore){
            winnerString = PUSH;

        }
        else if((dealerObj.handScore > playerObj.handScore && dealerObj.handScore < 22) || playerObj.handScore > 21){
            //dealer wins

            winnerString = DEALER_WINS;

        }
        else{
            //User wins

            winnerString = YOU_WIN;
        }


    }


    public boolean hasBlackJack(Player playerIn){
        if(playerIn.handScore == 21){
            return true;
        }
        else{
            return false;
        }
    }




    public void showCardImage(Player playerIn){
        ImageView img = new ImageView(this);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        LinearLayout imgHolder;



        if(playerIn.name.equals("Dealer")){

            imgHolder = (LinearLayout) findViewById(R.id.dealer_section);

        }
        else{
            imgHolder = (LinearLayout) findViewById(R.id.player_section);
        }




        img.setImageResource(deck.getCardImageID());


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width/6, height/6);
        img.setLayoutParams(params);







        imgHolder.addView(img);


    }








    public void restartGame(){
        //reset variables call play again.
        if(((LinearLayout) findViewById(R.id.player_section)).getChildCount() > 0)
            ((LinearLayout) findViewById(R.id.player_section)).removeAllViews();

        if(((LinearLayout) findViewById(R.id.dealer_section)).getChildCount() > 0)
            ((LinearLayout) findViewById(R.id.dealer_section)).removeAllViews();

        play();
    }

}

