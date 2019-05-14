
package Ludo.funktion;

import Ludo.enheder.*;


public class Regler {

    /*
    * kamp mellem brikker
    * returner om angriberen vandt kampen.
     */
    public boolean kamp(int antalForsvar, Brik forsvarer, Brik angriber) {
        if (antalForsvar == 1) {
            if (forsvarer.getHelle() == true && angriber.getHelle() == false) {
                return false;
            }
            if (forsvarer.getHelle() == false && angriber.getHelle() == true) {
                return true;
            }
            if (forsvarer.getHelle() == false && angriber.getHelle() == false) {
                return true;
            }
        }

        if (antalForsvar > 1) {

            if (angriber.getHelle() == true) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean forladerHjem(Brik brikInd, int slag) {
        if (brikInd.getHelle() == true) {
            if (slag == 6) {
                return true;
            }

        }
        return false;
    }
}
