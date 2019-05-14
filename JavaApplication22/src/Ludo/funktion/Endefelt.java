
package Ludo.funktion;

import Ludo.enheder.*;
import java.util.ArrayList;

public class Endefelt implements Felt {
        final String farve;
        final int feltnr;
        int antalBrikker;
        boolean out = false;
        ArrayList<Brik> brikker;
        
        
    public Endefelt (String spFarve,int spFeltnr){
    this.feltnr = spFeltnr;
    this.farve = spFarve;
    this.brikker = new ArrayList();
       
    }
        
    @Override
    public int getSize(){
        return brikker.size();
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
        if(brikker.contains(brikInd)){
            return;
        }
        
        if(brikInd.getEndefeltnr() == feltnr){
            brikInd.setFeltnr(brikInd.getBufferfeltnr());
            return;
        }
        
        brikker.add(brikInd);
        return;
        
    }

    @Override
    public void forlader(Brik brikUd) {
         brikker.remove(brikUd);
         return;
         
        
}
}
    
    
