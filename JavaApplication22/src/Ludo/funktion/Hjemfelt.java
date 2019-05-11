/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.funktion;

import Ludo.enheder.Brik;

/**
 *
 * @author s184805
 */
public class Hjemfelt implements Felt {

    final String farve;
    final int feltnr;
    Brik brik;

    public Hjemfelt(String spFarve, int spFeltnr) {
        this.farve = spFarve;
        this.feltnr = spFeltnr;
        this.brik = null;
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
        if(brik == null && this.farve.equals(brikInd.getFarve())){
            this.brik = brikInd;
            this.brik.setHelle(true);
            return;
        }
        if(brik.equals(brikInd)){
            return;
        }
        
    }
    
    @Override
    public void forlader(Brik brikUd){
        this.brik.setHelle(false);
        this.brik = null;
        brikUd.setHelle(false);
        
        
    }
    
}
