/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.funktion;

import Ludo.enheder.*;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author jcall
 */
public class Bufferfelt implements Felt {

    int antalbuffer;
    final String farve;
    final int feltnr;
    Queue<Brik> brikker;
    boolean win = false;
    
    public Bufferfelt (String spFarve, int spFeltnr){
    this.feltnr = spFeltnr;
    this.farve = spFarve;
        this.brikker = new LinkedList<Brik>();
        
    }
    
    /*
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
*/
    @Override
    public void landet(Brik brikInd) {
        brikker.add(brikInd); 
    }

    @Override
    public void forlader() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
