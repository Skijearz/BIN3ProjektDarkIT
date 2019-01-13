package de.hshannover.inform.escape;

import java.net.URISyntaxException;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

public class Sprite {
    
    private static final int ROWS = 1;
    private static final int COUNT = 6;
    private static final int OFFSET_X = 0;
    private static final int OFFSET_Y = 3*17;
    private static final int WIDTH = 16;
    private static final int HEIGHT = 17;
    private static final Duration DURATION = Duration.millis(600);
    
    private Pane gamePane;
    private Image Walking;
    private Player player;
    @SuppressWarnings("unused")
    private Stone stone;
    private ImageView ivWalking;
    private Animation walkingAnimation;
    
    
    public Sprite(Stone stone) {
        this.stone = stone;
	       Image img;
	        try {
	           
	            img = new Image(this.getClass().getResource("images/Stone.png").toURI().toString());
	            stone.collisionBox.setFill(new ImagePattern(img));
	        } catch (URISyntaxException e) {
	            e.printStackTrace();
	        }
	        
	}
	public Sprite(Player player,Pane gamePane) {
	    this.gamePane = gamePane;
	    this.player = player;
	    Walking = new Image(getClass().getResourceAsStream("/de/hshannover/inform/escape/images/CharacterSprites/Walk/Char_walk.png"));
	    
	     ivWalking = new ImageView(Walking);
	   
	    
	    ivWalking.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
	    
	    
	       ivWalking.setPreserveRatio(true);
	       ivWalking.setFitHeight(30);
	       ivWalking.setFitWidth(30);
	    
	     walkingAnimation = new SpriteAnimation(ivWalking,DURATION,COUNT,ROWS,OFFSET_X,OFFSET_Y,WIDTH,HEIGHT);
	
	    walkingAnimation.setCycleCount(Animation.INDEFINITE);

	    
	    ivWalking.setX(player.getX());
	    ivWalking.setY(player.getY());

	    
	    this.gamePane.getChildren().add(ivWalking);
	    
	}
	
	public void Update() {
	    ivWalking.toFront();
	    UpdateDirection();
	    ivWalking.setX(player.getX()-5);
        ivWalking.setY(player.getY()-14);



	}
	
	private void UpdateDirection() {
	    if(player.getKeyPressed()) {
	        walkingAnimation.play();

	        
	        switch(player.getWhichKeyIsPressed()) {
	        case UP:
	            ((SpriteAnimation)this.walkingAnimation).setOffsetY(3);
	            break;
	            
	        case DOWN:
	            ((SpriteAnimation)this.walkingAnimation).setOffsetY(0);
	            break;
	            
	        case LEFT:
	            ((SpriteAnimation)this.walkingAnimation).setOffsetY(1);
	            break;
	            
	        case RIGHT:
	            ((SpriteAnimation)this.walkingAnimation).setOffsetY(2);
	            break;
	            
	        default:
	            break;

	        }
	        
	    }else {
	        ivWalking.setViewport(new Rectangle2D(0,((SpriteAnimation)this.walkingAnimation).getOffsetY() , WIDTH, HEIGHT));
	       
	    }
	    
	}
	   private class SpriteAnimation extends Transition{

	        private final ImageView imageView;
	        private final int count;
	        private final int columns;
	        private final int offsetX;
	        private int offsetY;
	        private final int width;
	        private final int height;
	        
	        public SpriteAnimation(ImageView imageView,Duration duration,int count,int columns,int offsetX,int offsetY,int width,int height) {
	            this.imageView = imageView;
	            this.count = count;
	            this.columns = columns;
	            this.offsetX = offsetX;
	            this.offsetY = offsetY;
	            this.width = width;
	            this.height = height;
	            setCycleDuration(duration);
	        }
	        @Override
	        protected void interpolate(double k) {
	           final int index = Math.min((int)Math.floor(k*count), count-1);
	           final int x = (index / columns) * width + offsetX;
	           //System.out.println("x : " + x);
	           final int y = (index % columns) * height + offsetY;
	          // System.out.println("y : " + y);
	           imageView.setViewport(new Rectangle2D(x, y, width, height));
	            
	        }
	        public void setOffsetY(int newOffsetY) {
	            this.offsetY = newOffsetY*17;
	    }   
	           public int getOffsetY() {
	                return this.offsetY;
	       }

	   }
}
