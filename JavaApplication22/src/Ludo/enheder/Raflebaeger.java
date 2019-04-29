/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.enheder;

import java.util.ArrayList;

public class Raflebaeger {

    ArrayList<Terning> raflebaeger;

    public Raflebaeger(int antalterninger) {
        raflebaeger = new ArrayList<Terning>();

        for (int i = 0; i < antalterninger; i++) {
            Terning terning = new Terning();
            raflebaeger.add(terning);
        }
    }
    
  
    public int size(){
        return raflebaeger.size();
    }
    
    public void ryst() {
        double tilfaeldigvaerdi = Math.random() % 50;

        int antalkast = (int) (tilfaeldigvaerdi * 50 + 1);

        for (int i = 0; i < antalkast; i++) {
            for (int j = 0; j < raflebaeger.size(); j++) {

                Terning terning = raflebaeger.get(j);
                terning.kast();
                raflebaeger.set(j, terning);

            }
        }
    }

    public int getTerningVaerdi(int index) {
        Terning terning = raflebaeger.get(index);
        return terning.getVærdi();
    }
/* // skal ikke bruges i dette projekt 
    public String getAlleVaerdier() {
        String s = "";
        for (int i = 0; i < raflebaeger.size(); i++) {
            Terning terning = raflebaeger.get(i);
            if (i == raflebaeger.size() - 1) {
                s += terning.getVærdi();
                break;
            }
            s += terning.getVærdi() + ",";
        }
        return s;
    }

    public void addTerning(int antal) {
        if (antal < 0) {
            return;
        }

        for (int i = 0; i < antal; i++) {
            Terning terning = new Terning();
            raflebaeger.add(terning);
        }

    }

    public void removeTerning(int antal) {
        if (antal < 0) {
            return;
        }

        for (int i = 0; i < antal; i++) {
            raflebaeger.remove(0);
            
        }
    }
   */ 
}
