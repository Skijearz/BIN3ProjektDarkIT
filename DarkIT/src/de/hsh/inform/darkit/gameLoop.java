package de.hsh.inform.darkit;

import de.hsh.inform.darkit.enums.Directions;
import de.hsh.inform.darkit.gui.gameWindowController;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class gameLoop {
	private gameWindowController gmc;
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
	public gameLoop(gameWindowController gmc,Pane gamePane, Sprite player, Player p) {
		this.gmc = gmc;
		this.gamePane = gamePane;
		this.player = player;
		this.p = p;
		this.keyBinds();
		this.createGameloop();
		this.startTimer();
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
				p.move();
			}
			
		};
		
	}
	public void startTimer() {
		gameTimer.start();
	}

	/**
	 * Adds a KeyListener on the active scene
	 */
	public void keyBinds() {
		gamePane.getScene().setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case W:
				p.moveKeyPress(Directions.UP);
				break;
			case A:
				p.moveKeyPress(Directions.LEFT);
				break;
			case S:
				p.moveKeyPress(Directions.DOWN);
				break;
			case D:
				p.moveKeyPress(Directions.RIGHT);
				break;
			case ESCAPE:
				gameTimer.stop();
				gmc.switchToMainMenu();
			default:
				break;
			}
		});
		gamePane.getScene().setOnKeyReleased(e ->{
			switch (e.getCode()) {
			case W:
				p.moveKeyRelease(Directions.UP);
				break;
			case A:
				p.moveKeyRelease(Directions.LEFT);
				break;
			case S:
				p.moveKeyRelease(Directions.DOWN);
				break;
			case D:
				p.moveKeyRelease(Directions.RIGHT);
				break;
			default:
				break;
			}
		});
	}
	

}
