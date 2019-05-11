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
    ArrayList<Brik> brikker;
    Regler regler;
    boolean angrebVandt;

    public Startfelt(String spFarve, int spFeltnr) {
        this.farve = spFarve;
        this.feltnr = spFeltnr;
        this.brikker = new ArrayList();
        this.regler = new Regler();
        this.angrebVandt = false;

    }
    
    @Override
    public String getFarve(){
        return this.farve;
    }
    
    @Override
    public int getFeltnr(){
        return this.feltnr;
    }

    @Override
    public void landet(Brik brikInd) {
        
        if (this.brikker.contains(brikInd)){
            return;
        }
        
        if (brikInd.getFarve().equals(this.farve)) {
            brikInd.setHelle(true);

        }

        // Check om der er brikker paa feltet.
        if (brikker.isEmpty()) {
            brikker.add(brikInd);
        } // Der er brikker paa feltet.
        else {

            Brik tmp = brikker.get(0);

            //Check om brikken/erne har samme farve som feltet.
            if (tmp.getFarve().equals(this.farve)) {

                /*
                * 1. Brikken der lander paa feltet er den samme type, som den/de eksisterende brik/ker
                * 2. Brikken der lander paa feltet er forskellig fra den/de eksisterende brik/ker
                 */
                if (brikInd.getFarve().equals(tmp.getFarve())) {
                    brikker.add(brikInd);
                } else {

                    angrebVandt = regler.kamp(brikker.size(), tmp, brikInd);
                    rykEfterKamp(brikInd);
                }
            } // Brikkerne har en anden farve end feltet.
            else {
                // Check om brikken der lander paa feltet har den samme farve, som den/de eksisterende brik/ker.
                if (brikInd.getFarve().equals(tmp.getFarve())) {
                    brikker.add(brikInd);
                } else {
                    // Check om brikken der lander paa feltet har den samme farve som feltet.
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
    public void forlader(Brik brikUd) {
        brikker.remove(brikUd);
        brikUd.setHelle(false);

    }

    public void rykEfterKamp(Brik brikInd) {
        if (angrebVandt == true) {
            for(Brik brik : brikker){
                brik.setFeltnr(brik.getHjemFeltnr());
                brik.setHelle(false);
            }
            brikker.clear();
            brikker.add(brikInd);
        } else {
            brikInd.setFeltnr(brikInd.getHjemFeltnr());
        }
    }
}
