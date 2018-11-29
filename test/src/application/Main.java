package application;

import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.application.Application;



import java.awt.image.RenderedImage;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.ByteArrayOutputStream;

import java.net.URL;

import javax.imageio.ImageIO;

import org.mapeditor.core.Map;
import org.mapeditor.core.Tile;
import org.mapeditor.core.TileLayer;

import org.mapeditor.io.TMXMapReader;

import java.io.ByteArrayInputStream;
import java.util.HashMap;

public class Main extends Application {

    Pane mainPane;
    Scene scene;

    TMXMapReader mapReader = new TMXMapReader();
   
    Map map = null;
    TileLayer layer = null;

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();

        mainPane = new Pane();
        root.getChildren().add( mainPane );
        scene = new Scene( root, 800,600);

        primaryStage.setScene( scene );
        primaryStage.setResizable(false);
        primaryStage.show();


        try {
        	
        	URL url = getUrlFromResources("application/map1.tmx");
        	System.out.println(url.getPath());
            map = mapReader.readMap(url.getPath());
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        layer = (TileLayer)map.getLayer(0);
        if (layer==null) {
            System.out.println("can't get map layer");
            System.exit(-1);
        }
        
        
		int width = map.getWidth();
		int height = map.getHeight();

        Tile tile = null;
        int tid;


        HashMap<Integer,Image> tileHash = new HashMap<Integer,Image>();
        Image tileImage = null;

        for (int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                tile = layer.getTileAt(x,y);
                tid = tile.getId();
                if (tileHash.containsKey(tid)) {
                  
                    tileImage=tileHash.get(tid);
                } else {
                  
                    try {
                        tileImage=createImage(tile.getImage());
                    } catch (Exception e) {
                        e.printStackTrace(); // TODO!
                    }
                    tileHash.put(tid,tileImage);
                }
                ImageView iv = new ImageView(tileImage);
                
                iv.setTranslateX((x*16)+4);
                iv.setTranslateY(y*16);
                mainPane.getChildren().add(iv);

            }
        }
   
        System.out.println("tile image hash has "+tileHash.size()+" items");

        tileHash = null;
        map = null;
        layer = null;
    }

    public static void main(String[] args) {
        launch(args);
    }

  
    public static javafx.scene.image.Image createImage(java.awt.Image image) throws Exception {
        if (!(image instanceof RenderedImage)) {
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null),
                    image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
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
    private URL getUrlFromResources(String filename) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        return classLoader.getResource(filename);
    }
}
