package com.davidroach.blackjack_assignment1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import android.widget.Button;

import org.w3c.dom.Text;

import java.util.Objects;

/**
 * Created by droach-dev on 1/26/17.
 * Joined by bcrozier on 1/28/17.
 */

public class GameActivity extends AppCompatActivity {

    public int betSize;
    //public int playerHandScore;
    //public int dealerHandScore;

    Player dealerObj;
    Player playerObj;

    String winnerString = "game result popup";
    String DEALER_WINS = "Dealer Wins.";
    String YOU_WIN = "You Win!!!";

    boolean dealerStands = false;
    boolean playerStands = false;
    boolean playerWins;
    boolean dealerBusts;
    boolean playerBusts;

    Deck deck;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Disable title bar */
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_game);



        //init variables
        betSize = 10;
        //playerHandScore = 0;
        //dealerHandScore = 0;

        //create deck object
        deck = new Deck();

        //create player objects
        dealerObj = new Player();
        playerObj = new Player();

        dealerObj.name = "Dealer";
        playerObj.name = "You";

        playerObj.chipCount = 100;
        /* Dealer does not need a chip count */

        //run main loop
        play();
        //gameResult();
    }


    public void betPopup(){

    }



    public void play(){

        /* Bind to UI */
        TextView betCountTv = (TextView)findViewById(R.id.bet_count_tv);
        TextView chipCountTv = (TextView)findViewById(R.id.chip_count_tv);
        TextView playerHandScore = (TextView)findViewById(R.id.player_score_tv);
        TextView dealerHandScore = (TextView)findViewById(R.id.dealer_score_tv);
        Button hitButton = (Button)findViewById(R.id.hit_button);
        Button standButton = (Button)findViewById(R.id.stand_button);




        //get deck ready
        deck.shuffleDeck();

       /* place bet here */
        //betsize init to 10.  will need to be handled by a popup
        placeBet(playerObj);



       /*Initial deal*/
        deck.dealCard(playerObj);
        setHandScore(playerObj);
        deck.dealCard(dealerObj);
        setHandScore(dealerObj);
        deck.dealCard(playerObj);
        setHandScore(playerObj);
        deck.dealCard(dealerObj);
        setHandScore(dealerObj);

        /* check player hand for blackjack */
        if(hasBlackJack(playerObj) == true){
            winnerString = YOU_WIN;
            playerWins = true;

        }

        /* player takes hits here check playerStands before loop iteration */


int i= 1+1;


        /* Dealer takes hits until score is 16 or greater or he goes over 21 */


        /* Compare Scores here */


        /* Set winner string and show winner popup */





         gameResult();


        /* Restart */
        //restartGame();

    }//end of plaqy


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
        //show you win popup
        //remove bet size from player pot.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(winnerString)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();


        //restart game
        //restartGame();
    }




    public void takeHit(Player playerIn){
        deck.dealCard(playerIn);


    }

    public void takeStand(Player playerIn){
        if(Objects.equals("Dealer",playerIn.name)){
            dealerStands = true;
        }
        else{
            playerStands = true;
        }

    }


    //Pass hand variables to these functions.
    //once you figure out its type
    /* MAY NOT BE NEEDED */
    public boolean dealerCheckHand(){
        //return true if dealer wants to take a stand
        return true;

        //return false if dealer wants to take a hit

    }


    public void placeBet(Player playerIn){
        //show bet popup

        //take value from that popup and add it to betSize variable

    }




    public void addToScore(Player playerIn, int cardValueIn){
        //if card val is zero it is an ace.
        //check and see if adding 11 would bust player
        //if it will use the ace as a 1
        if(cardValueIn ==0){

            if((playerIn.handScore + cardValueIn) > 21){
                playerIn.handScore ++;
            }
            else{
                playerIn.handScore += 11;
            }

        }
        else{
            playerIn.handScore += cardValueIn;
        }


    }

    public void compareScores(Player dealerObj, Player playerObj){

        if(dealerObj.handScore > playerObj.handScore){
            //dealer wins
            playerWins = false;

        }
        else{
            //User wins
            playerWins = true;
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




    public void restartGame(){
        //reset variables call play again.

        play();
    }

}



