package finalProject;


/*
 * @Authors: Raj, Andrew, and Braylon
 * The player class sets up the variables for the player including start position, speed, and jump that move the player
 * This class also creates the player calling in the sprite and drawing in the sprite to be shown. 
 * This class deals with the gravity component and switches between the different versions we have on the sprite 
 * based on the action the player is doing being running, jumping, or falling
 */

import java.awt.Graphics;
import java.awt.Image;

public class Player{
	
	// Player variables
	private int x = 50;
	private int y = 840;
	
	private int spawnX = 50;
	private int spawnY = 840;
	
	private static final int SPEED = 5;
	private static final double GRAVITY = 0.5;
	private static final int JUMP_POWER = -12;
	private static final int SPRITE_WIDTH = 50;
	private static final int SPRITE_HEIGHT = 50;
	
	private double velY = 0;
	
    private boolean facingLeft = false;;
    private boolean isIdle = true;
	private boolean onGround = true;
	
	private SpriteManager sprites = new SpriteManager();

	public Player() {
		sprites.loadPlayer();
	}
	
	public void draw(Graphics g) {
		Image currentImage = sprites.playerImage();
		g.drawImage(currentImage, x, y, SPRITE_WIDTH, SPRITE_HEIGHT, null);
	}
	
	public void update(int screenHeight, int screenWidth) {
		// Sets the gravity affects
		onGround = false;
		
		if(x <= -10) {
			x += SPEED;
		} else if(x + SPRITE_WIDTH - 10 >= screenWidth) {
			x -= SPEED;
		}
		
		velY += GRAVITY;
		y += velY;
		
		int ground = screenHeight - SPRITE_HEIGHT - 35;
		if(y >= ground) {
			y = ground;
			velY = 0;
			onGround = true;
		}
	}
	
	public void updatePlayerSprite() {
		sprites.updatePlayerSprite(facingLeft, isIdle);
	}
	
	
	public void jump() {
		// Deals with the jump effect
		if(onGround) {
			velY = JUMP_POWER;
			onGround = false;
		}
	}
	
	public void moveLeft() {
		// Deals with the movement going left and loading the left sprite image
		x -= SPEED; 
		isIdle = false;
		facingLeft = true;
	}
	
	public void moveRight() {
		// Deals with the movement going right and loading the right sprite image
		x += SPEED; 
		isIdle = false;
		facingLeft = false;
	}
	public void respawnPlayer() {
		// respawns the players location
		x = spawnX;
		y = spawnY;
	}
	
	public void setSpawn(int x, int y) {
		this.x = x;
		this.y = y;
		spawnX = x;
		spawnY = y;
		
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public double getVelyY() {
		return velY;
	}
	
	public int getSpriteWidth() {
		return SPRITE_WIDTH;
	}
	
	public int getSpriteHeight() {
		return SPRITE_HEIGHT;
	}
	
	public void setVelY(double velY) {
		this.velY = velY;
	}
	
	public void setIdle(boolean idle) {
		this.isIdle = idle;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setOnGround(boolean onGround) {
		this.onGround = onGround;
	}

	public boolean isFacingLeft() {
		return facingLeft;
	}

	public void setFacingLeft(boolean facingLeft) {
		this.facingLeft = facingLeft;
	}
}
