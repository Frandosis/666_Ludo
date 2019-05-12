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
    boolean containsBrik;

    public Hjemfelt(String spFarve, int spFeltnr) {
        this.farve = spFarve;
        this.feltnr = spFeltnr;
        this.containsBrik = false;
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
        if(containsBrik == false && this.farve.equals(brikInd.getFarve())){
            this.containsBrik = true;
            brikInd.setErHjemme(true);
            return;
        }
        if(containsBrik == true || brikInd.getErHjemme() == true){
            if(brikInd.getErHjemme() == true && containsBrik == false){
                containsBrik = true;
                return;
            }
            if(brikInd.getErHjemme() == false && containsBrik == true){
                brikInd.setErHjemme(true);
                return;
            }
            
            return;
        }
        
    }
    
    @Override
    public void forlader(Brik brikUd){
        this.containsBrik = false;
        brikUd.setErHjemme(false);
        
        
    }
    
}
