package de.hshannover.inform.escape.gui;

import de.hshannover.inform.escape.SceneManager;
import de.hshannover.inform.escape.Enums.Scenes;
import javafx.fxml.FXML;

public class HelpMenuController implements ControllerSet {
	SceneManager sm;
	@FXML
	public void backToMainMenu(){
		sm.changeScene(Scenes.mainMenu);
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

