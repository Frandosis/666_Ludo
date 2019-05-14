
package Ludo.funktion;
import Ludo.enheder.*;

public interface Felt {
    
    public int getSize();
    
    public int getFeltnr();
    
    public String getFarve();
    
    public void landet(Brik brikInd);
    
    public void forlader(Brik brikUd);
    
}
