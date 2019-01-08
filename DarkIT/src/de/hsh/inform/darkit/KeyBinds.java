package de.hsh.inform.darkit;

import de.hsh.inform.darkit.Enums.Directions;
import de.hsh.inform.darkit.gui.GameWindowController;
import javafx.scene.layout.Pane;

/**
 * Bind key press and release on the scene to register key presses and releases.
 * 
 * @param gamePane Pane on which the game itself plays.
 * @param          p: Player obj. which has the corresponding move function for
 *                 the given key press.
 */
public class KeyBinds {

	public static void initializeMoveKeyBinds(Pane gamePane, Player p, GameLoop gl, GameWindowController gmc) {
		
		
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
				gl.gameTimer.stop();
				gmc.switchToPauseMenu();
				break;

			default:
				break;
			}
		});
		gamePane.getScene().setOnKeyReleased(e -> {
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
