package de.hshannover.inform.escape;

import java.util.ArrayList;

import de.hshannover.inform.escape.gui.GameWindowController;
import de.hshannover.inform.escape.Enums.RelativPosition;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GameLoop {
	private GameWindowController gmc;
	private Pane gamePane;
	private Player player;
	private ArrayList<CollisionBox> collisionBoxes;
	private ArrayList<Entity> entityList;
	private boolean mapSuccesfulCompleted;
	MapBuilder mb;
	AnimationTimer gameTimer;

/**
 * 
 * @param gmc GameWindowController, class(controller of the gameWindow.fxml) which controls the pane 
 * @see GameWindowController
 * @param gamePane Pane where all elements gets drawn into
 * @param collisionBoxPlayer is a CollisionBox of the Player to check Collisions
 * @see CollisionBox
 * @param Sprite TODO
 * @param mb object of the MapBuilder to get the information from the map(goalTiles,ObstacleList)
 * @See MapBuilder
 * @param entityList ArrayList of all entities 
 * @param p
 */
	public GameLoop(GameWindowController gmc, Pane gamePane, CollisionBox collisionBoxPlayer, ArrayList<CollisionBox>Sprite, MapBuilder mb, ArrayList<Entity> entityList,Player p) {
		this.gmc = gmc;
		this.gamePane = gamePane;
		this.player = p;
		this.collisionBoxes = Sprite;
		this.entityList = entityList;
		this.mb = mb;
		for(Entity e : entityList) {
			gamePane.getChildren().add(e.collisionBox);
		}
		gamePane.getChildren().add(player.collisionBox);
		gamePane.getChildren().add(player.isTouchingBox); 
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
				for(CollisionBox cb : collisionBoxes) {
					cb.Update();
				}
				player.move(entityList,mb.getObstacleList());
				player.playerSprite.Update();
				player.isTouchingBox.Update();
				
			if(Collision.checkIfStoneIsOnGoalTile(entityList, mb.getGoalTiles())){
                    if (!mapSuccesfulCompleted) {
                        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
                            System.out.println("test");
                            gmc.switchToMapCompletedWindow();

                        }));
                        timeline.setCycleCount(1);
                        timeline.play();
                        mapSuccesfulCompleted = true;
                    }

				}
			}
		};
	}
	/**
	 * Called if the space key gets pressed, if the player touches an entity (Stone) at the same time as the key press happens
	 * it pushes the entity(Stone) in the opposite direction of the Player
	 * @see Stone
	 */
	public void stonePush() {
		if(Collision.checkIfPlayerIsTouchingStone(player, entityList)) {
			Stone tmp = (Stone) Collision.getStone(player, entityList);
			
			RelativPosition tmpPos = EvaluatePosition.evaluatePosition(player, tmp);
			tmp.push(tmpPos);
			
		}
	}
	/**
	 * Starts the gameLoop
	 */
	public void startTimer() {
		gameTimer.start();
	}
	/**
	 * Stops the gameLoop
	 */
	public void stopTimer() {
		gameTimer.stop();
	}

}
