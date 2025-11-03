package finalProject;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class PlatformManager {
	
//	private Platforms plateform = new Platforms();

	private ArrayList<Platform> platforms = new ArrayList<>();
	private SpriteManager sprite = new SpriteManager();
	private static final int SPRITE_WIDTH = 35;
	private static final int SPRITE_HEIGHT = 35;
	
	public PlatformManager() {
		sprite.loadPlatforms();
	}
	
	public void addPlatforms(int x, int y, int tileWidth) {
		platforms.add(new Platform(x, y,sprite.groundImage(),tileWidth));
	}
	
	public void draw(Graphics g, int screenWidth, int screenHeight) {
		//Drawing the floor
		Image ground = sprite.groundImage();
		int tiles = (screenWidth / SPRITE_WIDTH ) + 1;
		for(int i = 0; i < tiles; i++) {
			g.drawImage(ground, SPRITE_WIDTH*i, screenHeight - SPRITE_HEIGHT, SPRITE_WIDTH, SPRITE_HEIGHT, null);
		}
		
		for(Platform p: platforms) {
			p.draw(g);
		}
	}
	
	public ArrayList<Platform> getPlatforms() {
		return platforms;
	}
}
