package core;

import gui.Button;
import gui.SampleGridWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Daniel on 10/27/2014.
 */
public class Config {

    public static int tempo = 138;
    public static boolean editMode = true;
    public static Map<Character, Button> keyBinds = new HashMap<Character, Button>();
    public static SampleGridWindow mainWindow = null;

    public static void buildKeyBinds()
    {
        keyBinds.put(new Character('7'), mainWindow.grid[0][0]);
        keyBinds.put(new Character('8'), mainWindow.grid[0][1]);
        keyBinds.put(new Character('9'), mainWindow.grid[0][2]);
        keyBinds.put(new Character('0'), mainWindow.grid[0][3]);
        keyBinds.put(new Character('y'), mainWindow.grid[1][0]);
        keyBinds.put(new Character('u'), mainWindow.grid[1][0]);
        keyBinds.put(new Character('i'), mainWindow.grid[1][2]);
        keyBinds.put(new Character('o'), mainWindow.grid[1][3]);
        keyBinds.put(new Character('y'), mainWindow.grid[2][0]);
        keyBinds.put(new Character('y'), mainWindow.grid[2][1]);
        keyBinds.put(new Character('k'), mainWindow.grid[2][2]);
        keyBinds.put(new Character('l'), mainWindow.grid[2][3]);
        keyBinds.put(new Character('n'), mainWindow.grid[3][0]);
        keyBinds.put(new Character('m'), mainWindow.grid[3][1]);
        keyBinds.put(new Character(','), mainWindow.grid[3][2]);
        keyBinds.put(new Character('.'), mainWindow.grid[3][3]);
    }

}
