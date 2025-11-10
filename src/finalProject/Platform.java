package finalProject;

/*
 * @Authors: Raj, Andrew, and Braylo
 * The platform class sets up the variables and information of the platforms
 * This class creates specificlly one small tile platform. Then in the manager it multiples these tiles and 
 * creates the larger platforms and multiple of the platforms.
 */

import java.awt.Graphics;
import java.awt.Image;

public class Platform {
	
	// Gets the sprite size information and platform spawn locations
	private Image ground;
	private int spriteHeight;
	private int spriteWidth;
	private int tileWidth;
	private int x, y;
	
	public Platform(int x, int y, Image ground, int tileWidth) {
		this.x = x;
		this.y = y;
		this.tileWidth = tileWidth;
		this.ground = ground;
		this.spriteWidth = 35;
		this.spriteHeight = 35;
	}
	
	public void draw(Graphics g) {
		// draws a single platform that is used to create multiple in the platformManager class
		for(int i = 0; i < tileWidth; i++) {
			g.drawImage(ground, x + (spriteWidth*i), y, spriteWidth, spriteHeight,null);
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return spriteWidth * tileWidth;
	}
	
	public int getHeight() {
		return spriteHeight;
	}
}
