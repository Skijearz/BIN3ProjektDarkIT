package de.hshannover.inform.escape;

import de.hshannover.inform.escape.Enums.RelativPosition;
/**
 * Class to determine where a Player is relatively to another Entity object
 * only used when the Player and the Entity already touches.
 */
public class EvaluatePosition {
	/**
	 * 
	 * @param player object of a Player to check its position relatively to the entity(when they are colliding)
	 * @see Player
	 * @param entity object of an Entity which gets touched by a Player
	 * @see Entity
	 * @return RelativePosition (Enumeration) from the player and Entity 
	 * @see RelativePosition
	 */
	public static RelativPosition evaluatePosition(Player player,Entity entity) {
		double deltaX = player.getX() - entity.getX();
		double deltaY = player.getY() - entity.getY();
		
		
		if(deltaX > 0 && deltaX > Math.abs(deltaY)) {
			return RelativPosition.RIGHT;
		}
		if(deltaX < 0 && Math.abs(deltaX) > Math.abs(deltaY) ) {
			return RelativPosition.LEFT;
		}
		if(deltaY < 0 && Math.abs(deltaY) > Math.abs(deltaX)) {
			return RelativPosition.ABOVE;
		}
		if(deltaY > 0 && deltaY > Math.abs(deltaX)) {
			return RelativPosition.BELOW;
		}
		
		return null;
		
	}
}
