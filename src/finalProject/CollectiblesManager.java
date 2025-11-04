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
	private static final int SPRITE_WIDTH = 35;
	private static final int SPRITE_HEIGHT = 35;
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
		//g.drawImage(gold_collectible, 800, 735,SPRITE_WIDTH, SPRITE_HEIGHT, null);
//		int dist = 100;
//		for (int i = 0; i < 10; i++) {
//			g.drawImage(gold_collectible, 100 + dist * i, 500,SPRITE_WIDTH, SPRITE_HEIGHT, null);
//		}
//		for (int i = 0; i < 10; i++) {
//			g.drawImage(silver_collectible,  100 + dist*i,  600,  SPRITE_WIDTH,  SPRITE_HEIGHT,  null);
//		}		
		//g.drawImage(gold_collectible, 800, 735,SPRITE_WIDTH, SPRITE_HEIGHT, null);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, SPRITE_WIDTH, SPRITE_HEIGHT);
	}
	public ArrayList<Collectibles> getCollectibles() {
		return collectibles;
	}
	
}
