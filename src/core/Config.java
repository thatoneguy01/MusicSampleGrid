package core;

import gui.Button;
import gui.SampleGridWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Daniel on 10/27/2014.
 */
public class Config {

    public static int tempo = 480;
    public static boolean editMode = true;
    public static Map<Character, Button> keyBinds = new HashMap<Character, Button>();
    public static SampleGridWindow mainWindow = null;

}
