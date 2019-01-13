package de.hshannover.inform.escape;



import de.hshannover.inform.escape.Enums.Directions;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * 
 * Player class is a subclass of Entity
 * @see Entity
 * and is used to create an Player object which gets controlled from the user via keyboard controls.
 */
public class Player extends Entity {

	private static final double VELOCITY = 2.0;
	private boolean keyPressed = false;
	private Directions whichKeyIsPressed;
	public Sprite playerSprite;
	public CollisionBox isTouchingBox;
	
	

	public Player(int x, int y,Pane gamePane) {
		super(x, y);
		this.playerSprite = new Sprite(this,gamePane);
		this.isTouchingBox = new CollisionBox(this.getX(),this.getY(),16,16,Color.TRANSPARENT,this,0,-5);

	}


	/**
	 * Player keyPress (move) handling method, set the velocity of the entity based
	 * on the key pressed.
	 * Only one keyPress at a time
	 * 
	 * @param d Enumeration of directions to simplify the difference of the keys 
	 * @see Directions
	 */
	public void moveKeyPress(Directions d) {
		switch (d) {
		case UP:
			if (!keyPressed) {
				this.setVelY(-VELOCITY);
				this.isTouchingBox.setOffsetX(0);
				this.isTouchingBox.setOffsetY(-5);
				keyPressed = true;
				whichKeyIsPressed = Directions.UP;
			}
			break;
		case DOWN:
			if (!keyPressed) {
				this.setVelY(VELOCITY);
				this.isTouchingBox.setOffsetX(0);
				this.isTouchingBox.setOffsetY(5);
				keyPressed = true;
				whichKeyIsPressed = Directions.DOWN;
			}
			break;
		case LEFT:
			if (!keyPressed) {
				this.setVelX(-VELOCITY);
				this.isTouchingBox.setOffsetX(-5);
				this.isTouchingBox.setOffsetY(0);
				keyPressed = true;
				whichKeyIsPressed = Directions.LEFT;		
			}
			break;
		case RIGHT:
			if (!keyPressed) {
				this.setVelX(VELOCITY);
				keyPressed = true;
				this.isTouchingBox.setOffsetX(5);
				this.isTouchingBox.setOffsetY(0);
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
	 * @param d Enumeration of directions to simplify the difference of the keys 
	 * @see Directions
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
	public boolean getKeyPressed() {
	    return this.keyPressed;
	}
	public Directions getWhichKeyIsPressed() {
	    return this.whichKeyIsPressed;
	}



}
