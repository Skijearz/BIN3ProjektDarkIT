package de.hsh.inform.darkit.gui;

import de.hsh.inform.darkit.MapBuilder;
import de.hsh.inform.darkit.Player;
import de.hsh.inform.darkit.SceneManager;
import de.hsh.inform.darkit.Sprite;
import de.hsh.inform.darkit.Stone;
import de.hsh.inform.darkit.GameLoop;

import java.util.ArrayList;

import de.hsh.inform.darkit.Entity;
import de.hsh.inform.darkit.Enums.Maps;
import de.hsh.inform.darkit.Enums.Scenes;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class GameWindowController implements ControllerSet {

	private Entity player;
	private Entity stone;
	private Entity stone2;
	private Sprite spritePlayer;
	private Sprite spriteStone;
	private Sprite spriteStone2;
	private boolean initiaded;
	private ArrayList<Entity> entityList;
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
	/**
	 * on call, this method starts the gameloop and initialize entity objects and sprites.
	 * 
	 */
	public void gameStart() {
		if (!initiaded) {
			map1();
			
		} else {
			gm.startTimer();
		}
	}
	
	public void map1() {
		gamePane.setStyle("-fx-background-color: #000000");
		entityList = new ArrayList<Entity>();
		player = null;
		stone = null;
		
		
		player = new Player(300, 450);
		stone = new Stone(288, 400);
		stone2 = new Stone(464, 400);
		//stone.setVelY(-1);
		//stone2.setVelY(-1);
		entityList.add(stone);
		entityList.add(stone2);
		
		
		spriteStone = new Sprite(stone.getX(), stone.getY(), 16, 16, Color.BLUE, stone);
		spriteStone2 = new Sprite(stone2.getX(), stone2.getY(), 16, 16, Color.BLUE, stone2);
		spritePlayer = new Sprite(player.getX(), player.getY(), 16, 16, Color.GREEN, player);
		mb = new MapBuilder(getGamePane(), Maps.map1);
		mb.build(Maps.map1);
		gm = new GameLoop(this, this.getGamePane(), this.spritePlayer, spriteStone,spriteStone2, mb, entityList, (Player)player);

		getGamePane().getChildren().add(spritePlayer);
		getGamePane().getChildren().add(spriteStone);
		getGamePane().getChildren().add(spriteStone2);
		this.initiaded = true;
	}

	public void switchToMainMenu() {
		sm.changeScene(Scenes.mainMenu);
	}

	public void setInitiatedToFalse() {
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
	public ArrayList<Entity> getEntityList(){
		return entityList;
	}

}
