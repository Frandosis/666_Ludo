/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.enheder;

/**
 *
 * @author s184805
 */
public class Brik {
    String farve;
    int feltnr;
    public Brik (String spFarve){
        this.farve = spFarve;
    }
    
    public int getFeltnr(){
        return feltnr;
    }
    
    public void setFeltnr(int nyfelt){
        feltnr = nyfelt;
    }
    
}
