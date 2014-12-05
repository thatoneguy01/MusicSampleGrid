package core;

import gui.Button;
import gui.SampleGridWindow;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    public static Color selectColor = Color.lightGray;
    public static File currentSave;

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

    public static void save()
    {
    	DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder builder = null;
    	Document doc = null;
    	try{
    		builder = builderFactory.newDocumentBuilder();
			doc = builder.newDocument();
			
			Element root = doc.createElement("save");
			
			doc.appendChild(root);
			
			mainWindow.save(doc,root);
	    	TransformerFactory transFact = TransformerFactory.newInstance();
	    	Transformer transformer = transFact.newTransformer();
	    	DOMSource source = new DOMSource(doc);
	    	StreamResult result = new StreamResult(new File("save.xml"));
	    	transformer.transform(source, result);
	    	System.out.println("File saved!");
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    }

    public static void load()
    {

    }

}
