package de.hsh.inform.darkit;

import de.hsh.inform.darkit.Enums.Directions;
import de.hsh.inform.darkit.gui.GameWindowController;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

/**
 * Bind key press and release on the scene to register key presses and releases.
 * 
 * @param gamePane Pane on which the game itself plays.
 * @param          p: Player obj. which has the corresponding move function for
 *                 the given key press.
 */
public class KeyBinds {

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
