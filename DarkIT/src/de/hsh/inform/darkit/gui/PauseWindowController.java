package de.hsh.inform.darkit.gui;

import java.util.ArrayList;

import de.hsh.inform.darkit.Entity;
import de.hsh.inform.darkit.Enums.Scenes;
import de.hsh.inform.darkit.SceneManager;
import javafx.fxml.FXML;

public class PauseWindowController implements ControllerSet{
	SceneManager sm;
	ArrayList<Entity> entityList;
	
	
	@FXML
	public void switchToMainMenu(){
		sm.changeScene(Scenes.mainMenu);
		entityList = ((GameWindowController) sm.getController(Scenes.gameWindow)).getEntityList();
		entityList = null;
		((GameWindowController) sm.getController(Scenes.gameWindow)).getGamePane().getChildren().clear();
		((GameWindowController) sm.getController(Scenes.gameWindow)).setInitiatedToFalse();
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
