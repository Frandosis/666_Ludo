package Ludo.GUI;

import Ludo.funktion.*;
import Ludo.Classic.ClassicLudo;
import Ludo.GUI.LudoSpilModel;
import Ludo.enheder.Brik;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

public class GUILUDO {

    private int H = 15; // Sætter højde
    private int L = 15; // Sætter længeden
    private int size = 5; // Str på kanten rundet om spillet og jpanlet
    private int sizeboard = 15; // bruges som str af board og Jbuttons/knapper
    private int feltsize = 42; // sætter felt str
    private JPanel gui = new JPanel(new BorderLayout(size, size)); //
    private JButton[][] LudoBoardSquares = new JButton[sizeboard][sizeboard]; // sætte en matrix af jbuttons op i 15x15
    private JPanel LudoBoard;
    //private JLabel message = new JLabel("LudoManSpillet"); // Sætter text til toppen af panelet

    ClassicLudo spil = new ClassicLudo(4); // Opsætter spil til at lagere brikker og felter i
    // opsætter brikker
    private ImageIcon ingenBrik, redBrik, greenBrik, yellowBrik, blueBrik;

    GUILUDO() {
        initializeGui();

        spil.setUpGame();

        /*
        spil.spillere.brikker = new ArrayList<Brik>();
        Brik b = new Brik("roed", 4, 10, 14, 0);
        spil.brikker.add(b);
        spil.brikker.add(new Brik("roed", 5, 10, 14, 0));
        spil.brikker.add(new Brik("roed", 6, 10, 14, 0));
        spil.brikker.add(new Brik("roed", 7, 10, 14, 0));
=======
        model.brikker = new ArrayList<Brik>(); // laver en arraylist af Brik under model.brikker
        //Brik b = new Brik("roed", 4, 10, 14, 0); // laver
        // tilføjer de forskellige brikker
        model.brikker.add(new Brik("roed", 4, 10, 14, 0));
        model.brikker.add(new Brik("roed", 5, 10, 14, 0));
        model.brikker.add(new Brik("roed", 6, 10, 14, 0));
        model.brikker.add(new Brik("roed", 7, 10, 14, 0));
>>>>>>> origin/master

        spil.brikker.add(new Brik("blaa", 0, 10, 14, 0));
        spil.brikker.add(new Brik("blaa", 1, 10, 14, 0));
        spil.brikker.add(new Brik("blaa", 2, 10, 14, 0));
        spil.brikker.add(new Brik("blaa", 3, 10, 14, 0));

        spil.brikker.add(new Brik("gul", 8, 10, 14, 0));
        spil.brikker.add(new Brik("gul", 9, 10, 14, 0));
        spil.brikker.add(new Brik("gul", 10, 10, 14, 0));
        spil.brikker.add(new Brik("gul", 11, 10, 14, 0));

        spil.brikker.add(new Brik("groen", 12, 10, 14, 0));
        spil.brikker.add(new Brik("groen", 13, 10, 14, 0));
        spil.brikker.add(new Brik("groen", 14, 10, 14, 0));
        spil.brikker.add(new Brik("groen", 15, 10, 14, 0));

        for (Brik plads : spil.brikker) {
            plads.setFeltnr(plads.getHjemFeltnr());
        }
         */
        spil.felter = new ArrayList<Feltvisning>();
        spil.felter.add(new Feltvisning(11, 2, 0)); // Blaa Start 1
        spil.felter.add(new Feltvisning(12, 2, 1)); // Blaa Start 2
        spil.felter.add(new Feltvisning(11, 3, 2)); // Blaa Start 3
        spil.felter.add(new Feltvisning(12, 3, 3)); // Blaa Start 4
        spil.felter.add(new Feltvisning(11, 11, 4)); // Roed Start 1
        spil.felter.add(new Feltvisning(12, 11, 5)); // Roed Start 2
        spil.felter.add(new Feltvisning(11, 12, 6)); // Roed Start 3
        spil.felter.add(new Feltvisning(12, 12, 7)); // Roed Start 4
        spil.felter.add(new Feltvisning(2, 11, 8));  // Gul Start 1
        spil.felter.add(new Feltvisning(3, 11, 9)); // Gul start 2
        spil.felter.add(new Feltvisning(2, 12, 10)); // Gul start 3
        spil.felter.add(new Feltvisning(3, 12, 11)); // Gul start 4
        spil.felter.add(new Feltvisning(2, 2, 12)); // Groen start 1
        spil.felter.add(new Feltvisning(3, 2, 13)); // Groen start 2
        spil.felter.add(new Feltvisning(2, 3, 14)); // Groen start 3
        spil.felter.add(new Feltvisning(3, 3, 15)); // Groen start 4
        spil.felter.add(new Feltvisning(8, 1, 16)); // Blaa startfelt
        spil.felter.add(new Feltvisning(8, 2, 17));
        spil.felter.add(new Feltvisning(8, 3, 18));
        spil.felter.add(new Feltvisning(8, 4, 19));
        spil.felter.add(new Feltvisning(8, 5, 20));
        spil.felter.add(new Feltvisning(8, 6, 21));
        spil.felter.add(new Feltvisning(9, 6, 22));
        spil.felter.add(new Feltvisning(10, 6, 23));
        spil.felter.add(new Feltvisning(11, 6, 24));
        spil.felter.add(new Feltvisning(12, 6, 25));
        spil.felter.add(new Feltvisning(13, 6, 26));
        spil.felter.add(new Feltvisning(14, 6, 27));
        spil.felter.add(new Feltvisning(14, 7, 28)); // Roed safefelt indgang
        spil.felter.add(new Feltvisning(14, 8, 29));
        spil.felter.add(new Feltvisning(13, 8, 30)); // Roed startfelt
        spil.felter.add(new Feltvisning(12, 8, 31));
        spil.felter.add(new Feltvisning(11, 8, 32));
        spil.felter.add(new Feltvisning(10, 8, 33));
        spil.felter.add(new Feltvisning(9, 8, 34));
        spil.felter.add(new Feltvisning(8, 8, 35));
        spil.felter.add(new Feltvisning(8, 9, 36));
        spil.felter.add(new Feltvisning(8, 10, 37));
        spil.felter.add(new Feltvisning(8, 11, 38));
        spil.felter.add(new Feltvisning(8, 12, 39));
        spil.felter.add(new Feltvisning(8, 13, 40));
        spil.felter.add(new Feltvisning(8, 14, 41));
        spil.felter.add(new Feltvisning(7, 14, 42)); // Gul safefelt indgang
        spil.felter.add(new Feltvisning(6, 14, 43));
        spil.felter.add(new Feltvisning(6, 13, 44)); // Gul startfelt
        spil.felter.add(new Feltvisning(6, 12, 45));
        spil.felter.add(new Feltvisning(6, 11, 46));
        spil.felter.add(new Feltvisning(6, 10, 47));
        spil.felter.add(new Feltvisning(6, 9, 48));
        spil.felter.add(new Feltvisning(6, 8, 49));
        spil.felter.add(new Feltvisning(5, 8, 50));
        spil.felter.add(new Feltvisning(4, 8, 51));
        spil.felter.add(new Feltvisning(3, 8, 52));
        spil.felter.add(new Feltvisning(2, 8, 53));
        spil.felter.add(new Feltvisning(1, 8, 54));
        spil.felter.add(new Feltvisning(0, 8, 55));
        spil.felter.add(new Feltvisning(0, 7, 56)); // Groen safefelt indgang
        spil.felter.add(new Feltvisning(0, 6, 57));
        spil.felter.add(new Feltvisning(1, 6, 58)); // Groen startfel
        spil.felter.add(new Feltvisning(2, 6, 59));
        spil.felter.add(new Feltvisning(3, 6, 60));
        spil.felter.add(new Feltvisning(4, 6, 61));
        spil.felter.add(new Feltvisning(5, 6, 62));
        spil.felter.add(new Feltvisning(6, 6, 63));
        spil.felter.add(new Feltvisning(6, 5, 64));
        spil.felter.add(new Feltvisning(6, 4, 65));
        spil.felter.add(new Feltvisning(6, 3, 66));
        spil.felter.add(new Feltvisning(6, 2, 67));
        spil.felter.add(new Feltvisning(6, 1, 68));
        spil.felter.add(new Feltvisning(6, 0, 69));
        spil.felter.add(new Feltvisning(7, 0, 70)); // Blaa safefelt indgang
        spil.felter.add(new Feltvisning(8, 0, 71));// ende
        spil.felter.add(new Feltvisning(7, 1, 72));// Blaa endefelt top
        spil.felter.add(new Feltvisning(7, 2, 73));
        spil.felter.add(new Feltvisning(7, 3, 74));
        spil.felter.add(new Feltvisning(7, 4, 75));
        spil.felter.add(new Feltvisning(7, 5, 76));
        spil.felter.add(new Feltvisning(7, 6, 77)); // Blaa slut felt
        spil.felter.add(new Feltvisning(13, 7, 78)); // roed endefelt top
        spil.felter.add(new Feltvisning(12, 7, 79));
        spil.felter.add(new Feltvisning(11, 7, 80));
        spil.felter.add(new Feltvisning(10, 7, 81));
        spil.felter.add(new Feltvisning(9, 7, 82));
        spil.felter.add(new Feltvisning(8, 7, 83)); // roed endefelt
        spil.felter.add(new Feltvisning(7, 13, 84)); // Gul endefelt top
        spil.felter.add(new Feltvisning(7, 12, 85));
        spil.felter.add(new Feltvisning(7, 11, 86));
        spil.felter.add(new Feltvisning(7, 10, 87));
        spil.felter.add(new Feltvisning(7, 9, 88));
        spil.felter.add(new Feltvisning(7, 8, 89)); // Gul endefelt
        spil.felter.add(new Feltvisning(1, 7, 90)); // Groen endefelt top
        spil.felter.add(new Feltvisning(2, 7, 91));
        spil.felter.add(new Feltvisning(3, 7, 92));
        spil.felter.add(new Feltvisning(4, 7, 93));
        spil.felter.add(new Feltvisning(5, 7, 94));
        spil.felter.add(new Feltvisning(6, 7, 95)); // Groent endefelt
        spil.felter.add(new Feltvisning(14, 0, 96)); // blaa buffer felt
        spil.felter.add(new Feltvisning(14, 14, 97)); // roed buffer felt
        spil.felter.add(new Feltvisning(0, 14, 98)); // gul buffer felt
        spil.felter.add(new Feltvisning(0, 0, 99)); // Groent endefelt
        opdaterGuiFraModel();
    }

