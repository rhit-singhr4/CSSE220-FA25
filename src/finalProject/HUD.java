package finalProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	
	private int score = 0;
	private int lives = 3;
	
	public void HUD() {
		
	}
	
	public void setScore(int score) {
		this.score = score;
		//repaint();
	}
	
	public void setLives(int lives) {
		this.lives = lives;
		//repaint();
	}
	
	public void draw(Graphics g) {
		//Score
		g.setColor(Color.WHITE);
		g.setFont(new Font("Block", Font.BOLD, 10));
		g.drawString("Score: " + score, 50,50);
		
		//Lives
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 10));
		g.drawString("Lives: " + lives, 50, 75);
	}
}
