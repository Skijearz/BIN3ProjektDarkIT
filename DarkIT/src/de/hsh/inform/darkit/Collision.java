package de.hsh.inform.darkit;

import java.util.ArrayList;


import javafx.scene.shape.Rectangle;

public class Collision {

	public static boolean checkCollision(ArrayList<Rectangle> obstacle, ArrayList<Entity> entityList, Player player) {
		for (Rectangle r : obstacle) {
			for (Entity e : entityList) {
				//Collsion check between entity(stones) and map obstacles
				//Alternative r.getBoundsInParent().intersects(e.getX()+e.getVelX().e.getY()+e.getVelY(),14,14);
				if (r.getBoundsInParent().intersects(e.collisionSprite.getBoundsInParent().getMinX()+e.getVelX(),e.collisionSprite.getBoundsInParent().getMinY()+e.getVelY(),14,14)) {
					return true;

				}
				//Collision check between player and map obstacles
				if(r.getBoundsInParent().intersects(player.getX()+player.getVelX(),player.getY()+player.getVelY(),16,16)) {
					return true;
				}
				//Collision chekc between stones and player
				if(e.collisionSprite.getBoundsInParent().intersects(player.getX()+player.getVelX(),player.getY()+player.getVelY(),16,16)) {
					
					return true;
				}
				//collision check between the stones itself
				for(int i = 0; i < entityList.size();i++) {
				if(e.collisionSprite.equals(entityList.get(i).collisionSprite)) {
					break;
				}else {
					if(e.collisionSprite.getBoundsInParent().intersects(entityList.get(i).collisionSprite.getBoundsInParent().getMinX()+entityList.get(i).getVelX(),entityList.get(i).collisionSprite.getBoundsInParent().getMinY()+entityList.get(i).getVelY(),16,16)){
						System.out.println("collsion between 2 stones");
						return true;
						
					}
				}
				
				}
				
			}
		}
		return false;
	}
}