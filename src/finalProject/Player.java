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
	
	public void update() {
		isIdle = true;
		
		if(x <= 0) {
			x += SPEED;
		} else if(x + SPRITE_WIDTH >= 1920) {
			x -= SPEED;
		}
		
		velY += GRAVITY;
		y += velY;
		
		int ground = SPRITE_HEIGHT;
		if(y >= ground) {
			y = ground;
			velY = 0;
			onGround = true;
		} else {
			onGround = false;
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
	
	public void collide() {
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getSpriteWidth() {
		return SPRITE_WIDTH;
	}
	
	public int getSpriteHeight() {
		return SPRITE_HEIGHT;
	}
	
}
