package de.hsh.inform.darkit;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sprite extends Rectangle {
	private Player p;
    public Sprite(double sartX, double startY, int Width, int Height, Color color,Player p) {
        super(Width, Height, color);
        this.p=p;

        setTranslateX(sartX);
        setTranslateY(startY);
    }
public void Update() {
	setTranslateX(p.getX());
	setTranslateY(p.getY());
}
    

}