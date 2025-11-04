package finalProject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Player{
	
	private int x = 100;
	private int y = 300;
	
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
		
		g.setColor(Color.BLACK);
		g.drawRect(x, y, SPRITE_WIDTH, SPRITE_HEIGHT);
	}
	
	public void update(int screenHeight) {
		onGround = false;
		
		if(x <= 0) {
			x += SPEED;
		} else if(x + SPRITE_WIDTH >= 1920) {
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
		if(onGround) {
			velY = JUMP_POWER;
			onGround = false;
		}
	}
	
	public void moveLeft() {
		x -= SPEED; 
		isIdle = false;
		facingLeft = true;
	}
	
	public void moveRight() {
		x += SPEED; 
		isIdle = false;
		facingLeft = false;
	}
	
	public void attack() {
		
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
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setOnGround(boolean onGround) {
		this.onGround = onGround;
	}

	public void setX(int x) {
		this.x = x;
		
	}
	
}