    private void opdaterGuiFraModel() {
        for (Feltvisning fv : spil.felter) {
            JButton b = LudoBoardSquares[fv.getX()][fv.getY()];
            b.setIcon(ingenBrik);
            b.setText(""); // clear text

        }

        for (Spiller spiller : spil.spillere) {
            for (Brik brik : spiller.getBrikker()) {
                int fn = brik.getFeltnr();
                Feltvisning fv = spil.felter.get(fn);
                JButton b = LudoBoardSquares[fv.getX()][fv.getY()];
                b.setText("" + spil.getAntalBrikkerPaaFelt(fn)); // need for number of brikker
                if (brik.getFarve().equals("red")) {
                    b.setIcon(redBrik);
                } else if (brik.getFarve().equals("green")) {
                    b.setIcon(greenBrik);
                } else if (brik.getFarve().equals("yellow")) {
                    b.setIcon(yellowBrik);
                } else if (brik.getFarve().equals("blue")) {
                    b.setIcon(blueBrik);
                }
            }
        }
    }

    // Print koordinater on click
    private void knapTrykketPaaKoordinat(int x, int y) {

        int feltnr = spil.getfeltnr(x, y);
        if (feltnr != -1) {
            System.out.println("Der blev trykket paa feltnummer " + feltnr);
        } else {
            System.out.println("Der er trykket på " + x + " og " + y);
        }
    }

