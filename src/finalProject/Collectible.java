package finalProject;

/*
 * @Authors: Raj, Andrew, and Braylon
 * The collectibles class creates the first collectible by setting the sprites height and width, then setting
 * its location. Then is draws it to the game to be displayed. We have two different collectibles
 * each worth different values that add to the score. The collectibles spawn based on the platform location and length
 */

import java.awt.Graphics;
import java.awt.Image;

public class Collectible {
	// Variables for the collectibles
	private static final int SPRITE_WIDTH = 40;
	private static final int SPRITE_HEIGHT = 40;
	private int x, y;
	private int pointValue;
	private Image collectibleimage;
	
	public Collectible(int x, int y, Image collectible, Platform platform, int pointValue) {
		// Creates the initial collectible that is the basis for the rest of the collectibles
		this.x = x;
		this.y = y;
		this.collectibleimage = collectible;
		this.pointValue = pointValue;
	}

	public int getPointValue() {
		return pointValue;
	}

	public void setPointValue(int pointValue) {
		// set the value of the two different collectibles
		this.pointValue = pointValue;
	}

	public void draw(Graphics g) {
		// gets the sprite information and scales it properly and draws it to be displayed
		g.drawImage(collectibleimage, x, y, SPRITE_WIDTH, SPRITE_HEIGHT, null);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getSpriteWidth() {
		return SPRITE_WIDTH;
	}

	public int getSpriteHeight() {
		return SPRITE_HEIGHT;
	}

	public int getY() {
		return y;
	}
	
}
