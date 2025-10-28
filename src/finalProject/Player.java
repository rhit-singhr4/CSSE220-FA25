package finalProject;

public class Player{
	
	private int x;
	private int y;
	private int speed;
	
	public Player() {
		
		this.x = 100;
		this.y = 100;
		this.speed = 5;
	}	
	
	public void moveUp() {
		y =- speed;
	}
	
	public void moveDown() {
		y =+ speed;
	}
	
	public void moveLeft() {
		x =- speed;
	}
	
	public void moveRigt() {
		y =+ speed;
	}
	
}
