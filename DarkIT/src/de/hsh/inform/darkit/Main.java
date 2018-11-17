package de.hsh.inform.darkit;


import javafx.application.Application;

import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	SceneManager sm;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		mainWindow();
		
	}
	
	public void mainWindow() {
		sm = new SceneManager(primaryStage);
	}
	public static void main(String[] args) {
		launch(args);
	}

}
