package de.hsh.inform.darkit.gui;

import de.hsh.inform.darkit.Enums.Scenes;
import de.hsh.inform.darkit.SceneManager;
import javafx.fxml.FXML;

public class PauseWindowController implements ControllerSet{
	SceneManager sm;
	
	@FXML
	public void switchToMainMenu(){
		sm.changeScene(Scenes.mainMenu);
		((GameWindowController) sm.getController(Scenes.gameWindow)).getGamePane().getChildren().clear();
		((GameWindowController) sm.getController(Scenes.gameWindow)).setInitiaded();
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
