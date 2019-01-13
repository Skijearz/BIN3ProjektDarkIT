package de.hshannover.inform.escape;



import java.util.ArrayList;

import de.hshannover.inform.escape.Enums.RelativPosition;
import javafx.scene.shape.Rectangle;
/**
 * 
 * Stone class is a subclass of Entity
 * @see Entity
 * and is used to create an Stone object which will interact with the player.
 */
public class Stone extends Entity {
    @SuppressWarnings("unused")
    private Sprite stoneSprite;
    
	public Stone(int x, int y) {
		super(x, y);

		this.stoneSprite = new Sprite(this);

	}
	/**
	 * the move function differs from the entity's one because if stones hit and other object (obstacle or player) 
	 * their velocity gets changed to 0.
	 */
	@Override
	public void move(ArrayList<Entity> entityList,ArrayList <Rectangle> obstacles) {
		if (!Collision.checkCollision(obstacles, entityList, this)) {
			setX(getX() + getVelX());
			setY(getY() + getVelY());
		}else {
		    SoundPlayer sp = new SoundPlayer();
		    sp.playSound("stoneHitWall");
			setVelX(0);
			setVelY(0);
		}
		this.collisionBox.Update();
	}
	/**
	 * Push method a player calls with the Space key press if a player and stone object touches each other.
	 * @param pos (Enumeration) Relative position from the player to the stone
	 * @see RelativePosition
	 */
	public void push(RelativPosition pos) {
		switch(pos) {
		case ABOVE:
			this.setVelY(VELOCITY);
			break;
			
		case BELOW:
			this.setVelY(-VELOCITY);
			break;
			
		case LEFT:
			this.setVelX(VELOCITY);
			break;
			
		case RIGHT:
			this.setVelX(-VELOCITY);
			break;
		}
	}
}
