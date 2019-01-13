package de.hshannover.inform.escape;

import javafx.application.Application;


public class Start  {

    public static void main(String[] args) {
        System.setProperty("quantum.multithreaded", "false");

        Application.launch(Escape.class, args);
    }
    
}
