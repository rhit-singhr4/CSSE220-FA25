package finalProject;

/*
 * @Authors: Raj, Andrew, and Braylon
 * The collectibles class creates the first collectible by setting the sprites height and width, then setting
 * its location. Then is draws it to the game to be displayed.
 */

import java.awt.Graphics;
import java.awt.Image;

public class Collectible {

	private static final int SPRITE_WIDTH = 40;
	private static final int SPRITE_HEIGHT = 40;
	private int x, y;
	private Image collectibleimage;

	public Collectible(int x, int y, Image collectible, Platform platform) {
		this.x = x;
		this.y = y;
		this.collectibleimage = collectible;
	}

	public void draw(Graphics g) {
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
