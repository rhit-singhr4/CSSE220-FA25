package finalProject;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player{
	
	private int x = 100;
	private int y = 300;
	private int speed = 5;
	
	private double velY = 0;
	private double gravity = 0.5;
	private int jumpPower = -12;
	private int ground = 300;
	
	private Image idle_r, idle_l, run_r, run_l;
	private Image currentImage;
	
    private boolean spriteLoaded = false;
    private boolean facingLeft = false;;
    private boolean isIdle = true;
	private boolean onGround = true;

    
	public Player() {
		loadSprites();
	}
	
	public void loadSprites() {
		try {
			idle_l = ImageIO.read(getClass().getResource("player_idle_left.png"));
			run_l = ImageIO.read(getClass().getResource("player_run_left.png"));
			idle_r = ImageIO.read(getClass().getResource("player_idle_right.png"));
			run_r = ImageIO.read(getClass().getResource("player_run_right.png"));
			currentImage = idle_r;
			spriteLoaded = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void draw(Graphics g) {
		if(spriteLoaded) {
			g.drawImage(currentImage, x, y, 50, 50, null);
		}
	}
	
	public void update() {
		velY += gravity;
		y += velY;
		
		if(y >= ground) {
			y = ground;
			velY = 0;
			onGround = true;
		} else {
			onGround = false;
		}
		
		if(!isIdle) {
			if(facingLeft) {
				currentImage = run_l;
			} else {
				currentImage = run_r;
			}
		} else 
			if (facingLeft) {
				currentImage = idle_l;
		} else {
			currentImage = idle_r;
		}
		
	}
	
	public void jump() {
		if(onGround) {
			velY = jumpPower;
			onGround = false;
		}
	}
	
	public void moveLeft() {
		x -= speed; 
		isIdle = false;
		facingLeft = true;
	}
	
	public void moveRight() {
		x += speed; 
		isIdle = false;
		facingLeft = false;
	}
	
	public void attack() {
		
	}
	
}
