/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Valdemar Landberg
 */
public class TestSlutPopOp {
    
    public static void main(String [] args){
        String win = "Tillykke med sejren green"; 
        
        Object[] options = {"Nyt spil",
                    "Luk spillet"};
                int n = JOptionPane.showOptionDialog(new JFrame(),
                        win,
                        "Tillykke med sejren!",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, //do not use a custom Icon
                        options, //the titles of buttons
                        options[0]); //default button title

                switch (n){
                    //Yes Option
                    case 0:
                        System.out.println("Yes");
                        break;
                        
                    //No Option    
                    case 1:
                        System.out.println("No");
                        break;
                    //close Option
                    case -1:
                        System.out.println("close");
                        break;
                }
                
                System.exit(0);
            }
        
        
    
    
}
