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
	
	private CollectiblesManager collectibles = new CollectiblesManager();
	private HUD hud = new HUD();
	private CollisionManager collisionManager = new CollisionManager(hud);
	private Player player = new Player();
	private EnemyManager enemies = new EnemyManager();
	private Inputs inputs = new Inputs(player);
	private PlatformManager platforms = new PlatformManager();
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
            collisionManager.playerToPlatformsCollision(player, platforms);
            collisionManager.playerToEnemyCollision(player, enemies);
            collisionManager.playerToCollectibles(player, collectibles);

            player.updatePlayerSprite();
            enemies.update();
            repaint();
        });
        timer.start();
    }
	
	public Game() {
		platforms.addPlatforms(800,775,20);
		platforms.addPlatforms(1100,650,2);
		platforms.addPlatforms(900,550,3);
		platforms.addPlatforms(350,550,10);
		platforms.addPlatforms(125,660,1);
		platforms.addPlatforms(1300,500,3);
		
		collectibles.addCollectibles(800, 735);
		collectibles.addCollectibles(1400,735);
		collectibles.addCollectibles(1112, 610);
		collectibles.addCollectibles(780,360);
		collectibles.addCollectibles(125,620);
		
		for(Platform platform: platforms.getPlatforms()) {
			enemies.addEnemies(platform);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(0,  0,  getWidth(), getHeight());
		platforms.draw(g,getWidth(),getHeight());
		enemies.draw(g);
		player.draw(g);
		collectibles.draw(g, getWidth(), getHeight());
		hud.draw(g);
	}
}
 
 