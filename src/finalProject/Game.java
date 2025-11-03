package finalProject;
 
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;
 
public class Game extends JComponent{
 
	private Collectibles collectible = new Collectibles();
	private Player player = new Player();
	private Enemy enemy1 = new Enemy();
	private Inputs inputs = new Inputs(player);
	private PlatformManager platformManager = new PlatformManager();
	private JFrame frame = new JFrame();
	private Timer timer;
	
	public void show() {
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
            player.updatePlayerSprite();
            enemy1.update();
            repaint();
        });
        timer.start();
    }
	
	public Game() {
		platformManager.addPlatforms(960,540,5);
		platformManager.addPlatforms(420,270,5);
		platformManager.addPlatforms(210,135,5);
		platformManager.addPlatforms(300,375,5);
		platformManager.addPlatforms(125,425,5);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
//		g.setColor(BG);
		g.fillRect(0,  0,  getWidth(), getHeight());
		platformManager.draw(g,getWidth(),getHeight());
		enemy1.draw(g);
		player.draw(g);
		collectible.draw(g);
	}
}
 
 