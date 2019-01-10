package de.hsh.inform.darkit;



import de.hsh.inform.darkit.Enums.Directions;
import javafx.scene.paint.Color;

/**
 * 
 * Player entity class
 *
 */
public class Player extends Entity {

	private boolean keyPressed = false;
	private Directions whichKeyIsPressed;
	public Sprite isTouchingBox;
	

	public Player(int x, int y) {
		super(x, y);
		this.isTouchingBox = new Sprite(this.getX(),this.getY(),5,5,Color.AQUA,this,5,-5);

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
				this.isTouchingBox.setOffsetX(5);
				this.isTouchingBox.setOffsetY(-5);
				keyPressed = true;
				whichKeyIsPressed = Directions.UP;
			}
			break;
		case DOWN:
			if (!keyPressed) {
				this.setVelY(VELOCITY);
				this.isTouchingBox.setOffsetX(5);
				this.isTouchingBox.setOffsetY(16);
				keyPressed = true;
				whichKeyIsPressed = Directions.DOWN;
			}
			break;
		case LEFT:
			if (!keyPressed) {
				this.setVelX(-VELOCITY);
				this.isTouchingBox.setOffsetX(-5);
				this.isTouchingBox.setOffsetY(5);
				keyPressed = true;
				whichKeyIsPressed = Directions.LEFT;		
			}
			break;
		case RIGHT:
			if (!keyPressed) {
				this.setVelX(VELOCITY);
				keyPressed = true;
				this.isTouchingBox.setOffsetX(16);
				this.isTouchingBox.setOffsetY(5);
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
