/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.funktion;

import Ludo.enheder.Brik;
import java.util.HashSet;

/**
 *
 * @author s184805
 */
public class Hjemfelt implements Felt {

    final String farve;
    final int feltnr;
    final int startfeltnr;
    boolean indeholderBrik;

    public Hjemfelt(String spFarve, int spFeltnr, int spStartfeltnr) {
        this.farve = spFarve;
        this.feltnr = spFeltnr;
        this.startfeltnr = spStartfeltnr;

    }

    @Override
    public void landet(Brik brikInd) {
        if (this.farve.equals(brikInd.getFarve())) {
            this.indeholderBrik = true;
        }
        
    }
    
    @Override
    public void forlader(Brik brikUd){
        if (brikUd.getSlag() == 6){
            brikUd.setFeltnr(this.startfeltnr);
        }
    }
    
}
