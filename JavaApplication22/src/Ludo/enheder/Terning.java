/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.enheder;

/**
 *
 * @author s184805
 */
public class Terning {
    
    public int vaerdi;
    
    public Terning (){
        kast();
    }
    
    public int getVaerdi(){
        return vaerdi;
    }
    
    public void setVaerdi(int nyvaerdi){
        vaerdi = nyvaerdi;
    }
    
    public void kast(){
       double tilfaeldigvaerdi = Math.random() % 6;
       
       vaerdi = (int) (tilfaeldigvaerdi * 6 + 1);
    }
    
}
