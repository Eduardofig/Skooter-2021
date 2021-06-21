package Data;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundFx {

    private Clip cSoundtrack;
    private Clip cColecionavelSound;
    private Clip cDestroiBlocoSound;
    private Clip cMorteSound;
    private AudioInputStream cSoundtrackStream;
    private AudioInputStream cColecionavelSoundStream;
    private AudioInputStream cDestroiBlocoSoundStream;
    private AudioInputStream cMorteSoundStream;

    public void soundtrack() {
        try {
            this.cSoundtrack.loop(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void colecionavelSound() {
        try {
            this.cColecionavelSound.stop();
            this.cColecionavelSound.setFramePosition(0);
            this.cColecionavelSound.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroiBlocoSound() {
        try {
            this.cDestroiBlocoSound.stop();
            this.cDestroiBlocoSound.setFramePosition(0);
            this.cDestroiBlocoSound.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void morteSound() {
        try {
            this.cMorteSound.stop();
            this.cMorteSound.setFramePosition(0);
            this.cMorteSound.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SoundFx() {
        try {
            File soundtrackFile = new File("audio" + File.separator + "soundtrack.wav");
            File colecionavelSoundFile = new File("audio" + File.separator + "grabitem.wav");
            File destroiBlocoSoundFile = new File("audio" + File.separator + "break.wav");
            File morteSoundFile = new File ("audio" + File.separator + "death.wav");
            this.cSoundtrackStream = AudioSystem.getAudioInputStream(soundtrackFile);
            this.cColecionavelSoundStream = AudioSystem.getAudioInputStream(colecionavelSoundFile);
            this.cDestroiBlocoSoundStream = AudioSystem.getAudioInputStream(destroiBlocoSoundFile);
            this.cMorteSoundStream = AudioSystem.getAudioInputStream(morteSoundFile);
            this.cSoundtrack = AudioSystem.getClip();
            this.cSoundtrack.open(this.cSoundtrackStream);
            this.cColecionavelSound = AudioSystem.getClip();
            this.cColecionavelSound.open(this.cColecionavelSoundStream);
            this.cDestroiBlocoSound = AudioSystem.getClip();
            this.cDestroiBlocoSound.open(this.cDestroiBlocoSoundStream);
            this.cMorteSound = AudioSystem.getClip();
            this.cMorteSound.open(this.cMorteSoundStream);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
