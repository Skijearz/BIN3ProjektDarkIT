package de.hshannover.inform.escape;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;
/**
 * 
 * Collision class, used to detect all kinds of collisions : 
 * collision between :
 * 			- player and stone
 * 			- stone and stone
 * 			- play and obstacle (map)
 * 			- stone and obstacle (map)
 * Detect if a stone is on a goalTile and the possibility to return this stone obj.
 *
 */
public class Collision {
    /**
     * Checks various collisions at the time.
     * 
     * @param obstacle ArrayList of all obstacles on the map
     * @param entityList ArrayList of all entities on the map
     * @param entity Object of either Player or Stone to check collision on them
     * @see Entity
     * @return true if any collision happens
     */
    public static boolean checkCollision(ArrayList<Rectangle> obstacle, ArrayList<Entity> entityList, Entity entity) {
        for (Rectangle r : obstacle) {
            for (Entity e : entityList) {

                // Collision check between entity and map obstacles
                if (r.getBoundsInParent().intersects(entity.getX() + entity.getVelX(), entity.getY() + entity.getVelY(),14, 14)) {
                    return true;
                }
                // Collision check between stones and player
                if(entity instanceof Player) {
                    if (e.collisionBox.getBoundsInParent().intersects(entity.getX() + entity.getVelX(),
                            entity.getY() + entity.getVelY(), 14, 14)) {

                        return true;
                    }
                }
                // collision check between the stones itself
                if(entity instanceof Stone) {
                        // check if the both stones to check are the same, if yes do nothing.
                        // necessary because the intersects method will always return true if both sides are the same:
                        // a.intersects(a) will always return true
                        if (e.collisionBox.equals(entity.collisionBox)) {                        
                        } else {
                            if (e.collisionBox.intersects(entity.getX()+entity.getVelX(), entity.getY()+entity.getVelY(), 16, 16)) {
                                return true;
                            }
                        }

                }
            }
        }
        return false;
    }
    /**
     * Checking if all goalTiles are occupied by a stone
     * @param entityList stores all Stone objects
     * @param goalTiles stores all goalTile rectangles
     * @return true if all goalTiles are occupied by a stone
     */
    public static boolean checkIfStoneIsOnGoalTile(ArrayList<Entity>entityList,ArrayList<Rectangle> goalTiles) {
        int check = 0;

        for(Rectangle g : goalTiles) {
            for(Entity e : entityList) {
                if(e.getVelX() == 0 && e.getVelY() ==0) {
                    if (g.getBoundsInParent().intersects(e.collisionBox.getBoundsInParent())) {
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
    /**
     * Returns the stone a player is touching
     * @param player the object of a player to check if its touching a stone
     * @see Player
     * @param entityList stores all Stone objects
     * @return entity which gets touched by a player
     * @see Entity
     */
    public static Entity getStone(Player player,ArrayList<Entity>entityList) {
        for(Entity e : entityList) {
            if(player.isTouchingBox.getBoundsInParent().intersects(e.collisionBox.getBoundsInParent())) {
                return e;
            }

        }
        return null;


    }
    /**
     * Checks if a Player touches a stone
     * @param player object of a Player to check if its touching a stone
     * @see Player
     * @param entityList ArrayList of all entities on the map
     * @return true if a Player and a Stone collides 
     */
    public static boolean checkIfPlayerIsTouchingStone(Player player,ArrayList<Entity>entityList) {
        for(Entity e : entityList) {
            if(player.isTouchingBox.getBoundsInParent().intersects(e.collisionBox.getBoundsInParent())) {
                return true;
            }

        }
        return false;


    }
}