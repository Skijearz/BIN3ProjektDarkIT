package de.hshannover.inform.escape.gui;

import java.util.ArrayList;

import de.hshannover.inform.escape.Entity;
import de.hshannover.inform.escape.SceneManager;
import de.hshannover.inform.escape.Enums.Scenes;
import javafx.fxml.FXML;

public class PauseWindowController implements ControllerSet{
	SceneManager sm;
	ArrayList<Entity> entityList;
	
	
	@FXML
	public void switchToMainMenu(){
		((GameWindowController) sm.getController(Scenes.gameWindow)).destroyGame();
		((GameWindowController) sm.getController(Scenes.gameWindow)).setMapCount(1);
		sm.changeScene(Scenes.mainMenu);
		
	}
	@FXML
	public void backToGame() {
		sm.changeScene(Scenes.gameWindow);
		((GameWindowController) sm.getController(Scenes.gameWindow)).gameStart();
	}
	
	
	@Override
	public ControllerSet getController(Scenes scene) {
		return this;
	}

	@Override
	public void setSceneManager(SceneManager sceneManager) {
		this.sm = sceneManager;
		
	}

}
