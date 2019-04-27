/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.enheder;

import java.util.*;

/**
 *
 * @author s184805
 */
public class BenytRaflebaeger {

    public static void main(String[] arg) {

        Raflebaeger raflebaeger = new Raflebaeger(2);

        System.out.println("Startvaerdier: " + raflebaeger.getAlleVaerdier());
        int dup = 0;
        for (int i = 0; i < 5; i++) {
            raflebaeger.ryst();
            String s = raflebaeger.getAlleVaerdier();
            System.out.println("Efter ryst: " + s);

            String[] s1 = s.split(",");

            int[] value = new int[s1.length];

            if (raflebaeger.size() > 1) {
                for (int j = 0; j < s1.length; j++) {
                    value[j] = Integer.parseInt(s1[j]);
                }
                Arrays.sort(value);

                

                for (int k = 1; k < value.length; k++) {
                    if (value[k - 1] == value[k]) {
                        dup++;
                    }

                }

            }

        }
        System.out.println("Number of duplicates:" + dup);

    }

}
