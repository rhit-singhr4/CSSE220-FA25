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
	// initializing Collectible variables
	private ArrayList<Collectibles> collectibles = new ArrayList<>();
	private SpriteManager sprite = new SpriteManager();
	private Image gold_collectible; //silver_collectible;
	// loads coins from sprite manager
	public CollectiblesManager() {
		sprite.loadGoldCoins();
		sprite.loadSilverCoins();
		gold_collectible = sprite.collectibleGoldImage();
		//silver_collectible = sprite.collectibleSilverImage();
	}
	
	// adds collectibles from game class with x and y
	public void addCollectibles(int x, int y) {
		collectibles.add(new Collectibles(x, y, gold_collectible));
		//collectibles.add(new Collectibles(x,y, silver_collectible));
	}
	
	// draws the collectibles with a for loop
	public void draw(Graphics g,int screenWidth, int screenHeight) {		
		for(Collectibles p: collectibles) {
			p.draw(g);
		}
	}
	
	// ArrayList of collectibles 
	public ArrayList<Collectibles> getCollectibles() {
		return collectibles;
	}
	
}