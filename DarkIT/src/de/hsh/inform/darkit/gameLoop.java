package de.hsh.inform.darkit;

import de.hsh.inform.darkit.enums.Directions;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class gameLoop {
	private Player p;
	private Pane gamePane;
	private Sprite player;
	AnimationTimer gameTimer;

	/**
	 * GameLoop Constructor
	 * 
	 * @param gamePane The main game pane where stuff gets drawn onto
	 * @param player   Sprite Player
	 * @param p        Entity Player
	 */
	public gameLoop(Pane gamePane, Sprite player, Player p) {
		this.gamePane = gamePane;
		this.player = player;
		this.p = p;
		this.keyBinds();
		this.createGameloop();
	}

	/**
	 * Creating the Loop to update the position where the Player Sprite gets drawn
	 * 
	 * @param player Sprite Player
	 */
	public void createGameloop() {
		gameTimer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				player.Update();
			}

		};
		gameTimer.start();
	}

	/**
	 * Adds a KeyListener on the active scene
	 */
	public void keyBinds() {
		gamePane.getScene().setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case W:
				p.move(Directions.UP);
				break;
			case A:
				p.move(Directions.LEFT);
				break;
			case S:
				p.move(Directions.DOWN);
				break;
			case D:
				p.move(Directions.RIGHT);
				break;
			default:
				break;
			}
		});
	}

}
