package de.hsh.inform.darkit;

import java.io.File;

public class Enums {
	public enum Scenes{
		mainMenu,helpMenu,gameWindow,pauseWindow;

		public static String getFXML(Scenes scene) {
			
			return "gui/"+ scene + ".fxml";
		}
	}
	public enum Directions{
		UP,DOWN,LEFT,RIGHT;
	}
	public enum Maps{
		map1;
		
		public static String getMapFile(Maps map) {
			return "rsc"+File.separatorChar+ map +".tmx";
		}
	}
	public enum RelativPosition{
		ABOVE,BELOW,LEFT,RIGHT;
	}
	
}

