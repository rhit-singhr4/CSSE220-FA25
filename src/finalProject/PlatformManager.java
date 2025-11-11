package finalProject;

/*
 * @Authors: Raj, Andrew, and Braylo
 * The platformManager class creates an arraylist of platforms to make multiple platforms
 * and a large platform to represent the ground. This class is what makes multiple platforms from the one platform created.
 * The platforms have 3 inputs being the x position the y position and the tilewidth.
 * The different x and y positions are to change the location of where a platform is called
 * and these changes and calls are made in the game class. The tilewidth is to make the platform images clearer 
 * instead of stretching the image to make larger platforms the tilewidth creates multiple and adds them together
 * creating one large smooth looking platform. Then they get drawn on being displayed in the game
 */

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class PlatformManager {
	
	// creates an array list of platforms to have multiple
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
		// draws the multiple platforms
		for(Platform p: platforms) {
			p.draw(g);
		}
	}
	
	public void clearPlatforms() {
		// clears the platforms to spawn the new level or when the game is over 
		platforms.clear();
	}
	// adds them to the array list
	public ArrayList<Platform> getPlatforms() {
		return platforms;
	}
}
