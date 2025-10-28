package finalProject;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player{
	
	private int x = 100;
	private int y = 100;
	private int speed = 5;
	private Image sprite;
    private boolean spriteLoaded = false;

	
	public Player() {
		try {
			sprite = ImageIO.read(getClass().getResource("player_standing.png"));
			spriteLoaded = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics g) {
		if(spriteLoaded) {
			g.drawImage(sprite, x, y, 40, 40, null);
		}
	}
	
	public void moveUp() {y -= speed;} 
	public void moveDown() {y += speed;}
	public void moveLeft() {x -= speed;}
	public void moveRight() {x += speed;}
	
}
