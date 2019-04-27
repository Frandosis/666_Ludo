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
public class Startfelt implements Felt {
    final String farve;
    final int feltnr;
    int antalBrikker;
    ArrayList<Brik> brikker;
    
    public Startfelt (String spFarve, int spFeltnr){
        this.farve = spFarve;
        this.feltnr = spFeltnr;
        this.brikker = new ArrayList<Brik> ();
    }
    
    public void landet(Brik brikInd){
        
    }
    
}
