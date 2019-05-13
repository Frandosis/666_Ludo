/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.Classic;

import Ludo.GUI.Feltvisning;
import Ludo.enheder.*;
import Ludo.funktion.*;
import Ludo.funktion.Braet1.*;
import java.util.*;

/**
 *
 * @author Valdemar Landberg
 */
public class ClassicLudo {

    public ArrayList<Spiller> spillere;
    public ArrayList<Feltvisning> felter;

    
    public Braet1 braet1;
    public Graph braet;
    public Regler regler;
    int antalspillere;
    public int spillerstur;

    public ClassicLudo(int startantalspillere) {
        this.spillere = new ArrayList();
        this.felter = new ArrayList();

        this.braet1 = new Braet1();

        this.regler = new Regler();

        this.spillerstur = 0;
        
        this.antalspillere = startantalspillere;

    }

    public void setUpGame() {

        //Først lav braettet
        braet = braet1.getGraph();
        
        felter.add(new Feltvisning(11, 2, 0)); // Blaa Start 1
        felter.add(new Feltvisning(12, 2, 1)); // Blaa Start 2
        felter.add(new Feltvisning(11, 3, 2)); // Blaa Start 3
        felter.add(new Feltvisning(12, 3, 3)); // Blaa Start 4
        felter.add(new Feltvisning(11, 11, 4)); // Roed Start 1
        felter.add(new Feltvisning(12, 11, 5)); // Roed Start 2
        felter.add(new Feltvisning(11, 12, 6)); // Roed Start 3
        felter.add(new Feltvisning(12, 12, 7)); // Roed Start 4
        felter.add(new Feltvisning(2, 11, 8));  // Gul Start 1
        felter.add(new Feltvisning(3, 11, 9)); // Gul start 2
        felter.add(new Feltvisning(2, 12, 10)); // Gul start 3
        felter.add(new Feltvisning(3, 12, 11)); // Gul start 4
        felter.add(new Feltvisning(2, 2, 12)); // Groen start 1
        felter.add(new Feltvisning(3, 2, 13)); // Groen start 2
        felter.add(new Feltvisning(2, 3, 14)); // Groen start 3
        felter.add(new Feltvisning(3, 3, 15)); // Groen start 4
        felter.add(new Feltvisning(8, 1, 16)); // Blaa startfelt
        felter.add(new Feltvisning(8, 2, 17));
        felter.add(new Feltvisning(8, 3, 18));
        felter.add(new Feltvisning(8, 4, 19));
        felter.add(new Feltvisning(8, 5, 20));
        felter.add(new Feltvisning(8, 6, 21));
        felter.add(new Feltvisning(9, 6, 22));
        felter.add(new Feltvisning(10, 6, 23));
        felter.add(new Feltvisning(11, 6, 24));
        felter.add(new Feltvisning(12, 6, 25));
        felter.add(new Feltvisning(13, 6, 26));
        felter.add(new Feltvisning(14, 6, 27));
        felter.add(new Feltvisning(14, 7, 28)); // Roed safefelt indgang
        felter.add(new Feltvisning(14, 8, 29));
        felter.add(new Feltvisning(13, 8, 30)); // Roed startfelt
        felter.add(new Feltvisning(12, 8, 31));
        felter.add(new Feltvisning(11, 8, 32));
        felter.add(new Feltvisning(10, 8, 33));
        felter.add(new Feltvisning(9, 8, 34));
        felter.add(new Feltvisning(8, 8, 35));
        felter.add(new Feltvisning(8, 9, 36));
        felter.add(new Feltvisning(8, 10, 37));
        felter.add(new Feltvisning(8, 11, 38));
        felter.add(new Feltvisning(8, 12, 39));
        felter.add(new Feltvisning(8, 13, 40));
        felter.add(new Feltvisning(8, 14, 41));
        felter.add(new Feltvisning(7, 14, 42)); // Gul safefelt indgang
        felter.add(new Feltvisning(6, 14, 43));
        felter.add(new Feltvisning(6, 13, 44)); // Gul startfelt
        felter.add(new Feltvisning(6, 12, 45));
        felter.add(new Feltvisning(6, 11, 46));
        felter.add(new Feltvisning(6, 10, 47));
        felter.add(new Feltvisning(6, 9, 48));
        felter.add(new Feltvisning(6, 8, 49));
        felter.add(new Feltvisning(5, 8, 50));
        felter.add(new Feltvisning(4, 8, 51));
        felter.add(new Feltvisning(3, 8, 52));
        felter.add(new Feltvisning(2, 8, 53));
        felter.add(new Feltvisning(1, 8, 54));
        felter.add(new Feltvisning(0, 8, 55));
        felter.add(new Feltvisning(0, 7, 56)); // Groen safefelt indgang
        felter.add(new Feltvisning(0, 6, 57));
        felter.add(new Feltvisning(1, 6, 58)); // Groen startfel
        felter.add(new Feltvisning(2, 6, 59));
        felter.add(new Feltvisning(3, 6, 60));
        felter.add(new Feltvisning(4, 6, 61));
        felter.add(new Feltvisning(5, 6, 62));
        felter.add(new Feltvisning(6, 6, 63));
        felter.add(new Feltvisning(6, 5, 64));
        felter.add(new Feltvisning(6, 4, 65));
        felter.add(new Feltvisning(6, 3, 66));
        felter.add(new Feltvisning(6, 2, 67));
        felter.add(new Feltvisning(6, 1, 68));
        felter.add(new Feltvisning(6, 0, 69));
        felter.add(new Feltvisning(7, 0, 70)); // Blaa safefelt indgang
        felter.add(new Feltvisning(8, 0, 71));// ende
        felter.add(new Feltvisning(7, 1, 72));// Blaa endefelt top
        felter.add(new Feltvisning(7, 2, 73));
        felter.add(new Feltvisning(7, 3, 74));
        felter.add(new Feltvisning(7, 4, 75));
        felter.add(new Feltvisning(7, 5, 76));
        felter.add(new Feltvisning(7, 6, 77)); // Blaa slut felt
        felter.add(new Feltvisning(13, 7, 78)); // roed endefelt top
        felter.add(new Feltvisning(12, 7, 79));
        felter.add(new Feltvisning(11, 7, 80));
        felter.add(new Feltvisning(10, 7, 81));
        felter.add(new Feltvisning(9, 7, 82));
        felter.add(new Feltvisning(8, 7, 83)); // roed endefelt
        felter.add(new Feltvisning(7, 13, 84)); // Gul endefelt top
        felter.add(new Feltvisning(7, 12, 85));
        felter.add(new Feltvisning(7, 11, 86));
        felter.add(new Feltvisning(7, 10, 87));
        felter.add(new Feltvisning(7, 9, 88));
        felter.add(new Feltvisning(7, 8, 89)); // Gul endefelt
        felter.add(new Feltvisning(1, 7, 90)); // Groen endefelt top
        felter.add(new Feltvisning(2, 7, 91));
        felter.add(new Feltvisning(3, 7, 92));
        felter.add(new Feltvisning(4, 7, 93));
        felter.add(new Feltvisning(5, 7, 94));
        felter.add(new Feltvisning(6, 7, 95)); // Groent endefelt
        felter.add(new Feltvisning(14, 0, 96)); // blaa buffer felt
        felter.add(new Feltvisning(14, 14, 97)); // roed buffer felt
        felter.add(new Feltvisning(0, 14, 98)); // gul buffer felt
        felter.add(new Feltvisning(0, 0, 99)); // Groent endefelt

        //Gør Blaa spiller klar.
        this.spillere.add(new Spiller("", "blue"));
        Spiller blue = this.spillere.get(0);
        for (int i = 0; i < 4; i++) {

            blue.addBrik(i, 16, 77, 96);

        }

        //Goer roed spiller klar
        this.spillere.add(new Spiller("", "red"));
        Spiller red = this.spillere.get(1);
        for (int i = 4; i < 8; i++) {

            red.addBrik(i, 30, 83, 97);

        }

        //Goer gul spiller klar
        this.spillere.add(new Spiller("", "yellow"));
        Spiller yellow = this.spillere.get(2);
        for (int i = 8; i < 12; i++) {

            yellow.addBrik(i, 44, 89, 98);

        }

        //Goer groen spiller klar
        this.spillere.add(new Spiller("", "green"));
        Spiller green = this.spillere.get(3);
        for (int i = 12; i < 16; i++) {

            green.addBrik(i, 58, 95, 99);

        }

        //sæt brikkerne på hjemfelterne.
        for (Spiller spiller : spillere) {
            var brikker = spiller.getBrikker();
            for (var brik : brikker) {
                brik.setFeltnr(brik.getHjemFeltnr());
            }
        }
        opdaterBraettet();

    }
    
