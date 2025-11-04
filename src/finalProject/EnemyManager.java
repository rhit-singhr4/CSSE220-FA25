package finalProject;

import java.awt.Graphics;
import java.util.ArrayList;

public class EnemyManager {
	
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private SpriteManager sprite = new SpriteManager();
	private static final int SPRITE_WIDTH = 35;
	private static final int SPRITE_HEIGHT = 35;
	
	public EnemyManager() {
		sprite.loadEnemy();
	}
	
	public void addEnemies(Platform platform) {
		int enemyX = platform.getX() + 10;
		int enemyY = platform.getY() - SPRITE_HEIGHT;
		enemies.add(new Enemy(enemyX, enemyY));
	}
	
	public void update() {
		for(Enemy enemy: enemies) {
			enemy.update();
		}
	}
	
	public void draw(Graphics g) {
		for(Enemy enemy: enemies) {
			enemy.draw(g);
		}
	}
}
