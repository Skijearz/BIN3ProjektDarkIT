package de.hsh.inform.darkit;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;

public class Collision {
	public static boolean checkCollision(ArrayList<Rectangle> obstacle, Player p) {
		for (Rectangle r : obstacle) {
			if (r.getBoundsInParent().intersects(p.getX()+p.getVelX(), p.getY()+p.getVelY(), 16, 16)) {
				return true;

			}
		}
		return false;
	}
}