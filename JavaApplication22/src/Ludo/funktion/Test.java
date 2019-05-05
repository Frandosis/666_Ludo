/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.funktion;

import java.util.*;
/**
 *
 * @author Valdemar Landberg
 */
public class Test {
    
    public static void main(String [] arg){
        
        LinkedList list = new LinkedList<>();
        
        for (int i = 0; i < 10; i++){
            list.add(i);
            System.out.println(list.get(i));
        }
        
        list.poll();
        System.out.println(list);
        list.set(7, 10);
        System.out.println(list);
        
        
    }
    
}
