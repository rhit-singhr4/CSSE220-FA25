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

public class CollectiblesManager {

	private ArrayList<Collectible> collectibles = new ArrayList<>();
	private static final int SPRITE_WIDTH = 35;
	private static final int SPRITE_HEIGHT = 35;
	
	private SpriteManager sprite = new SpriteManager();
	private Image gold_collectible; // silver_collectible;

	public CollectiblesManager() {
		sprite.loadGoldCoins();
	}

	public void addCollectibles(Platform platform) {
		int spacing = 150;
		int numOfCoinsPerPlatform = (platform.getWidth() - spacing) / spacing;
		for(int i = 0; i < numOfCoinsPerPlatform; i++) {
			int collectibleX = platform.getX() + 5;
			int collectibleY = platform.getY() - SPRITE_HEIGHT;
			if(collectibleX + SPRITE_WIDTH <= platform.getX() + platform.getWidth()) {
				collectibles.add(new Collectible(collectibleX + spacing * i, collectibleY, sprite.collectibleGoldImage(), platform));

				
			}
		}
	}

	public void draw(Graphics g) {
		for(Collectible collectibe: collectibles) {
			collectibe.draw(g);
		}
	}

	public ArrayList<Collectible> getCollectibles() {
		return collectibles;
	}
}
