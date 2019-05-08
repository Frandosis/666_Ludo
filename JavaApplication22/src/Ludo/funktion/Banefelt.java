/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.funktion;

import Ludo.enheder.*;
import java.util.Queue;
import java.util.LinkedList;

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
        this.brikker = new LinkedList<Brik>();
        for (int i = 0; i < 4; i++) {
            brikker.add(null);
        }
        angrebVandt = false;

    }

    @Override
    public void landet(Brik brikInd) {
        if(brikker.contains(brikInd)){
            return;
        }
        
        //Der er ingen brikker paa feltet
        if (brikker.isEmpty()) {
            brikker.add(brikInd);

        } //Der er brikker paa feltet i forvejen.
        else {
            var forsvarer = brikker.peek();
            //Check om brikkerne der er i forvejen er ens med den brik der lander.
            if (forsvarer.getFarve().equals(brikInd.getFarve())) {
                brikker.add(brikInd);
            } //Brikken er ikke ens.
            else {
                angrebVandt = regler.kamp(brikker.size(), forsvarer, brikInd);
                rykEfterKamp(brikInd);
            }
        }
    }

    @Override
    public void forlader() {
        brikker.poll();

    }

    public void rykEfterKamp(Brik brikInd) {
         if (angrebVandt == true) {
            while (brikker.isEmpty() == false) {
                var brik = brikker.poll();
                brik.setFeltnr(brik.getHjemFeltnr());
                brik = null;
            }
            brikker.add(brikInd);
        } else {
            brikInd.setFeltnr(brikInd.getHjemFeltnr());
        }
    }
}
