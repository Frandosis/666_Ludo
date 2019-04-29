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
    final int hjemfeltnr;
    final int id;
    int feltnr;
    int slag;
    
    public Brik (String spFarve, int spHjemfeltnr, int ID){
        this.farve = spFarve;
        this.hjemfeltnr = spHjemfeltnr;
        this.id = ID;
    }
    
    public String getFarve(){
        return this.farve;
    }
    
    public int getHjemFeltnr(){
        return this.hjemfeltnr;
    }
    
    public int getFeltnr(){
        return this.feltnr;
    }
    
    public void setFeltnr(int nyfelt){
        this.feltnr = nyfelt;
    }
    
    public int getSlag(){
        return this.slag;
    }
    
    public void setSlag(int slagInd){
        this.slag = slagInd;
    }
    
    public int getID(){
     return this.id;
    }
    
}
