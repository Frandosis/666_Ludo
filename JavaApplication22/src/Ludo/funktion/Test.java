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
        
       main.brikker.add(new Brik("green", 0, 2, 4, 6));
       main.brikker.add(new Brik ("red", 1, 3, 5, 7));
        
        
        
        main.felter.add(new Hjemfelt("green", 0));
        main.felter.add(new Hjemfelt("red", 1));
        main.felter.add(new Startfelt("green", 2));
        main.felter.add(new Startfelt("red", 3));
        for(int i = 4; i < 8; i++){
        main.felter.add(new Banefelt(i));
        }
        main.felter.add(new Endefelt("green",8));
        //main.felter.add(new Endefelt("green",9));
        //main.felter.add(new Endefelt("red",10));
        main.felter.add(new Bufferfelt("green",11));
        //main.felter.add(new Bufferfelt("red",12));
        
        
        var tmp = main.felter.get(main.brikker.get(0).getHjemFeltnr());
        System.out.println("cf= " + main.brikker.get(0).getFeltnr()+ "hf= "+ main.brikker.get(0).getHjemFeltnr());
        main.brikker.get(0).setFeltnr(main.brikker.get(0).getHjemFeltnr());
        tmp.landet(main.brikker.get(0));
        
        var tmp1 = main.felter.get(main.brikker.get(1).getHjemFeltnr());
        main.brikker.get(1).setFeltnr(main.brikker.get(1).getHjemFeltnr());
        tmp1.landet(main.brikker.get(1));
        
        main.felter.get(main.brikker.get(1).getFeltnr()).forlader();
        main.brikker.get(1).setFeltnr(3);
        main.felter.get(main.brikker.get(1).getFeltnr()).landet(main.brikker.get(1));
        
        main.felter.get(main.brikker.get(0).getFeltnr()).forlader();
        main.brikker.get(0).setFeltnr(2);
        main.felter.get(main.brikker.get(0).getFeltnr()).landet(main.brikker.get(0));
        
        main.felter.get(main.brikker.get(0).getFeltnr()).forlader();
        main.brikker.get(0).setFeltnr(3);
        main.felter.get(main.brikker.get(0).getFeltnr()).landet(main.brikker.get(0));
        
        var tmp2 = main.felter.get(main.brikker.get(0).getEndefeltnr());
        main.brikker.get(0).setFeltnr(main.brikker.get(0).getEndefeltnr());
        tmp.landet(main.brikker.get(0));
        
        System.out.println("cf= " + main.brikker.get(0).getFeltnr()+ " ef= "+ main.brikker.get(0).getEndefeltnr() + " bf= "+ main.brikker.get(0).getBufferfeltnr());
        
        main.opdaterBraettet();
        
        System.out.println("cf= " + main.brikker.get(0).getFeltnr()+ " hf= "+ main.brikker.get(0).getEndefeltnr());
        System.out.println("hej");
        
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
    
}
