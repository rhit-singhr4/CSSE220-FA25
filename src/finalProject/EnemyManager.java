package finalProject;

/* @Authors: Raj, Andrew, and Braylon
* The Enemy manager class makes multiple of the enemies on each platform. It creates an array list to contain
* multiple of them but allow for different locations. Their spawn location is dependent of the platform spawn location.
* This also updates The enemies direction depending on which way the enemy is moving. It switches direction when its x
* position is equal to the length of the platform then switches direction.
* This class creates an auto moving enemy that starts moving the moment it is loaded in the game
* The enemy patrols by moving one direction constantly then hits the border of the screen than flips
* direction and begins to move the other direction 
*/

import java.awt.Graphics;
import java.util.ArrayList;

public class EnemyManager {
	
	// Creates an array list for the enemies
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private SpriteManager sprite = new SpriteManager();
	
	private static final int SPEED = 1;
	private static final int SPRITE_WIDTH = 35;
	private static final int SPRITE_HEIGHT = 35;
	
	public EnemyManager() {
		sprite.loadEnemy1();
	}

	public void addEnemies(Platform platform, int numOfEnemies) {
		// Adds the enemy to the platforms and spawns them on top of the platforms
		int spacing = platform.getWidth() / (numOfEnemies + 1);
		for(int i = 0; i < numOfEnemies; i++) {
			int enemyX = platform.getX() + (spacing* i);
			int enemyY = platform.getY() - SPRITE_HEIGHT;
			enemies.add(new Enemy(enemyX, enemyY, sprite.enemy1Image(), platform));
			
		}
	}
	
	public void update() {
		// Determines what direction the enemy is facing and when to switch direction and load the correct sprite
		for(Enemy enemy: enemies) {
			if(enemy.getIsFacingLeft()) {
				enemy.setX(enemy.getX() - SPEED);
			} else if(!enemy.getIsFacingLeft()) {
				enemy.setX(enemy.getX() + SPEED);
			}
			// This switches the sprite when its at the end of the platform
			if(enemy.getX() <= enemy.getPlatfrom().getX()) {
				enemy.setFacingLeft(false);
			} else if(enemy.getX() + SPRITE_WIDTH >= enemy.getPlatfrom().getX() + enemy.getPlatfrom().getWidth()) {
				enemy.setFacingLeft(true);
			}
		}
	}
	
	public void draw(Graphics g) {
		// Draws the enemies
		for(Enemy enemy: enemies) {
			sprite.updateEnemy1Sprite(enemy.getIsFacingLeft());
			enemy.setEnemyImage(sprite.enemy1Image());
			enemy.draw(g);
		}
	}
	
	public void clearEnemies() {
		// Gets rid of the enemies when 
		enemies.clear();
	}
	
	public ArrayList<Enemy> getEnemies() {
		// Adds them to the list
		return enemies;
	}
}
