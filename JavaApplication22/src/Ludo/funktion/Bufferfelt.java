/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.funktion;

import Ludo.enheder.*;
import java.util.Queue;
/**
 *
 * @author jcall
 */
public class Bufferfelt {

    int antalbuffer;
    String farve;
    int feltnr;
    Queue<Brik> brikker;
    boolean win = false;
    
    
    public void tilqueue(Brik brikInd){
        
             brikker.add(brikInd);   
              
    }
    
    public Boolean checkWin() {
        
        
        if(brikker.size() == 4){
            win = true;
           return win;
        }
        else{
        win = false;
        }
        return win;
    }
}
