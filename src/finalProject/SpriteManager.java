package finalProject;


/*
 * @Authors: Raj, Andrew, and Braylo
 * The SpriteManager class adds in all of our sprites used in the game 
 * This class deals with loading in our sprites we created and updating the version of a sprite we want based on
 * the controls being used
 */

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteManager {
	
	private Image idle_r, idle_l, run_r, run_l, currentPlayerImage;
	
	private Image enemy_l, enemy_r, currentEnemyImage;
	
	private Image ground;
	
	private Image gold_coin, silver_coin;
	
	public SpriteManager() {
		
	}
	
	public void loadPlayer() {
		try {
			idle_l = ImageIO.read(getClass().getResource("player_idle_left.png"));
			run_l = ImageIO.read(getClass().getResource("player_run_left.png"));
			idle_r = ImageIO.read(getClass().getResource("player_idle_right.png"));
			run_r = ImageIO.read(getClass().getResource("player_run_right.png"));
			currentPlayerImage = idle_r;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updatePlayerSprite(boolean facingLeft, boolean isIdle) {
		if(!isIdle) {
			if(facingLeft) {
				currentPlayerImage = run_l;
			} else {
				currentPlayerImage = run_r;
			}
		} else 
			if (facingLeft) {
				currentPlayerImage = idle_l;
		} else {
			currentPlayerImage = idle_r;
		}
	}
	
	public Image playerImage() {
		return currentPlayerImage;
	}
	
	public void loadEnemy() {
		try {
			enemy_l = ImageIO.read(getClass().getResource("enemy1_left.png"));
			enemy_r = ImageIO.read(getClass().getResource("enemy1_right.png"));
			currentEnemyImage = enemy_l;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadGoldCoins() {
		try {
			gold_coin = ImageIO.read(getClass().getResource("Gold_Coin.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadSilverCoins() {
		try {
			silver_coin = ImageIO.read(getClass().getResource("Silver_Coin.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	public Image collectibleGoldImage() {
		return gold_coin;
	}

	public Image collectibleSilverImage() {
		return silver_coin;
	}
	
	public void updateEnemy1Sprite(boolean facingLeft) {
		if(facingLeft) {
			currentEnemyImage = enemy_l;
		} else {
			currentEnemyImage = enemy_r;
		}
	}
	
	public Image enemyImage() {
		return currentEnemyImage;
	}
	
	public void loadPlatforms() {
		try {
			ground = ImageIO.read(getClass().getResource("dirt_block.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Image groundImage() {
		return ground;
		
	}
}
