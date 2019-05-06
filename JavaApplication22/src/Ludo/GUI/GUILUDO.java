/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeppe
 */
import java.awt.*;
import java.awt.image.BufferedImage;
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

    GUILUDO() {
        initializeGui();
    }

    public final void initializeGui() {
        // set up the main GUI
        gui.setBorder(new EmptyBorder(size, size, size, size));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(new JButton("Brik 1")); // TODO - add functionality!
        tools.add(new JButton("Brik 2")); // TODO - add functionality!
        tools.add(new JButton("Brik 3")); // TODO - add functionality!
        tools.add(new JButton("Brik 4"));
        tools.addSeparator();
        tools.add(new JButton("Kast terning"));
        tools.add(new JButton("Genstart")); // TODO - add functionality!
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
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(feltsize, feltsize, BufferedImage.TYPE_INT_ARGB));//BufferedImage.TYPE_INT_ARGB
                b.setIcon(icon);
                LudoBoardSquares[jj][ii] = b;
            }
        }

        // Std Felter
        for (int i = L / 2 - 1; i < L / 2 + 2; i++) {
            for (int j = 0; j < H; j++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(feltsize, feltsize, BufferedImage.TYPE_INT_ARGB));//BufferedImage.TYPE_INT_ARGB
                b.setIcon(icon);
                b.setBackground(Color.BLACK);
                LudoBoardSquares[i][j] = b;
            }
        }
        for (int i = H / 2 - 1; i < H / 2 + 2; i++) {
            for (int j = 0; j < L; j++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(feltsize, feltsize, BufferedImage.TYPE_INT_ARGB));//BufferedImage.TYPE_INT_ARGB
                b.setIcon(icon);
                b.setBackground(Color.BLACK);
                LudoBoardSquares[j][i] = b;
            }
        }

        // Opsætter safefelter
        for (int i = 1; i < 7; i++) {//blue
            JButton b = new JButton();
            b.setMargin(buttonMargin);
            ImageIcon icon = new ImageIcon(
                    new BufferedImage(feltsize, feltsize, BufferedImage.TYPE_INT_ARGB));//BufferedImage.TYPE_INT_ARGB
            b.setIcon(icon);
            b.setBackground(Color.BLUE);
            LudoBoardSquares[H / 2][i] = b;
        }
        for (int i = H - 2; i > H - 8; i--) {//yellow
            JButton b = new JButton();
            b.setMargin(buttonMargin);
            ImageIcon icon = new ImageIcon(
                    new BufferedImage(feltsize, feltsize, BufferedImage.TYPE_INT_ARGB));//BufferedImage.TYPE_INT_ARGB
            b.setIcon(icon);
            b.setBackground(Color.YELLOW);
            LudoBoardSquares[H / 2][i] = b;
        }
        for (int i = 1; i < 7; i++) {//blue
            JButton b = new JButton();
            b.setMargin(buttonMargin);
            ImageIcon icon = new ImageIcon(
                    new BufferedImage(feltsize, feltsize, BufferedImage.TYPE_INT_ARGB));//BufferedImage.TYPE_INT_ARGB
            b.setIcon(icon);
            b.setBackground(Color.GREEN);
            LudoBoardSquares[i][L / 2] = b;
        }
        for (int i = H - 2; i > L - 8; i--) {//yellow
            JButton b = new JButton();
            b.setMargin(buttonMargin);
            ImageIcon icon = new ImageIcon(
                    new BufferedImage(feltsize, feltsize, BufferedImage.TYPE_INT_ARGB));//BufferedImage.TYPE_INT_ARGB
            b.setIcon(icon);
            b.setBackground(Color.RED);
            LudoBoardSquares[i][L / 2] = b;
        }
        for (int i = 0; i < 4; i++) {
            JButton b = new JButton();
            b.setMargin(buttonMargin);
            ImageIcon icon = new ImageIcon(
                    new BufferedImage(feltsize, feltsize, BufferedImage.TYPE_INT_ARGB));//BufferedImage.TYPE_INT_ARGB
            b.setIcon(icon);
            if (i == 0) {
                b.setBackground(Color.YELLOW);
                LudoBoardSquares[L / 2 - 1][13] = b;
                /*  for (int j = 0; i < 2; j++) { // test for 2x2 til brikker
                    for (int k = 0; k < 2; k++) {
                        LudoBoardSquares[3 + j][12 + k] = b;
                    }
                }*/
            }
            if (i == 1) {
                b.setBackground(Color.BLUE);
                LudoBoardSquares[L / 2 + 1][1] = b;
            }
            if (i == 2) {
                b.setBackground(Color.RED);
                LudoBoardSquares[13][8] = b;
            }
            if (i == 3) {
                b.setBackground(Color.GREEN);
                LudoBoardSquares[1][6] = b;
            }
        }

        // fill the black non-pawn piece row
        for (int ii = 0; ii < sizeboard; ii++) {
            for (int jj = 0; jj < sizeboard; jj++) {
                switch (jj) {
                    // case 0:
                    //   chessBoard.add(new JLabel("" + (ii + 1),
                    //         SwingConstants.CENTER));
                    default:
                        LudoBoard.add(LudoBoardSquares[jj][ii]);
                }
            }
        }

    }

    public final JComponent getLudoBoard() {
        return LudoBoard;
    }

    public final JComponent getGui() {
        return gui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                GUILUDO cb
                        = new GUILUDO();

                JFrame f = new JFrame("ChessChamp");
                f.add(cb.getGui());
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
    }
}
