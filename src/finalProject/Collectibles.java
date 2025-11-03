package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Collectibles {
	
	private SpriteManager sprites = new SpriteManager();
	
	private static final int SPRITE_WIDTH = 20;
	private static final int SPRITE_HEIGHT = 20;
	
	//private ArrayList<Collectibles> collectibles = new ArrayList<>();
	private int x, y;
	private Image collectible;
	

	public Collectibles() {
		sprites.loadCoins();
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(collectible, 200, 200,SPRITE_WIDTH, SPRITE_HEIGHT, null);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, SPRITE_WIDTH, SPRITE_HEIGHT);
	}
//	public Collectibles(int x, int y, Image collectible) {
//		this.x = x;
//		this.y = y;
//		this.collectible = collectible;
//	}
}

