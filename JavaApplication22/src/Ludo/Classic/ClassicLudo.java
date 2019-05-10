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
    int spillerstur;
    
    public ClassicLudo (){
        this.spillere = new ArrayList();
        
        this.braet = new ArrayList();
        
        this.regler = new Regler();
        
        this.spillerstur= 0;
        
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
    
    public void setSpillerName(String name, int index){
        spillere.get(index).setName(name);
    }
    
    
    
    
    public void spillerKaster(int spillerindex){
        spillere.get(spillerindex).kast();
        
        
    }
    
    public int getSpillerSlag(int spillerindex){
        return spillere.get(spillerindex).getSlag();
    }

    
    public void rykBrik (int spillerindex , int brikindex, int slag){
        var brik = spillere.get(spillerindex).getBrik(brikindex);
        int gammelfelt = brik.getFeltnr();
        int nyfelt = gammelfelt + slag;
        braet.get(gammelfelt).forlader(brik);
        
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
    public boolean checkWinner(int spillerindex){
        int antalBrikker = 0;
        
        var spiller = spillere.get(spillerindex);
        for (Brik brik: spiller.getBrikker()){
            if(brik.getFeltnr()== brik.getBufferfeltnr()){
                antalBrikker++;
            }
            
        }
        if(antalBrikker >= 4){
            return true;
            
        }
        return false;
        
    }
}
