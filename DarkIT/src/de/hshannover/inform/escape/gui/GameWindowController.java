package de.hshannover.inform.escape.gui;


import java.util.ArrayList;



import de.hshannover.inform.escape.CollisionBox;
import de.hshannover.inform.escape.Entity;
import de.hshannover.inform.escape.GameLoop;
import de.hshannover.inform.escape.MapBuilder;
import de.hshannover.inform.escape.Player;
import de.hshannover.inform.escape.SceneManager;
import de.hshannover.inform.escape.SoundPlayer;
import de.hshannover.inform.escape.Stone;
import de.hshannover.inform.escape.Enums.Maps;
import de.hshannover.inform.escape.Enums.Scenes;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class GameWindowController implements ControllerSet {
	
	
	
	
	private boolean initiaded;
	private int mapCount = 1;
	
	private ArrayList<Entity> entityList;
	private ArrayList<CollisionBox> Sprite;
	
	MapBuilder mb;
	SceneManager sm;
	GameLoop gameLoop;
	SoundPlayer sp = new SoundPlayer();

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
			switch(mapCount) {
			case 1:
				map1();
				break;
			case 2:
				System.out.println("map2");
				break;
			case 3:
				break;
			}
			
			
		} else {
			gameLoop.startTimer();
		}
	}
	
	public void map1() {
		gamePane.setStyle("-fx-background-color: #211e27");
		entityList = new ArrayList<Entity>();
		Sprite = new ArrayList<CollisionBox>();
		Entity player = null;
		Entity stone = null;
		Entity stone2 = null;
		CollisionBox collisionBoxStone = null;
		CollisionBox collisionBoxStone2 =null;
		CollisionBox collisionBoxPlayer = null;
		
		player = new Player(300, 450,this.getGamePane());
		stone = new Stone(200, 400);
		stone2 = new Stone(250, 400);

		entityList.add(stone);
		entityList.add(stone2);
		
		
		collisionBoxStone = new CollisionBox(stone.getX(), stone.getY(), 16, 16, Color.TRANSPARENT, stone);
		collisionBoxStone2 = new CollisionBox(stone2.getX(), stone2.getY(), 16, 16, Color.TRANSPARENT, stone2);
		collisionBoxPlayer = new CollisionBox(player.getX(), player.getY(), 16, 16, Color.TRANSPARENT, player);
		
		Sprite.add(collisionBoxStone);
		Sprite.add(collisionBoxStone2);
		Sprite.add(collisionBoxPlayer);
		 
		
		mb = new MapBuilder(getGamePane());
		mb.build(Maps.getMapFile(Maps.map1));
		gameLoop = new GameLoop(this, this.getGamePane(), collisionBoxPlayer,Sprite , mb, entityList, (Player)player);
		getGamePane().getChildren().addAll(Sprite);
		this.initiaded = true;
	}

	public void switchToMainMenu() {
		this.destroyGame();
		sm.changeScene(Scenes.mainMenu);
	
	}

	public void setInitiatedToFalse() {
		this.initiaded = false;
	}

	public void switchToPauseMenu() {
		sm.changeScene(Scenes.pauseWindow);

	}
	public void switchToMapCompletedWindow() {
		this.destroyGame();
		sp.playSound("levelSucces");
		sm.changeScene(Scenes.mapCompletedWindow);
	}
	public void destroyGame() {
		entityList = null;
		Sprite = null;
		gamePane.getChildren().clear();
		gameLoop.stopTimer();
		this.setMapCount(mapCount);
		this.setInitiatedToFalse();
	}
	//Getter and Setter methods
	public Pane getGamePane() {
		return gamePane;
	}

	public void setGamePane(Pane gamePane) {
		this.gamePane = gamePane;
	}
	public ArrayList<Entity> getEntityList(){
		return entityList;
	}
	public void setMapCount(int mapCount) {
		this.mapCount = mapCount;
	}
	public int getMapCount() {
		return this.mapCount;
	}

}
