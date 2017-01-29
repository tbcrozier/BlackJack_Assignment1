package com.davidroach.blackjack_assignment1;

/**
 * Created by droach-dev on 1/28/17.
 */

public class Game {

    public int betSize;
    public int playerHandScore;
    public int dealerHandScore;



    /* need to figure out how the deck is going to work.
       Will put variable here.
     */


    /* Constructor */
    public Game(){
        //init variables


        //create player objects



    }


    //Main loop in here.
    public void play(){

    }



    public void takeHit(){

    }

    public void takeStand(){

    }


    //Pass hand variables to these functions.
    //once you figure out its type
    public void dealerCheckHand(){

    }


    public void placeBet(){
        //show bet popup
        //take value from that popup and add it to betSize variable

    }

    public void youWin(){
        //show you win popup
        //remove bet size from player pot.


        //restart game
        restartGame();

    }

    public void dealerWin(){
        //show dealer win popup
        //remove bet size from player pot.


        //restart game
        restartGame();

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


    public void restartGame(){

    }

}
