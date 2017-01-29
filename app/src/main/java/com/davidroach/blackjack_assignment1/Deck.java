package com.davidroach.blackjack_assignment1;


import android.content.Intent;
import java.util.Vector;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by droach-dev on 1/29/17.
 */

public class Deck {
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
    //when a random number between 1 and 52 is picked access this array with that number.
    //the zeros represent aces and need to be proccessed for value.
    public int[] cardVals = {0,0,0,0,8,8,8,8,5,5,5,5,4,4,4,4,10,10,10,10,10,10,10,10,9,9,9,9,10,10,10,10,7,7,7,7,6,6,6,6,10,10,10,10,3,3,3,3,2,2,2,2};

    //randomize deckIndex and use deck position to get value of card in cardVals array.
    //cardVals[deckIndex[deckPosition]];
    public int deckPosition = 0;
    public int[] deckIndex = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51};


    public void shuffleDeck(int[] ar){
        //randomize deckIndex array.
        //uses Fisher–Yates shuffle

        //TEST THIS CODE

        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }


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

    //use value returned as file name when showing card that is drawn.
    public String getCardImageName(){

         return cardFileNames[deckIndex[deckPosition]];

    }



}
