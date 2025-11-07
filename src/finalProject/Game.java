package finalProject;
 
/*
* @Authors: Raj, Andrew, and Braylo
* The game class sets up the main frame that calls all the componenets together
* adding everything to the frame and displaying
* the player, enemy, platforms, and collectibles all on one frame
*/
 
import javax.swing.JFrame;

public class Game{
	
	private JFrame frame = new JFrame();
	private World world = new World();
	private GamePanel gamePanel = new GamePanel(world);
	
	public Game() {
		frame.setTitle("Final Project");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(1480,1080);
		frame.add(gamePanel);
	}
	
	public void show() {
		frame.setVisible(true);
		gamePanel.startGameLoop();
	}
}