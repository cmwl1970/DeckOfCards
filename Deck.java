// Programmer: Dylan Canfield
// Class: CS &145
// Date 7/*/2022
// Assignment: Lab 4: Deck of Cards
// develop a card game using stacks,
// queues, lists, arrays
// ** code of note **
// Switch/Case in Card Class
// Switch/Case in GameOfWar (ln 30+)
// Linked List in Deck Class
// Queue in Deck Class
// Enhanced For Loop (Deck Class ln 18 + 24)
// Stack in GameOfWar (ln 65 +)
// ** code of note **
// This code generates/displays a deck of cards
// It also simulates and displays the card game "WAR"

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Deck { // deck of card class
    private final Queue<Card> cards;

    public Deck() { // method to create deck of cards
        LinkedList<Card> cards = new LinkedList<>(); // list of generated cards

        int[] suits = {Card.clubs, Card.diamonds, Card.hearts, Card.spades}; // 0-3 array
        int[] specialRanks = {Card.jack, Card.queen, Card.king, Card.ace}; // 11-14 array
        System.out.println(Arrays.toString(suits));
        System.out.println(Arrays.toString(specialRanks));


        for (int suit : suits) { // for each suit

            for (int j = 2; j <= 10; j++) { // 2-10 ranks
                cards.add(new Card(suit, j)); // add suit/rank to list
            }

            for (int specialRank : specialRanks) { // jack, queen, king, ace
                cards.add(new Card(suit, specialRank)); // add suit/rank to list
            }
        } // end of card generation/for loops
        System.out.println("unshuffled"); // for testing
        System.out.println(cards);
        Collections.shuffle(cards); // randomize cards list
        this.cards = cards; // assign 'shuffled' cards to current instance
        System.out.println("shuffled"); // for testing
    }

    public boolean isEmpty() { // check list for content
        return cards == null || cards.isEmpty();
    }

    public Card dealCard() { // pull from queue
        if (cards == null || cards.isEmpty()) {
            throw new IllegalStateException();
        }
        return cards.remove();
    } // end of dealCard

    public String toString() {
        return cards.toString();
    }
} // end of class Deck

