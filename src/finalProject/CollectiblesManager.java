package finalProject;

/*
 * @Authors: Raj, Andrew, and Braylon
 * The collectiblesManager class takes the single collectible that was created and creates multiple.
 * This makes an arraylist of multiple collectibles and changes their locations to spawn
 * multiple in the game all at different and varing locations.
 */

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

public class CollectiblesManager {

	// Creates an array list to have multiple collectibles at different locations
	private ArrayList<Collectible> collectibles = new ArrayList<>();
	private static final int SPRITE_WIDTH = 35;
	private static final int SPRITE_HEIGHT = 35;
	private static final int GOLD_COIN_POINTS = 2;
	private static final int SILV_COIN_POINTS = 4;
	private int pointValue;
	private Image currentImage;
	
	private SpriteManager sprite = new SpriteManager();

	public CollectiblesManager() {
		// the two different collectibles
		sprite.loadGoldCoins();
		sprite.loadSilverCoins();
	}

	public void addCollectibles(Platform platform) {
		// Spawn location for the collectibles depend on the platform length and locations
		Random random = new Random();
		int spacing = 50;
		int numOfCoinsPerPlatform = (platform.getWidth() - spacing) / spacing;
		for(int i = 0; i < numOfCoinsPerPlatform; i++) {
			int chanceOfSilver = random.nextInt(6) + 1;
			if(chanceOfSilver == 2) {
				currentImage = sprite.collectibleSilverImage();
				pointValue = SILV_COIN_POINTS;
			} else {
				currentImage = sprite.collectibleGoldImage();
				pointValue = GOLD_COIN_POINTS;
			}
			// This set their locations based on the platforms
			int collectibleX = platform.getX() + 5;
			int collectibleY = platform.getY() - SPRITE_HEIGHT;
			if(collectibleX + SPRITE_WIDTH <= platform.getX() + platform.getWidth()) {
				collectibles.add(new Collectible(collectibleX + spacing * i, collectibleY, currentImage, platform, pointValue));
			}
		}
	}

	public void draw(Graphics g) {
		for(Collectible collectibe: collectibles) {
			collectibe.draw(g);
		}
	}
	
	public void clearCollectibles() {
		// clears the collectibles when collected by the player or when the game is over
		collectibles.clear();
	}

	public ArrayList<Collectible> getCollectibles() {
		// adds them to the list
		return collectibles;
	}
}
