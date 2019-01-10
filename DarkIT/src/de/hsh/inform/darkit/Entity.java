package de.hsh.inform.darkit;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * 
 * Entity class
 *
 */
public class Entity {

	protected static final double VELOCITY = 1.0;

	private double x;
	private double y;
	private double velX;
	private double velY;
	public Sprite collisionSprite;

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
		this.collisionSprite = new Sprite(this.getX(),this.getY() , 16, 16, Color.YELLOW, this);
		System.out.println(this.collisionSprite);
	}

	/**
	 * Moves the player around based on his Velocity in the x or y direction,
	 * updates through a gameloop
	 * 
	 * @param collision, boolean from the Collision class which checks if the player
	 *        collision rectangle touches/overlaps with a obstacle obj.
	 */
	public void move(ArrayList<Entity> entityList,ArrayList <Rectangle> obstacles) {
		if (!Collision.checkCollision(obstacles, entityList, this)) {
			setX(getX() + getVelX());
			setY(getY() + getVelY());
		}
		this.collisionSprite.Update();
	}

	// getter and setter of entity fields
	public void setX(double d) {
		this.x = d;
	}

	public void setY(double d) {
		this.y = d;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	/**
	 * Prints the class name and the coordinates of that class in this format :
	 * "Classname" + " " + X-Coordinate + "," + Y-Coordinate
	 */
	public String toString() {
		return this.getClass().getSimpleName() + " " + getX() + "," + getY();

	}


}
