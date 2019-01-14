package de.hshannover.inform.escape;

import javafx.scene.media.AudioClip;

public class SoundPlayer extends Thread{
    private AudioClip audio;
    public SoundPlayer() {
        
        
    }
    
    public  void playSound(String SoundFileName) {
        this.audio = new AudioClip(getClass().getResource("sounds/"+SoundFileName +".wav").toExternalForm());
        this.audio.setVolume(0.3);
        Thread playingSound = new Thread(this);
        playingSound.start();
    }
    public void playBGM(String SoundFileName) {
        this.audio = new AudioClip(getClass().getResource("sounds/"+SoundFileName +".wav").toExternalForm());
        this.audio.setVolume(0.1);
        this.audio.setCycleCount(AudioClip.INDEFINITE);
        Thread playingSound = new Thread(this);
        playingSound.start();
    }
    public void stopAudio() {
        this.audio.stop();
    }
    public void setCycleCount() {
        this.audio.setCycleCount(AudioClip.INDEFINITE);
    }
    public void run() {
        
        this.audio.play();
       
       
        
      }
    
}
