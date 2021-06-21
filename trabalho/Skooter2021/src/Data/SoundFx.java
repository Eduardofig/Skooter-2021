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
    private Clip cBlocoSetaSound;
    private Clip cMatarInimigoSound;
    private Clip cCoracaoSound;
    private Clip cCoracaoMovendoSound;

    private AudioInputStream cSoundtrackStream;
    private AudioInputStream cColecionavelSoundStream;
    private AudioInputStream cDestroiBlocoSoundStream;
    private AudioInputStream cMorteSoundStream;
    private AudioInputStream cBlocoSetaSoundStream;
    private AudioInputStream cMatarInimigoSoundStream;
    private AudioInputStream cCoracaoSoundStream;
    private AudioInputStream cCoracaoMovendoSoundStream;

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

    public void blocoSetaSound() {
        try {
            this.cBlocoSetaSound.stop();
            this.cBlocoSetaSound.setFramePosition(0);
            this.cBlocoSetaSound.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void matarInimigoSound() {
        try {
            this.cMatarInimigoSound.stop();
            this.cMatarInimigoSound.setFramePosition(0);
            this.cMatarInimigoSound.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void coracaoSound() {
        try {
            this.cCoracaoSound.stop();
            this.cCoracaoSound.setFramePosition(0);
            this.cCoracaoSound.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void coracaoMovendoSound() {
        try {
            this.cCoracaoMovendoSound.stop();
            this.cCoracaoMovendoSound.setFramePosition(0);
            this.cCoracaoMovendoSound.start();
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
            File blocoSetaSoundFile = new File ("audio" + File.separator + "skid.wav");
            File matarInimigoSoundFile = new File("audio" + File.separator + "enemy.wav");
            File coracaoSoundFile = new File("audio" + File.separator + "heart.wav");
            File coracaoMovendoSoundFile = new File("audio" + File.separator + "heartcome.wav");

            this.cSoundtrackStream = AudioSystem.getAudioInputStream(soundtrackFile);
            this.cColecionavelSoundStream = AudioSystem.getAudioInputStream(colecionavelSoundFile);
            this.cDestroiBlocoSoundStream = AudioSystem.getAudioInputStream(destroiBlocoSoundFile);
            this.cMorteSoundStream = AudioSystem.getAudioInputStream(morteSoundFile);
            this.cBlocoSetaSoundStream = AudioSystem.getAudioInputStream(blocoSetaSoundFile);
            this.cMatarInimigoSoundStream = AudioSystem.getAudioInputStream(matarInimigoSoundFile);
            this.cCoracaoSoundStream = AudioSystem.getAudioInputStream(coracaoSoundFile);
            this.cCoracaoMovendoSoundStream = AudioSystem.getAudioInputStream(coracaoMovendoSoundFile); 

            this.cSoundtrack = AudioSystem.getClip();
            this.cColecionavelSound = AudioSystem.getClip();
            this.cDestroiBlocoSound = AudioSystem.getClip();
            this.cMorteSound = AudioSystem.getClip();
            this.cBlocoSetaSound = AudioSystem.getClip();
            this.cMatarInimigoSound = AudioSystem.getClip();
            this.cCoracaoSound = AudioSystem.getClip();
            this.cCoracaoMovendoSound = AudioSystem.getClip();

            this.cSoundtrack.open(this.cSoundtrackStream);
            this.cColecionavelSound.open(this.cColecionavelSoundStream);
            this.cDestroiBlocoSound.open(this.cDestroiBlocoSoundStream);
            this.cMorteSound.open(this.cMorteSoundStream);
            this.cBlocoSetaSound.open(this.cBlocoSetaSoundStream);
            this.cMatarInimigoSound.open(this.cMatarInimigoSoundStream);
            this.cCoracaoSound.open(this.cCoracaoSoundStream);
            this.cCoracaoMovendoSound.open(this.cCoracaoMovendoSoundStream);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
