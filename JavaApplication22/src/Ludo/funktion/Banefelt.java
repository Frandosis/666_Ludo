/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.funktion;

import Ludo.enheder.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author s184805
 */
public class Banefelt implements Felt {

    final int feltnr;
    Queue<Brik> brikker;
    Regler regler;
    boolean angrebVandt;

    public Banefelt(int spFeltnr) {
        this.feltnr = spFeltnr;
        this.brikker = new LinkedList<>();
        angrebVandt = false;

    }

    @Override
    public void landet(Brik brikInd) {
        if (brikker.isEmpty()) {
            brikker.add(brikInd);

        } else {
            var forsvarer = brikker.peek();
           angrebVandt = regler.kamp(brikker.size(), forsvarer, brikInd);
           rykEfterKamp (brikInd);
        }
    }

    @Override
    public void forlader(Brik brikUd) {

    }

    public void rykEfterKamp(Brik brikInd) {
        if (angrebVandt == true) {
            while (brikker.isEmpty() == false) {
                var brik = brikker.poll();
                brik.setFeltnr(brik.getHjemFeltnr());
                
            }
            brikker.add(brikInd);
        } else {
            brikInd.setFeltnr(brikInd.getHjemFeltnr());
            
        }
    }
}
