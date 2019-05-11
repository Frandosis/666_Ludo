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
    
    public static void main(String [] arg){
        Braet1 braet1 = new Braet1();
       Graph braet = braet1.getGraph();
       Brik groen = new Brik("green", 12, 58, 95, 99);
       
       braet.getFelt(groen.getHjemFeltnr()).landet(groen);
       braet.getFelt(groen.getHjemFeltnr()).forlader(groen);
        
        
    }
    
}
