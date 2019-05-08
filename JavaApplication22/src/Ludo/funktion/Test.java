/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.funktion;
import Ludo.enheder.*;
import java.util.*;
/**
 *
 * @author Valdemar Landberg
 */
public class Test {
    
    public static void main(String [] arg){
        
        Brik groen = new Brik("green", 0, 2, 5, 7);
        Brik roed = new Brik ("red", 1, 3, 5, 6);
        
        
        ArrayList<Felt> felter = new ArrayList();
        felter.add(new Hjemfelt("green", 0));
        felter.add(new Hjemfelt("red", 1));
        felter.add(new Startfelt("green", 2));
        felter.add(new Startfelt("red", 3));
        for(int i = 4; i < 8; i++){
        felter.add(new Banefelt(i));
        }
        
        var tmp = felter.get(groen.getHjemFeltnr());
        groen.setFeltnr(groen.getHjemFeltnr());
        tmp.landet(groen);
        
        var tmp1 = felter.get(roed.getHjemFeltnr());
        roed.setFeltnr(roed.getHjemFeltnr());
        tmp1.landet(roed);
        
        felter.get(roed.getFeltnr()).forlader();
        roed.setFeltnr(3);
        felter.get(roed.getFeltnr()).landet(roed);
        
        felter.get(groen.getFeltnr()).forlader();
        groen.setFeltnr(2);
        felter.get(groen.getFeltnr()).landet(groen);
        
        felter.get(groen.getFeltnr()).forlader();
        groen.setFeltnr(3);
        felter.get(groen.getFeltnr()).landet(groen);
        
        
        
        
    }
    
}
