package Ludo.GUI;

public class Feltvisning {

    private int x;
    private int y;
    private int nr;

    public Feltvisning(int i, int j, int p) {
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
        if (this.x == x && this.y == y) {
            return true;
        }
        return false;
    }
}
