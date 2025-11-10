package finalProject;

/*
 * @Authors: Raj, Andrew, and Braylo
 * The collectiblesManager class takes the single collectible that was created and creates multiple.
 * This makes an arraylist of multiple collectibles and changes their locations to spawn
 * multiple in the game all at different and varing locations.
 */

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

public class CollectiblesManager {
	// Creates an array list for collectibles to create multiple of the one drawn
	private ArrayList<Collectible> collectibles = new ArrayList<>();
	private static final int SPRITE_WIDTH = 35;
	private static final int SPRITE_HEIGHT = 35;
	private Image currentImage;
	
	private SpriteManager sprite = new SpriteManager();
	// loads the two collectibles
	public CollectiblesManager() {
		sprite.loadGoldCoins();
		sprite.loadSilverCoins();
	}

	// creates multiple and sets the locations that are attach to the position of the platforms. Also spawns 
	// a certain number of collectibles depending on the length of the platform
	public void addCollectibles(Platform platform) {
		Random random = new Random();
		int spacing = 50;
		int numOfCoinsPerPlatform = (platform.getWidth() - spacing) / spacing;
		for(int i = 0; i < numOfCoinsPerPlatform; i++) {
			int chanceOfSilver = random.nextInt(6) + 1;
			if(chanceOfSilver == 2) {
				currentImage = sprite.collectibleSilverImage();
			} else {
				currentImage = sprite.collectibleGoldImage();
			}
			int collectibleX = platform.getX() + 5;
			int collectibleY = platform.getY() - SPRITE_HEIGHT;
			if(collectibleX + SPRITE_WIDTH <= platform.getX() + platform.getWidth()) {
				collectibles.add(new Collectible(collectibleX + spacing * i, collectibleY, currentImage, platform));

				
			}
		}
	}

	public void draw(Graphics g) {
		for(Collectible collectibe: collectibles) {
			collectibe.draw(g);
		}
	}
	
	public void clearCollectibles() {
		collectibles.clear();
	}

	public ArrayList<Collectible> getCollectibles() {
		return collectibles;
	}
}
