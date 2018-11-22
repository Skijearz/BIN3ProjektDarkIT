package de.hsh.inform.darkit.gui;

import de.hsh.inform.darkit.SceneManager;
import de.hsh.inform.darkit.enums.Scenes;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class GameWindowController implements ControllerSet {
	SceneManager sm;
	TileReader tr;
	
	
	@FXML
	Pane gamePane;
	
	public void startGame() {
		tr = new TileReader(gamePane);
		tr.buildMap();
	}
	
	@Override
	public ControllerSet getController(Scenes scene) {
		return this;
	}

	@Override
	public void setSceneManager(SceneManager stage) {
		sm = stage;
		
	}

}
