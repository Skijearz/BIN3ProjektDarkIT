package de.hshannover.inform.escape;


import javafx.application.Application;

import javafx.stage.Stage;
/**
 * Main class of the project, gets called on startup
 * and prepares the stage and loads the mainmenu
 */
public class Escape extends Application {

	private Stage primaryStage;
	SceneManager sm;
	SoundPlayer sp = new SoundPlayer();
	
	@Override
	public void start(Stage primaryStage) {
	    System.setProperty("quantum.multithreaded", "false");
		this.primaryStage = primaryStage;
		
		mainWindow();
		
	}
	/**
	 * Sets the mainMenu Scene to the stage 
	 */
	public void mainWindow() {
	    sp.playBGM("dungeonBGM");
		sm = new SceneManager(primaryStage);
	}


}