    public final void initializeGui() {
        ingenBrik = new ImageIcon(new BufferedImage(feltsize, feltsize, BufferedImage.TYPE_INT_ARGB)); // laver en tomfelt type til at clear felter
        // Sætter png filer til de tilsavrende brikker
        redBrik = new ImageIcon("ludobrikRed.png");
        blueBrik = new ImageIcon("ludobrikBlue.png");
        yellowBrik = new ImageIcon("ludobrikYellow.png");
        greenBrik = new ImageIcon("ludobrikGreen.png");
        gui.setBorder(new EmptyBorder(size, size, size, size)); // set kanterne omkring brættet
        JToolBar tools = new JToolBar(); // laver et felt for oven til evt. knapper
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        // opretter knapper til mulig brug senere
        tools.add(new JButton("Brik 1"));
        tools.add(new JButton("Brik 2"));
        tools.add(new JButton("Brik 3"));
        tools.add(new JButton("Brik 4"));
        tools.addSeparator(); // sætter en adskiller i baren
        tools.add(new JButton("Kast terning"));
        tools.add(new JButton("Genstart"));
        tools.addSeparator();
        tools.add(new JLabel("LudoManSpillet")); // Sætter text til toppen af panelet

        //  gui.add(new JLabel("?"), BorderLayout.LINE_START);
        LudoBoard = new JPanel(new GridLayout(0, 15)); // sætter længden på gridet/matrix
        LudoBoard.setBorder(new LineBorder(Color.BLACK)); // sætter kanten til sort
        gui.add(LudoBoard); // tilføjer disse ting til gui'en

        // create the Ludo board squares
        //Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int i = 0; i < LudoBoardSquares.length; i++) { // for loop x2 der køre alle felter igennem
            for (int j = 0; j < LudoBoardSquares[i].length; j++) {
                JButton b = new JButton(); // Opretter knapper
                b.setMargin(new Insets(0, 0, 0, 0));
                b.setIcon(ingenBrik); // fjerner alle evt. ting der skulle vær epå dem
                b.setEnabled(false); // slå knap funktionen fra
                LudoBoardSquares[j][i] = b; // loader den ind
                final int x = j; // opretter værdier til at brug under
                final int y = i;
                b.addActionListener(new ActionListener() { // actionlisterner til knapperne i b
                    @Override // overskriver den orginale funktion
                    public void actionPerformed(ActionEvent e) {
                        knapTrykketPaaKoordinat(x, y); // udprinter kordinaterne
                    }
                });
                // b.addActionListener( (e) -> knapTrykketPaaKoordinat(x, y) ); // gøre samme som koden ovenfor kan evt. slettes
            }
        }

