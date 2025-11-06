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
	private Player player = new Player();
	private EnemyManager enemies = new EnemyManager();
	private Inputs inputs = new Inputs(player);
	private PlatformManager platforms = new PlatformManager();
	private LevelManager levels = new LevelManager(platforms);
	private JFrame frame = new JFrame();
	private JFrame frame2 = new JFrame();
	private Timer timer;
	private CollisionManager collisionManager = new CollisionManager(hud, player, platforms, enemies, collectibles);
	
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
            collisionManager.playerToPlatformsCollision();
            collisionManager.playerToEnemyCollision();
            collisionManager.playerToCollectibles();
 
            player.updatePlayerSprite();
            enemies.update();
            repaint();
        });
        timer.start();
    }
	
	public Game() {
		
		levels.level2();
		
		for(Platform platform: platforms.getPlatforms()) {
			enemies.addEnemies(platform);
			collectibles.addCollectibles(platform);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(0,  0,  getWidth(), getHeight());
		platforms.draw(g,getWidth(),getHeight());
		enemies.draw(g);
		player.draw(g);
		collectibles.draw(g);
		hud.draw(g);
	}
}