package de.hsh.inform.darkit;

public class Stone extends Entity {

	public Stone(int x, int y) {
		super(x, y);

	}
	@Override
	public void move(boolean collision) {
		if (!collision) {
			setX(getX() + getVelX());
			setY(getY() + getVelY());
		}else {
			setVelX(0);
			setVelY(0);
		}
	}
}
