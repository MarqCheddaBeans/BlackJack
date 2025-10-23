package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamblingTable {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        //Create list to store all players
        List<Player> gamblers = new ArrayList<>();

        //Each player will also need a hand
        List<Hand> hands = new ArrayList<>();

        System.out.println("Lets feed that gambling addiction with some Blackjack!");

        //Prompt user for player count and store
        System.out.print("How many players? ");
        int numOfPlayers = scan.nextInt();

        //Hungry buffer
        scan.nextLine();

        //Ask for names of each player and create individual objects for each
        for(int i = 1; i <= numOfPlayers ; ++i){
            System.out.print("Enter name for player " + i + " ");
            String name = scan.nextLine();
            gamblers.add(new Player(name));
            hands.add(new Hand());
            System.out.println("\nWelcome " + name);
        }

        //Display all players
        System.out.println("\nFollowing Players: ");
        for(Player p : gamblers){
            System.out.println( p.getName());
        }

        //create and shuffle the deck
        Deck deck = new Deck();
        deck.shuffle();

        //Cycle through each player
        for (int i = 0; i<numOfPlayers; i++){
            //Deal 2 cards per player
            for (int m = 0; m < 2; m++){
                //Calls Deck deal() method, store card in variable named dealtCard
                Card dealtCard = deck.deal();
                //Flips card to reveal actual values
                dealtCard.flip();
                //Adds dealt card to player hand
                hands.get(i).deal(dealtCard);

                System.out.println("Cards dealt: \n" + dealtCard.getSuit() + " " + dealtCard.getValue());
            }
        }









//
//
//            deck.shuffle();
//            // deal 5 cards from the deck and add them to the hand
//            for (int i = 0; i < 5; i++) {
//                // get a card from the deck
//                Card card = deck.deal();
//                // deal that card to the hand
//                hand1.deal(card);
//            }
//
//            //print out the value of all the cards in the hand
//            System.out.println("This hand is worth " + hand1.getValue());

    }
}
