package com.davidroach.blackjack_assignment1;


import android.content.Intent;
import java.util.Vector;

/**
 * Created by droach-dev on 1/29/17.
 */

public class Deck {
    //when a random number between 1 and 52 is picked access this array with that number.
    //the zeros represent aces and need to be proccessed for value.
    public int[] cardVals = {0,0,0,0,8,8,8,8,5,5,5,5,4,4,4,4,10,10,10,10,10,10,10,10,9,9,9,9,10,10,10,10,7,7,7,7,6,6,6,6,10,10,10,10,3,3,3,3,2,2,2,2};

    //randomize deckIndex and use deck position to get value of card in cardVals array.
    //cardVals[deckIndex[deckPosition]];
    public int deckPosition = 0;
    public int[] deckIndex = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51};


    public void shuffleDeck(){
        //randomize deckIndex array.


    }

    //pop top card integer from deck array.
    public void dealCard(){

    }




    public boolean isEndOfDeck(){
        //if is end of deck return true and do nothing
        if(deckPosition == 51){
            return true;
        }
        else{
            //advance deck position
            deckPosition++;
            return false;
        }
    }



}
