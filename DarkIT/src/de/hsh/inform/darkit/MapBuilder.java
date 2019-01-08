package de.hsh.inform.darkit;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.mapeditor.core.Map;
import org.mapeditor.core.Tile;
import org.mapeditor.core.TileLayer;
import org.mapeditor.io.TMXMapReader;

import de.hsh.inform.darkit.Enums.Maps;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class MapBuilder {
	private Pane gamePane;
	private TMXMapReader mapReader = new TMXMapReader();
	private Map map = null;
	private TileLayer layer = null;
	private int width;
	private int height;
	private boolean debug = false;
	private ArrayList <Rectangle> obstacles = new ArrayList <Rectangle>();
	
	

	public MapBuilder(Pane pane, Maps map) {
		gamePane = pane;
	}

	public void build() {
		try {
			
			
			map = mapReader.readMap(Maps.getMapFile(Maps.map1));

		} catch (Exception e) {
			e.printStackTrace();
		}
		/**
		 * Getting the map resolution based on the number of tiles and their resolution
		 */
		width = map.getWidth();
		height = map.getHeight();
		/**
		 * Iterate through all of the known layers of tiles
		 */
		for (int i = 0; i < map.getLayerCount(); i++) {
			layer = (TileLayer) map.getLayer(i);
			if (layer == null) {
				System.out.println("can't get map layer");
				System.exit(-1);
			}

			Tile tile = null;
			int tid;
			/**
			 * Hashmap of all tiles identified with the id of a tile
			 */
			HashMap<Integer, Image> tileHash = new HashMap<Integer, Image>();
			Image tileImage = null;
			/**
			 * Iterate through all rows and columns of tiles
			 * y = row
			 * x = column
			 */
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					// Getting the tile at a specific cell 
					tile = layer.getTileAt(x, y);
					//Identify the TileID of the tile in this specific cell
					tid = tile.getId();
					// If the TileID is already known and stored in the Hashmap dont add it but get an image of this tile, 
					// and if it is known add it to the hash map and try to "createImage" of the tile
					if (tileHash.containsKey(tid)) {

						tileImage = tileHash.get(tid);
					} else {

						try {
							tileImage = createImage(tile.getImage());
						} catch (Exception e) {
							e.printStackTrace();
						}
						tileHash.put(tid, tileImage);
					}
					//Creating an ImageView of the tileImage
					ImageView iv = new ImageView(tileImage);
					//Set the position of this ImageView to fill the map
					iv.setTranslateX((x * 16));
					iv.setTranslateY((y * 16) + 4);
				
					
					//Check if the layer is called collision, if so, draw an rectangle on the position
					//of an object which will have a collision box
					if(layer.getName().equals("collision")&& tid != 18) {
						Rectangle r = new Rectangle();
						if(debug) {
						r.setFill(Color.RED);
						}else {
							r.setFill(Color.TRANSPARENT);
						}
						r.setX(x*16);
						r.setY((y*16)+4);
						r.setWidth(16);
						r.setHeight(16);
						obstacles.add(r);
						
						gamePane.getChildren().add(r);
						
						
					}else {
						//Add the image to the pane
						gamePane.getChildren().add(iv);
						
						
						
					}
					
				}
			}
			
			System.out.println("tile image hash has " + tileHash.size() + " items");
			tileHash = null;
		}
		

		
		map = null;
		layer = null;
	}
	//Converting and Image to an javaFx image
	//
	public static javafx.scene.image.Image createImage(java.awt.Image image) throws Exception {
		if (!(image instanceof RenderedImage)) {
			BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
					BufferedImage.TYPE_INT_ARGB);
			Graphics g = bufferedImage.createGraphics();
			g.drawImage(image, 0, 0, null);
			g.dispose();
			image = bufferedImage;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write((RenderedImage) image, "png", out);
		out.flush();
		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
		return new javafx.scene.image.Image(in);
	}
	/**
	 * Getter method
	 * @return ArrayList of rectangles to determine obstacles
	 */
	public ArrayList <Rectangle> getObstacleList(){
		return obstacles;
	}


}

