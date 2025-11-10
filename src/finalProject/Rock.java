package finalProject;

/*
 * @Authors: Raj, Andrew, and Braylon
 * The rock class deals with incorporating a rock to be launched at enemies from the player so the player
 * has a way to face the enemies and not just avoid them. when the space bar is pressed the player shoots
 * a rock the flys accross the screen and interacts with the enemy.
 */

import java.awt.Graphics;
import java.awt.Image;

public class Rock {
	
	// Sprite details about the rock for sizing
	private Image rock;
	private final static int SPRITE_WIDTH = 35;
	private final static int SPRITE_HEIGHT = 35;
	private int x;
	private int y;
	private boolean facingLeft;
	
	public Rock(int x, int y, Image rock) {
		this.x = x;
		this.y = y;
		this.rock = rock;
		this.facingLeft = false;
	}
	
	public void draw(Graphics g) {
		// draws the one rock to be replicated easily by rock manager
		g.drawImage(rock, x, y, SPRITE_WIDTH, SPRITE_HEIGHT, null);
	}

	public int getSpriteWidth() {
		return SPRITE_WIDTH;
	}

	public int getSpriteHeight() {
		return SPRITE_HEIGHT;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isFacingLeft() {
		return facingLeft;
	}

	public void setFacingLeft(boolean facingLeft) {
		this.facingLeft = facingLeft;
	}
	
	
	
	
	
}
