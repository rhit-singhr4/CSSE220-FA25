package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Game extends JComponent{
	public static final Color BG = Color.CYAN;
	
	private Player player = new Player();
	Inputs inputs = new Inputs(player, this);
	private Timer timer;
	
	public void show() {
		JFrame frame = new JFrame();
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1920,1080);
		frame.setVisible(true);
		this.setFocusable(true);
		this.addKeyListener(inputs);
		startGameLoop();
	}
	
    private void startGameLoop() {
        timer = new Timer(1000 / 60, e -> {
            player.update();
            inputs.update();
            repaint();
        });
        timer.start();
    }
	
	public Game() {
	}
	
	

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(BG);
		g.fillRect(0,  0,  getWidth(), getHeight());
		player.draw(g);
	
		
		
	}
}
