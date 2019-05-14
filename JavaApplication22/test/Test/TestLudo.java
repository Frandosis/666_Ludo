/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Ludo.Classic.ClassicLudo;
import Ludo.Classic.ClassicLudo;
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

    public TestLudo() {
        Braet1 braet1 = new Braet1();
        this.braet = braet1.getGraph();
    }

    public static void main(String[] arg) {
        TestLudo test = new TestLudo();
        ClassicLudo cl = new ClassicLudo(4);

        Brik groen = new Brik("green", 12, 58, 95, 99);
        Raflebaeger raflebaeger = new Raflebaeger(1);

        groen.setFeltnr(groen.getHjemFeltnr());
        test.braet.getFelt(groen.getHjemFeltnr()).landet(groen);
        int oejne = 0;
        while (oejne != 6) {
            raflebaeger.ryst();
            oejne = raflebaeger.getTerningVaerdi(0);
            test.rykUdAfHjem(raflebaeger.getTerningVaerdi(0), groen);

        }
        /*
        //Nu er groen på startfelt
        while (true) {
            raflebaeger.ryst();
            test.rykBrik(raflebaeger.getTerningVaerdi(0), groen);
            test.opdaterBraettet(groen);

        }
        */
       // cl.playSound();
    }

    public void rykBrik(int slag, Brik brik) {
        int feltnr = brik.getFeltnr();
        boolean gåTilbage = false;
        this.braet.getFelt(feltnr).forlader(brik);
        List<Vertex> list = null;
        for (int i = 1; i <= slag; i++) {
            list = this.braet.getAdjVertices(feltnr);
            if (list.size() != 0) {
                if (list.size() == 1) {
                    Vertex vertex = list.get(0);
                    if (feltnr == brik.getEndefeltnr() && i != slag) {
                        gåTilbage = true;
                    }
                    feltnr = vertex.getFeltnr();

                }
                if (list.size() >= 2) {
                    for (Vertex vertex : list) {
                        if (vertex.getFelt() instanceof Endefelt && brik.getFarve().equals(vertex.getFelt().getFarve())) {
                            if (gåTilbage == true && vertex.getFeltnr() < feltnr) {
                                feltnr = vertex.getFeltnr();
                            }
                            if (gåTilbage == false && vertex.getFeltnr() > feltnr) {
                                feltnr = vertex.getFeltnr();
                            }

                        } else if (vertex.getFelt() instanceof Endefelt == false) {
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
            this.braet.getFelt(brik.getFeltnr()).forlader(brik);
            brik.setFeltnr(brik.getStartFeltnr());
            this.braet.getFelt(brik.getFeltnr()).landet(brik);
            return;
        }
        return;

    }

    public void opdaterBraettet(Brik brik) {

        this.braet.getFelt(brik.getFeltnr()).landet(brik);

    }
}
