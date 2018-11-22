package de.hsh.inform.darkit.gui;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.*;

import javafx.scene.layout.Pane;

import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;
import org.mapeditor.core.Map;
import org.mapeditor.core.Tile;
import org.mapeditor.core.TileLayer;
import org.mapeditor.io.TMXMapReader;

import java.util.HashMap;

public class TileReader {
	//private Stage primaryStage;
	private Pane gamePane;
	//private static Scene scene;

	private static TMXMapReader mapReader = new TMXMapReader();
	private static Map map = null;
	private static TileLayer layer = null;
	private static Tile tile = null;
	private static int tid;

	public TileReader(Pane gamePane) {
		//this.primaryStage = primaryStage;
		this.gamePane = gamePane;
	}

	public void buildMap() {
		Group root = new Group();
		root.getChildren().add(gamePane);

		try {
			map = mapReader.readMap(TileReader.class.getResource("/de/hsh/inform/darkit/gui/map1.tmx").toString());
		} catch (Exception e) {
			System.out.println("Datei nicht gefunden");
			e.printStackTrace();
		}
		
		/*
		layer = (TileLayer) map.getLayer(1);
		System.out.println("test");
		if (layer == null) {
			System.out.println("can't get map layer");
			System.exit(-1);
		}
		int width = map.getWidth();
		int height = map.getHeight();
		HashMap<Integer, BufferedImage> tileHash = new HashMap<Integer, BufferedImage>();
		BufferedImage tileImage = null;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tile = layer.getTileAt(x, y);
				tid = tile.getId();
				if (tileHash.containsKey(tid)) {
					tileImage = tile.getImage();

				} else {

					try {

					} catch (Exception e) {
						e.printStackTrace(); // TODO!
					}
					tileHash.put(tid, tileImage);
				}
				ImageView iv = new ImageView();
				iv.setImage(SwingFXUtils.toFXImage(tileImage, null));

				gamePane.getChildren().add(iv);

			}
		}*/

	}


}
