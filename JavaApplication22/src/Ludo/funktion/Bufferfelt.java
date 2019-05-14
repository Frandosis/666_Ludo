
package Ludo.funktion;

import Ludo.enheder.*;
import java.util.ArrayList;


public class Bufferfelt implements Felt {

    int forladeraktion;
    int antalbuffer;
    final String farve;
    final int feltnr;
    ArrayList<Brik> brikker;
    boolean win = false;

    public Bufferfelt(String spFarve, int spFeltnr) {
        this.feltnr = spFeltnr;
        this.farve = spFarve;
        this.brikker = new ArrayList();
        this.forladeraktion = 0;

    }

    /*
    public Boolean checkWin() {
        
        
        if(brikker.size() == 4){
            win = true;
           return win;
        }
        else{
        win = false;
        }
        return win;
    }
     */
    @Override
    public int getSize(){
        return brikker.size();
    }
    @Override
    public String getFarve() {
        return this.farve;
    }

    @Override
    public int getFeltnr() {
        return this.feltnr;
    }

    @Override
    public void landet(Brik brikInd) {
        if (brikker.contains(brikInd)) {
            return;
        }

        brikker.add(brikInd);

    }

    @Override
    public void forlader(Brik brikUd) {
        forladeraktion++;
    }
}
