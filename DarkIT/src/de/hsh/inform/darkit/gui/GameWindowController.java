package de.hsh.inform.darkit.gui;

import de.hsh.inform.darkit.MapBuilder;
import de.hsh.inform.darkit.Player;
import de.hsh.inform.darkit.SceneManager;
import de.hsh.inform.darkit.Sprite;
import de.hsh.inform.darkit.GameLoop;
import de.hsh.inform.darkit.Enums.Maps;
import de.hsh.inform.darkit.Enums.Scenes;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class GameWindowController implements ControllerSet {
	
	private Player p;
	private Sprite player;
	private boolean initiaded;
	MapBuilder mb;
	SceneManager sm;
	GameLoop gm;
	
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
		p = new Player(300,500);
		player = new Sprite(p.getX(), p.getY(), 16, 16, Color.GREEN,p);
		mb = new MapBuilder(getGamePane(),Maps.map1);
		mb.build();
		gm = new GameLoop(this,this.getGamePane(),this.player,p,mb);

		getGamePane().getChildren().add(player);
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

	public void switchToPauseMenu() {
		sm.changeScene(Scenes.pauseWindow);
		
	}

	public Pane getGamePane() {
		return gamePane;
	}

	public void setGamePane(Pane gamePane) {
		this.gamePane = gamePane;
	}


}
