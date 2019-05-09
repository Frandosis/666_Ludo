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
        
        Braet braet1 = new Braet();
        this.braet = braet1.getBraet();
        
        this.regler = new Regler();
        
        
    }
    
    
    
    
}
