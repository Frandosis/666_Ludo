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
       main.brikker.add(new Brik("green", 9, 1, 3, 4));
       main.brikker.add(new Brik("yellow", 16, 17, 18, 19));
        
        
        main.felter.add(new Hjemfelt("green", 0));
        main.felter.add(new Startfelt("green", 1));
        main.felter.add(new Endefelt("green",2));
        main.felter.add(new Endefelt("green",3));
        main.felter.add(new Bufferfelt("green",4));
        main.felter.add(new Hjemfelt("red", 5));
        main.felter.add(new Startfelt("red", 6));
        main.felter.add(new Endefelt("red", 7));
        main.felter.add(new Bufferfelt("red", 8));
        for(int i = 10; i <= 15; i++){
        main.felter.add(new Banefelt(i));
        }
        main.felter.add(new Hjemfelt("yellow", 16));
        main.felter.add(new Startfelt("yellow", 17));
        main.felter.add(new Endefelt("yellow",18));
        main.felter.add(new Bufferfelt("yellow",19));
        
        
        //Felt tmp = main.felter.get(main.brikker.get(0).getHjemFeltnr());
        //Felt tmp2 = main.felter.get(main.brikker.get(2).getEndefeltnr());
        //Felt tmp1 = main.felter.get(main.brikker.get(1).getHjemFeltnr());
        // 0 og 2 er groen og 1 er roed og 3 er gul
        main.brikker.get(0).setFeltnr(main.brikker.get(0).getHjemFeltnr());
        main.brikker.get(1).setFeltnr(main.brikker.get(1).getHjemFeltnr());
        main.brikker.get(2).setFeltnr(main.brikker.get(2).getHjemFeltnr());
        main.brikker.get(3).setFeltnr(main.brikker.get(2).getHjemFeltnr());
        //System.out.println("brik green 1 cf= " + main.brikker.get(0).getFeltnr()+ "hf= "+ main.brikker.get(0).getHjemFeltnr());
        //System.out.println("brik green 2 cf= " + main.brikker.get(2).getFeltnr()+ "hf= "+ main.brikker.get(2).getHjemFeltnr());
        //System.out.println("brik red 1 cf= " + main.brikker.get(1).getFeltnr()+ "hf= "+ main.brikker.get(1).getHjemFeltnr());
        
        /*
        main.brikker.get(0).setFeltnr(main.brikker.get(0).getHjemFeltnr());
        tmp.landet(main.brikker.get(0));
        */
        System.out.println("\ncf= currentfelt, hf = hjemfelt, buf = bufferfelt, ef = endefelt, sf = startfelt, baf = banefelt");
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
        System.out.println("-----Test af Ende- og Bufferfelt----");
        //Felt tmp = felter.get(brikker.get(0).getFeltnr());
        //Felt tmp2 = felter.get(brikker.get(2).getFeltnr());
        //test af endefelt til bufferfelt med flere brikker i buffer felt.
        brikker.get(0).setFeltnr(3);
        System.out.println("test om der kan veare mere end en brik på buffer \nbrik 1: cf= " + brikker.get(0).getFeltnr()+ " ef= "+ brikker.get(0).getEndefeltnr() + " bf= "+ brikker.get(0).getBufferfeltnr());
        opdaterBraettet();
        
        brikker.get(2).setFeltnr(3);
        System.out.println("brik 2: cf= " + brikker.get(2).getFeltnr()+ " ef= "+ brikker.get(2).getEndefeltnr()+ " bf= "+ brikker.get(0).getBufferfeltnr());
        opdaterBraettet();
        
        System.out.println("brik 1= " + brikker.get(0).getFeltnr()+ " brik 2= "+ brikker.get(2).getFeltnr());
        
        brikker.get(0).setFeltnr(brikker.get(0).getHjemFeltnr());
        brikker.get(2).setFeltnr(brikker.get(2).getHjemFeltnr());
    }
    
    public void testStartfelt(){
        System.out.println("\n-----Test af Startfelt----");
        Felt tmp = felter.get(brikker.get(0).getFeltnr());
        Felt tmp1 = felter.get(brikker.get(1).getFeltnr());
        Felt tmp2 = felter.get(brikker.get(2).getFeltnr());
        Felt tmp3 = felter.get(brikker.get(3).getFeltnr());
        
        brikker.get(0).setFeltnr(brikker.get(0).getStartFeltnr());
        
        // Here I get the felt where the brik so i can remove it form the felt so it doesn't clone the brik.
        tmp = felter.get(brikker.get(0).getFeltnr());
        opdaterBraettet();
        System.out.println("Test om groen brik kan lande på groen start felt: \ngroen brik: cf= " + brikker.get(0).getFeltnr()+ " sf= "+ brikker.get(0).getStartFeltnr()+ " hf= "+ brikker.get(0).getHjemFeltnr());
        
        brikker.get(0).setFeltnr(brikker.get(0).getHjemFeltnr());
        // Here I remove the cloned brik
        tmp.forlader(brikker.get(0));
        opdaterBraettet();
        
        brikker.get(1).setFeltnr(1);
        opdaterBraettet();
        System.out.println("Test om reod brik kan lande på groen start felt: \nroed brik 1: cf= " + brikker.get(1).getFeltnr()+ " sf= "+ brikker.get(1).getStartFeltnr()+ " hf= "+ brikker.get(1).getHjemFeltnr());
        tmp1 = felter.get(brikker.get(1).getFeltnr());
        
        brikker.get(1).setFeltnr(brikker.get(1).getHjemFeltnr());
        tmp1.forlader(brikker.get(1));
        opdaterBraettet();

        brikker.get(0).setFeltnr(brikker.get(0).getStartFeltnr());
        brikker.get(2).setFeltnr(brikker.get(2).getStartFeltnr());
        System.out.println("Test om groen brik kan lande på groen start felt med en groen brik paa: \ngroen brik 0: cf= " + brikker.get(0).getFeltnr()+ " sf= "+ brikker.get(0).getStartFeltnr()+ " hf= "+ brikker.get(0).getHjemFeltnr() + "\ngroen brik 2: cf= " + brikker.get(2).getFeltnr()+ " sf= "+ brikker.get(2).getStartFeltnr()+ " hf= "+ brikker.get(2).getHjemFeltnr());
        
        brikker.get(2).setFeltnr(brikker.get(2).getHjemFeltnr());
        tmp2.forlader(brikker.get(2));
        
        tmp1 = felter.get(brikker.get(0).getStartFeltnr());
        brikker.get(1).setFeltnr(brikker.get(0).getStartFeltnr());
        System.out.println("Test om roed brik kan lande på groen start felt med en groen brik paa: \ngroen brik 0: cf= " + brikker.get(0).getFeltnr()+ " sf= "+ brikker.get(0).getStartFeltnr()+ " hf= "+ brikker.get(0).getHjemFeltnr() + "\nroed brik 1: cf= " + brikker.get(2).getFeltnr()+ " sf= "+ brikker.get(2).getStartFeltnr()+ " hf= "+ brikker.get(2).getHjemFeltnr());
        tmp1.forlader(brikker.get(1));

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