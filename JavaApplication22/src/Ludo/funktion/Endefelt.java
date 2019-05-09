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
        String farve;
        int feltnr;
        int antalBrikker;
        int tmp;
        boolean out = false;
        Queue<Brik> brikker;
        
        
    public Endefelt (int spFeltnr){
    this.feltnr = spFeltnr;
        this.brikker = new LinkedList<Brik>();
        for (int i = 0; i < 4; i++) {
            brikker.add(null);
        }
    }
        

    @Override
    public void landet(Brik brikInd) {
        
        brikker.add(brikInd);
        
        var brik = brikker.poll();
        brik.setFeltnr(brik.getBufferfeltnr());
        brik = null;
    }

    @Override
    public void forlader() {
       brikker.poll();
}
}
    
    
