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
	private boolean collision;

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
				collision = Collision.checkCollision(mb.getObstacleList(), entityList,player);
				for (Entity e : entityList) {
					e.move(collision);
					e.collisionSprite.Update();
				}
				player.move(collision);
				player.collisionSprite.Update();
				
				spritePlayer.Update();
				spriteStone.Update();
				spriteStone2.Update();

			}
		};
	}

	public void startTimer() {
		gameTimer.start();
	}

}
