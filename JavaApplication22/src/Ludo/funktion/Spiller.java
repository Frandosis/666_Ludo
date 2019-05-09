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
    
    public Spiller (String spName, String spFarve){
        this.name = spName;
        this.farve = spFarve;
        this.brikker = new ArrayList ();
        
        vundet = false;
    }
    
    public void addBrik(int hjemfeltnr, int startfeltnr, int endefeltnr, int bufferfeltnr){
        brikker.add(new Brik(this.farve, hjemfeltnr, startfeltnr, endefeltnr, bufferfeltnr));
        return;
    }
    
    public ArrayList getBrikker(){
        return this.brikker;
    }
    
    
    
}
