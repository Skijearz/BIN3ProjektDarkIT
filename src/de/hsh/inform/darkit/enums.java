package de.hsh.inform.darkit;

public class enums {
	public enum Scenes{
		mainMenu,helpMenu;

		public static String getFXML(Scenes scene) {
			
			return "gui/"+ scene + ".fxml";
		}
	}
	
}

