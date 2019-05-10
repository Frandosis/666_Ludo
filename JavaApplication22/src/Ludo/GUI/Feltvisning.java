/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.GUI;

/**
 *
 * @author j
 */
class Feltvisning {

    private int x;
    private int y;
    private int nr;

    Feltvisning(int i, int j, int p) {
        x = i;
        y = j;
        nr = p;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNR() {
        return nr;
    }

    public boolean isthisfeltnr(int x, int y) {
        boolean lol = false;
        if (this.x == x & this.y == y) {
            lol = true;
        }
        return lol;
    }
}
