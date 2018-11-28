package de.hsh.inform.darkit;

public class enums {
	public enum Scenes{
		mainMenu,helpMenu,gameWindow;

		public static String getFXML(Scenes scene) {
			
			return "gui/"+ scene + ".fxml";
		}
	}
	public enum Directions{
		UP,DOWN,LEFT,RIGHT;
	}
	
}

