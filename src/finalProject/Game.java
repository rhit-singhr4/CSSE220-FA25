package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Game extends JComponent{
	
//	public static final Color BG = Color.CYAN;
	
	private Player player = new Player();
	private Enemy enemy1 = new Enemy();
	private Inputs inputs = new Inputs(player);
	private Platforms platforms = new Platforms();
	private JFrame frame = new JFrame();
	private Timer timer;
	
	public void show() {
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(960,540);
		frame.setVisible(true);
		this.setFocusable(true);
		this.addKeyListener(inputs);
		startGameLoop();
	}
	
    private void startGameLoop() {
        timer = new Timer(1000 / 60, e -> {
            player.update();
            inputs.update();
            enemy1.update();
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
//		g.setColor(BG);
		g.fillRect(0,  0,  getWidth(), getHeight());
		platforms.draw(g,getWidth(),getHeight());
		enemy1.draw(g);
		player.draw(g);
	}
}
