package finalProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	
	// Sets the initial value of each component
	private int score = 0;
	private int lives = 3;
	private int rocks = 35;
	
	public int getScore() {
		// We can access the value and change it
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getLives() {
		// We can access the value and change it
		return lives;
	}
	
	public void setLives(int lives) {
		this.lives = lives;
	}
	
	public int getRocks() {
		// We can access the value and change it
		return rocks;
	}
	
	public void setRocks(int rocks) {
		this.rocks = rocks;
	}

	public void draw(Graphics g) {
		// Draws the HUD and applies all the initial sets
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 25));
		
		//Score
		g.drawString("Score: " + score, 10,50);
		
		//Lives
		g.drawString("Lives: " + lives, 10, 75);
		
		//Rocks
		g.drawString("Rocks: " + rocks, 10, 100);
	}
	
}
