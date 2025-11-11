package finalProject;

/*
 * @Authors: Raj, Andrew, and Braylon
 * Starts the game Adding everything to a panel to be displayed and called in the game class
 */

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.Timer;

public class GamePanel extends JComponent {
	
	private World world;
	private Timer timer;
	
	public GamePanel(World world) {
		// Adds everything from world
		this.world = world;
		setFocusable(true);
		addKeyListener(world.getInputs());
	}
	
	public void startGameLoop() {
		// Starts the game to have everything spawn
		timer = new Timer(1000 / 60, e -> {
			world.update(getWidth(), getHeight());
			repaint();
		});
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		world.draw(g, getWidth(), getHeight());
	}
	
	
	
}
