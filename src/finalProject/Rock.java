package finalProject;

import java.awt.Graphics;
import java.awt.Image;

public class Rock {
	
	private Image rock;
	private final static int SPRITE_WIDTH = 35;
	private final static int SPRITE_HEIGHT = 35;
	private int x;
	private int y;
	private boolean facingLeft;
	
	public Rock(int x, int y, Image rock) {
		this.x = x;
		this.y = y;
		this.rock = rock;
		this.facingLeft = false;
	}
	
	public void draw(Graphics g) {
		g.drawImage(rock, x, y, SPRITE_WIDTH, SPRITE_HEIGHT, null);
	}

	public int getSpriteWidth() {
		return SPRITE_WIDTH;
	}

	public int getSpriteHeight() {
		return SPRITE_HEIGHT;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isFacingLeft() {
		return facingLeft;
	}

	public void setFacingLeft(boolean facingLeft) {
		this.facingLeft = facingLeft;
	}
	
	
	
	
	
}
