package de.hshannover.inform.escape.gui;

import de.hshannover.inform.escape.SceneManager;
import de.hshannover.inform.escape.Enums.Scenes;
import javafx.fxml.FXML;

public class MapCompletedWindow implements ControllerSet{
	SceneManager sm;
	GameWindowController gmc;
	@FXML
	public void switchToMainMenu() {
		getGameWindowController();
		gmc.setInitiatedToFalse();
		gmc.setMapCount(1);
		sm.changeScene(Scenes.mainMenu);
	}
	@FXML
	public void nextLevel() {
		getGameWindowController();
		gmc.setInitiatedToFalse();
		gmc.setMapCount(gmc.getMapCount()+1);
		sm.changeScene(Scenes.gameWindow);
		gmc.gameStart();
	}

	@Override
	public ControllerSet getController(Scenes scene) {
		
		return this;
	}

	@Override
	public void setSceneManager(SceneManager sceneManager) {
		this.sm = sceneManager;
		
	}
	private void getGameWindowController() {
		gmc = (GameWindowController)sm.getController(Scenes.gameWindow);
	}

}
