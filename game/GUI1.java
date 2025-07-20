/**
 * Write a description of class GUI1 here.
 *
 * @author Ashu
 * @version 05/05/2025
 */
import javax.swing.*;
import java.awt.*; 
import java.util.Scanner;
public class GUI1 extends JFrame
{
    // instance variables - replace the example below with your own
    private int x;
    private ImageIcon image;
    private JLabel label;
    /**
     * Constructor for objects of class GUI1
     */
    public GUI1()
    {
        Scanner sc = new Scanner(System.in); 
        System.out.println("What would you like to call your window?"); // asking user what the name of the window should be
        
        String windowname = sc.nextLine(); 
        
        setTitle(windowname); // setting the window name
        
        // size of the window
        this.getContentPane().setPreferredSize(new Dimension(1920,1080)); 
        
        // closing the window 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Most of the code down below
        
        this.pack(); // sizes window so contents are above preferred size.
        this.toFront();    // says whether the window wants to be in the front.  Won’t force it to be the active window though.
        this.setVisible(true);
        
        Canvas myGraphic; // declaring canvas variable
        
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}