package de.hsh.inform.darkit.gui;

import de.hsh.inform.darkit.SceneManager;
import de.hsh.inform.darkit.Enums.Scenes;
import javafx.fxml.FXML;

public class MainMenuController implements ControllerSet {
	SceneManager sm;

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
		sm.changeScene(Scenes.helpMenu);
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
