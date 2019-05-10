package Ludo.GUI;

import Ludo.enheder.Brik;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author j
 */
public class LudoSpilModel {

    public ArrayList<Brik> brikker;
    public ArrayList<Feltvisning> felter;

    public int getfeltnr(int x, int y) {
        for (Feltvisning nr : felter) {
            if (nr.isthisfeltnr(x, y)) {
                return nr.getNR();
            }
        }
        return -1;
    }
}
