package gui;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

//import com.sun.xml.internal.txw2.Document;

/**
 * An interface to define methods for saving to a string and loading from a string.
 * @author Henry
 */
public interface Saveable {
	
	public void load(Element node);

	public void save(Document doc, Element parentElement);

}
