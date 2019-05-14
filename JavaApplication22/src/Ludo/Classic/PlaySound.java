package Ludo.Classic;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlaySound implements Runnable {

    public String filename;

    public void setFilename(String file) {
        filename = file;
    }

    @Override
    public void run() {
        Clip clip = null;

        try {
            File sound = new File(System.getProperty("user.dir"));
            URI uri = new URI(sound.toURI() + filename);
            URL soundURL = uri.toURL();
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (LineUnavailableException lue) {
            lue.printStackTrace();
        } catch (UnsupportedAudioFileException uafe) {
            uafe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (URISyntaxException use) {
            use.printStackTrace();
        }

        clip.start();

    }

}
