package de.hsh.inform.darkit.gui;
import de.hsh.inform.darkit.SceneManager;
import de.hsh.inform.darkit.Enums.Scenes;


public abstract interface ControllerSet {
	
	public abstract ControllerSet getController(Scenes scene);
	public abstract void setSceneManager(SceneManager sceneManager);
	

}
