package finalProject;
 
/*
 * @Authors: Raj, Andrew, and Braylo
 * The game class sets up the main frame that calls all the componenets together 
 * adding everything to the frame and displaying
 * the player, enemy, platforms, and collectibles all on one frame
 */

import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Game extends JComponent{
	
	private CollectiblesManager collectiblesManager = new CollectiblesManager();
	private CollisionManager collisonManager = new CollisionManager();
	private Player player = new Player();
	private Enemy enemy1 = new Enemy();
	private Inputs inputs = new Inputs(player);
	private PlatformManager platformManager = new PlatformManager();
	private HUD hud = new HUD();
	private JFrame frame = new JFrame();
	private Timer timer;
	
	public void show() {
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1480,1080);
		frame.setVisible(true);
		this.setFocusable(true);
		this.addKeyListener(inputs);
		startGameLoop();
	}
	
    private void startGameLoop() {
        timer = new Timer(1000 / 60, e -> {
        	inputs.update();
            player.update(getHeight(), getWidth());
            collisonManager.playerToPlatformsCollision(player, platformManager);
            player.updatePlayerSprite();
            enemy1.update();
            repaint();
        });
        timer.start();
    }
	
	public Game() {
		platformManager.addPlatforms(800,775,20);
		platformManager.addPlatforms(1100,650,2);
		platformManager.addPlatforms(900,550,3);
		platformManager.addPlatforms(350,550,10);
		platformManager.addPlatforms(125,660,1);
		platformManager.addPlatforms(1300,500,3);
		
		collectiblesManager.addCollectibles(800, 735);
		collectiblesManager.addCollectibles(1400,735);
		collectiblesManager.addCollectibles(1112, 610);
		collectiblesManager.addCollectibles(780,360);
		collectiblesManager.addCollectibles(125,620);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(0,  0,  getWidth(), getHeight());
		platformManager.draw(g,getWidth(),getHeight());
		enemy1.draw(g);
		player.draw(g);
		collectiblesManager.draw(g, getWidth(), getHeight());
		hud.draw(g);
	}
}
 
 