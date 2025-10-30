package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Game extends JComponent{
	public static final Color BG = Color.CYAN;
	private Image cloud;
	private boolean spriteLoaded = false;
	
	private Player player = new Player();
	Inputs inputs = new Inputs(player, this);

	
	public void show() {
		JFrame frame = new JFrame();
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1920,1080);
		frame.setVisible(true);
		
		
		this.setFocusable(true);
		this.addKeyListener(inputs);
	}
	
	public Game() {
	}
	
	
	
	

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(BG);
		g.fillRect(0,  0,  getWidth(), getHeight());
		try {
			cloud = ImageIO.read(getClass().getResource("cloud.png"));
			spriteLoaded = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(spriteLoaded) {
			Random random = new Random();
			int x = 0;
			int y = 0;
			g.drawImage(cloud, x, y, 150, 150, null);
			for (int i = 0; i < 9; i++) {
				x = 150 + x;
				y = 100 - random.nextInt(200);
				g.drawImage(cloud, x, y, 150, 150, null);
				
			}
		}
		player.draw(g);
	
		
		
	}
}
