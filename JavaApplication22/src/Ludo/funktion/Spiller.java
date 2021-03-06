
package Ludo.funktion;
import Ludo.enheder.*;
import java.util.ArrayList;



public class Spiller {
    
    String name;
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
    
    public String getFarve(){
        return this.farve;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String newName){
        this.name = newName;
        
    }
    
    public void addBrik(int hjemfeltnr, int startfeltnr, int endefeltnr, int bufferfeltnr){
        brikker.add(new Brik(this.farve, hjemfeltnr, startfeltnr, endefeltnr, bufferfeltnr));
        return;
    }
    
    public Brik getBrik(int index){
        return this.brikker.get(index);
    }
    
    public ArrayList<Brik> getBrikker(){
        return this.brikker;
    }
    
    public void kast(){
        this.raflebaeger.ryst();
    }
    
    public int getSlag(){
        return this.raflebaeger.getTerningVaerdi(0);
    }
    
}
