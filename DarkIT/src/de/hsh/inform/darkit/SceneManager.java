package de.hsh.inform.darkit;

import java.io.IOException;

import de.hsh.inform.darkit.Enums.Scenes;
import de.hsh.inform.darkit.gui.ControllerSet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SceneManager {

	private Scene[] scenes;
	private Stage primaryStage;
	private ControllerSet[] controller;

	public SceneManager(Stage primaryStage) {

		this.primaryStage = primaryStage;
		scenes = new Scene[Scenes.values().length];
		setController();

		this.changeScene(Scenes.mainMenu);
		primaryStage.setResizable(false);
		primaryStage.setTitle("DarkIT");
		primaryStage.sizeToScene();
		primaryStage.show();
		primaryStage.setOnCloseRequest(evt -> {
			System.exit(1);
		});
	}
	public void setController() {
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

	public void changeScene(Scenes scene) {
		primaryStage.setScene(scenes[scene.ordinal()]);
	}

	public ControllerSet getController(Scenes scene) {
		return controller[scene.ordinal()];
	}
}
	
