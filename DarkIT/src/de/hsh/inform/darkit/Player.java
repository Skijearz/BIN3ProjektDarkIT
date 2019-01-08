package de.hsh.inform.darkit;

import de.hsh.inform.darkit.Enums.Directions;

/**
 * 
 * Player entity class
 *
 */
public class Player extends Entity {

	private static final double VELOCITY = 1.0;
	private boolean keyPressed = false;
	private Directions whichKeyIsPressed;

	public Player(int x, int y) {
		super(x, y);

	}

	@Override
	public void move(boolean collision) {
		if (!collision) {
			setX(getX() + getVelX());
			setY(getY() + getVelY());
		} /*
			 * else { setVelX(0); setVelY(0); }
			 */
	}

	/**
	 * Player keyPress (move) handling method, set the velocity of the entity based
	 * on the key pressed.
	 * Only one keyPress at a time
	 * 
	 * @param d Enum of the possible directions a player can walk, based on the key
	 *          press
	 */
	public void moveKeyPress(Directions d) {
		switch (d) {
		case UP:
			if (!keyPressed) {
				this.setVelY(-VELOCITY);
				keyPressed = true;
				whichKeyIsPressed = Directions.UP;
			}
			break;
		case DOWN:
			if (!keyPressed) {
				this.setVelY(VELOCITY);
				keyPressed = true;
				whichKeyIsPressed = Directions.DOWN;
			}
			break;
		case LEFT:
			if (!keyPressed) {
				this.setVelX(-VELOCITY);
				keyPressed = true;
				whichKeyIsPressed = Directions.LEFT;		
			}
			break;
		case RIGHT:
			if (!keyPressed) {
				this.setVelX(VELOCITY);
				keyPressed = true;
				whichKeyIsPressed = Directions.RIGHT;
			}
			break;
		default:
			break;
		}

	}

	/**
	 * Player keyRelease (move) handling method, resets the velocity of the given
	 * direction to 0.
	 * 
	 * @param d
	 */
	public void moveKeyRelease(Directions d) {
		switch (d) {
		
		case UP:
			if (keyPressed) {
				if (whichKeyIsPressed == Directions.UP) {
					this.setVelY(0);
					keyPressed = false;
					whichKeyIsPressed = null;
				}
			}
			break;
			
		case DOWN:
			if (keyPressed) {
				if (whichKeyIsPressed == Directions.DOWN) {
					this.setVelY(0);
					keyPressed = false;
					whichKeyIsPressed = null;
				}
			}
			break;
			
		case LEFT:
			if (keyPressed) {
				if (whichKeyIsPressed == Directions.LEFT) {
					this.setVelX(0);
					keyPressed = false;
					whichKeyIsPressed = null;
				}
			}
			break;
			
		case RIGHT:
			if (keyPressed) {
				if (whichKeyIsPressed == Directions.RIGHT) {
					this.setVelX(0);
					keyPressed = false;
					whichKeyIsPressed = null;
				}
			}
			break;
			
		default:
			break;
		}

	}

}
