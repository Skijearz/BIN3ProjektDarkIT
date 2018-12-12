package de.hsh.inform.darkit.gui;

import de.hsh.inform.darkit.MapBuilder;
import de.hsh.inform.darkit.Player;
import de.hsh.inform.darkit.SceneManager;
import de.hsh.inform.darkit.Sprite;
import de.hsh.inform.darkit.gameLoop;
import de.hsh.inform.darkit.enums.Maps;
import de.hsh.inform.darkit.enums.Scenes;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class gameWindowController implements ControllerSet {
	private Player p = new Player(300,500);
	private Sprite player = new Sprite(p.getX(), p.getY(), 16, 16, Color.GREEN,p);
	private boolean initiaded;
	SceneManager sm;
	gameLoop gm;
	MapBuilder mb;
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
		if(!initiaded) {
		gm = new gameLoop(this,this.gamePane,this.player,p);
		mb = new MapBuilder(gamePane,Maps.map1);
		mb.build();
		gamePane.getChildren().add(player);
		this.initiaded = true;
		}else {
			gm.startTimer();
		}
	}
	public void switchToMainMenu() {
		sm.changeScene(Scenes.mainMenu);
	}
	public void setInitiaded() {
		this.initiaded = false;
	}

}
