package finalProject;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.Timer;

public class GamePanel extends JComponent {
	
	private World world;
	private Timer timer;
	
	public GamePanel(World world) {
		this.world = world;
		setFocusable(true);
		addKeyListener(world.getInputs());
	}
	
	public void startGameLoop() {
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
