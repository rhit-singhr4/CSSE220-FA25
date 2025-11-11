package finalProject;
import java.awt.Graphics;
import java.util.ArrayList;

public class EnemyManager {
	
	// Creates an array list to make multiple of the same enemies but at different locations
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private SpriteManager sprite = new SpriteManager();
	
	private static final int SPEED = 1;
	private static final int SPRITE_WIDTH = 35;
	private static final int SPRITE_HEIGHT = 35;
	
	public EnemyManager() {
		sprite.loadEnemy1();
	}

	public void addEnemies(Platform platform, int numOfEnemies) {
		// Creates multiple enemies based off of the main one that was created
		// Spacing makes it where the enemies spawn based on where the platform is located
		int spacing = platform.getWidth() / (numOfEnemies + 1);
		for(int i = 0; i < numOfEnemies; i++) {
			int enemyX = platform.getX() + (spacing* i);
			int enemyY = platform.getY() - SPRITE_HEIGHT;
			enemies.add(new Enemy(enemyX, enemyY, sprite.enemy1Image(), platform));
			
		}
	}
	
	public void update() {
		// Controls the enemies auto movement function. And determines when it should switch directions
		// It switches directions when its speed is the same at the platform length so it doesn't go off the platform
		for(Enemy enemy: enemies) {
			if(enemy.getIsFacingLeft()) {
				enemy.setX(enemy.getX() - SPEED);
			} else if(!enemy.getIsFacingLeft()) {
				enemy.setX(enemy.getX() + SPEED);
			}
			// Same thing but when its facing the right direction
			if(enemy.getX() <= enemy.getPlatfrom().getX()) {
				enemy.setFacingLeft(false);
			} else if(enemy.getX() + SPRITE_WIDTH >= enemy.getPlatfrom().getX() + enemy.getPlatfrom().getWidth()) {
				enemy.setFacingLeft(true);
			}
		}
	}
	
	public void draw(Graphics g) {
		for(Enemy enemy: enemies) {
			sprite.updateEnemy1Sprite(enemy.getIsFacingLeft());
			enemy.setEnemyImage(sprite.enemy1Image());
			enemy.draw(g);
		}
	}
	
	public void clearEnemies() {
		// Gets rid of the enemies on by hit by the rock or when there is a screen change
		enemies.clear();
	}
	// Adds the enemies to the array list
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
}
