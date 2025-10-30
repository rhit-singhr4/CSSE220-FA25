package finalProject;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player{
	
	private int x = 100;
	private int y = 300;
	private int speed = 5;
	private Image idle_r, idle_l, run_r, run_l;
    private boolean spriteLoaded = false;
    private boolean facingLeft;
    private Image currentImage;
    private boolean onGround = false;
    private int jumpStrength;
  
    
    
	public Player() {
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
		
		
		if(facingLeft) {
			currentImage = idle_l;
		} else {
			currentImage = idle_r;
		}
	}
	
	public void jump() {
		y -= jumpStrength;
	}

	
	public void moveLeft() {
		x -= speed; 
		currentImage = run_l;
		facingLeft = true;
		if(!onGround) {
			y -= 0;
		}
	}
	
	public void moveRight() {
		x += speed; 
		currentImage = run_r;
		facingLeft = false;
		if(!onGround) {
			y -= 0;
		}
	}
	
	public void attack() {
		
	}
	
}
