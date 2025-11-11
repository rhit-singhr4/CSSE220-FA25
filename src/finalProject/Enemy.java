package finalProject;
/*
 * @Authors: Raj, Andrew, and Braylon
 * The Enemy class sets up the speed variable for the enemy determining what direction the enemy should move
 * This class creates an auto moving enemy that starts moving the moment it is loaded in the game
 * The enemy patrols by moving one direction constantly then hits the border of the screen than flips
 * direction and begins to move the other direction 
 */

import java.awt.Graphics;
import java.awt.Image;

public class Enemy {

	// The variables for the enemy
	private Image enemy;
	private int x;
	private int y;
	private int health = 2;
	private Platform platform;;
	private boolean facingLeft = false;
	private static final int SPRITE_WIDTH = 35;
	private static final int SPRITE_HEIGHT = 35;
	
	public Enemy(int x, int y, Image enemy, Platform platform) {
		this.x = x;
		this.y = y;
		this.platform = platform;
		this.enemy = enemy;
		this.facingLeft = false;
	}
	
	public void draw(Graphics g) {
		g.drawImage(enemy, x, y, SPRITE_WIDTH, SPRITE_HEIGHT, null);
	}
	
	public void takeDamadge(int damage) {
		// Sets the health of the enemy
		health -= damage;
	}
	
	public boolean isDead() {
		// gets rid of the enemy when it has no more health
		return health <= 0;
	}

	public int getSpriteWidth() {
		return SPRITE_WIDTH;
	}

	public int getSpriteHeight() {
		return SPRITE_HEIGHT;
	}
	
	public int getHealth() {
		return health;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Platform getPlatfrom() {
		return platform;
	}
	
	public boolean getIsFacingLeft() {
		return facingLeft;
	}

	public void setX(int x) {
		// sets its x position to start moving
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setFacingLeft(boolean facingLeft) {
		this.facingLeft = facingLeft;
	}
	
	public void setEnemyImage(Image enemy) {
		this.enemy = enemy;
	}
	

}
