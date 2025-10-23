package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamblingTable {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        List<Player> gamblers = new ArrayList<>();

        System.out.println("Lets feed that gambling addiction with some Blackjack!");
        System.out.print("How many players? ");
        int numOfPlayers = scan.nextInt();
        scan.nextLine();

        for(int i = 1; i <= numOfPlayers ; ++i){
            System.out.print("Enter name for player " + i + " ");
            String name = scan.nextLine();
            gamblers.add(new Player(name));
            System.out.println("\nWelcome " + name);
        }
        System.out.println("\nFollowing Players: ");
        for(Player p : gamblers){
            System.out.println( p.getName());
        }

        //create the deck
        Deck deck = new Deck();
        deck.shuffle();

        //create the hand
        Hand hand1 = new Hand();





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
