/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.Classic;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Valdemar Landberg
 */
public class PlaySound implements Runnable {

    
    @Override
    public void run() {
        Mixer mixer = null;
        Clip clip = null;
    
        /*
        Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
        /*
        for(Mixer.Info info : mixInfos){
            System.out.println(info.getName() + "---" + info.getDescription());
        }
        
        
        mixer = AudioSystem.getMixer(mixInfos[3]);
        
        DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
        try { clip = (Clip) mixer.getLine(dataInfo); }
        catch (LineUnavailableException lue){ lue.printStackTrace(); }
        */
        try{
            File sound = new File(System.getProperty("user.dir"));
            URI uri = new URI(sound.toURI()+"/DiceShake.wav");
            URL soundURL = uri.toURL();
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        }
        catch(LineUnavailableException lue){ lue.printStackTrace();}
        catch(UnsupportedAudioFileException uafe){ uafe.printStackTrace();}
        catch(IOException ioe){ioe.printStackTrace();}
        catch(URISyntaxException use){use.printStackTrace(); }
        
        clip.start();
        /*
        do{
            try{ Thread.sleep(50);}
            catch (InterruptedException ie){ ie.printStackTrace();}
        } while(clip.isActive());
        */
    
    }
    
    
}
