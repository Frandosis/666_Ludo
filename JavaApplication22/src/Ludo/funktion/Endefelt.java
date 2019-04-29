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
        boolean out = false;
 
    public void moveToBuffer(){
    
        
        
    }
        
        
    public Boolean checkWin() {
        tmp = Buffer.getAntalBuffer;
        
        if(tmp== 4){
            out = true;
           return out;
        }
        else{
        out = false;
        }
        return out;
    }
}
