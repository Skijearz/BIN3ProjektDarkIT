package de.hshannover.inform.escape;

import de.hshannover.inform.escape.gui.GameWindowController;
import de.hshannover.inform.escape.Enums.Directions;
import javafx.scene.layout.Pane;

/**
 * Bind key press and release on the scene to register key presses and releases.
 * 
 */
public class KeyBinds {
    /**
     * Method gets called from the GameLoop constructor to initialize the key binds(press and release) for the movement
     * @param gamePane Pane where all game related things happen
     * @param player Object of the Player to call the needed movement functions
     * @see Player
     * @param gl GameLoop object
     * @see GameLoop
     * @param gmc GameWindowController object
     * @see GameWindowController
     */
	public static void initializeMoveKeyBinds(Pane gamePane, Player player, GameLoop gl, GameWindowController gmc) {
		
		
		gamePane.getScene().setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case W:
				player.moveKeyPress(Directions.UP);
				break;

			case A:
				player.moveKeyPress(Directions.LEFT);
				break;

			case S:
				player.moveKeyPress(Directions.DOWN);
				break;

			case D:
				player.moveKeyPress(Directions.RIGHT);
				break;

			case ESCAPE:
				gl.gameTimer.stop();
				gmc.switchToPauseMenu();
				break;
				
			case SPACE:
				gl.stonePush();
				

			default:
				break;
			}
		});
		gamePane.getScene().setOnKeyReleased(e -> {
			switch (e.getCode()) {
			case W:
				player.moveKeyRelease(Directions.UP);

				break;
			case A:
				player.moveKeyRelease(Directions.LEFT);

				break;
			case S:
				player.moveKeyRelease(Directions.DOWN);

				break;
			case D:
				player.moveKeyRelease(Directions.RIGHT);

				break;
			default:
				break;
			}
		});
	}
	
}
