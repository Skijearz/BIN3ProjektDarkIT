package de.hsh.inform.darkit.gui;

import de.hsh.inform.darkit.SceneManager;
import de.hsh.inform.darkit.enums.Scenes;
import javafx.fxml.FXML;

public class helpMenuController implements ControllerSet {
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

