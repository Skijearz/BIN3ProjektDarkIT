package de.hshannover.inform.escape;

import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;
/**
 * CollisionBoxe extends Rectangle, therefore the boxes are rectangles used to determine a position of an entity
 * (Stone or Player) also to check for collisions
 * 
 *
 */
public class CollisionBox extends Rectangle {
    private Entity e;
    private int offsetX;
    private int offsetY;
    /**
     * Constructor of a CollisionBox without an offset, 
     * therefore the box will always be at the same position as the Entity position.
     * @param startX X-Coordinate of the upper left corner of the resulting CollisionBox
     * @param startY Y-Coordinate of the upper left corner of the resulting CollisionBox
     * @param Width of the CollisionBox
     * @param Height of the CollisionBox
     * @param color javafx.scene.shape.Color used to fill the rectangles(most of the time transparent)
     * @param entity object to bind the box to it
     */
    public CollisionBox(double startX, double startY, int Width, int Height, Color color, Entity entity) {
        super(Width, Height, color);
        this.e = entity;

        super.setX(startX);
        super.setY(startY);
    }
    /**
     * Constructor of a CollisionBox with an offset, 
     * therefore the CollisionBox can be positioned relatively to the bound entity.
     * @param startX X-Coordinate of the upper left corner of the resulting CollisionBox
     * @param startY Y-Coordinate of the upper left corner of the resulting CollisionBox
     * @param Width of the CollisionBox
     * @param Height of the CollisionBox
     * @param color javafx.scene.shape.Color used to fill the rectangles(most of the time transparent)
     * @param entity object to bind the box to it
     * @param offsetX value(int) to shift the position of the CollisionBox, resulting X-Coordinate : CollisionBox.X()+offsetX 
     * @param offsetY value(int) to shift the position of the CollisionBox, resulting X-Coordinate : CollisionBox.Y()+offsetY
     */
    public CollisionBox(double startX, double startY, int Width, int Height, Color color, Entity e,int offsetX,int offsetY) {
        super(Width, Height, color);
        this.e = e;
        this.offsetX = offsetX;
        this.offsetY = offsetY;


        super.setX(startX+offsetX);
        super.setY(startY+offsetY);
    }
    /**
     * Updates the position of a CollisionBox mostly called from a AnimationTimer loop to create a smooth movement.
     */
    public void Update() {

        setX(e.getX()+offsetX);
        setY(e.getY()+offsetY);


    }
    //Getter and setter methods
    /**
     * OffsetX set method
     * @param offsetX the value to change offsetX into
     */
    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }
    /**
     * OffsetY set method
     * @param offsetY the value to change offsetY into
     */
    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

}