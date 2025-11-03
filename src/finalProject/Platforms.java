package finalProject;

import java.awt.Graphics;
import java.awt.Image;

public class Platforms {
	
	private Image ground;
	private static final int SPRITE_WIDTH = 35;
	private static final int SPRITE_HEIGHT = 35;
	
	private SpriteManager sprites = new SpriteManager();
	
	public Platforms() {
		sprites.loadPlatforms();
	}
	
	public void draw(Graphics g, int screenWidth, int screenHeight) {
		ground = sprites.groundImage();
		int tiles = (screenWidth / SPRITE_WIDTH) + 1;
		for(int i = 0; i < tiles; i++) {
			g.drawImage(ground, SPRITE_WIDTH*i, screenHeight - SPRITE_HEIGHT, SPRITE_WIDTH, SPRITE_HEIGHT, null);
		}
	}
}
