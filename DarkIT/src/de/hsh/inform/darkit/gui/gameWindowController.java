package de.hsh.inform.darkit.gui;

import de.hsh.inform.darkit.Player;
import de.hsh.inform.darkit.SceneManager;
import de.hsh.inform.darkit.Sprite;
import de.hsh.inform.darkit.gameLoop;
import de.hsh.inform.darkit.enums.Scenes;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class gameWindowController implements ControllerSet {
	private Player p = new Player(300,500);
	private Sprite player = new Sprite(p.getX(), p.getY(), 10, 10, Color.GREEN,p);
	SceneManager sm;
	gameLoop gm;
	
	@FXML
	private Pane gamePane;
	
	
	
	@Override
	public ControllerSet getController(Scenes scene) {
		return this;
	}

	@Override
	public void setSceneManager(SceneManager sceneManager) {
		sm = sceneManager;
		
		
	}
	public void gameStart() {
		gm = new gameLoop(gamePane,player,p);
		gamePane.getChildren().add(player);
		
	}

}
