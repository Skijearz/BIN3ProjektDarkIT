package de.hshannover.inform.escape;

import javafx.application.Application;

/**
 * Main class, has to be executed first because of a known bug in the javafx sdk
 * on some machines(e.g ubuntu) is the AnimationTimer too fast and isnt running with 60fps 
 */
public class Start  {
 
    public static void main(String[] args) {
        System.setProperty("quantum.multithreaded", "false");

        Application.launch(Escape.class, args);
    }
    
}
