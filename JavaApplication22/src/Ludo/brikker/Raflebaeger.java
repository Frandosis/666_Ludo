/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.brikker;

import java.util.ArrayList;

/**
 *
 * @author s184805
 */
public class Raflebaeger {

    ArrayList<Terning> raflebaeger;

    public Raflebaeger(int antalterninger) {
        raflebaeger = new ArrayList<Terning>();

        for (int i = 0; i < antalterninger; i++) {
            Terning terning = new Terning();
            raflebaeger.add(terning);
        }
    }

    public void rystBaeger() {
        double tilfaeldigvaerdi = Math.random() % 100;
        
        int antalkast = (int) (tilfaeldigvaerdi * 100 + 1);
        
        for (int i = 0; i < antalkast; i++) {
            for (int j = 0; j < raflebaeger.size(); j++) {

                Terning terning = raflebaeger.get(j);
                terning.kast();
                raflebaeger.set(j, terning);

            }
        }
    }
    
    public int getTerningVaerdi (int index){
        Terning terning = raflebaeger.get(index);
        return terning.getVærdi();
    }
    
    public String getAlleVaerdier(){
        String s = "";
        for (int i = 0; i < raflebaeger.size(); i++){
            Terning terning = raflebaeger.get(i);
            s += terning.getVærdi() + ",";
        }
        return s;
    }
}
