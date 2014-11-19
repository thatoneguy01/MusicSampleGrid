package gui;

/**
 * An interface to define methods for saving to a string and loading from a string.
 * @author Henry
 */
public interface Saveable {
	public String saveString();
	
	public Saveable fromString(String s);
}
