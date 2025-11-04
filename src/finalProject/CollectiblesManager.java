package finalProject;

/*
 * @Authors: Raj, Andrew, and Braylo
 * The collectiblesManager class takes the single collectible that was created and creates multiple.
 * This makes an arraylist of multiple collectibles and changes their locations to spawn
 * multiple in the game all at different and varing locations.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class CollectiblesManager {
	
	private ArrayList<Collectibles> collectibles = new ArrayList<>();
	private SpriteManager sprite = new SpriteManager();
	private Image gold_collectible; //silver_collectible;
	private int x, y;
	
	public CollectiblesManager() {
		sprite.loadGoldCoins();
		sprite.loadSilverCoins();
		gold_collectible = sprite.collectibleGoldImage();
		//silver_collectible = sprite.collectibleSilverImage();
	}
	public void addCollectibles(int x, int y) {
		collectibles.add(new Collectibles(x, y, gold_collectible));
		//collectibles.add(new Collectibles(x,y, silver_collectible));
	}
	
	
	public void draw(Graphics g,int screenWidth, int screenHeight) {
		Image goldcoin = sprite.collectibleGoldImage();
		
		for(Collectibles p: collectibles) {
			p.draw(g);
		}
	}
	public ArrayList<Collectibles> getCollectibles() {
		return collectibles;
	}
	
}
