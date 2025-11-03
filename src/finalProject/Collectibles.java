package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Collectibles {
	
	private SpriteManager sprites = new SpriteManager();
	
	private static final int SPRITE_WIDTH = 40;
	private static final int SPRITE_HEIGHT = 40;
	
	private ArrayList<Collectibles> collectibles = new ArrayList<>();
	private int x, y;
	private Image collectible;
	

	public Collectibles() {
		sprites.loadCoins();
		//hi
		
	}
	
	
	public Collectibles(int x, int y, Image collectible) {
		this.x = x;
		this.y = y;
		this.collectible = collectible;
	}
	
	
	public void draw(Graphics g) {
		int dist = 100;
		collectible = sprites.collectibleImage();
		for (int i = 0; i < 10; i++) {
			g.drawImage(collectible, 100 + dist * i, 500,SPRITE_WIDTH, SPRITE_HEIGHT, null);
		}
//		g.drawImage(collectible, 500, 500,SPRITE_WIDTH, SPRITE_HEIGHT, null);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, SPRITE_WIDTH, SPRITE_HEIGHT);
	}
}

