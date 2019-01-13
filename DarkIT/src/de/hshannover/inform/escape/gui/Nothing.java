package de.hshannover.inform.escape.gui;



import de.hshannover.inform.escape.SceneManager;
import de.hshannover.inform.escape.Enums.Scenes;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
/**
 * 
 * Just nothing
 *
 */
//Easter egg class :P
public class Nothing implements ControllerSet {
	SceneManager sm;
	@FXML
	private Pane nPane;
	
	public void doNothing() {
        try {

            nPane.setStyle("-fx-background-color: #000000");
            Media media = new Media(getClass().getResource("/de/hshannover/inform/escape/useless/noOneIsAroundToHelp.mp4").toExternalForm());
            MediaPlayer player = new MediaPlayer(media);
            MediaView view = new MediaView(player);
            player.setVolume(0.5);
            player.play();

            this.nPane.getChildren().add(view);

            nPane.getScene().setOnKeyPressed(e -> {
                if (e.getCode() != null) {
                    player.stop();
                    sm.changeScene(Scenes.mainMenu);
                }
            });
            player.setOnEndOfMedia(() -> {
                player.stop();
                sm.changeScene(Scenes.helpMenu);
            });

		} catch (Exception e) {
			e.printStackTrace();
		}

	
	}
	
	

	@Override
	public ControllerSet getController(Scenes scene) {
		return this;
	}

	@Override
	public void setSceneManager(SceneManager sceneManager) {
		this.sm = sceneManager;
		
	}
}
