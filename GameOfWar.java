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
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class GameOfWar {
    private final Queue<Card> player1;
    private final Queue<Card> player2;

    public static void main(String[] args) { // main method
        boolean playGame = true;
        Scanner console = new Scanner(System.in);

        Welcome();
        while (playGame) {
            playGame = menu(console);
        }
        System.out.println("Thanks for playing!");
    } // end of main method

    private static void Welcome() { // Game Info
        System.out.println("Welcome to the Card Generator.");
        System.out.println("I can create and display a Deck of Cards,");
        System.out.println("using Linked Lists, Stacks and Queues!\n");
        System.out.println("I can also simulate the Card Game - WAR !");
        System.out.println("Let's get started.\n");
    }

    public static boolean menu(Scanner console) { // user choices for game
        System.out.println("(C)reate Card Deck, (S)imulate Game-of-War, (Q)uit?");
        System.out.println();
        String answer = console.next();
        switch (answer.charAt(0)) {
            case 'c': // Create Deck
            case 'C':
                System.out.println("Here is your deck!");
                DisplayDeck(); // Display deck to console
                return true;

            case 's': // Simulate Game of War
            case 'S':
                GameOfWar game = new GameOfWar();
                game.rankMatch();
                console.nextLine();
                return true;

            case 'q': // Quit Program
            case 'Q':
            return false;

            default:
            System.out.println("Invalid answer. Please try again.");
            return true;
        } // end switch/case
    } // end of menu method


    public static void DisplayDeck() { // generate and display deck of cards
        Deck deck = new Deck();
        System.out.println(deck);
        System.out.println();
    }

    public GameOfWar() { // run simulation of "War"
            Deck deck = new Deck();
            System.out.println("Running Simulation!\n");
            //System.out.println(deck);

            Stack<Card> player1 = new Stack<>(); // initialize player stacks
            Stack<Card> player2 = new Stack<>();

            while (!deck.isEmpty()) { // while cards remain in deck
                player1.push(deck.dealCard());  // deck to stack
                player2.push(deck.dealCard());
            }

            this.player1 = new LinkedList<>(); // stack to list instance
            while (!player1.isEmpty()) {
                this.player1.add(player1.pop());
            }

            this.player2 = new LinkedList<>(); // stack to list instance
            while (!player2.isEmpty()) {
                this.player2.add(player2.pop());
            }
        } // end of GameOfWar method


        public void rankMatch () { // compare ranks/play hands
            Stack<Card> p1 = new Stack<>(); // initialize player stacks
            Stack<Card> p2 = new Stack<>();

            p1.push(player1.remove()); // list to stack
            p2.push(player2.remove());


            while (p1.peek().getRank() == p2.peek().getRank()) {

                p1.push(player1.remove()); // match hand
                p1.push(player1.remove());

                p2.push(player2.remove());
                p2.push(player2.remove());

            }

            Queue<Card> winner;
            int playerWinner;

            if (p1.peek().getRank() > p2.peek().getRank()) {
                winner = this.player1; // player 1 wins
                playerWinner = 1;
            } else {
                winner = this.player2; // player 2 wins
                playerWinner = 2;
            }

            while (!p1.isEmpty()) {
                winner.add(p1.pop());
            }

            while (!p2.isEmpty()) {
                winner.add(p2.pop());
            }
            // Display Match results
            System.out.println("Player " + playerWinner + " won the war!" + " (" + this.player1.size() + ", " + this.player2.size() + ")");
            System.out.println("Player 1 :" + this.player1);
            System.out.println("Player 2 :" + this.player2);
            System.out.println();
        } // end of rankMatch method
    } // end of class GameOfWar