        // Std Felter
        for (int i = L / 2 - 1; i < L / 2 + 2; i++) {
            for (int j = 0; j < H; j++) {
                JButton b = LudoBoardSquares[i][j];
                b.setBackground(Color.BLACK);
                b.setEnabled(true);
                b = LudoBoardSquares[j][i];
                b.setBackground(Color.BLACK);
                b.setEnabled(true);
            }
        }

        // Opsaetter safefelter
        for (int i = 1; i < 7; i++) {//blue
            JButton b = LudoBoardSquares[H / 2][i];
            b.setBackground(Color.BLUE);
            b.setEnabled(true);
        }
        for (int i = H - 2; i > H - 8; i--) {//yellow
            JButton b = LudoBoardSquares[H / 2][i];
            b.setBackground(Color.YELLOW);
            b.setEnabled(true);
        }
        for (int i = 1; i < 7; i++) {//green
            JButton b = LudoBoardSquares[i][L / 2];
            b.setBackground(Color.GREEN);
            b.setEnabled(true);
        }
        for (int i = H - 2; i > L - 8; i--) {//red
            JButton b = LudoBoardSquares[i][L / 2];
            b.setBackground(Color.RED);
            b.setEnabled(true);
        }
        //Color startfelter
        colorStart(8, 1, 1);
        colorStart(13, 8, 2);
        colorStart(6, 13, 3);
        colorStart(1, 6, 4);

        //Color the 4 bases
        colorBase(11, 2, 1);
        colorBase(11, 11, 2);
        colorBase(2, 11, 3);
        colorBase(2, 2, 4);

        // fill the board out with all the stuff we made
        for (int i = 0; i < sizeboard; i++) {
            for (int j = 0; j < sizeboard; j++) {
                LudoBoard.add(LudoBoardSquares[j][i]);
            }
        }

    }

    /*
    public final JComponent getLudoBoard() {
        return LudoBoard;
    }*/
    public final JComponent getGui() {
        return gui;
    }

    public static void main(String[] args) throws InterruptedException {
        GUILUDO LudoBoard = new GUILUDO();
        boolean start = true;
        Runnable r = new Runnable() {

            @Override
            public void run() {

                JFrame f = new JFrame("LudoGame");
                f.add(LudoBoard.getGui());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // ensures the minimum size is enforced.
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);

        while (start == true) {

            for (int i = 0; i < LudoBoard.spil.felter.size() - 1; i++) {
                Thread.sleep(500);
                LudoBoard.spil.getBrik(0, 0).setFeltnr(i);
                LudoBoard.spil.getBrik(1, 0).setFeltnr(i + 2);
                LudoBoard.spil.getBrik(2, 0).setFeltnr(i + 4);
                LudoBoard.spil.getBrik(3, 0).setFeltnr(i + 6);
                LudoBoard.opdaterGuiFraModel();
                if (i == LudoBoard.spil.felter.size() - 1) {
                    i = -1;
                }
            }

        }

    }

    private void colorBase(int x, int y, int color) {
        for (int i = 0; i < 4; i++) {
            if (i == 2) {
                y++;
                x--;
            } else if (i == 1 || i == 3) {
                x++;
            }
            JButton b = LudoBoardSquares[x][y];
            switch (color) {
                case 1:
                    b.setBackground(Color.BLUE);
                    break;
                case 2:
                    b.setBackground(Color.RED);
                    break;
                case 3:
                    b.setBackground(Color.YELLOW);
                    break;
                case 4:
                    b.setBackground(Color.GREEN);
                    break;
                default:
                    b.setBackground(Color.black);
            }
            b.setEnabled(true);
        }

    }

    private void colorStart(int x, int y, int color) {

        JButton b = LudoBoardSquares[x][y];
        switch (color) {
            case 1:
                b.setBackground(Color.BLUE);
                break;
            case 2:
                b.setBackground(Color.RED);
                break;
            case 3:
                b.setBackground(Color.YELLOW);
                break;
            case 4:
                b.setBackground(Color.GREEN);
                break;
            default:
                b.setBackground(Color.black);
        }
        b.setEnabled(true);
    }
}
