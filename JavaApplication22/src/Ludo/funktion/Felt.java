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
public interface Felt {
    
    public int getSize();
    
    public int getFeltnr();
    
    public String getFarve();
    
    public void landet(Brik brikInd);
    
    public void forlader(Brik brikUd);
    
}
