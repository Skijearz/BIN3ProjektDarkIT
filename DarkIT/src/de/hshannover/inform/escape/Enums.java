package de.hshannover.inform.escape;


/**
 * Class of various Enumerations to simplify some mechanisms like:
 *    - Scene naming
 *    - Movement Directions
 *    - Map naming
 *    - Positioning
 */
public class Enums {
    /**
     * Enumeration of Scenes to get a better feeling of Scene naming
     */
    public enum Scenes{
        mainMenu,helpMenu,gameWindow,pauseWindow,mapCompletedWindow,nothing;
        /**
         * Method to get the corresponding FXML file of a Scene
         * @param scene 
         * @return String in the format of : "gui/mainMenu.fxml" where "mainMenu" gets replaced to the wanted file.
         */
        public static String getFXML(Scenes scene) {

            return "gui/"+ scene + ".fxml";
        }
    }
    /**

     * Enumeration of Directions
     */
    public enum Directions{
        UP,DOWN,LEFT,RIGHT;
    }
    /**
     * Enumeration of
     */
    public enum Maps{
        map1,test;

        public static String getMapFile(Maps map) {
            return "rsc"+"/"+ map +".tmx";
        }
    }
    public enum RelativPosition{
        ABOVE,BELOW,LEFT,RIGHT;
    }

}

