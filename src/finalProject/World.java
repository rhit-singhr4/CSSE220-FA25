package finalProject;

/*
 * @Authors: Raj, Andrew, and Braylon
 * The world class is where everything is put together. This is what loads all the players, enemies, platforms,
 * , background, hud, and collectibles when the game is started. This class also manager the affects of collisions and
 * adding the score or losing lives. This is where everything is drawn and added to the screen. The conditionals are
 * set up here for when the next level should occur, the game is over, or you win the game.
 */

import java.awt.Graphics;

public class World {
	
	// sets the initial level
	private int currentLevel = 1;
	// Calls all the components together to be added together in a single frame and ready to be displayed
	private final HUD hud = new HUD();
	private final CollectiblesManager collectibles = new CollectiblesManager();
	private final EnemyManager enemies = new EnemyManager();
	private final RockManager rocks = new RockManager();
	private final PlatformManager platforms = new PlatformManager();
	private final Player player = new Player();
	private final LevelManager levels = new LevelManager(platforms, player);
	private final Inputs inputs = new Inputs(player, rocks);
	private final SpriteManager sprite = new SpriteManager();
	private final CollisionManager collisions = new CollisionManager(hud, player, platforms, enemies, collectibles,
			rocks);
	
	public World() {
		// loads everything for each level
		sprite.loadBackground();
		loadLevel(currentLevel);
	}
	public Inputs getInputs() {
		return inputs;
	}

	public void update(int width, int height) {
		// calls the collisions
		inputs.update();
		player.update(height, width);
		rocks.update(width);
		hud.setRocks(rocks.getCurrentRocks());
		collisions.playerToPlatformsCollision();
//		collisions.playerToEnemyCollision();
		collisions.playerToCollectibles();
		collisions.rockToEnemyCollision();
		player.updatePlayerSprite();
		enemies.update();
		
		// changes the level when all collectibles are collected making the score reach a certain value
		int currentScore = hud.getScore();
		if(currentScore >= 76 && currentLevel == 1) {
			currentLevel = 2;
			loadLevel(currentLevel);
		}
		
		// If we are on level 2 and everything is collected the screen switches to the winner screen
		//and despawns everything else
		int winner = hud.getScore();
		if (winner == 103) {
			sprite.loadwinnerImage();
			enemies.clearEnemies();
			collectibles.clearCollectibles();
			platforms.clearPlatforms();
		}
		
		// if the player has zero life the game is over and switches to the game over screen
		// and despawns everything
		int over = hud.getLives();
		if (over == 0) {
			sprite.loadloserImage();
			enemies.clearEnemies();
			collectibles.clearCollectibles();
			platforms.clearPlatforms();
		}
	}
	
	public void loadLevel(int level) {
		// clear all old platforms, collectibles, and enemies when the level is switched
		platforms.clearPlatforms();
		enemies.clearEnemies();
		collectibles.clearCollectibles();
		
		// identifies which level is which
		if(level == 1) {
			levels.level1();
		} else if(level == 2) {
			levels.level2();
		}
		
		for (Platform platform : platforms.getPlatforms()) {
			// adds the enemies and collectibles to where the platform locations are
			enemies.addEnemies(platform, 3);
			collectibles.addCollectibles(platform);
		}
	}
	
	public void draw(Graphics g, int width, int height) {
		// draws all the images
		g.drawImage(sprite.backgroundImage(), 0, 0, width, height, null);
		g.drawImage(sprite.loserImage(), 0, 0, width, height, null);
		g.drawImage(sprite.winnerImage(), 0, 0, width, height, null);
		platforms.draw(g, width, height);
		rocks.draw(g);
		enemies.draw(g);
		player.draw(g);
		collectibles.draw(g);
		hud.draw(g);
	}

	public int getCurrentLevel() {
		return currentLevel;
	}
	//hi
	
	
}
