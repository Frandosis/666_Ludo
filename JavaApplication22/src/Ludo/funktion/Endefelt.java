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
public class Endefelt implements Felt {
        String farve;
        int feltnr;
        int antalBrikker;
        int tmp;
        String out;
 
    public void moveToBuffer(){
    
        
        
    }
        
        
    public String checkWin() {
        tmp = Buffer.getAntalBuffer;
        
        if(tmp== 4){
            out = ("win");
           return out;
        }
        else{
        out = ("continue");
        }
        return out;
    }
}
