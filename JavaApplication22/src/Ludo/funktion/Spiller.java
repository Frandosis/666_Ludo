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
 * @author Valdemar Landberg
 */
public class Spiller {
    
    final String name;
    final String farve;
    ArrayList<Brik> brikker;
    boolean vundet;
    Raflebaeger raflebaeger;
    
    public Spiller (String spName, String spFarve){
        this.name = spName;
        this.farve = spFarve;
        this.brikker = new ArrayList ();
        this.raflebaeger = new Raflebaeger(1);
        
        vundet = false;
    }
    
    public void addBrik(int hjemfeltnr, int startfeltnr, int endefeltnr, int bufferfeltnr){
        brikker.add(new Brik(this.farve, hjemfeltnr, startfeltnr, endefeltnr, bufferfeltnr));
        return;
    }
    
    public ArrayList getBrikker(){
        return this.brikker;
    }
    
    public void kast(){
        this.raflebaeger.ryst();
    }
    
    public int getSlag(){
        return this.raflebaeger.getTerningVaerdi(0);
    }
    
}
