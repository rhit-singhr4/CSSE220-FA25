package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Enemy{
	
	private boolean facingLeft = false;
	private static final int SPEED = 3;
	private static final int SPRITE_WIDTH = 35;
	private static final int SPRITE_HEIGHT = 35;

	
	private int x = 100;
	private int y = 200;
	
	private SpriteManager sprites = new SpriteManager();
	
	
	public Enemy() {
		sprites.loadEnemy();
	}
	
	public void update() {
		if(facingLeft) {
			moveLeft();
		} else {
			moveRight();
		}
		
		if(x <= 0) {
			moveRight();
		}
		
		if(x + SPRITE_WIDTH >= 1920) {
			moveLeft();
		}
		sprites.updateEnemy1Sprite(facingLeft);
	}
	
	public void moveLeft() {
		x -= SPEED;
		facingLeft = true;
	}
	
	public void moveRight() {
		x += SPEED;
		facingLeft = false;
	}
	
	public void draw(Graphics g) {
		Image currentImage = sprites.enemyImage();
		g.drawImage(currentImage, x, y, SPRITE_WIDTH, SPRITE_HEIGHT, null);
		
		g.setColor(Color.BLACK);
		g.drawRect(x, y, SPRITE_WIDTH, SPRITE_HEIGHT);
	}
	
	
}
