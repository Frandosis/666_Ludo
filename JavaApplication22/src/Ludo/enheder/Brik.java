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
    int feltnr;
    int slag;
    boolean helle;
    int bufferfeltnr;
    
    public Brik (String spFarve, int spHjemfeltnr, int spBufferfeltnr){
        this.farve = spFarve;
        this.hjemfeltnr = spHjemfeltnr;
        this.helle = false;
        this.bufferfeltnr = spBufferfeltnr;
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
    
    
    public boolean getHelle(){
        return this.helle;
    }
    
    public void setHelle(boolean HelleInd){
        this.helle = HelleInd;
    }
    
    public int getBufferfeltnr(){
        return this.bufferfeltnr;
    }
    
}
