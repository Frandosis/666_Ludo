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
public class Banefelt implements Felt {

    final int feltnr;
    ArrayList<Brik> brikker;
    Regler regler;
    boolean angrebVandt;

    public Banefelt(int spFeltnr) {
        this.feltnr = spFeltnr;
        this.brikker = new ArrayList();
        this.regler = new Regler();
        this.angrebVandt = false;

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
            var forsvarer = brikker.get(0);
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
    public int getSize(){
        return brikker.size();
    }
    
    @Override
    public String getFarve(){
        return "";
    }

    @Override
    public int getFeltnr(){
        return this.feltnr;
    }
    
    @Override
    public void forlader(Brik brikUd) {
        brikker.remove(brikUd);
        return;

    }

    public void rykEfterKamp(Brik brikInd) {
         if (angrebVandt == true) {
            for(Brik brik : brikker){
                brik.setFeltnr(brik.getHjemFeltnr());
            }
            brikker.clear();
            brikker.add(brikInd);
        } else {
            brikInd.setFeltnr(brikInd.getHjemFeltnr());
        }
    }
}
