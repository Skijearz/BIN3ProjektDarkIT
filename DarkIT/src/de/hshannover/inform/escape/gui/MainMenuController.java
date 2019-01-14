package de.hshannover.inform.escape.gui;

import de.hshannover.inform.escape.SceneManager;
import de.hshannover.inform.escape.Enums.Scenes;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class MainMenuController implements ControllerSet {
	private int uselessCounter = 0;
	SceneManager sm;
	
	@FXML
	private Pane mainPane;

	public void startGame() {
		sm.changeScene(Scenes.gameWindow);
		((GameWindowController) sm.getController(Scenes.gameWindow)).gameStart();
		
	}

	@FXML
	public void exitGame() {
		System.exit(1);
	}

	@FXML
	public void gameStart() {
		startGame();

	}

	@FXML
	public void helpMenu() {
		this.uselessCounter++;
		if(uselessCounter % 5 == 0) {
			sm.changeScene(Scenes.nothing);
			((Nothing)sm.getController(Scenes.nothing)).doNothing();
		}else {
			sm.changeScene(Scenes.helpMenu);
		}
	}

	@Override
	public ControllerSet getController(Scenes scene) {

		return this;
	}

	@Override
	public void setSceneManager(SceneManager sceneManager) {
		sm = sceneManager;

	}

}
