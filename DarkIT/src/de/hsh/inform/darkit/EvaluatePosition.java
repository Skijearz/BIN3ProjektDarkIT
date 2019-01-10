package de.hsh.inform.darkit;

import de.hsh.inform.darkit.Enums.RelativPosition;

public class EvaluatePosition {
	
	public static RelativPosition evaluatePosition(Player player,Entity entity) {
		double deltaX = player.getX() - entity.getX();
		double deltaY = player.getY() - entity.getY();
		
		System.out.println("x " + deltaX);
		System.out.println("y " + deltaY);
		
		if(deltaX > 0 && deltaX > Math.abs(deltaY)) {
			System.out.println("Rechts");
			return RelativPosition.RIGHT;
		}
		if(deltaX < 0 && Math.abs(deltaX) > Math.abs(deltaY) ) {
			System.out.println("Links");
			return RelativPosition.LEFT;
		}
		if(deltaY < 0 && Math.abs(deltaY) > Math.abs(deltaX)) {
			System.out.println("Oben");
			return RelativPosition.ABOVE;
		}
		if(deltaY > 0 && deltaY > Math.abs(deltaX)) {
			System.out.println("Unten");
			return RelativPosition.BELOW;
		}
		
		return null;
		
	}
}
