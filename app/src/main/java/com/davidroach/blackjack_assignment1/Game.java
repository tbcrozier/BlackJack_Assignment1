package com.davidroach.blackjack_assignment1;

import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * Created by droach-dev on 1/28/17.
 */

public class Game {

    public int betSize;
    public int playerHandScore;
    public int dealerHandScore;

    Player dealerObj;
    Player playerObj;

    String winnerString;
    String DEALER_WINS = "Dealer Wins.";
    String YOU_WIN = "You Win!!!";

    boolean playerWins;
    boolean dealerBusts;
    boolean playerBusts;

    Deck deck;



    /* need to figure out how the deck is going to work.
       Will put variable here.
     */


    /* Constructor */
    public Game(){
        //init variables
        betSize = 0;
        playerHandScore = 0;
        dealerHandScore = 0;

        //create deck object
        deck = new Deck();

        //create player objects
        dealerObj = new Player();
        playerObj = new Player();

        playerObj.name = "Dealer";
        playerObj.name = "You";

        playerObj.chipCount = 100;
        /* Dealer does not need a chip count */

        //run main loop
        play();





    }


    //Main loop in here.

    public void play(){

        //get deck ready
        deck.shuffleDeck();





       /*Initial deal*/
        deck.dealCard(playerObj);
        deck.dealCard(dealerObj);
        deck.dealCard(playerObj);
        deck.dealCard(dealerObj);

        /* check player hand for blackjack */
        if(hasBlackJack(playerObj) == true){
            winnerString = YOU_WIN;
            playerWins = true;

        }



        /* Dealer takes hits until score is 16 or greater or he goes over 21 */


        /* Compare Scores here */


        /* Set winner string */





        /* Restart */
        //restartGame();

    }



    public void takeHit(Player playerIn){
        deck.dealCard(playerIn);


    }

    public void takeStand(Player playerIn){

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



    /* WILL NEED TO BE REMOVED BEFORE PRODUCTION */
    /*

    public void youWin(){
        //show you win popup
        //remove bet size from player pot.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Look at this dialog!")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();


        //restart game
        restartGame();
    }
*/


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
        play();
    }

}
