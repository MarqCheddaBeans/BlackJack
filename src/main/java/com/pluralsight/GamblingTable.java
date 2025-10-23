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

        System.out.println("======================================================");
        System.out.println("Lets feed that gambling addiction with some Blackjack!");
        System.out.println("======================================================\n");

        //Prompt user for player count and store
        System.out.print("How many players?: ");
        int numOfPlayers = scan.nextInt();

        //Hungry buffer
        scan.nextLine();

        //Ask for names of each player and create individual objects for each
        for(int i = 1; i <= numOfPlayers ; ++i){
            System.out.print("\nEnter name for player " + i + " ");
            String name = scan.nextLine();
            gamblers.add(new Player(name));
            hands.add(new Hand());

            System.out.println("------------------------");
            System.out.println("Welcome " + name);
            System.out.println("------------------------");
        }

        //Display all players
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\nFollowing Players: ");
        for(Player p : gamblers){
            System.out.println( p.getName());
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++");


        //create and shuffle the deck
        Deck deck = new Deck();
        deck.shuffle();

        //Cycle through each player
        for (int i = 0; i<numOfPlayers; i++){
            //Deal 2 cards per player
            for (int m = 0; m < 2; m++){
                //Calls Deck deal() method, store card in variable named dealtCard
                Card dealtCard = deck.deal();
                //make card visible before adding
                dealtCard.flip();
                //Adds dealt card to player hand
                hands.get(i).deal(dealtCard);
            }
        }
        //Hit or Stay Bonus
        //Cycle through list of players
        for(int i = 0; i< numOfPlayers;i++){
            //retrieve current player and their hand
            Player player = gamblers.get(i);
            Hand hand = hands.get(i);

            System.out.println("\n" + player.getName() + "'s turn");

            //boolean to indicate when a players turn ends, they got packed up
            boolean turnOver = false;

            //Keep looping until player gets packed up or chooses to stay
            while(!turnOver){
                //show current hand
                System.out.println("\nYour current hand: ");

                //cycle through players cards and display its value and suit
                for(Card card : hand.getCards()) {
                    System.out.println(card.getValue() + " of " + card.getSuit());
                }

                //calculate value of cards in players hand
                int score = hand.getValue();
                System.out.println("Current total: " + score);

                //if score over 21, they get packed up
                if(score > 21 ) {
                    System.out.println("You went over 21, PACK IT UP");
                    //end turn
                    turnOver = true;
                    //skip rest of loop iteration
                    continue;
                }

                //Ask player if they want to hit or stay
                System.out.println("Do you want to (H)it or (S)tay? ");
                String choice = scan.nextLine();

                //check if player chooses to hit
                if (choice.equalsIgnoreCase("h")){

                    //Deal new card from top of deck
                    Card newCard = deck.deal();
                    //flip card so it can be visible
                    newCard.flip();
                    //add card to players hand
                    hand.deal(newCard);
                    //display new card dealt
                    System.out.println("\nYou drew: " + newCard.getValue() + " of " + newCard.getSuit());

                    //check if player chose to stay
                }else if(choice.equalsIgnoreCase("s")){
                    //player stays, end turn
                    System.out.println(player.getName() + " chose to stay, with " + score +".");
                    turnOver = true;

                    //user entered invalid input, send back to pick
                } else{
                    System.out.println("Invalid choice. please enter H or S");
                }
            }
        }

        //Display each players hand and calculate values
        int highestScore = 0;
        String winner = "";

        System.out.println("\nFinal Scores: ");

        //cycle through list of players
        for(int i = 0; i < numOfPlayers; i++){
            //retrieves name from player
            Player player = gamblers.get(i);
            //Retrieves hand from player
            Hand hand = hands.get(i);
            //Uses getValue method to get card values
            int score = hand.getValue();

            System.out.println("\n" + player.getName() + ": " + score);

            //check for highest score that is not over 21
            if (score <= 21 && score > highestScore){
                highestScore = score;
                winner = player.getName();
            }
        }

        //check if there is a winner
        if(winner.isEmpty()){
            System.out.println("You all got packed up, gg");
        }else{
            System.out.println("\nThe winner is: " + winner + " with score of " + highestScore);
        }

    }
}
