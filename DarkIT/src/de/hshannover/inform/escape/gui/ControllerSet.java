package de.hshannover.inform.escape.gui;
import de.hshannover.inform.escape.SceneManager;
import de.hshannover.inform.escape.Enums.Scenes;


public abstract interface ControllerSet {
	
	public abstract ControllerSet getController(Scenes scene);
	public abstract void setSceneManager(SceneManager sceneManager);
	

}
