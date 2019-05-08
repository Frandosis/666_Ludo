/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.funktion;
import java.util.ArrayList;
/**
 *
 * @author Valdemar Landberg
 */
public class Braet {
    ArrayList<Felt> braet;
    
    public Braet (){
        this.braet = new ArrayList();
        int i = 0;
        //indsaet groenne hjemfelter
        while (i < 4){
            braet.add(new Hjemfelt("green", i));
            i++;
        }
        
        //indsaet roede hjemfelter
        while (i < i+4){
            braet.add(new Hjemfelt("red", i));
            i++;
        }
        
        //indsaet blaa hjemfelter
        while (i < i+4){
            braet.add(new Hjemfelt("red", i));
            i++;
        }
        
    }
    
}
