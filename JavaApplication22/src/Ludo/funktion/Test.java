/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.funktion;
import Ludo.enheder.*;
import java.util.*;
/**
 *
 * @author Valdemar Landberg
 */
public class Test {
    
    ArrayList<Brik> brikker = new ArrayList<Brik>();
    ArrayList<Felt> felter = new ArrayList();
    
    public static void main(String [] arg){
        try{
        Test main = new Test();
        
        Braet braet = new Braet();
        boolean checktest;
       main.brikker.add(new Brik("green", 0, 1, 3, 4));
       main.brikker.add(new Brik ("red", 5, 6, 7,8));
       main.brikker.add(new Brik("green", 9, 10, 3, 4));
        
        
        main.felter.add(new Hjemfelt("green", 0));
        main.felter.add(new Startfelt("green", 1));
        main.felter.add(new Endefelt("green",2));
        main.felter.add(new Endefelt("green",3));
        main.felter.add(new Bufferfelt("green",4));
        main.felter.add(new Hjemfelt("red", 5));
        main.felter.add(new Startfelt("red", 6));
        main.felter.add(new Endefelt("red", 7));
        main.felter.add(new Bufferfelt("red", 8));
        for(int i = 11; i < 15; i++){
        main.felter.add(new Banefelt(i));
        }
        
        
        //Felt tmp = main.felter.get(main.brikker.get(0).getHjemFeltnr());
        //Felt tmp2 = main.felter.get(main.brikker.get(2).getEndefeltnr());
        //Felt tmp1 = main.felter.get(main.brikker.get(1).getHjemFeltnr());
        
        main.brikker.get(0).setFeltnr(main.brikker.get(0).getHjemFeltnr());
        main.brikker.get(1).setFeltnr(main.brikker.get(1).getHjemFeltnr());
        main.brikker.get(2).setFeltnr(main.brikker.get(2).getHjemFeltnr());
        
        //System.out.println("brik green 1 cf= " + main.brikker.get(0).getFeltnr()+ "hf= "+ main.brikker.get(0).getHjemFeltnr());
        //System.out.println("brik green 2 cf= " + main.brikker.get(2).getFeltnr()+ "hf= "+ main.brikker.get(2).getHjemFeltnr());
        //System.out.println("brik red 1 cf= " + main.brikker.get(1).getFeltnr()+ "hf= "+ main.brikker.get(1).getHjemFeltnr());
        
        /*
        main.brikker.get(0).setFeltnr(main.brikker.get(0).getHjemFeltnr());
        tmp.landet(main.brikker.get(0));
        */
        
        main.testBufferfelt();
        main.testStartfelt();
        //main.opdaterBraettet();
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
    public void opdaterBraettet(){
        for(Brik brik : this.brikker ){
            this.felter.get(brik.getFeltnr()).landet(brik);
        }
        
    }
    
    public void testBufferfelt(){
        System.out.println("\n-----Test af Ende- og Bufferfelt----\n");
       // Felt tmp = felter.get(brikker.get(0).getEndefeltnr());
       // Felt tmp2 = felter.get(brikker.get(2).getEndefeltnr());
        
        //test af endefelt til bufferfelt med flere brikker i buffer felt.
        brikker.get(0).setFeltnr(3);
        brikker.get(2).setFeltnr(3);
        //tmp.landet(brikker.get(0));
        //tmp2.landet(brikker.get(2));
        opdaterBraettet();
        
            System.out.println("Efter landet green brik 1: cf= " + brikker.get(0).getFeltnr()+ " ef= "+ brikker.get(0).getEndefeltnr() + " bf= "+ brikker.get(0).getBufferfeltnr());
            
            System.out.println("Efter landet green brik 2: cf= " + brikker.get(2).getFeltnr()+ " ef= "+ brikker.get(2).getEndefeltnr()+ " bf= "+ brikker.get(0).getBufferfeltnr());
            
            System.out.println("brik 1= " + brikker.get(0).getFeltnr()+ " brik 2= "+ brikker.get(2).getFeltnr());
           
        
        
    }
    
    public void testStartfelt(){
        System.out.println("\n-----Test af Startfelt----\n");
        //Felt tmp = felter.get(brikker.get(0).getHjemFeltnr());
        //Felt tmp1 = felter.get(brikker.get(1).getHjemFeltnr());
        //Felt tmp2 = felter.get(brikker.get(2).getEndefeltnr());
        
        brikker.get(0).setFeltnr(brikker.get(0).getStartFeltnr());
        System.out.println("Efter landet green brik 1: cf= " + brikker.get(0).getFeltnr()+ " sf= "+ brikker.get(0).getStartFeltnr()+ " hf= "+ brikker.get(0).getHjemFeltnr());
        brikker.get(0).setFeltnr(brikker.get(0).getHjemFeltnr());
        brikker.get(1).setFeltnr(brikker.get(0).getStartFeltnr());
        System.out.println("Efter landet green brik 1: cf= " + brikker.get(1).getFeltnr()+ " sf= "+ brikker.get(1).getStartFeltnr()+ " hf= "+ brikker.get(1).getHjemFeltnr());
    }
}




 /* ved ikke hvad det skulle bruges til.
        main.brikker.get(1).setFeltnr(main.brikker.get(1).getHjemFeltnr());
        tmp1.landet(main.brikker.get(1));
        
        //main.felter.get(main.brikker.get(1).getFeltnr()).forlader();
        main.brikker.get(1).setFeltnr(3);
        main.felter.get(main.brikker.get(1).getFeltnr()).landet(main.brikker.get(1));
        
        //main.felter.get(main.brikker.get(0).getFeltnr()).forlader();
        main.brikker.get(0).setFeltnr(2);
        main.felter.get(main.brikker.get(0).getFeltnr()).landet(main.brikker.get(0));
        
       // main.felter.get(main.brikker.get(0).getFeltnr()).forlader();
        main.brikker.get(0).setFeltnr(3);
        main.felter.get(main.brikker.get(0).getFeltnr()).landet(main.brikker.get(0));
        */