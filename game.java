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
        
        public String toString(){
            return value + "-" + type;
        }
        
        public int getValue(){
            if ("AJQK".contains(value)){
                if (value == "A"){
                    return 11;
                }
                return 10;
            }
            return Integer.parseInt(value);
        }
        
        public boolean isAce(){
            return value == "A"; 
        }
        
        public String getImagePath(){
            return "./cards/" + toString() + ".png";
        }
    }
    
    //array list to store cards
    ArrayList<Card> deck;
    Random random = new Random(); //shuffle deck
        
    game(){
        startGame();
        
        frame.setVisible(true); //creating window
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null); // open the window at the centre of the screen
        frame.setResizable(false); // you can't re-size the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gamePanel.setLayout(new BorderLayout());
        gamePanel.setBackground(new Color(54, 101, 77));
        frame.add(gamePanel);
        
        hitButton.setFocusable(false);
        buttonPanel.add(hitButton);
        stayButton.setFocusable(false);
        buttonPanel.add(stayButton);
        frame.add(buttonPanel,BorderLayout.SOUTH);
        
        hitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Card card = deck.remove(deck.size() - 1);
                playerSum += card.getValue();
                
                if (card.isAce()) {
                    playerAceCount = playerAceCount + 1;
                }
                
                playerHand.add(card);
                gamePanel.repaint();
            }
        });
        gamePanel.repaint();
    }
    
    public void startGame(){
        buildDeck();
    
        dealerHand = new ArrayList<Card>();
        dealerSum = 0;
        dealerAceCount = 0;
    
        hiddenCard = deck.remove(deck.size() - 1);
        dealerSum += hiddenCard.getValue();
        if (hiddenCard.isAce()) {
            dealerAceCount++;
        }
    
        shuffleDeck();
    }

    // dealer
    Card hiddenCard;
    ArrayList<Card> dealerHand;
    int dealerSum;
    int dealerAceCount;
    
    //player
    ArrayList<Card> playerHand;
    int playerSum;
    int playerAceCount;
    
    // game window
    int boardWidth = 600;
    int boardHeight = 600;
    
    int cardWidth = 110;
    int cardHeight = 154;
    
    JFrame frame = new JFrame("Black Jack");
    JPanel gamePanel = new JPanel(){
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);  
            
            //hidden card
            Image hiddenCardImage = new ImageIcon(getClass().getResource("./cards/BACK.png")).getImage();
            g.drawImage(hiddenCardImage, 20, 20, cardWidth, cardHeight, null);
            
            //draw dealers hand
            for (int i = 0; i < dealerHand.size(); i++){
                Card card = dealerHand.get(i);
                Image cardImg = new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
                g.drawImage(cardImg, cardWidth + 25 + (cardWidth + 5)*i, 20, cardWidth, cardHeight, null);
            }
            
            // draw players hand
            for (int i = 0; i < playerHand.size(); i++){
                Card card = playerHand.get(i);
                Image cardImg = new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
                g.drawImage(cardImg, 20 + (cardWidth + 5)*i, 320, cardWidth, cardHeight, null);
            }
        }
    };
    JPanel buttonPanel = new JPanel();
    JButton hitButton = new JButton("Hit");
    JButton stayButton = new JButton("Stand");

    public void shuffleDeck(){
        for (int i = 0; i < deck.size(); i++){
            int j = random.nextInt(deck.size());
            Card currCard = deck.get(i);
            Card randomCard = deck.get(j); 
            deck.set(i, randomCard);
            deck.set(j, currCard);
        }
        
        System.out.println("AFTER SHUFFLE");
        System.out.println(deck);
        
        Card card = deck.remove(deck.size() - 1);
        dealerSum += card.getValue();
        if (card.isAce()) {
            dealerAceCount++;
        }
        dealerHand.add(card);

        System.out.println("DEALER:");
        System.out.println(hiddenCard);
        System.out.println(dealerHand);
        System.out.println(dealerSum);
        System.out.println(dealerAceCount);
        
        //player
        playerHand = new ArrayList<Card>();
        playerSum = 0;
        playerAceCount = 0;
        
        for(int i = 0; i < 2; i++){
            card = deck.remove(deck.size()-1);
            playerSum += card.getValue();
            if (card.isAce()){
                playerAceCount++;
            }
            playerHand.add(card);
        }
        
        System.out.println("PLAYER:");
        System.out.println(playerHand);
        System.out.println(playerSum);
        System.out.println(playerAceCount);
    }
    
    public void buildDeck(){
        deck = new ArrayList<Card>();
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; 
        String[] types = {"C", "D", "H", "S"};
        
        for (int i = 0; i < types.length; i++){
            for (int j = 0; j < values.length; j++){
                Card card = new Card(values[j], types[i]);
                deck.add(card);
            }
        }
         
        System.out.println("BUILD DECK:");
        System.out.println(deck);
    }
}