package finalProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	
	private int score = 0;
	private int lives = 3;
	
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
	
	public void draw(Graphics g) {
		//Score
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 25));
		g.drawString("Score: " + score, 10,50);
		
		//Lives
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 25));
		g.drawString("Lives: " + lives, 10, 75);
	}
}
