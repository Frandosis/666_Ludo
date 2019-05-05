/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.funktion;

import Ludo.enheder.*;
import java.util.LinkedList;

/**
 *
 * @author s184805
 */
public class Banefelt implements Felt {

    final int feltnr;
    LinkedList<Brik> brikker;
    Regler regler;
    boolean angrebVandt;

    public Banefelt(int spFeltnr) {
        this.feltnr = spFeltnr;
        this.brikker = new LinkedList<Brik>();
        for(int i = 0; i < 4; i++){
            brikker.add(null);
        }
        angrebVandt = false;

    }

    @Override
    public void landet(Brik brikInd) {
        if (brikker.isEmpty()) {
            brikker.add(brikInd);

        } else {
            var forsvarer = brikker.;
            if(forsvarer.getFarve().equals(brikInd.getFarve()))
           angrebVandt = regler.kamp(brikker.size(), forsvarer, brikInd);
           rykEfterKamp (brikInd);
        }
    }

    @Override
    public void forlader() {
        brikker.poll();
        
    }

    public void rykEfterKamp(Brik brikInd) {
        boolean isEmpty = false;
        int nulls = 0;
        for (int i = 0; i < 4; i++){
            var brik = brikker.get(i);
            if(brik == null){
                nulls++;
            }
            if (nulls == 4){
                isEmpty = true;
            }
        }
        
        if (angrebVandt == true) {
            while (isEmpty == false) {
                var brik = brikker.;
                brik.setFeltnr(brik.getHjemFeltnr());
                brik = null;
                
            }
            brikker.add(brikInd);
        } else {
            brikInd.setFeltnr(brikInd.getHjemFeltnr());
            
        }
    }
}
