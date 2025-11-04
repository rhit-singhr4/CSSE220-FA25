package finalProject;

/*
 * @Authors: Raj, Andrew, and Braylo
 * The Enemy class sets up the speed variable for the enemy determining what direction the enemy should move
 * This class creates an auto moving enemy that starts moving the moment it is loaded in the game
 * The enemy patrols by moving one direction constantly then hits the border of the screen than flips
 * direction and begins to move the other direction 
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Enemy{
	
	private boolean facingLeft = false;
	private static final int SPEED = 3;
	private static final int SPRITE_WIDTH = 35;
	private static final int SPRITE_HEIGHT = 35;

	
	private int x = 100;
	private int y = 200;
	
	private SpriteManager sprites = new SpriteManager();
	
	
	public Enemy() {
		sprites.loadEnemy();
	}
	
	public void update() {
		if(facingLeft) {
			moveLeft();
		} else {
			moveRight();
		}
		
		if(x <= 0) {
			moveRight();
		}
		
		if(x + SPRITE_WIDTH >= 1920) {
			moveLeft();
		}
		sprites.updateEnemy1Sprite(facingLeft);
	}
	
	public void moveLeft() {
		x -= SPEED;
		facingLeft = true;
	}
	
	public void moveRight() {
		x += SPEED;
		facingLeft = false;
	}
	
	public void draw(Graphics g) {
		Image currentImage = sprites.enemyImage();
		g.drawImage(currentImage, x, y, SPRITE_WIDTH, SPRITE_HEIGHT, null);
		
		g.setColor(Color.BLACK);
		g.drawRect(x, y, SPRITE_WIDTH, SPRITE_HEIGHT);
	}
	
	public void collide() {
		
	}
	
	
}
