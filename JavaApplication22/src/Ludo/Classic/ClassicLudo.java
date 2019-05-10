/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.Classic;
import Ludo.enheder.*;
import Ludo.funktion.*;
import java.util.*;

/**
 *
 * @author Valdemar Landberg
 */
public class ClassicLudo {
    ArrayList<Spiller> spillere;
    ArrayList<Felt> braet;
    Regler regler;
    
    public ClassicLudo (){
        this.spillere = new ArrayList();
        
        this.braet = new ArrayList();
        
        this.regler = new Regler();
        
        
    }
    
    public void setUpGame(){
        
        //Først lav braettet
        Braet tmp = new Braet();
        
        this.braet = tmp.getBraet();
        
        //Gør Blaa spiller klar.
        this.spillere.add(new Spiller("", "blue"));
        Spiller blue = this.spillere.get(0);
        for(int i = 0; i < 4; i++){
        
            blue.addBrik(i, 16, 77, 96);
        
        }
        
        //Goer roed spiller klar
        this.spillere.add(new Spiller("", "red"));
        Spiller red = this.spillere.get(1);
        for(int i = 4; i < 8; i++){
        
            red.addBrik(i, 30, 83, 97);
        
        }
        
        //Goer gul spiller klar
        this.spillere.add(new Spiller("", "yellow"));
        Spiller yellow = this.spillere.get(2);
        for(int i = 8; i < 12; i++){
        
            yellow.addBrik(i, 44, 89, 98);
        
        }
        
        //Goer groen spiller klar
        
        this.spillere.add(new Spiller("", "green"));
        Spiller green = this.spillere.get(3);
        for(int i = 12; i < 16; i++){
        
            green.addBrik(i, 58, 95, 99);
        
        }
        
        //sæt brikkerne på hjemfelterne.
        
        for(Spiller spiller: spillere){
            var brikker = spiller.getBrikker();
            for(var brik : brikker){
                brik.setFeltnr(brik.getHjemFeltnr());
            }
        }
        
    }
    
    
    
    public void spillerKaster(int index){
        spillere.get(index).kast();
        
        
    }
    
    public int getSpillerSlag(int index){
        return spillere.get(index).getSlag();
    }
    
    //problemer det er ikke sikkert den fjerner den rigtige brik når den forlader det gamle felt.
    public void rykBrik (int spillerindex , int brikindex, int slag){
        var brik = spillere.get(spillerindex).getBrik(brikindex);
        int gammelfelt = brik.getFeltnr();
        int nyfelt = gammelfelt + slag;
        braet.get(gammelfelt).forlader();
        
        
        brik.setFeltnr(nyfelt);
        
        braet.get(nyfelt).landet(brik);
        
        
    }
    
    public void opdaterBraettet(){
        
        for(Spiller spiller: spillere){
            var brikker = spiller.getBrikker();
            for(var brik : brikker){
                this.braet.get(brik.getFeltnr()).landet(brik);
            }
        }
        
    }
}