    public int getAntalBrikkerPaaFelt(int feltnr){
        return braet.getFelt(feltnr).getSize();
    }
    
    public String getSpillerFarve(int index){
        return spillere.get(index).getFarve();
    }
    
    public String getSpillerName(int index){
        return spillere.get(index).getName();
    }

    public void setSpillerName(String name, int index) {
        spillere.get(index).setName(name);
    }

    public void spillerKaster(int spillerindex) {
        spillere.get(spillerindex).kast();

    }

    public int getSpillerSlag(int spillerindex) {
        return spillere.get(spillerindex).getSlag();
    }
    
    public int getfeltnr(int x, int y) {
        for (Feltvisning nr : felter) {
            if (nr.isthisfeltnr(x, y)) {
                return nr.getNR();
            }
        }
        return -1;
    }
    
    public boolean rykBrik(int spillerindex, int feltnr, int slag) {
        Brik brik = null;
        for (Brik brik1 : spillere.get(spillerindex).getBrikker()){
            if(brik1.getFeltnr() == feltnr){
                brik = brik1;
            }
        }
        if(brik == null){
            return false;
        }
        if(brik.getHjemFeltnr() == brik.getFeltnr()){
            rykUdAfHjem(slag, brik);
            return true;
        }
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
        
        opdaterBraettet();
        return true;
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
    
    public boolean måRyk (int feltnr){
        for (Brik brik : spillere.get(this.spillerstur).getBrikker()){
            if (brik.getFeltnr() == feltnr){
                return true;
            }
        }
        return false;
    }
    
    public int getSpillersTur(){
        return spillerstur;
        
    }

    public void opdaterBraettet() {

        for (Spiller spiller : spillere) {
            var brikker = spiller.getBrikker();
            for (var brik : brikker) {
                this.braet.getFelt(brik.getFeltnr()).landet(brik);
            }
        }

    }
    
    public void skiftTur(){
        spillerstur++;
        if(spillerstur >= spillere.size()){
            spillerstur = 0;
        }
        return;
    }
    
    public Brik getBrik(int spillerindex, int brikindex){
        return spillere.get(spillerindex).getBrik(brikindex);
    }

    public String getSlagString(int spillerindex){
        String s = "";
        s += spillere.get(spillerindex).getName();
        s += " har slået ";
        s += spillere.get(spillerindex).getSlag();
        return s;
    }
    
    public boolean checkWinner(int spillerindex) {
        int antalBrikker = 0;

        var spiller = spillere.get(spillerindex);
        for (Brik brik : spiller.getBrikker()) {
            if (brik.getFeltnr() == brik.getBufferfeltnr()) {
                antalBrikker++;
            }

        }
        if (antalBrikker >= 4) {
            return true;

        }
        return false;

    }
}
