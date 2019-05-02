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
    
    /*
    * kamp mellem brikker
    * returner om angriberen vandt kampen.
    */
    public boolean kamp(int antalForsvar, Brik forsvarer, Brik angriber){
        if(antalForsvar == 1){
            if(forsvarer.getHelle() == true && angriber.getHelle() == false){
                return false;
            }
            if(forsvarer.getHelle() == false && angriber.getHelle() == true){
                return true;
            }
            if(forsvarer.getHelle() == false && angriber.getHelle() == false){
                return true;
            }
        }
        
        if(antalForsvar > 1){
            
            if(angriber.getHelle() == true){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
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
    
    public int rykModEndefelt(){
        int afstand;
        int ryk;
        int nyfeltnr;
        afstand = Brik.getEndefeltnr + Brik.getFeltnr;
        
        if(Brik.getSlag>afstand){
            ryk=afstand - Brik.getSlag;
          return nyfeltnr = Brik.getEndefeltnr + ryk;
        }
        if(Brik.getSlag < afstand){
            return nyfeltnr = Brik.getFeltnr + Brik.getSlag;
        }
        return 0;
        
    }
}
