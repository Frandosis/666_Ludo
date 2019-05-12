/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.Classic;

import java.util.*;
import Ludo.enheder.*;
import Ludo.funktion.*;
import Ludo.funktion.Braet1.*;

/**
 *
 * @author Valdemar Landberg
 */
public class TestLudo {

    public Graph braet;

    public static void main(String[] arg) {
        TestLudo test = new TestLudo();

        Braet1 braet1 = new Braet1();
        test.braet = braet1.getGraph();
        Brik groen = new Brik("green", 12, 58, 95, 99);
        Raflebaeger raflebaeger = new Raflebaeger(1);

        test.braet.getFelt(groen.getHjemFeltnr()).landet(groen);

        while (raflebaeger.getTerningVaerdi(0) != 6) {
            raflebaeger.ryst();
            test.rykUdAfHjem(raflebaeger.getTerningVaerdi(0), groen);

        }

        //Nu er groen på startfelt
        
        while(true){
         raflebaeger.ryst();
         
         
        }

    }

    public void rykBrik(int slag, Brik brik) {
        int feltnr = brik.getFeltnr();
        braet.getFelt(feltnr).forlader(brik);
        List<Vertex> list = null;
        for (int i = 0; i < slag; i++) {
            list = braet.getAdjVertices(feltnr);
            if (list.size() != 0) {
                if (list.size() == 1) {
                    Vertex vertex = list.get(0);
                    feltnr = vertex.getFeltnr();
                }
                if (list.size() >= 2){
                    for (Vertex vertex : list) {
                        if(vertex.getFelt() instanceof Endefelt && brik.getFarve().equals(vertex.getFelt().getFarve())){
                            feltnr = vertex.getFeltnr();
                        }
                        else if (vertex.getFelt() instanceof Endefelt == false) {
                            feltnr = vertex.getFeltnr();
                        }
                    }
                }
            }
            
        }
        
        brik.setFeltnr(feltnr);
        braet.getFelt(brik.getFeltnr()).landet(brik);
        
    }

    public void rykUdAfHjem(int slag, Brik brik) {
        if (slag == 6) {
            braet.getFelt(brik.getFeltnr()).forlader(brik);
            brik.setFeltnr(brik.getStartFeltnr());
            braet.getFelt(brik.getFeltnr()).landet(brik);
            return;
        }
        return;

    }

}
