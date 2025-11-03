package finalProject;


import java.awt.Graphics;
import java.awt.Image;


public class Collectibles {
	
	
	
	private static final int SPRITE_WIDTH = 40;
	private static final int SPRITE_HEIGHT = 40;
	
	
	private int x, y;
	private Image collectibleimage;
	
	public Collectibles(int x, int y, Image collectible) {
		this.x = x;
		this.y = y;
		this.collectibleimage = collectibleimage;
	}
	
	
	public void draw(Graphics g) {
		g.drawImage(collectibleimage, x, y,SPRITE_WIDTH, SPRITE_HEIGHT, null);
		}
}

