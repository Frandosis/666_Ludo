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
    Regler regler;

    public Startfelt(String spFarve, int spFeltnr) {
        this.farve = spFarve;
        this.feltnr = spFeltnr;
        this.brikker = new ArrayList<Brik>();
        Regler regler = new Regler();

    }

    @Override
    public void landet(Brik brikInd) {
        if (brikker.isEmpty()) {
            brikker.add(brikInd);
        } else {
            Brik tmp = brikker.get(0);
            if (tmp.getFarve().equals(this.farve)) {
                if (brikInd.getFarve().equals(tmp.getFarve())) {
                    brikker.add(brikInd);
                } else {
                    regler.kamp(true, brikker.size(), tmp, brikInd);
                }

            } else {
                if (brikInd.getFarve().equals(tmp.getFarve())) {
                    brikker.add(brikInd);
                } else {
                    if (brikInd.getFarve().equals(this.farve)) {
                        
                    } else {
                        regler.kamp(false, brikker.size(), tmp, brikInd);
                    }
                }
            }

        }
    }

    @Override
    public void forlader(Brik brikUd) {

    }

}
