package Data;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundFx {

    private Clip cSoundtrack;
    private AudioInputStream cSoundtrackStream;

    public void soundtrack() {
        System.out.println("soundtrack");
        try {
            this.cSoundtrack.open(this.cSoundtrackStream);
            this.cSoundtrack.loop(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SoundFx() {
        try {
            File soundtrackFile = new File("audio" + File.separator + "soundtrack.wav");
            this.cSoundtrackStream = AudioSystem.getAudioInputStream(soundtrackFile);
            this.cSoundtrack = AudioSystem.getClip();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
