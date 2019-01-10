package de.hsh.inform.darkit;

import java.util.ArrayList;

import de.hsh.inform.darkit.Enums.RelativPosition;
import javafx.scene.shape.Rectangle;

public class Stone extends Entity {

	public Stone(int x, int y) {
		super(x, y);

	}
	@Override
	public void move(ArrayList<Entity> entityList,ArrayList <Rectangle> obstacles) {
		if (!Collision.checkCollision(obstacles, entityList, this)) {
			setX(getX() + getVelX());
			setY(getY() + getVelY());
		}else {
			setVelX(0);
			setVelY(0);
		}
		this.collisionSprite.Update();
	}
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
