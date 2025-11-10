package finalProject;


/*
 * @Authors: Raj, Andrew, and Braylon
 * The SpriteManager class adds in all of our sprites used in the game 
 * This class deals with loading in our sprites we created and updating the version of a sprite we want based on
 * the controls being used
 */

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteManager {
	// Variables for all sprites
	private Image idle_r, idle_l, run_r, run_l, rock ,currentPlayerImage;
	
	private Image enemy_l, enemy_r, currentEnemyImage;
	
	private Image ground;
	
	private Image gold_coin, silver_coin;
	
	private Image background;
	
	private Image win;
	
	private Image loser;
	
	public SpriteManager() {
		
	}
	
	public void loadPlayer() {
		// Loads all version of the player sprite
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
		// logic for deciding what direction the sprite is facing to load the correct sprite
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
	
	// Creates the rock sprite
	public void loadRock() {
		try {
			rock = ImageIO.read(getClass().getResource("rock.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Image rockImage() {
		return rock;
	}
	
	// Creates the coin/collectibles sprites
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
	
	// Creates the enemy sprites and determines what direction the sprite is facing to load the correct version
	public void updateEnemy1Sprite(boolean facingLeft) {
		if(facingLeft) {
			currentEnemyImage = enemy_l;
		} else {
			currentEnemyImage = enemy_r;
		}
	}
	
	public void loadEnemy1() {
		try {
			enemy_l = ImageIO.read(getClass().getResource("enemy1_left.png"));
			enemy_r = ImageIO.read(getClass().getResource("enemy1_right.png"));
			currentEnemyImage = enemy_l;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Image enemy1Image() {
		return currentEnemyImage;
	}
	
	// Creates the platforms and ground sprites
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
	
	// Creates the background sprite for the game
	public void loadBackground() {
		try {
			background = ImageIO.read(getClass().getResource("background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Image backgroundImage() {
		return background;
	}
	
	// Creates the winner sprite screen
	public void loadwinnerImage() {
		try {
			win = ImageIO.read(getClass().getResource("win_screen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Image winnerImage() {
		return win;
	}
	
	// creates the loser sprite screen
	public void loadloserImage() {
		try {
			loser = ImageIO.read(getClass().getResource("Game_over.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Image loserImage() {
		return loser;
	}
}
