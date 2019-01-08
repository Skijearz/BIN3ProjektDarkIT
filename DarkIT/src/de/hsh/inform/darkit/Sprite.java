package de.hsh.inform.darkit;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sprite extends Rectangle {
	private Entity e;
	private double startX;
	private double startY; 
	
	public Sprite(double startX, double startY, int Width, int Height, Color color, Entity e) {
		super(Width, Height, color);
		this.e = e;
		this.startX = startX;
		this.startY = startY;
		
		
		super.setX(startX);
		super.setY(startY);
	}

	public void Update() {
	
		setTranslateX(e.getX()-startX);
		setTranslateY(e.getY()-startY);
		

	}

}