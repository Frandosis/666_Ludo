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
public class Startfelt implements Felt {

    final String farve;
    final int feltnr;
    Queue<Brik> brikker;
    Regler regler;
    boolean angrebVandt;

    public Startfelt(String spFarve, int spFeltnr) {
        this.farve = spFarve;
        this.feltnr = spFeltnr;
        this.brikker = new LinkedList<>();
        this.regler = new Regler();
        this.angrebVandt = false;

    }

    @Override
    public void landet(Brik brikInd) {
        
        if (this.brikker.contains(brikInd)){
            return;
        }
        
        if (brikInd.getFarve().equals(this.farve)) {
            brikInd.setHelle(true);

        }

        // Check om der er brikker på feltet.
        if (brikker.isEmpty()) {
            brikker.add(brikInd);
        } // Der er brikker på feltet.
        else {

            Brik tmp = brikker.peek();

            //Check om brikken/erne har samme farve som feltet.
            if (tmp.getFarve().equals(this.farve)) {

                /*
                * 1. Brikken der lander på feltet er den samme type, som den/de eksisterende brik/ker
                * 2. Brikken der lander på feltet er forskellig fra den/de eksisterende brik/ker
                 */
                if (brikInd.getFarve().equals(tmp.getFarve())) {
                    brikker.add(brikInd);
                } else {

                    angrebVandt = regler.kamp(brikker.size(), tmp, brikInd);
                    rykEfterKamp(brikInd);
                }
            } // Brikkerne har en anden farve end feltet.
            else {
                // Check om brikken der lander på feltet har den samme farve, som den/de eksisterende brik/ker.
                if (brikInd.getFarve().equals(tmp.getFarve())) {
                    brikker.add(brikInd);
                } else {
                    // Check om brikken der lander på feltet har den samme farve som feltet.
                    if (brikInd.getFarve().equals(this.farve)) {

                        angrebVandt = regler.kamp(brikker.size(), tmp, brikInd);
                        rykEfterKamp(brikInd);

                    } else {

                        angrebVandt = regler.kamp(brikker.size(), tmp, brikInd);
                        rykEfterKamp(brikInd);
                    }
                }
            }

        }
    }

    @Override
    public void forlader() {
        var brikUd = brikker.poll();
        brikUd.setHelle(false);
        brikUd = null;
        

    }

    public void rykEfterKamp(Brik brikInd) {
        if (angrebVandt == true) {
            while (brikker.isEmpty() == false) {
                var brik = brikker.poll();
                brik.setFeltnr(brik.getHjemFeltnr());
                brik.setHelle(false);
                brik = null;
            }
            brikker.add(brikInd);
        } else {
            brikInd.setFeltnr(brikInd.getHjemFeltnr());
        }
    }
}
