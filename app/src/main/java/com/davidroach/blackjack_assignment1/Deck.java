package com.davidroach.blackjack_assignment1;


import android.content.Intent;

import java.io.Serializable;
import java.util.Vector;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by droach-dev on 1/29/17.
 */

public class Deck implements Serializable {
    /* TO BE REMOVED
     Will be used to show card in dynamic image view.

    /* Easier to deal with than using file names.  */
    public int[] cardFileNames = {
            R.drawable.ace_of_clubs,
            R.drawable.ace_of_diamonds,
            R.drawable.ace_of_hearts,
            R.drawable.ace_of_spades,
            R.drawable.eight_of_clubs,
            R.drawable.eight_of_diamonds,
            R.drawable.eight_of_hearts,
            R.drawable.eight_of_spades,
            R.drawable.five_of_clubs,
            R.drawable.five_of_diamonds,
            R.drawable.five_of_hearts,
            R.drawable.five_of_spades,
            R.drawable.four_of_clubs,
            R.drawable.four_of_diamonds,
            R.drawable.four_of_hearts,
            R.drawable.four_of_spades,
            R.drawable.jack_of_clubs2,
            R.drawable.jack_of_diamonds2,
            R.drawable.jack_of_hearts2,
            R.drawable.jack_of_spades2,
            R.drawable.king_of_clubs2,
            R.drawable.king_of_diamonds2,
            R.drawable.king_of_hearts2,
            R.drawable.king_of_spades2,
            R.drawable.nine_of_clubs,
            R.drawable.nine_of_diamonds,
            R.drawable.nine_of_hearts,
            R.drawable.nine_of_spades,
            R.drawable.queen_of_clubs2,
            R.drawable.queen_of_diamonds2,
            R.drawable.queen_of_hearts2,
            R.drawable.queen_of_spades2,
            R.drawable.seven_of_clubs,
            R.drawable.seven_of_diamonds,
            R.drawable.seven_of_hearts,
            R.drawable.seven_of_spades,
            R.drawable.six_of_clubs,
            R.drawable.six_of_diamonds,
            R.drawable.six_of_hearts,
            R.drawable.six_of_spades,
            R.drawable.ten_of_clubs,
            R.drawable.ten_of_diamonds,
            R.drawable.ten_of_hearts,
            R.drawable.ten_of_spades,
            R.drawable.three_of_clubs,
            R.drawable.three_of_diamonds,
            R.drawable.three_of_hearts,
            R.drawable.three_of_spades,
            R.drawable.two_of_clubs,
            R.drawable.two_of_diamonds,
            R.drawable.two_of_hearts,
            R.drawable.two_of_spades,

    };




    //the zeros represent aces and need to be proccessed for value.
    public int[] cardVals = {0,0,0,0,8,8,8,8,5,5,5,5,4,4,4,4,10,10,10,10,10,10,10,10,9,9,9,9,10,10,10,10,7,7,7,7,6,6,6,6,10,10,10,10,3,3,3,3,2,2,2,2};

    //randomize deckIndex and use deck position to get value of card in cardVals array.
    //cardVals[deckIndex[deckPosition]];
    public int deckPosition = 0;
    public int[] deckIndex = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51};


    public void shuffleDeck(){
        //randomize deckIndex array.
        //uses Fisher–Yates shuffle

        Random rnd = ThreadLocalRandom.current();
        for (int i = deckIndex.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = deckIndex[index];
            deckIndex[index] = deckIndex[i];
            deckIndex[i] = a;
        }

        //shuffle debug line int a = 1+1;
    }

    //pop top card integer from deck array.
    public void dealCard(Player playerIn){

        //take current card value and add it to player hand score
        addToScore(playerIn,cardVals[deckIndex[deckPosition]]);


        deckPosition++;
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



    public boolean isEndOfDeck(){
        //if is end of deck return true and do nothing
        if(deckPosition == 51){
            return true;
        }
        else{
            return false;
        }
    }

    //use value returned as file name when showing card that is drawn.
    public int getCardImageID(){

        /*CHECK THIS*/
        int resID = cardFileNames[deckIndex[deckPosition-1]];


        return resID;


    }



}