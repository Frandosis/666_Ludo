
package Ludo.funktion;

import java.util.ArrayList;


public class Braet {

    ArrayList<Felt> braet;

    public Braet() {
        this.braet = new ArrayList();
        int i = 0;
        //indsaet blaa hjemfelter
        while (i < 4) {
            braet.add(new Hjemfelt("blue", i));
            i++;
        }
        int tmp = i;
        //indsaet roede hjemfelter
        while (tmp < i + 4) {
            braet.add(new Hjemfelt("red", tmp));
            tmp++;
        }
        i = tmp;
        
        //indsaet gule hjemfelter
        while (tmp < i + 4) {
            braet.add(new Hjemfelt("yellow", tmp));
            tmp++;
        }
        
        i = tmp;
        //indsæt groenne hjemfelter
        while (tmp < i + 4) {
            braet.add(new Hjemfelt("green", tmp));
            tmp++;
        }
        i = tmp;
        System.out.println("Size after hjemfelt: "+braet.size());
     
        //skal taelle hvert op til
        int counter = 0;
        //tilføj banefelter og startfelter
        while (tmp < i + 56) {
            
            if(counter == 0){
                braet.add(new Startfelt("blue", tmp));
            }
            else if(counter == 14){
                braet.add(new Startfelt("red", tmp));
            }
            else if(counter == 28){
                braet.add(new Startfelt("yellow", tmp));
            }
            else if(counter == 42){
                braet.add(new Startfelt("green", tmp));
            }
            
            else{
                    braet.add(new Banefelt(tmp));
                    }
            tmp++;
            counter++;
        }
        i = tmp;
        counter = 0;
        System.out.println("Size after Bane and Start: " +  braet.size());
        
        //indsaet Endefelter
        while (tmp < i + 6){
            braet.add(new Endefelt("blue", tmp));
            tmp++;
        }
        
        i = tmp;
        
        while (tmp < i + 6){
            braet.add(new Endefelt("red", tmp));
            tmp++;
        }
        
        i = tmp;
        
        while (tmp < i + 6){
            braet.add(new Endefelt("yellow", tmp));
            tmp++;
        }
        
        i = tmp;
        
        while (tmp < i + 6){
            braet.add(new Endefelt("green", tmp));
            tmp++;
        }
        i = tmp;
        
        System.out.println("Size after Endefelt: " + braet.size());
        
        //Tilfoej bufferfelter
        
        braet.add(new Bufferfelt("blue", i));
        i++;
        braet.add(new Bufferfelt("red", i));
        i++;
        braet.add(new Bufferfelt("yellow", i));
        i++;
        braet.add(new Bufferfelt("green", i));
        
        System.out.println("Size after Bufferfelt: "+ braet.size());
         
    }
    
    public ArrayList<Felt> getBraet(){
        return this.braet;
    } 
}
