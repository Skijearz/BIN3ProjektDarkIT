package de.hsh.inform.darkit;

import de.hsh.inform.darkit.enums.Directions;
/**
 * 
 * Player entity class
 *
 */
public class Player {
	private static final double VELOCITY = 1.0;
	
	
	private double x;
	private double y;
	private double velX;
	private double velY;

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//Moves the player around based on his Velocity in the x or y direction, updates through a gameloop  
	public void move() {
		setX(getX()+getVelX());
		setY(getY()+getVelY());
	}
/**
 * Player keyPress (move) handling method, set the velocity of the entity based on the key pressed
 * @param d Enum of the possible directions a player can walk, based on the key press
 */
	public void moveKeyPress(Directions d) {
		switch (d) {
		case UP:
			this.setVelY(-VELOCITY);
			break;
		case DOWN:
			this.setVelY(VELOCITY);
			break;
		case LEFT:
			this.setVelX(-VELOCITY);
			break;
		case RIGHT:
			this.setVelX(VELOCITY);
			break;

		default:
			break;
		}

	}
	/**
	 * Player keyRelease (move) handling method, resets the velocity of the given direction to 0.
	 * @param d
	 */
	public void moveKeyRelease(Directions d) {
		switch (d) {
		case UP:
			this.setVelY(0);
			break;
		case DOWN:
			this.setVelY(0);
			break;
		case LEFT:
			this.setVelX(0);
			break;
		case RIGHT:
			this.setVelX(0);
			break;

		default:
			break;
		}

	}
	// getter and setter of Player variables
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

}
