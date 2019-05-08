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
    final int bufferfeltnr;
    final int endefeltnr;
    int feltnr;
    int slag;
    boolean helle;
    boolean erHjemme;
  
    
    public Brik (String spFarve, int spHjemfeltnr,int spEndefeltnr , int spBufferfeltnr){
        this.farve = spFarve;
        this.hjemfeltnr = spHjemfeltnr;
        this.helle = false;
        this.bufferfeltnr = spBufferfeltnr;
        this.endefeltnr = spEndefeltnr;
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
    
    public int getEndefeltnr(){
    
        return this.endefeltnr;
    }
    
}
