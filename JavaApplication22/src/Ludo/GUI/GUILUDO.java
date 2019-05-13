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
    private boolean vundet = false;
    private boolean erKastet = false;
    private int H = 15; // Sætter højde
    private int L = 15; // Sætter længeden
    private int size = 5; // Str på kanten rundet om spillet og jpanlet
    private int sizeboard = 15; // bruges som str af board og Jbuttons/knapper
    private int feltsize = 42; // sætter felt str
    private JPanel gui = new JPanel(new BorderLayout(size, size)); //
    private JLabel terningvaerdi = new JLabel();
    private JLabel spillertur = new JLabel();
    private JButton kastTerning;
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
            spil.rykBrik(spil.getSpillersTur(), feltnr, spil.getSpillerSlag(spil.getSpillersTur()));
            
            spil.opdaterBraettet();
            
            opdaterGuiFraModel();
            
            vundet = spil.checkWinner(spil.getSpillersTur());
            if(vundet == true){
                String win = "Tillykke med sejren " + spil.getSpillerName(spil.getSpillersTur());
                
                JOptionPane.showMessageDialog(new JFrame(), win);
                
                System.exit(0);
                
            }
            
            spil.skiftTur();
            spillertur.setText("Det er nu " + spil.getSpillerName(spil.getSpillersTur()) + " tur.");
            
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
       /*
        tools.add(new JButton("Brik 1"));
        tools.add(new JButton("Brik 2"));
        tools.add(new JButton("Brik 3"));
        tools.add(new JButton("Brik 4"));
        tools.addSeparator(); // sætter en adskiller i baren
        */
        
       
       kastTerning = new JButton("Kast terning");
        
        kastTerning.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(erKastet == false){
                erKastet = true;
                spil.spillerKaster(spil.getSpillersTur());
                JOptionPane.showMessageDialog(new JFrame(), spil.getSlagString(spil.getSpillersTur()));
                terningvaerdi.setText(spil.getSpillerName(spil.getSpillersTur()) + " har slået: " + spil.getSpillerSlag(spil.getSpillersTur()));
                
                }
            }
        });
        tools.add(kastTerning);
        tools.add(new JButton("Genstart"));
        tools.addSeparator();
        //tools.add(new JLabel("LudoManSpillet")); // Sætter text til toppen af panelet
        tools.add(terningvaerdi);
        tools.addSeparator();
        tools.add(spillertur);
        
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
                        if(erKastet == true){
                        knapTrykketPaaKoordinat(x, y); // udprinter kordinaterne
                        
                        erKastet = false;
                        }
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
        JButton b1 = LudoBoardSquares[7] [7];
        b1.setEnabled(false);
        
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
        LudoBoard.spil.setSpillerName("blue", 0);
        LudoBoard.spil.setSpillerName("red", 1);
        LudoBoard.spil.setSpillerName("yellow", 2);
        LudoBoard.spil.setSpillerName("green", 3);
        
        

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
