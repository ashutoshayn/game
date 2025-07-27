
/**
 * Write a description of class game here.
 *
 * @author Ashu
 * @version 22/07/2025
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
public class game
{
    private class Card{
        String value;
        String type;
        
        Card(String value, String type){
            this.value = value; // creating value of card
            this.type = type; // creating type of card
        }
    }
    
    //array list to store cards
        ArrayList<Card> deck;
        
    game(){
        startGame();
    }
    
    public void startGame(){
        //deck
        buildDeck();
    }
    
    public void shuffleDeck(){
        
    }
    
    public void buildDeck(){
        deck = new ArrayList<Card>();
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; 
        String[] types = {"C", "D", "H", "S"};
        
        for (String type : types){
            for (String value : values){
                deck.add(new Card(value, type));
            }
        }
        
        shuffleDeck();
    }
}