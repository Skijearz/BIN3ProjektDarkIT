package de.hsh.inform.darkit;

import de.hsh.inform.darkit.enums.Directions;
/**
 * 
 * Player entity class
 *
 */
public class Player {
	private int x;
	private int y;

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}
/**
 * Player move method, set the coordinate of the entity based on the key pressed
 * @param d Enum of the possible directions a player can walk, based on the key press
 */
	public void move(Directions d) {
		switch (d) {
		case UP:
			this.setY(getY() - 3);
			break;
		case DOWN:
			this.setY(getY() + 3);
			break;
		case LEFT:
			this.setX(getX() - 3);
			break;
		case RIGHT:
			this.setX(getX() + 3);
			break;

		default:
			break;
		}

	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void moveUP() {
		this.setY(getY() + 5);

	}

	public boolean checkBoundries() {
		return false;

	}

}
