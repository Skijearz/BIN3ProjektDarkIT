package de.hshannover.inform.escape;

import java.io.IOException;

import de.hshannover.inform.escape.gui.ControllerSet;
import de.hshannover.inform.escape.Enums.Scenes;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * The SceneManger is used to dynamically allocate the FXML(Scenes) with their corresponding controller class,
 * this is necessary because java throws an exception if the FXML file don't have their own controller class.
 * In order to function the controller classes have to implement the interface ControllerSet
 * @see ControllerSet
 *
 */
public class SceneManager {

	private Scene[] scenes;
	private Stage primaryStage;
	private ControllerSet[] controller;
	/**
	 * SceneManager constructor called from the Main class to initialize the Scenes.
	 * @param primaryStage main Stage where everything happens on
	 */
	public SceneManager(Stage primaryStage) {

		this.primaryStage = primaryStage;
		scenes = new Scene[Scenes.values().length];
		setController();

		this.changeScene(Scenes.mainMenu);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Escape");
		primaryStage.sizeToScene();
		primaryStage.show();
		primaryStage.setOnCloseRequest(evt -> {
			System.exit(1);
		});
	}
	/**
	 * This method sets the controller class to each of their FXML files 
	 */
	private void setController() {
		try {
			controller = new ControllerSet[Scenes.values().length];
			for (int i = 0; i < Scenes.values().length; i++) {

				FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(Scenes.getFXML(Scenes.values()[i])));
				Pane pane = loader.load();
				scenes[i] = new Scene(pane);
				/*folgendes ist äquivalent zu : 
				 * MainMenuController mwc = loader.getController();
				 * und :
				 * MainMenuController.setMain();
				 */
				controller[i] = loader.getController();
				controller[i].setSceneManager(this);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method changes the current showing scene to a new one.
	 * @param scene (Enumeration) which should become the new showing scene.
	 * @see Scenes
	 */
	public void changeScene(Scenes scene) {
		primaryStage.setScene(scenes[scene.ordinal()]);
	}
	/**
	 * This method is used to get the controller object of a Scene.
	 * 
	 * @param scene (Enumeration)  from which the controller object is desired
	 * @see Scenes
	 * @return object of the scene controller class
	 */
	public ControllerSet getController(Scenes scene) {
		return controller[scene.ordinal()];
	}
}
	
