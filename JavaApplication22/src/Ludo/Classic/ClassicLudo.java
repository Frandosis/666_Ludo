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
    
    public void rykBrik(int spillerindex, int brikindex, int slag) {
        Brik brik = spillere.get(spillerindex).getBrik(brikindex);
        int feltnr = brik.getFeltnr();
        boolean gåTilbage = false;
        this.braet.getFelt(feltnr).forlader(brik);
        List<Vertex> list = null;
        
        if(brik.getHjemFeltnr() == brik.getFeltnr()){
            rykUdAfHjem(slag, brik);
            return;
        }
        
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
