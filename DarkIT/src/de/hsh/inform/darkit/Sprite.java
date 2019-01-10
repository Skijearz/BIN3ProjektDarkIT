package de.hsh.inform.darkit;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sprite extends Rectangle {
	private Entity e;
	private int offsetX;
	private int offsetY;
	
	public Sprite(double startX, double startY, int Width, int Height, Color color, Entity e) {
		super(Width, Height, color);
		this.e = e;

		
		
		super.setX(startX);
		super.setY(startY);
	}
	public Sprite(double startX, double startY, int Width, int Height, Color color, Entity e,int offsetX,int offsetY) {
		super(Width, Height, color);
		this.e = e;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		
		
		super.setX(startX+offsetX);
		super.setY(startY+offsetY);
	}

	public void Update() {
	
		setX(e.getX()+offsetX);
		setY(e.getY()+offsetY);
		

	}
	
	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}
	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}

}