/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.funktion;

import Ludo.enheder.Brik;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Valdemar Landberg
 */
public class StartfeltTest {
    
    public StartfeltTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of landet method, of class Startfelt.
     */
    @Test
    public void testLandet() {
        System.out.println("landet");
        Brik brikInd = new Brik ("green", 0);
        Felt instance = new Startfelt ("green", 40);
        instance.landet(brikInd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of forlader method, of class Startfelt.
     */
    @Test
    public void testForlader() {
        System.out.println("forlader");
        Brik brikUd = null;
        Startfelt instance = null;
        instance.forlader();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rykEfterKamp method, of class Startfelt.
     */
    @Test
    public void testRykEfterKamp() {
        System.out.println("rykEfterKamp");
        Brik brikInd = null;
        Startfelt instance = null;
        instance.rykEfterKamp(brikInd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
