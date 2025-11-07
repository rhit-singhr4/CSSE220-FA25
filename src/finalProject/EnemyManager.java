package finalProject;
import java.awt.Graphics;
import java.util.ArrayList;

public class EnemyManager {
	
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private SpriteManager sprite = new SpriteManager();
	
	private static final int SPEED = 1;
	private static final int SPRITE_WIDTH = 35;
	private static final int SPRITE_HEIGHT = 35;
	
	public EnemyManager() {
		sprite.loadEnemy1();
	}

	public void addEnemies(Platform platform, int numOfEnemies) {
		int spacing = platform.getWidth() / (numOfEnemies + 1);
		for(int i = 0; i < numOfEnemies; i++) {
			int enemyX = platform.getX() + (spacing* i);
			int enemyY = platform.getY() - SPRITE_HEIGHT;
			enemies.add(new Enemy(enemyX, enemyY, sprite.enemy1Image(), platform));
			
		}
	}
	
	public void update() {
		for(Enemy enemy: enemies) {
			if(enemy.getIsFacingLeft()) {
				enemy.setX(enemy.getX() - SPEED);
			} else if(!enemy.getIsFacingLeft()) {
				enemy.setX(enemy.getX() + SPEED);
			}
			
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
		enemies.clear();
	}
	
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
}
