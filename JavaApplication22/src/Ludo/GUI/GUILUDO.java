package Ludo.GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jeppe
 */
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

    private final int H = 15;
    private final int L = 15;
    private final int size = 5;
    private final int sizeboard = 15;
    private final int feltsize = 42;
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] LudoBoardSquares = new JButton[15][15];
    private JPanel LudoBoard;
    private final JLabel message = new JLabel(
            "LudoManSpillet");

    LudoSpilModel model = new LudoSpilModel();
    private ImageIcon ingenBrik;
    private ImageIcon lillaBrik;

    GUILUDO() {
        initializeGui();
        model.brikker = new ArrayList<Brik>();
        Brik b = new Brik("rød", 4, 10, 14);
        model.brikker.add(b);/*
        model.brikker.add(new Brik("rød", 6, 10, 14));
        model.brikker.add(new Brik("rød", 7, 10, 14));
        model.brikker.add(new Brik("rød", 10, 10, 14));*/

        //model.brikker.get(0).setFeltnr(2);
        // model.brikker.get(1).setFeltnr(4);
        // model.brikker.get(2).setFeltnr(5);
        // model.brikker.get(3).setFeltnr(7);
        model.felter = new ArrayList<Feltvisning>();
        model.felter.add(new Feltvisning(8, 1)); // Blå startfelt
        model.felter.add(new Feltvisning(8, 2));
        model.felter.add(new Feltvisning(8, 3));
        model.felter.add(new Feltvisning(8, 4));
        model.felter.add(new Feltvisning(8, 5));
        model.felter.add(new Feltvisning(8, 6));
        model.felter.add(new Feltvisning(9, 6));
        model.felter.add(new Feltvisning(10, 6));
        model.felter.add(new Feltvisning(11, 6));
        model.felter.add(new Feltvisning(12, 6));
        model.felter.add(new Feltvisning(13, 6));
        model.felter.add(new Feltvisning(14, 6));
        model.felter.add(new Feltvisning(14, 7)); // Rød safefelt indgang
        model.felter.add(new Feltvisning(14, 8));
        model.felter.add(new Feltvisning(13, 8)); // Rød startfelt
        model.felter.add(new Feltvisning(12, 8));
        model.felter.add(new Feltvisning(11, 8));
        model.felter.add(new Feltvisning(10, 8));
        model.felter.add(new Feltvisning(9, 8));
        model.felter.add(new Feltvisning(8, 8));
        model.felter.add(new Feltvisning(8, 9));
        model.felter.add(new Feltvisning(8, 10));
        model.felter.add(new Feltvisning(8, 11));
        model.felter.add(new Feltvisning(8, 12));
        model.felter.add(new Feltvisning(8, 13));
        model.felter.add(new Feltvisning(8, 14));
        model.felter.add(new Feltvisning(7, 14)); // Gul safefelt indgang
        model.felter.add(new Feltvisning(6, 14));
        model.felter.add(new Feltvisning(6, 13)); // Gul startfelt
        model.felter.add(new Feltvisning(6, 12));
        model.felter.add(new Feltvisning(6, 11));
        model.felter.add(new Feltvisning(6, 10));
        model.felter.add(new Feltvisning(6, 9));
        model.felter.add(new Feltvisning(6, 8));
        model.felter.add(new Feltvisning(5, 8));
        model.felter.add(new Feltvisning(4, 8));
        model.felter.add(new Feltvisning(3, 8));
        model.felter.add(new Feltvisning(2, 8));
        model.felter.add(new Feltvisning(1, 8));
        model.felter.add(new Feltvisning(0, 8));
        model.felter.add(new Feltvisning(0, 7)); // Grøn safefelt indgang
        model.felter.add(new Feltvisning(0, 6));
        model.felter.add(new Feltvisning(1, 6)); // Grøn startfel
        model.felter.add(new Feltvisning(2, 6));
        model.felter.add(new Feltvisning(3, 6));
        model.felter.add(new Feltvisning(4, 6));
        model.felter.add(new Feltvisning(5, 6));
        model.felter.add(new Feltvisning(6, 6));
        model.felter.add(new Feltvisning(6, 5));
        model.felter.add(new Feltvisning(6, 4));
        model.felter.add(new Feltvisning(6, 3));
        model.felter.add(new Feltvisning(6, 2));
        model.felter.add(new Feltvisning(6, 1));
        model.felter.add(new Feltvisning(6, 0));
        model.felter.add(new Feltvisning(7, 0)); // Blå safefelt indgang
        model.felter.add(new Feltvisning(8, 0));// ende
        model.felter.add(new Feltvisning(7, 1));// Blå endefelt top
        model.felter.add(new Feltvisning(7, 2));
        model.felter.add(new Feltvisning(7, 3));
        model.felter.add(new Feltvisning(7, 4));
        model.felter.add(new Feltvisning(7, 5));
        model.felter.add(new Feltvisning(7, 6)); // Blå slut felt
        model.felter.add(new Feltvisning(1, 7)); // Grønt endefelt top
        model.felter.add(new Feltvisning(2, 7));
        model.felter.add(new Feltvisning(3, 7));
        model.felter.add(new Feltvisning(4, 7));
        model.felter.add(new Feltvisning(5, 7));
        model.felter.add(new Feltvisning(6, 7)); // Grønt endefelt
        model.felter.add(new Feltvisning(7, 13)); // Gul endefelt top
        model.felter.add(new Feltvisning(7, 12));
        model.felter.add(new Feltvisning(7, 11));
        model.felter.add(new Feltvisning(7, 10));
        model.felter.add(new Feltvisning(7, 9));
        model.felter.add(new Feltvisning(7, 8)); // Gul endefelt
        model.felter.add(new Feltvisning(13, 7)); // Rød endefelt top
        model.felter.add(new Feltvisning(12, 7));
        model.felter.add(new Feltvisning(11, 7));
        model.felter.add(new Feltvisning(10, 7));
        model.felter.add(new Feltvisning(9, 7));
        model.felter.add(new Feltvisning(8, 7)); // Grønt endefelt
        model.felter.add(new Feltvisning(11, 2)); // Blå Start 1
        model.felter.add(new Feltvisning(12, 2)); // Blå Start 2
        model.felter.add(new Feltvisning(11, 3)); // Blå Start 3
        model.felter.add(new Feltvisning(12, 3)); // Blå Start 4
        model.felter.add(new Feltvisning(11, 11)); // Rød Start 1
        model.felter.add(new Feltvisning(12, 11)); // Rød Start 2
        model.felter.add(new Feltvisning(11, 12)); // Rød Start 3
        model.felter.add(new Feltvisning(12, 12)); // Rød Start 4
        model.felter.add(new Feltvisning(2, 11));  // Gul Start 1
        model.felter.add(new Feltvisning(3, 11)); // Gul start 2
        model.felter.add(new Feltvisning(2, 12)); // Gul start 3
        model.felter.add(new Feltvisning(3, 12)); // Gul start 4
        model.felter.add(new Feltvisning(2, 2)); // Grøn start 1
        model.felter.add(new Feltvisning(3, 2)); // Grøn start 2
        model.felter.add(new Feltvisning(2, 3)); // Grøn start 3
        model.felter.add(new Feltvisning(3, 3)); // Grøn start 4
        opdaterGuiFraModel();
    }

    //
    private void opdaterGuiFraModel() {
        for (Feltvisning fv : model.felter) {
            JButton b = LudoBoardSquares[fv.x][fv.y];
            b.setText("t");
            b.setIcon(ingenBrik);
        }

        for (Brik brik : model.brikker) {
            int fn = brik.getFeltnr();
            Feltvisning fv = model.felter.get(fn);

            JButton b = LudoBoardSquares[fv.x][fv.y];
            b.setText("b");
            b.setIcon(lillaBrik);
        }

    }

    // Print koordinater on click
    private void knapTrykketPåKoordinat(int x, int y) {
        System.out.println("Der blev trykket på " + x + " , " + y);
    }

    public final void initializeGui() {
        ingenBrik = new ImageIcon(
                new BufferedImage(feltsize, feltsize, BufferedImage.TYPE_INT_ARGB));//BufferedImage.TYPE_INT_ARGB
        lillaBrik = new ImageIcon("ludobrik.png");//BufferedImage.TYPE_INT_ARGB

        // set up the main GUI
        gui.setBorder(new EmptyBorder(size, size, size, size));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(new JButton("Brik 1"));
        tools.add(new JButton("Brik 2"));
        tools.add(new JButton("Brik 3"));
        tools.add(new JButton("Brik 4"));
        tools.addSeparator();
        tools.add(new JButton("Kast terning"));
        tools.add(new JButton("Genstart"));
        tools.addSeparator();
        tools.add(message);

        //  gui.add(new JLabel("?"), BorderLayout.LINE_START);
        LudoBoard = new JPanel(new GridLayout(0, 15));
        LudoBoard.setBorder(new LineBorder(Color.BLACK));
        gui.add(LudoBoard);

        // create the Ludo board squares
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int ii = 0; ii < LudoBoardSquares.length; ii++) {
            for (int jj = 0; jj < LudoBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so  we'll
                // 'fill this in' using a transparent icon..
                b.setIcon(ingenBrik);
                LudoBoardSquares[jj][ii] = b;
                final int x = jj;
                final int y = ii;
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        knapTrykketPåKoordinat(x, y);
                    }
                });
                // b.addActionListener( (e) -> knapTrykketPåKoordinat(x, y) );
            }
        }

        // Std Felter
        for (int i = L / 2 - 1; i < L / 2 + 2; i++) {
            for (int j = 0; j < H; j++) {
                JButton b = LudoBoardSquares[i][j];
                b.setBackground(Color.BLACK);
            }
        }
        for (int i = H / 2 - 1; i < H / 2 + 2; i++) {
            for (int j = 0; j < L; j++) {
                JButton b = LudoBoardSquares[j][i];
                b.setBackground(Color.BLACK);
            }
        }

        // Opsætter safefelter
        for (int i = 1; i < 7; i++) {//blue
            JButton b = LudoBoardSquares[H / 2][i];
            b.setBackground(Color.BLUE);
        }
        for (int i = H - 2; i > H - 8; i--) {//yellow
            JButton b = LudoBoardSquares[H / 2][i];
            b.setBackground(Color.YELLOW);
        }
        for (int i = 1; i < 7; i++) {//green
            JButton b = LudoBoardSquares[i][L / 2];
            b.setBackground(Color.GREEN);
        }
        for (int i = H - 2; i > L - 8; i--) {//red
            JButton b = LudoBoardSquares[i][L / 2];
            b.setBackground(Color.RED);

        }
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                JButton b = LudoBoardSquares[L / 2 - 1][13];
                b.setBackground(Color.YELLOW);
            }
            if (i == 1) {
                JButton b = LudoBoardSquares[L / 2 + 1][1];
                b.setBackground(Color.BLUE);
            }
            if (i == 2) {
                JButton b = LudoBoardSquares[13][8];
                b.setBackground(Color.RED);
            }
            if (i == 3) {
                JButton b = LudoBoardSquares[1][6];
                b.setBackground(Color.GREEN);
            }
        }

        // fill the board out with all the stuff we made 
        for (int ii = 0; ii < sizeboard; ii++) {
            for (int jj = 0; jj < sizeboard; jj++) {
                LudoBoard.add(LudoBoardSquares[jj][ii]);

            }
        }

    }

    public final JComponent getLudoBoard() {
        return LudoBoard;
    }

    public final JComponent getGui() {
        return gui;
    }

    public static void main(String[] args) throws InterruptedException {
        GUILUDO LudoBoard = new GUILUDO();

        Runnable r = new Runnable() {

            @Override
            public void run() {

                JFrame f = new JFrame("LudoChamp");
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
        // while (){
        for (int i = 0; i < 100; i++) {
            Thread.sleep(500);
            LudoBoard.model.brikker.get(0).setFeltnr(i);
            LudoBoard.opdaterGuiFraModel();
            if (i == LudoBoard.model.felter.size() - 1) {
                i = -1;
                // }
            }
        }

    }
}
