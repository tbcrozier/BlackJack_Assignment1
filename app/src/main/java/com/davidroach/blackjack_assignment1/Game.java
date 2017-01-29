package com.davidroach.blackjack_assignment1;

/**
 * Created by droach-dev on 1/28/17.
 */

public class Game {

    public int betSize;
    public int playerHandScore;
    public int dealerHandScore;



    /* Will be used to show card in dynamic image view. */
    public String[] cardFileNames = {
            "ace_of_clubs.png",
            "ace_of_diamonds.png",
            "ace_of_hearts.png",
            "ace_of_spades.png",
            "eight_of_clubs.png",
            "eight_of_diamonds.png",
            "eight_of_hearts.png",
            "eight_of_spades.png",
            "five_of_clubs.png",
            "five_of_diamonds.png",
            "five_of_hearts.png",
            "five_of_spades.png",
            "four_of_clubs.png",
            "four_of_diamonds.png",
            "four_of_hearts.png",
            "four_of_spades.png",
            "jack_of_clubs.png",
            "jack_of_diamonds.png",
            "jack_of_hearts.png",
            "jack_of_spades.png",
            "king_of_clubs.png",
            "king_of_diamonds.png",
            "king_of_hearts.png",
            "king_of_spades.png",
            "nine_of_clubs.png",
            "nine_of_diamonds.png",
            "nine_of_hearts.png",
            "nine_of_spades.png",
            "queen_of_clubs.png",
            "queen_of_diamonds.png",
            "queen_of_hearts.png",
            "queen_of_spades.png",
            "seven_of_clubs.png",
            "seven_of_diamonds.png",
            "seven_of_hearts.png",
            "seven_of_spades.png",
            "six_of_clubs.png",
            "six_of_diamonds.png",
            "six_of_hearts.png",
            "six_of_spades.png",
            "ten_of_clubs.png",
            "ten_of_diamonds.png",
            "ten_of_hearts.png",
            "ten_of_spades.png",
            "three_of_clubs.png",
            "three_of_diamonds.png",
            "three_of_hearts.png",
            "three_of_spades.png",
            "two_of_clubs.png",
            "two_of_diamonds.png",
            "two_of_hearts.png",
            "two_of_spades.png",

    };

    /* need to figure out how the deck is going to work.
       Will put variable here.
     */


    /* Constructor */
    public Game(){
        //init variables


        //create player objects

        //

    }


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
