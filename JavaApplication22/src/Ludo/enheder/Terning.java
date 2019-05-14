
package Ludo.enheder;


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
