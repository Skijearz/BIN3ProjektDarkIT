package de.hsh.inform.darkit;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;

public class Collision {

	public static boolean checkCollision(ArrayList<Rectangle> obstacle, ArrayList<Entity> entityList, Entity entity) {
		for (Rectangle r : obstacle) {
			for (Entity e : entityList) {
	
				// Collision check between entity and map obstacles
				if (r.getBoundsInParent().intersects(entity.getX() + entity.getVelX(), entity.getY() + entity.getVelY(),
						14, 14)) {
					return true;
				}
				// Collision check between stones and player
				if(entity instanceof Player) {
					if (e.collisionSprite.getBoundsInParent().intersects(entity.getX() + entity.getVelX(),
							entity.getY() + entity.getVelY(), 14, 14)) {

						return true;
					}
				}
				// collision check between the stones itself
				if(entity instanceof Stone) {
					for (int i = 0; i < entityList.size(); i++) {
						// check if the both stones to check are the same, if yes break out of the for loop.
						// necessary because the intersects method will always return true if both sides are the same:
						// a.intersects(a) will always return true
						if (e.collisionSprite.equals(entityList.get(i).collisionSprite)) {
							break;
						} else {
							if (e.collisionSprite.getBoundsInParent().intersects(entityList.get(i).collisionSprite.getBoundsInParent().getMinX()+ entityList.get(i).getVelX(),entityList.get(i).collisionSprite.getBoundsInParent().getMinY()+ entityList.get(i).getVelY(),16, 16)) {
							
								return true;
							}
						}

					}
				}
			}
		}
		return false;
	}
	public static boolean checkIfStoneIsOnGoalTile(ArrayList<Entity>entityList,ArrayList<Rectangle> goalTiles) {
		int check = 0;
		
		for(Rectangle g : goalTiles) {
			for(Entity e : entityList) {
				if(e.getVelX() == 0 && e.getVelY() ==0) {
					if (g.getBoundsInParent().intersects(e.collisionSprite.getBoundsInParent())) {
						check++;
					}
				}
			}
		}
		if(check == goalTiles.size()) {
			return true;
		}
		return false;
		
	}
	public static Entity getStone(Player player,ArrayList<Entity>entityList) {
		for(Entity e : entityList) {
			if(player.isTouchingBox.getBoundsInParent().intersects(e.collisionSprite.getBoundsInParent())) {
				return e;
			}
			
		}
		return null;
	
		
	}
	public static boolean checkIfPlayerIsTouchingStone(Player player,ArrayList<Entity>entityList) {
		for(Entity e : entityList) {
			if(player.isTouchingBox.getBoundsInParent().intersects(e.collisionSprite.getBoundsInParent())) {
				return true;
			}
			
		}
		return false;
	
		
	}
}