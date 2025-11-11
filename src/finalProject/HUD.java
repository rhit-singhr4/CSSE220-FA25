package finalProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	
	private int score = 0;
	private int lives = 3;
	private int rocks = 100;
	private int coinsRemaning = 0;
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
		//repaint();
	}
	
	public int getLives() {
		return lives;
	}
	
	public void setLives(int lives) {
		this.lives = lives;
		//repaint();
	}
	
	public int getRocks() {
		return rocks;
	}
	
	public void setCoinsRemaning(int coinsRemaning) {
		this.coinsRemaning = coinsRemaning;
	}

	public void setRocks(int rocks) {
		this.rocks = rocks;
	}

	public void draw(Graphics g) {
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
