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



// intialize Card values
public class Card { // suits and rank for cards
    public static final int clubs = 0;
    public static final int diamonds = 1;
    public static final int hearts = 2;
    public static final int spades = 3;

    public static final int jack = 11;
    public static final int queen = 12;
    public static final int king = 13;
    public static final int ace = 14;

    private final int rank;
    private final int suit;

    public Card(int suit, int rank) { //  current instance
        this.suit = suit;
        this.rank = rank;
    }



    public int getRank() { // return rank
        return this.rank;
    }

    public String toString() { // suits
        String suit = "";
        switch (this.suit) {
            case clubs:
                suit = "♣";
                break;
            case diamonds:
                suit = "♦";
                break;
            case hearts:
                suit = "♥";
                break;
            case spades:
                suit = "♠";
                break;
        }

        String rank;
        switch (this.rank) { // high ranks
            case jack:
                rank = "J";
                break;
            case queen:
                rank = "Q";
                break;
            case king:
                rank = "K";
                break;
            case ace:
                rank = "A";
                break;
            default:
                rank = "" + this.rank;
                break;
        }

        return rank + suit;
    }
} // end of class Card
