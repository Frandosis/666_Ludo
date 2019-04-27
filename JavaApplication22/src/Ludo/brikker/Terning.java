/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.brikker;

/**
 *
 * @author s184805
 */
public class Terning {
    
    public int værdi;
    
    public Terning (){
        kast();
    }
    
    public int getVærdi(){
        return værdi;
    }
    
    public void setVærdi(int nyværdi){
        værdi = nyværdi;
    }
    
    public void kast(){
       double tilfældigværdi = Math.random() % 6;
       
       værdi = (int) (tilfældigværdi * 6 + 1);
    }
    
}
