package de.hshannover.inform.escape.gui;



import de.hshannover.inform.escape.SceneManager;
import de.hshannover.inform.escape.SoundPlayer;
import de.hshannover.inform.escape.Enums.Scenes;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * 
 * Just nothing
 *
 */
//Easter egg class :P
public class Nothing implements ControllerSet {
	SceneManager sm;
	SoundPlayer sp = new SoundPlayer();
	@FXML
	private Pane nPane;
	
    public void doNothing() {
        ImageView gifImageView = new ImageView(getClass().getResource("/de/hshannover/inform/escape/useless/noOneIsAroundToHelp.gif").toExternalForm());
        
        sp.playSound("none");
        sp.setCycleCount();
        nPane.getChildren().add(gifImageView);

        nPane.getScene().setOnKeyPressed(e->{
            if(e.getCode() != null) {
                nPane.getChildren().remove(gifImageView);
                sp.stopAudio();
                sm.changeScene(Scenes.helpMenu);
            }
        });
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
