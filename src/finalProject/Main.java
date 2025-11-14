package finalProject;

/*
 * @Authors: Raj, Andrew, and Braylon
 * Calls the game class to run the game.
 */

import javax.swing.SwingUtilities;

public class Main {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()-> new Game().show());
	}
}