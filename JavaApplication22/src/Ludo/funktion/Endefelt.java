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
 * @author s184805
 */
public class Endefelt implements Felt {
        final String farve;
        final int feltnr;
        int antalBrikker;
        boolean out = false;
        Queue<Brik> brikker;
        
        
    public Endefelt (int spFeltnr, String spFarve){
    this.feltnr = spFeltnr;
    this.farve = spFarve;
        this.brikker = new LinkedList<Brik>();
        for (int i = 0; i < 4; i++) {
            brikker.add(null);
        }
    }
        

    @Override
    public void landet(Brik brikInd) {
        if(brikInd.getEndefeltnr() == feltnr){
            brikInd.setFeltnr(brikInd.getBufferfeltnr());
        }
        
        brikker.add(brikInd);
        
        
    }

    @Override
    public void forlader() {
         brikker.poll();
        
}
}
    
    
