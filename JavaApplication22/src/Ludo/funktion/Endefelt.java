/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.funktion;

import Ludo.enheder.*;
import java.util.ArrayList;
/**
 *
 * @author s184805
 */
public class Endefelt implements Felt {
        final String farve;
        final int feltnr;
        int antalBrikker;
        boolean out = false;
        ArrayList<Brik> brikker;
        
        
    public Endefelt (String spFarve,int spFeltnr){
    this.feltnr = spFeltnr;
    this.farve = spFarve;
    this.brikker = new ArrayList();
       
    }
        
    @Override
    public int getFeltnr(){
        return this.feltnr;
    }
    
    @Override
    public String getFarve(){
        return this.farve;
    }

    @Override
    public void landet(Brik brikInd) {
        if(brikker.contains(brikInd)){
            return;
        }
        
        if(brikInd.getEndefeltnr() == feltnr){
            brikInd.setFeltnr(brikInd.getBufferfeltnr());
            return;
        }
        
        brikker.add(brikInd);
        return;
        
    }

    @Override
    public void forlader(Brik brikUd) {
         brikker.remove(brikUd);
         return;
         
        
}
}
    
    
