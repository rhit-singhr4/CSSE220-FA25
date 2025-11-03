package finalProject;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Platforms {
	
	private Image ground;
	private static final int SPRITE_WIDTH = 35;
	private static final int SPRITE_HEIGHT = 35;
	private ArrayList<Platforms> platforms = new ArrayList<>();
	private int x, y, length;
	
	private SpriteManager sprites = new SpriteManager();
	
	public Platforms() {
		sprites.loadPlatforms();
	}
	
	public Platforms(int x, int y, int length, Image ground) {
		this.x = x;
		this.y = y;
		this.length = length;
		this.ground = ground;
	}
	
	public void addPlatforms(int x, int y, int length) {
		platforms.add(new Platforms(x, y, length, sprites.groundImage()));
	}
	
	
	public void draw(Graphics g, int screenWidth, int screenHeight) {
		ground = sprites.groundImage();
		int tiles = (screenWidth / SPRITE_WIDTH) + 1;
		for(int i = 0; i < tiles; i++) {
			g.drawImage(ground, SPRITE_WIDTH*i, screenHeight - SPRITE_HEIGHT, SPRITE_WIDTH, SPRITE_HEIGHT, null);
		}
		
		for( Platforms p: platforms) {
			for (int j = 0; j < 5; j++) {
				g.drawImage(p.ground, p.x*j, p.y, SPRITE_WIDTH + p.length, SPRITE_HEIGHT, null);
			}
		}
	}
}
