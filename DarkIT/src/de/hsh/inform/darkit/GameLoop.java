package de.hsh.inform.darkit;

import java.util.ArrayList;

import de.hsh.inform.darkit.gui.GameWindowController;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class GameLoop {
	private GameWindowController gmc;
	private Pane gamePane;
	private Player player;
	private Sprite spritePlayer;
	private Sprite spriteStone;
	private Sprite spriteStone2;
	private ArrayList<Entity> entityList;
	MapBuilder mb;
	AnimationTimer gameTimer;

	/**
	 * GameLoop Constructor
	 * 
	 * @param gamePane     The main game pane where stuff gets drawn onto
	 * @param spritePlayer Sprite Player
	 * @param player       Entity Player
	 */
	public GameLoop(GameWindowController gmc, Pane gamePane, Sprite spritePlayer, Sprite spriteStone,Sprite spriteStone2, MapBuilder mb, ArrayList<Entity> entityList,Player p) {
		this.gmc = gmc;
		this.gamePane = gamePane;
		this.player = p;
		this.spritePlayer = spritePlayer;
		this.spriteStone = spriteStone;
		this.spriteStone2 = spriteStone2;
		this.entityList = entityList;
		this.mb = mb;
		for(Entity e : entityList) {
			gamePane.getChildren().add(e.collisionSprite);
		}
		gamePane.getChildren().add(player.collisionSprite);
		gamePane.getChildren().add(player.isTouchingBox); 
		System.out.println(player.isTouchingBox.toString());
		KeyBinds.initializeMoveKeyBinds(this.gamePane, player, this, this.gmc);

		this.createGameloop();
		this.startTimer();

	}

	/**
	 * Creating the Loop to update the position where the Player Sprite gets drawn
	 * 
	 * @param spritePlayer Sprite Player
	 */
	public void createGameloop() {
		gameTimer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				for (Entity e : entityList) {
					e.move(entityList,mb.getObstacleList());
					
				}
				player.move(entityList,mb.getObstacleList());
				player.isTouchingBox.Update();
				
			
				
				spritePlayer.Update();
				spriteStone.Update();
				spriteStone2.Update();
				if(Collision.checkIfPlayerIsTouchingStone(player, entityList)) {
					Entity tmp = Collision.getStone(player, entityList);
					EvaluatePosition.evaluatePosition(player, tmp);
					
				}
				if(Collision.checkIfStoneIsOnGoalTile(entityList, mb.getGoalTiles())){
					System.out.println("alle Steine auf ziel");
				}
			}
		};
	}

	public void startTimer() {
		gameTimer.start();
	}

}
