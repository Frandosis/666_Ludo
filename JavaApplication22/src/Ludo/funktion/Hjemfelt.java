
package Ludo.funktion;

import Ludo.enheder.Brik;


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
    public int getSize(){
        if(containsBrik == true){
            return 1;
        }
        return 0;
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
