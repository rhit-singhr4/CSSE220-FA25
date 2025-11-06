package finalProject;

/*
 * @Authors: Raj, Andrew, and Braylon
 * The collectibles class creates the first collectible by setting the sprites height and width, then setting
 * its location. Then is draws it to the game to be displayed.
 */

import java.awt.Graphics;
import java.awt.Image;


public class Collectibles {
	// initializes our variables for the measurements of the sprite
	private static final int SPRITE_WIDTH = 40;
	private static final int SPRITE_HEIGHT = 40;
	
	
	
	private int x, y;
	private Image collectibleimage;
	
	// assigns variables for Collectibles
	public Collectibles(int x, int y, Image collectible) {
		this.x = x;
		this.y = y;
		this.collectibleimage = collectible;
	}
	
	// draws the collectible image to the screen
	public void draw(Graphics g) {
		g.drawImage(collectibleimage, x, y,SPRITE_WIDTH, SPRITE_HEIGHT, null);
		}
}

	
