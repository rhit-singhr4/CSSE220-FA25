package finalProject;

import java.awt.Graphics;
import java.awt.Image;

public class Enemy{
	
	private boolean facingLeft = false;
	private static final int SPEED = 3;
	
	private int x = 100;
	private int y = 200;
	
	private SpriteManager sprites = new SpriteManager();
	
	
	public Enemy() {
		sprites.loadEnemy();
		
//		try {
//			
//			spriteLoaded = true;
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	public void update() {
		moveLeft();
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
		g.drawImage(currentImage, x, y, 64, 64, null);
	}
	
//	public void move(int left, int right) {
//		if (spiteLoaded = true) {
//			x += speed;
//			x -= speed;
//		}
//	}
	
	
}
