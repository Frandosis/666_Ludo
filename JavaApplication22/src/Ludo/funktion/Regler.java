/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.funktion;
import Ludo.enheder.*;
/**
 *
 * @author s184805
 */
public class Regler {
    
    public void kamp(boolean helle, int antalForsvar, Brik forsvarer, Brik angriber){
        if(helle == true){
            angriber.setFeltnr(angriber.getHjemFeltnr());
        }
        
        if (antalForsvar > 1){
            
        }
    }
    
    public boolean forladerHjem(int slag, Hjemfelt hjemfelt){
        if(hjemfelt.getIndeholderBrik() == true){
            if(slag == 6){
                hjemfelt.setIndeholderBrik(false);
               return true;
            }
            else return false;
        }
        return false;
    }
}
