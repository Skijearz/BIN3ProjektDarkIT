package de.hshannover.inform.escape;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * 
 * Entity class
 * Super class of Player and Stone
 */
public class Entity {

    protected static final double VELOCITY = 2.2;

    private double x;
    private double y;
    private double velX;
    private double velY;
    public CollisionBox collisionBox;
    /**
     * Entity Constructor, called from Player and Stone class to create an object.
     * @param x Coordinate on the map where the player starts
     * @param y Coordinate on the map where the player starts
     */
    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
        this.collisionBox = new CollisionBox(this.getX(),this.getY() , 16, 16, Color.TRANSPARENT, this);
    }

    /**
     * Moves the player around based on his Velocity in the x or y direction,
     * updates through a gameloop
     * 
     * @param collision, boolean from the Collision class which checks if the player
     *        collision rectangle touches/overlaps with a obstacle obj.
     */
    public void move(ArrayList<Entity> entityList,ArrayList <Rectangle> obstacles) {
        if (!Collision.checkCollision(obstacles, entityList, this)) {
            setX(getX() + getVelX());
            setY(getY() + getVelY());
        }
        this.collisionBox.Update();
    }

    // getter and setter of entity fields
    public void setX(double d) {
        this.x = d;
    }

    public void setY(double d) {
        this.y = d;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    /**
     * Prints the class name and the coordinates of that class in this format :
     * @return "Classname" + " " + X-Coordinate + "," + Y-Coordinate
     */
    public String toString() {
        return this.getClass().getSimpleName() + " " + getX() + "," + getY();

    }


}
