package finalProject;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Platforms {
	
	private Image ground;
	private static final int SPRITE_WIDTH = 64 ;
	private static final int SPRITE_HEIGHT = 64;
	
	
	private boolean spriteLoaded = false;;
	
	public Platforms() {
		loadSprites();
	}
	
	public void loadSprites() {
		try {
			ground = ImageIO.read(getClass().getResource("dirt_block.png"));
			spriteLoaded = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics g, int screenWidth, int screenHeight) {
		if(spriteLoaded) {
			int tiles = (screenWidth / SPRITE_WIDTH) + 1;
			for(int i = 0; i < tiles; i++) {
				g.drawImage(ground, SPRITE_WIDTH*i, screenHeight - SPRITE_HEIGHT, 64, 64, null);
			}
		}
	}

}
